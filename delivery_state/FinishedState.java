package delivery_state;

public class FinishedState extends State {
    @Override
    public void getStatus() {
        System.out.println("Your order has been delivered. Enjoy!");
    }

    @Override
    public void cancel() {
        System.out.println("You can not cancel a finished order.");
    }

    @Override
    public void proceed() {
        //do nothing
    }

    public FinishedState(Order o) {
        super(o);
    }
}
