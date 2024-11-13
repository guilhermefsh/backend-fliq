package singleagency.project_fliq.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import singleagency.project_fliq.dto.CreateRestaurantDto;
import singleagency.project_fliq.entities.Restaurant;
import singleagency.project_fliq.entities.Users;
import singleagency.project_fliq.enums.Roles;
import singleagency.project_fliq.repositories.RestaurantRepository;
import singleagency.project_fliq.repositories.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CreateRestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    @Transactional
    public Restaurant createRestaurant(CreateRestaurantDto createRestaurantDto, Users user) {
        var userRole = user.getRoles();
        var maxRestaurants = userRole.getMaxRestaurants();

        var userRestaurants = restaurantRepository.findByUser(user);
        if (userRestaurants.size() >= maxRestaurants) {
            throw new IllegalStateException("Limite de restaurantes atingido para o usuário com o plano " + userRole.getRoleName());
        }

        var restaurant = new Restaurant();
        restaurant.setName(createRestaurantDto.name());
        restaurant.setDescription(createRestaurantDto.description());
        restaurant.setPhoto(createRestaurantDto.photo());
        restaurant.setType(createRestaurantDto.type());
        restaurant.setUser(user);

        return restaurantRepository.save(restaurant);
    }
    //public void createRestaurant(@RequestBody CreateRestaurantDto createRestaurantDto, UUID userId){

      //  var user = userRepository.findById(userId)
        //        .orElseThrow(UserNotFoundException::new);

        //var restaurant = new Restaurant();
        //restaurant.setName(createRestaurantDto.name());
        //restaurant.setPhoto(createRestaurantDto.photo());
        //restaurant.setDescription(createRestaurantDto.description());
        //restaurant.setType(createRestaurantDto.type());

        //user.addRestaurant(restaurant);

        //restaurantRepository.save(restaurant);

    }

