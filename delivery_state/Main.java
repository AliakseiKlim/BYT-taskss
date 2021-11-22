package delivery_state;

public class Main {
    public static void main(String[] args) {

        //this order will be delivered successfully. User will try to cancel it while its being delivered, but nothing will change
        Order o1 = new Order("Uber Eats Delivery", "123-abc-456", "McDonald's", "Home");
        o1.getStatus();
        o1.proceed();
        o1.proceed();
        o1.cancel();
        o1.proceed();
        System.out.println("========");
        // this order will be cancelled while its being cooked
        Order o2 = new Order("Uber Eats Delivery", "228-qwe-332", "KFC", "University");
        o2.getStatus();
        o2.proceed();
        o2.cancel();
        o2.proceed();

        System.out.println("========");
        // this order will be cancelled immediately after being acceptedd by system
        Order o3 = new Order("BOLT Delivery", "qgt-b1b-o5k", "Burger King", "al. Jerozolimskie 123");
        o3.cancel();
        //next line will do nothing
        o3.proceed();
    }
}
