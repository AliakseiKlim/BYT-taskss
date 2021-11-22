package delivery_state;

public class ProccessedState extends State {
    public ProccessedState(Order o) {
        super(o);
    }

    @Override
    public void getStatus() {
        System.out.println("Your order is being cooked by the restaurant");
    }

    @Override
    public void cancel() {
        System.out.println("Your order has been cancelled. You will be fully charged for the order");
        order.setState(new CancelledState(order));
    }

    @Override
    public void proceed() {
        order.setState(new DeliveryState(order));
    }
}
