package org.graphics;

import java.awt.image.BufferedImage;

public class Assets {
    public static final int MARIO_HEIGHT = 48;
    public static BufferedImage[] marioLeft = new BufferedImage[4];
    public static BufferedImage[] marioRight = new BufferedImage[4];
    public static BufferedImage background;

    public static void init() {
        SpriteSheet marioForm = new SpriteSheet(ImageLoader.loadImage("/res/images/mario-forms.png"));
        marioLeft[0] = marioForm.crop(0,   MARIO_HEIGHT,      38, MARIO_HEIGHT);
        marioLeft[1] = marioForm.crop(0,   MARIO_HEIGHT * 2,  47, MARIO_HEIGHT);
        marioLeft[2] = marioForm.crop(0,   MARIO_HEIGHT * 3,  35, MARIO_HEIGHT);
        marioLeft[3] = marioForm.crop(0,   MARIO_HEIGHT * 4,  41, MARIO_HEIGHT);

        marioRight[0] = marioForm.crop(51, MARIO_HEIGHT,      38, MARIO_HEIGHT);
        marioRight[1] = marioForm.crop(51, MARIO_HEIGHT * 2,  47, MARIO_HEIGHT);
        marioRight[2] = marioForm.crop(51, MARIO_HEIGHT * 3,  35, MARIO_HEIGHT);
        marioRight[3] = marioForm.crop(51, MARIO_HEIGHT * 4,  41, MARIO_HEIGHT);

        background = ImageLoader.loadImage("/res/images/background.png");
    }
}
