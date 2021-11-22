package calculator_chain;

public class Main {
    public static void main(String[] args) {
        BaseHandler head = new ChainHead("");
        BaseHandler tail = new ChainTail("");

        //elements inside the chain may be implemented both as new classes and as anonymous classes
        BaseHandler addition = new BaseHandler("add") {
            @Override
            public void calculate(Request r) {
                System.out.println(r.getN1() + " + " + r.getN2() + " = " + (r.getN1()+r.getN2()));
            }
        };

        BaseHandler substraction = new BaseHandler("substract") {
            @Override
            public void calculate(Request r) {
                System.out.println(r.getN1() + "  " + r.getN2() + " = " + (r.getN1()-r.getN2()));
            }
        };

        BaseHandler multiplication = new Multiplication("multiply");
        BaseHandler division = new Division("divide");

        head.setNext(addition);
        addition.setNext(substraction);
        substraction.setNext(multiplication);
        multiplication.setNext(division);
        division.setNext(tail);

        Request r = new Request("multiply", 3.8, 2.7);
        Request r2 = new Request("add", 2, 10001);

        head.handle(r);

        head.handle(r2);
    }
}
