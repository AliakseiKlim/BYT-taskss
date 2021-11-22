package calculator_chain;

public class ChainTail extends BaseHandler{
    public ChainTail(String s) {
        super(s);
    }

    @Override
    public void handle(Request r) {
        System.out.println("The request could not be handled. Try another command");
    }

}
