public class CafeJava {
    public static void main(String[] args) {
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        String remainingMessage = "We're sorry for the mix-up. Your remaining balance is $";

        double mochaPrice = 3.5;
        double dripCoffeePrice = 2.75;
        double lattePrice = 3.75;
        double cappuchinoPrice = 3.85;
        
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = true;

        System.out.println(generalGreeting + customer1);
        if (isReadyOrder1) {
            System.out.println(customer1 + readyMessage);
            System.out.println(displayTotalMessage + mochaPrice);
        }
        else {
            System.out.println(customer1 + pendingMessage);
        }
        
        System.out.println("------------------------------");
        
        System.out.println(generalGreeting + customer4);
        if (isReadyOrder4) {
            System.out.println(customer4 + readyMessage);
            System.out.println(displayTotalMessage + cappuchinoPrice);
        }
        else {
            System.out.println(customer4 + pendingMessage);
        }
        
        System.out.println("------------------------------");
        
        System.out.println(generalGreeting + customer2);
        System.out.printf("%s%.2f\n", displayTotalMessage, (lattePrice * 2));
        if (isReadyOrder2) {
            System.out.println(customer2 + readyMessage);
        }
        else {
            System.out.println(customer2 + pendingMessage);
        }
        
        System.out.println("------------------------------");
        
        System.out.println(generalGreeting + customer3);
        System.out.printf("%s%.2f\n",remainingMessage, (lattePrice - dripCoffeePrice));
        if (isReadyOrder3) {
            System.out.println(customer3 + readyMessage);
        }
        else {
            System.out.println(customer3 + pendingMessage);
        }
    }
}
