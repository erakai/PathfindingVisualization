package main.core;

import main.util.ResourceManager;

import java.io.IOException;

public class Game {

    public Game() {
        try {
            ResourceManager.initialize("resources");
        } catch (IOException e) { e.printStackTrace(); }
    }



}
