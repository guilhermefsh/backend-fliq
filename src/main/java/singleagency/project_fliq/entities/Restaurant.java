package singleagency.project_fliq.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import singleagency.project_fliq.enums.RestaurantType;

import java.time.Instant;
import java.util.List;


@Entity
@Table(name = "restaurant")
@Getter
@Setter
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long restaurantId;

    @Column(length = 100, nullable = false)
    private String name;

    private String photo;

    private String description;

    @CreationTimestamp
    private Instant createdAt;

    @Enumerated(EnumType.STRING)
    private List<RestaurantType> type;
}
