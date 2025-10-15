package Characters;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class characters {
    public int X;
    public int Y;
    public BufferedImage image;
    public int SpriteNum=0;
    public int spriteCounter=0;
    public float velocityY=0;
    public float velocityX=0;
    public float gravity=0.4f;
    public float XGravity=0.4f;
    public boolean currentlyColliding=false;
    public boolean moving=false;
    public int speakTimer=0;
    public int moveDistance=0;
    public int timer=0;
    public int moveSpeed=4;
    public String moveDirection="right";
    public String direction="right";
    public float jumpStrength=-10f;
    public float maxFallSpeed=15;
    public Rectangle solidArea=new Rectangle(X, Y, 48*3, 48*3);
}
