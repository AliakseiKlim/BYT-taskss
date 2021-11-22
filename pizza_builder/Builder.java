package pizza_builder;


public interface Builder {
    public void reset();
    public PizzaBuilder setRadius(double r);
    public PizzaBuilder setSlices(int n);
    public PizzaBuilder addIngredient(String name, double amount);
    public PizzaBuilder instantiate();
    public PizzaBuilder setName(String s);
    public PizzaBuilder setCrustSize(Pizza.CrustSize s);
    public PizzaBuilder setSliceMode(Pizza.SliceMode s);
}
