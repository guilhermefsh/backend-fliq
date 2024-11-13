package singleagency.project_fliq.enums;

import lombok.Getter;

@Getter
public enum RestaurantType {
    LANCHONETE("Lanchonete"),
    PIZZARIA("Pizzaria"),
    DOCES_E_BOLOS("Doces e bolos"),
    JAPONESA("Japonesa"),
    RESTAURANTE("Restaurante"),
    ADEGA("Adega"),
    CHURRASCARIA("Churrascaria"),
    CONVENIENCIA("Conveniência"),
    SORVETERIA("Sorveteria"),
    PADARIA("Padaria");

    private final String description;

    RestaurantType(String description) {
        this.description = description;
    }

}