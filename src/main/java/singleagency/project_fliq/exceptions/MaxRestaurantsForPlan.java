package singleagency.project_fliq.exceptions;

public class MaxRestaurantsForPlan extends FliqException {
    public MaxRestaurantsForPlan() {
        super("Não é possível adicionar mais restaurantes para o plano atual.");
    }
}
