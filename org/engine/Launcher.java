package org.engine;

import org.managers.GameManager;

public class Launcher {
    public static void main(String[] args) {
        new GameManager("Mario", 1280, 720).start();
    }
}
