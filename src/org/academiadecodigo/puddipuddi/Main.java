package org.academiadecodigo.puddipuddi;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Game g = new Game(1000, 750, 40);

        g.init(); // Creates a bunch of chars and randomly puts them in the field
        g.start(); // Starts the car crash animation

    }
}
