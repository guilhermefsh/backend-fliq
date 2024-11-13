package singleagency.project_fliq.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import singleagency.project_fliq.dto.CreateRestaurantDto;
import singleagency.project_fliq.exceptions.UserNotFoundException;
import singleagency.project_fliq.repositories.UserRepository;
import singleagency.project_fliq.services.CreateRestaurantService;

import java.security.Principal;
import java.util.UUID;

@RestController
@RequestMapping("/fliq/api/restaurant")
@AllArgsConstructor
public class CreateRestaurant {

    private CreateRestaurantService createRestaurantService;
    private UserRepository userRepository;

    @PostMapping
    ResponseEntity<Void> createRestaurant(@RequestBody CreateRestaurantDto createRestaurantDTO, Principal principal) {

        String userId = principal.getName();
        var userUUID = UUID.fromString(userId);
        var user = userRepository.findById(userUUID).orElseThrow(UserNotFoundException::new);

        createRestaurantService.createRestaurant(createRestaurantDTO, user);
        return ResponseEntity.ok().build();
    }
}
