package calculator_chain;

public class Multiplication extends BaseHandler{

    public Multiplication(String s) {
        super(s);
    }

    @Override
    public void calculate(Request r) {
        System.out.println(r.getN1() + " * " + r.getN2() + " = " + (r.getN1()*r.getN2()));
    }
}
