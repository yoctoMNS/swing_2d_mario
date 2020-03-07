package org.entity.creature;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.entity.Entity;
import org.managers.GameManager;

public class Creature extends Entity {
    protected CreatureDirection direction;

    public Creature(float x, float y, float width, float height, boolean visible) {
        super(x, y, width, height, visible);
        direction = CreatureDirection.STOP;
    }

    @Override
    public void render(Graphics2D g) {
        Transparent(texture, Color.magenta);
        g.drawImage(texture, (int)x, (int)y, (int)width * GameManager.SCALE, (int)height * GameManager.SCALE, null);
        g.drawRect((int)x, (int)y, (int)bounds.getWidth() * GameManager.SCALE, (int)bounds.getHeight() * GameManager.SCALE);
    }

    @Override
    public void update() {
        x += dx;
        y += dy;
    }

    private void Transparent(BufferedImage img, Color c) {
        int w = img.getWidth();
        int h = img.getHeight();
        int t = c.getRGB();

        for (int y = 0; y < h; ++y) {
            for (int x = 0; x < w; ++x) {
                if (img.getRGB(x, y) == t) {
                    img.setRGB(x, y, 0);
                }
            }
        }
    }

    public void setDirection(CreatureDirection direction) {
        this.direction = direction;
    }

    public CreatureDirection getDirection() {
        return direction;
    }
}
