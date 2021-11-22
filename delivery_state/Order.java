package delivery_state;

public class Order {
    State state;
    String name;
    String uuid;
    String addressFrom;
    String addressTo;
    // Product... etc
    public void setState(State s){
        this.state = s;
    }
    public void getStatus(){
        this.state.getStatus();
    }
    public void cancel(){
        this.state.cancel();
    }
    public void proceed(){
        this.state.proceed();
    }
    public Order(String name, String uuid, String addressFrom, String addressTo) {
        this.name = name;
        this.uuid = uuid;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        setState(new AcceptedState(this));
    }
}
