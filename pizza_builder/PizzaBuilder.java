package pizza_builder;

import pizza_builder.Pizza.CrustSize;
import pizza_builder.Pizza.SliceMode;

import java.util.HashMap;

public class PizzaBuilder implements Builder{
    private Pizza p;
    @Override
    public void reset() {
        p = new Pizza();
    }
    @Override
    public PizzaBuilder instantiate(){
        p = new Pizza();
        return this;
    }

    @Override
    public PizzaBuilder setName(String s) {
        p.name = s;
        return this;
    }

    @Override
    public PizzaBuilder setCrustSize(CrustSize s) {
        p.crustSize = s;
        return this;
    }

    @Override
    public PizzaBuilder setSliceMode(SliceMode s) {
        p.sliceMode = s;
        return this;
    }

    @Override
    public PizzaBuilder setRadius(double r) {
        p.radius = r;
        return this;
    }

    @Override
    public PizzaBuilder setSlices(int n) {
        p.slices = n;
        return this;
    }

    @Override
    public PizzaBuilder addIngredient(String name, double amount) {
        if (p.ingredients==null) p.ingredients = new HashMap<>();
        p.ingredients.put(name, amount);
        return this;
    }

    public Pizza build(){
        Pizza oldP = p;
        reset();
        return oldP;
    }

    public PizzaBuilder getLargeCrustPizzaWithCheeseInside(){
        reset();
        return instantiate()
                     .setCrustSize(CrustSize.LARGE)
                     .addIngredient("Crust Cheese", 200)
                     .setRadius(45);
    }
    public PizzaBuilder getPizzaWithSquareSlices(){
        reset();
        return instantiate()
                .setCrustSize(CrustSize.MEDIUM)
                .setSlices(16)
                .setSliceMode(SliceMode.SQUARE)
                .setRadius(60);
    }
}
