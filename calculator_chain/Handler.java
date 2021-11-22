package calculator_chain;

public interface Handler {
    public void handle(Request r);
    public void setNext(BaseHandler e);
    public void calculate(Request r);
}
