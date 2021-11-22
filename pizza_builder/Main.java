package pizza_builder;

public class Main {
    public static void main(String[] args) {
        PizzaBuilder pb = new PizzaBuilder();
        //creating margarita manually
        Pizza p1 = pb.instantiate().setName("Margarita")
                        .setRadius(31)
                        .setSlices(4)
                        .addIngredient("Cheese", 500)
                        .addIngredient("Tomato", 200)
                        .build();
        System.out.println(p1);


        //creating large pizza with borders (crust) filled with cheese and then customizing it
        Pizza p2 = pb.getLargeCrustPizzaWithCheeseInside()
                .setSlices(8)
                .addIngredient("A", 150)
                .addIngredient("B", 350)
                .addIngredient("C", 200)
                .setName("SuperPizza")
                .build();
        System.out.println(p2);

        //creating giant pizza cut into 16 squares and then customizing it
        Pizza p3 = pb.getPizzaWithSquareSlices()
                .addIngredient("Tomato", 150)
                .addIngredient("Pepperoni", 350)
                .addIngredient("Mushroom", 200)
                .setName("PartyPizza")
                .build();
        System.out.println(p3);
    }
}
