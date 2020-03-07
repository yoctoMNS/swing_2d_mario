package org.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.graphics.Assets;
import org.entity.Entity;
import org.entity.creature.Mario;
import org.managers.EntityManager;
import org.managers.GameManager;

public class Camera extends Entity {
    private static Mario mario;

    public Camera(float x, float y, float width, float height, boolean visible) {
        super(x, y, width, height, visible);
        mario = EntityManager.getMario();
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(Assets.background,
                    0, 0, GameManager.getWidth(), GameManager.getHeight(),
                    ((int)mario.getX() + (int)mario.getWidth()) * GameManager.SCALE, 0,
                    ((int)mario.getX() + (int)mario.getWidth()) * GameManager.SCALE + GameManager.getWidth(), Assets.background.getHeight(),
                    null);
    }

    @Override
    public void update() {
    }
}
