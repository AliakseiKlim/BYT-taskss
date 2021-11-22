package delivery_state;

public abstract class State {
    Order order;
    public abstract void getStatus();
    public abstract void cancel();
    public abstract void proceed();
    public State(Order o){
        this.order = o;
        getStatus();
    }
}
