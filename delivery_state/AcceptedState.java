package delivery_state;

public class AcceptedState extends State{
    public AcceptedState(Order o) {
        super(o);
    }

    @Override
    public void getStatus() {
        System.out.println("Your order has been processed by the system");
    }

    @Override
    public void cancel() {
        System.out.println("Your order has been successfully cancelled");
        order.setState(new CancelledState(order));
    }

    @Override
    public void proceed() {
        order.setState(new ProccessedState(order));
    }
}
