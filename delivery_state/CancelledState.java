package delivery_state;

public class CancelledState extends State{
    public CancelledState(Order o) {
        super(o);
    }

    @Override
    public void getStatus() {
        System.out.println("Order #" + order.uuid + " has been cancelled. No info is available");
    }

    @Override
    public void cancel() {
        //do nothing
    }

    @Override
    public void proceed() {
        //do nothing since its an endpoint
    }
}
