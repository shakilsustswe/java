package design_pattern.Structural_pattern.adapter;

interface Bird {

    public void fly();

    public void makeSound();

}

class wastail implements Bird {

    @Override
    public void fly() {
        System.out.println("Flying");
    }

    @Override
    public void makeSound() {
        System.out.println("Chippppppp");
    }

}

interface toyDuyel {
    public void squeak();
}

class PlastictoyDuyel implements toyDuyel {

    @Override
    public void squeak() {
        System.out.println("Squeak");
    }

}

class Adapter implements toyDuyel{

    Bird bird;
    public Adapter(Bird bird)
    {
        this.bird=bird;
        
    }
    @Override
    public void squeak() {
        bird.makeSound();
    }

}

public class Main {

    public static void main(String[] args) {
        
        wastail wastail = new wastail();
        wastail.makeSound();
        wastail.fly();

        toyDuyel was=new Adapter(wastail);
        was.squeak();
    }
}
