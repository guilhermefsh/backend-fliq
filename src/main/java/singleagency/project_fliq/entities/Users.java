package singleagency.project_fliq.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import singleagency.project_fliq.enums.Roles;

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

    @Column( nullable = false, unique = true)
    private String email;

    @Column( nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Roles roles;
}
