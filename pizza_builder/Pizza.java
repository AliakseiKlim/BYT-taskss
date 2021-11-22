package pizza_builder;

import java.util.HashMap;

public class Pizza {
    public CrustSize crustSize = CrustSize.ORIGINAL;
    public SliceMode sliceMode = SliceMode.ORIGINAL;
    public String name;
    public double radius;
    public int slices;
    public HashMap<String, Double> ingredients;

    @Override
    public String toString() {
        return "Pizza " + name + " with "+crustSize.toString()+" crust size of radius "+radius + " with " + slices +" "+sliceMode.toString()+" slices and these ingredients: \n" + ingredients.toString();
    }
    public enum CrustSize{
        ORIGINAL,
        MEDIUM,
        LARGE
    }
    public enum SliceMode{
        ORIGINAL,
        SQUARE,
        STRIPS
    }
}
