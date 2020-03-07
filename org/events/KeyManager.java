package org.events;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    public static boolean isPressKeyW;
    public static boolean isPressKeyA;
    public static boolean isPressKeyS;
    public static boolean isPressKeyD;
    public static boolean isPressKeySpace;

    public KeyManager() {
        isPressKeyW = false;
        isPressKeyA = false;
        isPressKeyS = false;
        isPressKeyD = false;
        isPressKeySpace = false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_W:
            isPressKeyW = true;
            break;

        case KeyEvent.VK_A:
            isPressKeyA = true;
            break;

        case KeyEvent.VK_S:
            isPressKeyS = true;
            break;

        case KeyEvent.VK_D:
            isPressKeyD = true;
            break;

        case KeyEvent.VK_SPACE:
            isPressKeySpace = true;
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_W:
            isPressKeyW = false;
            break;

        case KeyEvent.VK_A:
            isPressKeyA = false;
            break;

        case KeyEvent.VK_S:
            isPressKeyS = false;
            break;

        case KeyEvent.VK_D:
            isPressKeyD = false;
            break;

        case KeyEvent.VK_SPACE:
            isPressKeySpace = false;
            break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
