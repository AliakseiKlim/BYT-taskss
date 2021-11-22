package calculator_chain;

public class Request {
    private final String action;
    private final double n1;
    private final double n2;

    public Request(String action, double n1, double n2){
        this.action = action;
        this.n1 = n1;
        this.n2 = n2;
    }

    public String getAction() {
        return action;
    }

    public double getN1() {
        return n1;
    }

    public double getN2() {
        return n2;
    }
}
