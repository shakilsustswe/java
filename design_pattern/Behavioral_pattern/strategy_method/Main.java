package design_pattern.Behavioral_pattern.strategy_method;

interface Pay {
    void pay();
}

class Bkash implements Pay {

    public void pay() {
        System.out.println("Pay with Bkash");
    }
}

class Nagad implements Pay {

    public void pay() {
        System.out.println("Pay with Nagad");
    }
}

class Card implements Pay {

    public void pay() {
        System.out.println("Pay with Card");
    }
}

class PaymentStrategy {
    private Pay pay;

    public void setMethod(Pay pay) {
        this.pay = pay;
    }

    public void execute() {
        pay.pay();
    }
}

public class Main {

    public static void main(String[] args) {
        PaymentStrategy paymentStrategy = new PaymentStrategy();
        String selectedMethod = "card";
        if (selectedMethod.equalsIgnoreCase("bkash")) {
            paymentStrategy.setMethod(new Bkash());
            paymentStrategy.execute();
        } else if (selectedMethod.equalsIgnoreCase("Nagad")) {
            paymentStrategy.setMethod(new Nagad());
            paymentStrategy.execute();
        } else if (selectedMethod.equalsIgnoreCase("card")) {
            paymentStrategy.setMethod(new Card());
            paymentStrategy.execute();
        } else {
            System.out.print("You can't pay !!!!!!!");
        }
    }
}
