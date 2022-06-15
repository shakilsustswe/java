package design_pattern.Structural_pattern.composite;

import java.util.ArrayList;
import java.util.List;

interface animalCompo {
    public void print();
}

class Head implements animalCompo {
    public void print() {

        System.out.println("Creating head......");

    }

}

class Lag implements animalCompo {
    public void print() {
        System.out.println("Creating Leg...");
    }
}

class Body implements animalCompo {
    public void print() {
        System.out.println("Creating Body...");
    }
}

class Horn implements animalCompo {

    public void print() {
        System.out.println("Creating Horn...");
    }
}

class Tail implements animalCompo {

    public void print() {
        System.out.println("Creating Tail...");
    }
}

class CompositeAnimal implements animalCompo {
    private List<animalCompo> childanimalCompo = new ArrayList<animalCompo>();

    public CompositeAnimal() {
    };

    public void print() {
        for (animalCompo graphic : childanimalCompo) {
            graphic.print();
        }
        System.out.println("Composition Completed..\n\n");
    }

    public void add(animalCompo compo) {
        childanimalCompo.add(compo);
    }

    public void remove(animalCompo compo) {
        childanimalCompo.remove(como);
    }
}

public class Main {

    public static void main(String[] args) {
        animalCompo head = new Head();
        animalCompo leg = new Lag();
        animalCompo body = new Body();
        animalCompo tail = new Tail();
        animalCompo horn = new Horn();

        CompositeAnimal horse = new CompositeAnimal();
        horse.add(head);
        horse.add(leg);
        horse.add(tail);
        horse.add(body);
        horse.print();

        CompositeAnimal cow = new CompositeAnimal();
        cow.add(head);
        cow.add(leg);
        cow.add(tail);
        cow.add(body);
        cow.add(horn);
        cow.print();

        // Creating a collection of Horses
        CompositeAnimal allHorses = new CompositeAnimal();
        allHorses.add(horse);
        allHorses.add(horse);
        allHorses.print();

        // Creating a firm of GHORA and GARU
        CompositeAnimal firm = new CompositeAnimal();
        firm.add(horse);
        firm.add(cow);
        firm.print();
    }

}
