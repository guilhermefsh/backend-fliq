package singleagency.project_fliq.enums;

import lombok.Getter;

@Getter
public enum RestaurantType {
    HAMBURGUER_ARTESANAL("Hamburguer Artesanal"),
    PIZZA("Pizza"),
    LANCHES_PRENSADOS("Lanches Prensados");

    private final String description;

    RestaurantType(String description) {
        this.description = description;
    }

}