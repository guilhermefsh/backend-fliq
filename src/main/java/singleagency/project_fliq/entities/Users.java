package singleagency.project_fliq.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;
import singleagency.project_fliq.dto.LoginRequest;
import singleagency.project_fliq.enums.Roles;
import singleagency.project_fliq.exceptions.MaxRestaurantsForPlan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId;

    @Column(nullable = false)
    private String name;

    @Column( nullable = false, unique = true)
    private String email;

    @Column( nullable = false)
    private String password;

    @Column(length = 40)
    @Enumerated(EnumType.STRING)
    private Roles roles;

    @OneToMany(targetEntity = Users.class, cascade = CascadeType.ALL)
    private List<Restaurant> restaurants;

    public boolean isLoginCorret(LoginRequest loginRequest, PasswordEncoder passwordEncoder){
        return passwordEncoder.matches(loginRequest.password(), this.password);
    }
}
