package design_pattern.Behavioral_pattern.chain_of_responsibility;

import java.util.ArrayList;
import java.util.List;

//w means weight
//m means mony
class Request {
    private double w;
    private double m;

    public Request(double w, double m) {
        this.w = w;
        this.m = m;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

}

abstract class Divison {

    protected List<Divison> divisons_list = new ArrayList<Divison>();

    public void addNextDivision(Divison d) {
        this.divisons_list.add(d);
    }

    public void handleRequest(Request request) {
        for (int i = 0; i < divisons_list.size(); i++) {
            Divison d = divisons_list.get(i);
            d.handleRequest(request);
        }
    }

    protected abstract void processRequest();
}

class GeneralDivison extends Divison {
    @Override
    public void handle(Request request) {
        if (request.getW() <= 10 && request.getMoney() <= 10000)
            processRequest();
        else
            super.handle(request);
    }

    public void processRequest() {
        System.out.println("This request is processed by -- General Divison");
    }
}

class ParcelDivisonOne extends Divison {
    @Override
    public void handleRequest(Request request) {
        if (request.getW() <= 100)
            processRequest();
        else
            super.handleRequest(request);
    }

    public void processRequest() {
        System.out.println("This request is processed by -- ParcelDivisonOne");
    }
}

class ParcelDivisonTwo extends Divison {
    @Override
    public void handleRequest(Request request) {
        if (request.getW() > 0)
            processRequest();
    }

    public void processRequest() {
        System.out.println("This request is processed by -- ParcelDivisonTwo");
    }
}

class MoneyDivison extends Divison {
    @Override
    public void handleRequest(Request request) {
        if (request.getM() > 0)
            processRequest();
    }

    public void processRequest() {
        System.out.println("This request is processed by -- MoneyDivison");
    }
}

public class Main {
    private static Divison createDivison() {
        Divison div1 = new GeneralDivison();
        Divison div2 = new ParcelDivisonOne();
        Divison div3 = new ParcelDivisonTwo();
        Divison div4 = new MoneyDivison();

        div2.addNextDivision(div3);

        div1.addNextDivision(div2);
        div1.addNextDivision(div4);

        return div1;
    }

    public static void main(String[] args) {

        Divison divison = createDivison();
        divison.handleRequest(new Request(100, 10));

        System.out.println("\n\n\n\n\n" + "Chain Responsibility\n\n\n\n");
    }
}
