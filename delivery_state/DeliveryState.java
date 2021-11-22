package delivery_state;

public class DeliveryState extends State {
    @Override
    public void getStatus() {
        System.out.println("Your order has been picked up by delivery partner is on its way.");
    }

    @Override
    public void cancel() {
        System.out.println("An order can not be cancelled while it is being delivered");
    }

    @Override
    public void proceed() {
        order.setState(new FinishedState(order));
    }

    public DeliveryState(Order o) {
        super(o);
    }
}
