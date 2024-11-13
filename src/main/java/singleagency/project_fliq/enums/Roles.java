package singleagency.project_fliq.enums;

import lombok.Getter;

@Getter
public enum Roles {
    STAFF("Staff", 0),
    RESTAURANT_PLAN_A("Restaurante plano A", 1),
    RESTAURANT_PLAN_B("Restaurante plano B", 2),
    RESTAURANT_PLAN_C("Restaurante plano C", 3),
    COSTUMER("Cliente", 0);

    private final String roleName;
    private final int maxRestaurants;

    Roles(String roleName, int maxRestaurants) {
        this.roleName = roleName;
        this.maxRestaurants = maxRestaurants;
    }
}
