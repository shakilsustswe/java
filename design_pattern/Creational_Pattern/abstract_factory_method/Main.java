package design_pattern.Creational_Pattern.abstract_factory_method;

interface Button {
    void DRAW();
}

interface GUIFactory {
    Button creaButton();
}

class winFactory implements GUIFactory {

    @Override
    public Button creaButton() {

        return new winButton();
    }

}

class osxFactory implements GUIFactory {

    @Override
    public Button creaButton() {
        // TODO Auto-generated method stub
        return new osxButton();
    }

}

class winButton implements Button {

    @Override
    public void DRAW() {
        // TODO Auto-generated method stub
      System.out.println("I am a windows Button");
    }

}

class osxButton implements Button {

    @Override
    public void DRAW() {
        System.out.println("i am an Osx Button");

    }

}

class abstructFactory {

    private GUIFactory factory;

    public abstructFactory() {
    }

    public abstructFactory(GUIFactory factory) {
        this.factory = factory;
        Button button = factory.creaButton();
        button.DRAW();
    }

    public void setFactory(GUIFactory factory) {
        this.factory = factory;
        Button button = factory.creaButton();
        button.DRAW();

    }

    public static GUIFactory createOsSpecificFactory(String platformName) {
        if (platformName.equals("windows"))
            return new winFactory();
        else if (platformName.equals("apple"))
            return new osxFactory();

        return null;
    }

}

public class Main {
    public static void main(String[] args) {
        abstructFactory abstructFactory = new abstructFactory();
        abstructFactory.setFactory(abstructFactory.createOsSpecificFactory("apple"));
    }
}