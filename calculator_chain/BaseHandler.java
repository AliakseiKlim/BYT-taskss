package calculator_chain;

public abstract class BaseHandler implements Handler{
    BaseHandler next;
    String actionAccepted;
    public BaseHandler(String s){
        this.actionAccepted = s;
    }

    @Override
    public void handle(Request r) {
        if (r.getAction().equals(actionAccepted)){
            this.calculate(r);
        }else{
            if (next!=null) this.next.handle(r);
        }
    }

    @Override
    public void setNext(BaseHandler next) {
        this.next = next;
    }

    @Override
    public void calculate(Request r){

    }
}
