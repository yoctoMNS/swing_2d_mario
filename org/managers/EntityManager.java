package org.managers;

import java.awt.Graphics2D;
import java.util.ArrayList;

import org.entity.Entity;
import org.entity.Camera;
import org.entity.creature.Mario;
import org.graphics.Assets;

public class EntityManager {
    private GameManager gameManager;
    private ArrayList<Entity> entities;
    private static Mario mario;

    public EntityManager(GameManager gameManager) {
        this.gameManager = gameManager;
        mario = new Mario(0, gameManager.getHeight() - Assets.marioRight[0].getHeight() - 29,           // x, y,
                          Assets.marioRight[0].getWidth(), Assets.marioRight[0].getHeight(),            // width, height
                          true);                                                                        // visible
        init();
    }

    private void init() {
        entities = new ArrayList<>();
        addEntity(new Camera(0f, 0f, (float)GameManager.getHeight(), (float)GameManager.getWidth(), true));
        addEntity(mario);
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void render(Graphics2D g) {
        for (Entity e : entities) {
            e.render(g);
        }
    }

    public void update() {
        for (Entity e : entities) {
            e.update();
        }
    }

    public static Mario getMario() {
        return mario;
    }
}
