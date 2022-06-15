package design_pattern.Creational_Pattern.singleton_method;

class SingletonObject {

    private static SingletonObject ins;

    private SingletonObject() {
    };

    public static SingletonObject getInstance() {
        if (ins == null)
            ins = new SingletonObject();

        return ins;
    }

    public void display() {
        System.out.println("Welcome to Singleton Pattern");
    }
}
class Main {
    public static void main(String[] args) {
        SingletonObject obj = SingletonObject.getInstance();
        obj.display();
    }
}
