package org.entity.creature;

import org.graphics.Assets;
import org.events.KeyManager;
import org.managers.GameManager;

public class Mario extends Creature {
    public static final int NUMBER_OF_TEXTURES = 4;
    private boolean jump;
    private int cnt = 0;

    public Mario(float x, float y, float width, float height, boolean visible) {
        super(x, y, width, height, visible);
        texture = Assets.marioRight[0];
    }

    @Override
    public void update() {
        super.update();
        move();
    }

    private void move() {
        if (KeyManager.isPressKeyW) {
            direction = CreatureDirection.UP;
            dx = 0f;
            dy = -2f;
            return;
        }
        if (KeyManager.isPressKeyA) {
            direction = CreatureDirection.LEFT;
            dx = -2f;
            dy = 0f;
            texture = Assets.marioLeft[(++cnt / 3) % NUMBER_OF_TEXTURES];
            return;
        }
        if (KeyManager.isPressKeyS) {
            direction = CreatureDirection.DOWN;
            dx = 0f;
            dy = 2f;
            return;
        }
        if (KeyManager.isPressKeyD) {
            direction = CreatureDirection.RIGHT;
            dx = 2f;
            dy = 0f;
            texture = Assets.marioRight[(++cnt / 3) % NUMBER_OF_TEXTURES];
            return;
        }
        if (KeyManager.isPressKeySpace) {
            jump = true;
            return;
        }

        texture = Assets.marioRight[0];
        dx = 0f;
        dy = 0f;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }

    public boolean isJump() {
        return jump;
    }
}
