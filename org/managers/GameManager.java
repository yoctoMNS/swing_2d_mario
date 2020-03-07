package org.managers;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import org.graphics.Assets;
import org.entity.creature.Mario;
import org.events.KeyManager;

public class GameManager implements Runnable {
    public static final int SCALE = 2;
    public static final int GROUND = 674;

    private boolean running;
    private Thread gameThread;

    private BufferStrategy bs;
    private Graphics2D g;
    private static JFrame mainFrame;
    private static Canvas mainCanvas;

    private EntityManager entityManager;

    public GameManager(String title, int width, int height) {
        mainFrame = new JFrame(title);
        mainFrame.setSize(width, height);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.addKeyListener(new KeyManager());

        mainCanvas = new Canvas();
        mainCanvas.setSize(width, height);
        mainCanvas.setPreferredSize(new Dimension(width, height));
        mainCanvas.setMaximumSize(new Dimension(width, height));
        mainCanvas.setMinimumSize(new Dimension(width, height));

        mainFrame.add(mainCanvas);
        mainFrame.pack();
    }

    private void init() {
        int width = mainFrame.getWidth();
        int height = mainFrame.getHeight();

        Assets.init();
        entityManager = new EntityManager(this);
    }

    public synchronized void start() {
        if (running) {
            return;
        }

        running = true;
        gameThread = new Thread(this);
        gameThread.setName("Game Thread");
        gameThread.start();
    }

    private void render() {
        bs = mainCanvas.getBufferStrategy();
        if (bs == null) {
            mainCanvas.createBufferStrategy(3);
            return;
        }

        g = (Graphics2D)bs.getDrawGraphics();
        g.clearRect(0, 0, getWidth(), getHeight());

        entityManager.render(g);

        bs.show();
        g.dispose();
    }

    private void update() {
        entityManager.update();
    }

    @Override
    public void run() {
        init();

        int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

        while (running) {
            now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
                update();
				render();
				ticks++;
				delta--;
			}
        }
    }

    public static int getWidth() {
        return mainFrame.getWidth();
    }

    public static int getHeight() {
        return mainFrame.getHeight();
    }
}
