package singleagency.project_fliq.dto;

import singleagency.project_fliq.enums.RestaurantType;

import java.util.List;

public record CreateRestaurantDto(String name, String description, String photo, List<RestaurantType> type) {
}
