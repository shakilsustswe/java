package design_pattern.Behavioral_pattern.template_method;

abstract class Game {

    abstract void start();

    abstract void run();

    abstract void stop();

    public final void play() {
        start();
        run();
        stop();
    }

}

class Cricket extends Game {

    @Override
    void run() {
        System.out.println("Run.........");

    }

    @Override
    void start() {
        System.out.println("Cricket started");
    }

    @Override
    void stop() {
        System.out.println("Game stop.....!!!");
    }

}

class Football extends Game {

    @Override
    void run() {
        System.out.println("Run.........");

    }

    @Override
    void start() {
        System.out.println("Football started");
    }

    @Override
    void stop() {
        System.out.println("Game stop.....!!!");
    }

}

public class Main {
    public static void main(String[] args) {

        Game cricket = new Cricket();
        cricket.play();

        Game football = new Football();
        football.play();
    }
}
