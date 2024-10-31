package singleagency.project_fliq.enums;

import lombok.Getter;

@Getter
public enum Roles {
    STAFF("Staff"),
    RESTAURANT_PLAN_A("Restaurante plano A"),
    COSTUMER("Cliente");

    private final String roleName;

    Roles(String roleName) {
        this.roleName = roleName;
    }
}
