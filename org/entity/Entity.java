package org.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.geom.Rectangle2D;

public abstract class Entity {
    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected float dx;
    protected float dy;
    protected Rectangle2D.Float bounds;
    protected BufferedImage texture;
    protected boolean visible;
    protected float gravity;

    public Entity(float x, float y, float width, float height, boolean visible) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dx = 0;
        this.dy = 0;
        this.bounds = new Rectangle2D.Float(x, y, width, height);
        this.visible = visible;
    }

    public abstract void render(Graphics2D g);

    public abstract void update();

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getWidth() {
        return width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getHeight() {
        return height;
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    public float getDx() {
        return dx;
    }

    public void setDy(float dy) {
        this.dy = dy;
    }

    public float getDy() {
        return dy;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }
}
