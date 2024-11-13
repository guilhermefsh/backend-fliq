package singleagency.project_fliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import singleagency.project_fliq.entities.Restaurant;
import singleagency.project_fliq.entities.Users;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByUser(Users user);
}
