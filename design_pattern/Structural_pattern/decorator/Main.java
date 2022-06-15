package design_pattern.Structural_pattern.decoration;

interface Shape {
    void draw();
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle..");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle..");
    }
}

class normalBorder implements Shape {

    private Shape decoShape;

    normalBorder(Shape decoShape) {
        this.decoShape = decoShape;
    }

    @Override
    public void draw() {
        decoShape.draw();
    }

}

class RedBorder implements Shape {

    private Shape decoShape;

    RedBorder(Shape decoShape) {
        this.decoShape = decoShape;
    }

    @Override
    public void draw() {
        decoShape.draw();
        border(decoShape);
    }

    private void border(Shape decoShape) {
        System.out.println("border Color :Red");
    }
}

public class Main {

    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedBorder(new Circle());
        Shape redRectangle = new RedBorder(new Rectangle());
        System.out.println("Normal Circle");
        circle.draw();
        System.out.println("RedBorder Circle");
        redCircle.draw();
        System.out.println("RedBorder Rectangle..");
        redRectangle.draw();
    }
}
