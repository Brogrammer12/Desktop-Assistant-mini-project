package Characters;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

import Main.mainStuff;

public class ExplosivelyUpwards extends characters{
    mainStuff men;
    public int previousX;
    public int previousY;
    public boolean idle=false;
    public boolean idleBack=false;
    public int differenceX=0;
    public Rectangle bottomFloor;
    public boolean animationFinished=false;
    public boolean playerAskHuman=false;
    public boolean jumpOnWindow=false;
    public boolean run=false;
    public boolean optionMenu=false;
    public boolean hangWindow=false;
    public boolean pathfindingFinished=false;
    public int aimTimer=0;
    public int finalTimer=0;
    public int anotherTimer=0;
    public Rectangle NahTextRight, NahTextLeft, MusicTextRight, MusicTextLeft, skidaddleTextLeft, skidaddleTextRight;
    public int bombX;
    public int bombY;
    public BufferedImage jumpingRight, jumpingLeft, right1, rightIdle2, rightIdle3, rightWalking1, 
    rightWalking2, rightWalking3, rightWalking4, leftWalking1, leftWalking2, leftWalking3, leftWalking4, left1, leftIdle2, 
    leftIdle3, leftSpeaking, leftSpeakingDone, rightSpeaking, rightSpeakingDone, rightRun1, rightRun2, rightRun3, rightRun4,
     rightRun5, leftRun1, leftRun2, leftRun3, leftRun4, leftRun5, aimLeftUp, aimRightUp, aimLeftDown, aimRightDown, bomb, explosion, explosionMove, PlayerHangingRight, PlayerHangingLeft;
    public ExplosivelyUpwards(mainStuff men) {
        this.men=men;
        //NahTextRight=new Rectangle(X+men.resTileSize*2, Y+men.resTileSize, men.resTileSize*3, 30);
        //NahTextLeft=new Rectangle(X-men.resTileSize*2, Y+men.resTileSize, men.resTileSize*3, 30);
        X=500;
        Y=500;
        imageLoader();
    }
public void imageLoader() {
    try {
        right1=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerRight1.png"));
        rightIdle2=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerRightIdle2.png"));
        rightIdle3=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerRightIdle3.png"));
        left1=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerLeft1.png"));
        leftIdle2=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerLeftIdle2.png"));
        leftIdle3=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerLeftIdle3.png"));
        jumpingRight=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerRightJump.png"));
        jumpingLeft=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerLeftJump.png"));
        rightWalking1=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerRightWalking1.png"));
        rightWalking2=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerRightWalking2.png"));
        rightWalking3=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerRightWalking3.png"));
        rightWalking4=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerRightWalking4.png"));
        leftWalking1=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerLeftWalking1.png"));
        leftWalking2=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerLeftWalking2.png"));
        leftWalking3=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerLeftWalking3.png"));
        leftWalking4=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerLeftWalking4.png"));
        rightSpeaking=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerRightSpeaking.png"));
        rightSpeakingDone=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerRightSpeakingDone.png"));
        leftSpeaking=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerLeftSpeaking.png"));
        leftSpeakingDone=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerLeftSpeakingDone.png"));
        rightRun1=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerRunRight1.png"));
        rightRun2=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerRunRight2.png"));
        rightRun3=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerRunRight3.png"));
        rightRun4=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerRunRight4.png"));
        rightRun5=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerRunRight5.png"));
        leftRun1=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerRunLeft1.png"));
        leftRun2=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerRunLeft2.png"));
        leftRun3=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerRunLeft3.png"));
        leftRun4=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerRunLeft4.png"));
        leftRun5=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerRunLeft5.png"));
        aimLeftUp=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerLeftUp.png"));
        aimRightUp=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerRightUp.png"));
        bomb=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/Bomb.png"));
        explosion=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/explosion.png"));
        PlayerHangingRight=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerHangingRight.png"));
        PlayerHangingLeft=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerHangingLeft.png"));
        aimRightDown=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerDownShoot.png"));
        aimLeftDown=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/PlayerDownShootLeft.png"));
        explosionMove=ImageIO.read(getClass().getResourceAsStream("/resources/Explosively Upwards/explosionMove.png"));
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
    public void update() {
        if (men.stopX==true) {
            if (velocityX>=0) {
                velocityX=0;
                men.stopX=false;
            }
        }
        if (men.stopXR==true) {
            if (velocityX<=0) {
                velocityX=0;
                men.stopXR=false;
            }
        }
        solidArea.x=X;
        solidArea.y=Y;
        if (men.m.playerClicked==true) {
            idle=false;
        }
        else if (moving==false) {
            idle=true;
        }
        if (men.m.playerClicked==false && pathfindingFinished==false) {
            men.cChecker.checkGravity(this);
        }
        if (men.m.playerSpeak==false && men.tgc.fileTriggered==false) {
            moveSpeed=4;
            spriteCounter++;
        if (idle==true) {
            if (SpriteNum==3) {
                SpriteNum=0;
            }
            if (spriteCounter>=25) {
                if (idleBack==false && SpriteNum!=2) {
                     SpriteNum++;
                }
                else if (SpriteNum==2) {
                 idleBack=true;
                }
                if (idleBack==true && SpriteNum!=0) {
                 SpriteNum--;
                }
                if (SpriteNum==0 && idleBack==true) {
                 idleBack=false;
                 //SpriteNum++;
                }
                spriteCounter=0;
             }
        }
        else if(moving==true) {
            if (spriteCounter>=12) {
                if (SpriteNum==3) {
                    SpriteNum=0;
                }
                else {
                    SpriteNum++;
                }
                spriteCounter=0;
             }
        }
        if (moving==false) {
            timer++;
        }
        if (timer>400 && moving==false && men.m.playerClicked==false && hangWindow==false) {
            Rectangle windowRect=men.getFocusedWindow();
            int hangOnWindow;
            if (windowRect==null) {
                hangOnWindow=5;
            }
            else {
                hangOnWindow=(int) (Math.random()*10);
            }
            int movedi=(int) (Math.random()*2);
            if (hangOnWindow==0) {
                hangWindow=true;
                if (movedi==0) {
                    moveDistance=Math.abs(X-(windowRect.x+40));
                    if (X<=(windowRect.x+40)) {
                        moveDirection="right";
                    direction="right";
                    }
                    else if(X>(windowRect.x+40)) {
                        moveDirection="left";
                    direction="left";
                    }
                }
                else if(movedi==1) {
                    System.out.println("this one working");
                    moveDistance=Math.abs(X-(windowRect.x+windowRect.width-40-solidArea.width));
                    if (X<=windowRect.x+windowRect.width-40-solidArea.width) {
                        moveDirection="right";
                        direction="right";
                    }
                    else if(X>windowRect.x+windowRect.width-40-solidArea.width) {
                        moveDirection="left";
                    direction="left";
                    }
                }
                timer=0;
            previousX=X;
            moving=true;
           // moveDistance=Math.abs(X-40);
            }
            else {
                moveDistance=(int) (Math.random()*men.screenWidth/2);
            int moveDi=(int) (Math.random()*2);
            if (moveDi==0) {
                moveDirection="right";
                direction="right";
            }
            else if(moveDi==1) {
                moveDirection="left";
                direction="left";
            }
            timer=0;
            previousX=X;
            moving=true;
            }
        }
        if (moving==true) {
            if (moveDirection=="left") {
                 if (previousX-moveDistance<=0) {
                    timer=399;
                    moving=false;
                    idle=true;
                }
                else {
                    if (men.m.playerClicked==true) {
                        timer=0;
                        moving=false;
                        idle=true;
                    }
                    if (previousX-moveDistance<=X) {
                        X-=moveSpeed;
                        idle=false;
                    }
                    else {
                        timer=0;
                        moving=false;
                        idle=true;
                        if (hangWindow==true) {
                            pathfindingFinished=true;
                        }
                    }
                }
            }
            else if(moveDirection=="right") {
                if (previousX+moveDistance>=men.screenWidth) {
                    timer=399;
                    moving=false;
                    idle=true;
                }
                else {
                    if (men.m.playerClicked==true) {
                        timer=0;
                        moving=false;
                        idle=true;
                    }
                    if (previousX+moveDistance>=X) {
                        X+=moveSpeed;
                        idle=false;
                    }
                    else {
                        timer=0;
                        moving=false;
                        idle=true;
                        if (hangWindow==true) {
                            pathfindingFinished=true;
                        }
                    }
                }
            }
        }
        }
        else if(men.tgc.fileTriggered==true) {
            spriteCounter++;
            moveSpeed=6;
            if (spriteCounter>=12) {
                if (SpriteNum==4) {
                    SpriteNum=0;
                }
                else {
                    SpriteNum++;
                }
                spriteCounter=0;
             }
            if (X<men.screenWidth/2) {
                X+=moveSpeed;
                direction="right";
            }
            else if(X>men.screenWidth/2+20) {
                X-=moveSpeed;
                direction="left";
            }
            else {
                aimTimer++;
            }
        }
        else if(men.m.playerSpeak==true) {
            talk();
        }
    }

    public void talk() {
        if ((speakTimer<=53 && playerAskHuman==true) || playerAskHuman==false) {
                speakTimer++;
            }
            if (speakTimer>55) {
                speakTimer=0;
                if (playerAskHuman==true) {
                    men.m.playerSpeak=false;
                }
                else if(playerAskHuman==false) {
                    playerAskHuman=true;
                }
            }
        }

public void drawDialogue(Graphics2D g2) {
    NahTextRight=new Rectangle(X+men.resTileSize*2, Y+men.resTileSize, men.resTileSize*3, 30);
        NahTextLeft=new Rectangle(X-men.resTileSize*2, Y+men.resTileSize, men.resTileSize*3, 30);
        MusicTextRight=new Rectangle(X+men.resTileSize*2, Y+2*men.resTileSize, men.resTileSize*3, 30);
        MusicTextLeft=new Rectangle(X-men.resTileSize*2, Y+2*men.resTileSize, men.resTileSize*3, 30);
        skidaddleTextLeft=new Rectangle(X-men.resTileSize*5, Y+men.resTileSize, men.resTileSize*3, 30);
        skidaddleTextRight=new Rectangle(X+men.resTileSize*5, Y+men.resTileSize, men.resTileSize*3, 30);
    if (direction=="left") {
                    g2.setColor(Color.BLACK);
                    g2.setFont(new Font("Arial",Font.PLAIN, 20));
                    g2.fillRect(X-men.resTileSize*2, Y, men.resTileSize*3, 30);
                    g2.setColor(Color.WHITE);
                    if (playerAskHuman==false) {
                        g2.drawString("Hello There!", X-men.resTileSize*2+20, Y+20);
                    }
                    else {
                        g2.drawString("Need Smth?", X-men.resTileSize*2+20, Y+20);
                        if (speakTimer>53) {
                            g2.setColor(Color.BLACK);
                            g2.fillRect(X-men.resTileSize*2, Y+men.resTileSize, men.resTileSize*3, 30);
                            g2.setColor(Color.WHITE);
                            g2.drawString("Nah.", X-men.resTileSize*2+20, Y+20+men.resTileSize);
                            g2.setColor(Color.BLACK);
                            g2.fillRect(X-men.resTileSize*2, Y+2*men.resTileSize, men.resTileSize*3, 30);
                            g2.setColor(Color.WHITE);
                            g2.drawString("Music.", X-men.resTileSize*2+20, Y+20+2*men.resTileSize);
                            g2.setColor(Color.BLACK);
                            g2.fillRect(X-men.resTileSize*5, Y+men.resTileSize, men.resTileSize*3, 30);
                            g2.setColor(Color.WHITE);
                            g2.drawString("Skidaddle pls.", X-men.resTileSize*5+20, Y+20+men.resTileSize);
                            if (NahTextLeft.intersects(men.m.mouseRect) && men.m.mouseclicked==false) {
                                g2.setColor(Color.WHITE);
                                g2.drawRect(X-men.resTileSize*2, Y+men.resTileSize, men.resTileSize*3, 30);
                            }
                            if (NahTextLeft.intersects(men.m.mouseRect) && men.m.mouseclicked==true) {
                                playerAskHuman=false;
                                speakTimer=0;
                                men.m.playerSpeak=false;
                            }
                            if (MusicTextLeft.intersects(men.m.mouseRect) && men.m.mouseclicked==false) {
                                g2.setColor(Color.WHITE);
                                g2.drawRect(X-men.resTileSize*2, Y+2*men.resTileSize, men.resTileSize*3, 30);
                            }
                            if (MusicTextLeft.intersects(men.m.mouseRect) && men.m.mouseclicked==true) {
                                playerAskHuman=false;
                                speakTimer=0;
                                men.m.playerSpeak=false;
                                try {
                                    Desktop.getDesktop().browse(new URI("https://www.youtube.com/feed/playlists"));
                                } catch (IOException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (URISyntaxException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            }
                            if (skidaddleTextLeft.intersects(men.m.mouseRect) && men.m.mouseclicked==false) {
                                g2.setColor(Color.WHITE);
                                g2.drawRect(X-men.resTileSize*5, Y+men.resTileSize, men.resTileSize*3, 30);
                            }
                            if (skidaddleTextLeft.intersects(men.m.mouseRect) && men.m.mouseclicked==true) {
                                System.exit(0);
                            }
                        }
                    }
                    if (speakTimer<=35) {
                        image=leftSpeaking;
                    }
                    else if(speakTimer>35) {
                        image=leftSpeakingDone;
                    }
                }
                else if(direction=="right") {
                    g2.setColor(Color.BLACK);
                    g2.setFont(new Font("Arial",Font.PLAIN, 20));
                    g2.fillRect(X+men.resTileSize*2, Y, men.resTileSize*3, 30);
                    g2.setColor(Color.WHITE);
                    if (playerAskHuman==false) {
                        g2.drawString("Hello There!", X+men.resTileSize*2+20, Y+20);
                    }
                    else {
                        g2.drawString("Need Smth?", X+men.resTileSize*2+20, Y+20);
                        if (speakTimer>53) {
                            g2.setColor(Color.BLACK);
                            g2.fillRect(X+men.resTileSize*2, Y+men.resTileSize, men.resTileSize*3, 30);
                            g2.setColor(Color.WHITE);
                            g2.drawString("Nah.", X+men.resTileSize*2+20, Y+20+men.resTileSize);
                            g2.setColor(Color.BLACK);
                            g2.fillRect(X+men.resTileSize*2, Y+2*men.resTileSize, men.resTileSize*3, 30);
                            g2.setColor(Color.WHITE);
                            g2.drawString("Music.", X+men.resTileSize*2+20, Y+20+2*men.resTileSize);
                            g2.setColor(Color.BLACK);
                            g2.fillRect(X+men.resTileSize*5, Y+men.resTileSize, men.resTileSize*3, 30);
                            g2.setColor(Color.WHITE);
                            g2.drawString("Skidaddle pls.", X+men.resTileSize*5+20, Y+20+men.resTileSize);
                            if (NahTextRight.intersects(men.m.mouseRect) && men.m.mouseclicked==false) {
                                g2.setColor(Color.WHITE);
                               g2.drawRect(X+men.resTileSize*2, Y+men.resTileSize, men.resTileSize*3, 30);
                            }
                            if (NahTextRight.intersects(men.m.mouseRect) && men.m.mouseclicked==true) {
                                playerAskHuman=false;
                                speakTimer=0;
                                men.m.playerSpeak=false;
                            }
                            if (MusicTextRight.intersects(men.m.mouseRect) && men.m.mouseclicked==false) {
                                g2.setColor(Color.WHITE);
                               g2.drawRect(X+men.resTileSize*2, Y+2*men.resTileSize, men.resTileSize*3, 30);
                            }
                            if (MusicTextRight.intersects(men.m.mouseRect) && men.m.mouseclicked==true) {
                                playerAskHuman=false;
                                speakTimer=0;
                                men.m.playerSpeak=false;
                                try {
                                    Desktop.getDesktop().browse(new URI("https://www.youtube.com/feed/playlists"));
                                } catch (IOException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (URISyntaxException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            }
                             if (skidaddleTextRight.intersects(men.m.mouseRect) && men.m.mouseclicked==false) {
                                g2.setColor(Color.WHITE);
                                g2.drawRect(X+men.resTileSize*5, Y+men.resTileSize, men.resTileSize*3, 30);
                            }
                            if (skidaddleTextRight.intersects(men.m.mouseRect) && men.m.mouseclicked==true) {
                                System.exit(0);
                            }
                        }
                    }
                    if (speakTimer<=35) {
                        image=rightSpeaking;
                    }
                    else if(speakTimer>35) {
                        image=rightSpeakingDone;
                    }
                }
}
    public void draw(Graphics2D g2) {
        if (men.m.playerClicked==true) {
            if (direction=="right") {
                image=jumpingRight;
            }
            else if(direction=="left") {
            image=jumpingLeft;
            }
            velocityY=0;
        }
        if (men.m.playerSpeak==false && men.tgc.fileTriggered==false) {
            if (idle==true) {
            if (direction=="right") {
                if (SpriteNum==0) {
                            image=right1;
                            
                    }
                    else if(SpriteNum==1) {
                            image=rightIdle2;
                            
                    }
                    else if(SpriteNum==2) {
                            image=rightIdle3;
                            
                    }
            }
            else if(direction=="left") {
                if (SpriteNum==0) {
                            image=left1;
                            
                    }
                    else if(SpriteNum==1) {
                            image=leftIdle2;
                            
                    }
                    else if(SpriteNum==2) {
                            image=leftIdle3;
                            
                    }
            }
                    }
                    else if (moving==true) {
                        if (direction=="right") {
                            if (SpriteNum==0) {
                            image=rightWalking1;
                            
                    }
                    else if(SpriteNum==1) {
                            image=rightWalking2;
                            
                    }
                    else if(SpriteNum==2) {
                            image=rightWalking3;
                            
                    }
                    else if(SpriteNum==3) {
                            image=rightWalking4;
                            
                    }
                        }
                        else if(direction=="left") {
                            if (SpriteNum==0) {
                            image=leftWalking1;
                            
                    }
                    else if(SpriteNum==1) {
                            image=leftWalking2;
                            
                    }
                    else if(SpriteNum==2) {
                            image=leftWalking3;
                            
                    }
                    else if(SpriteNum==3) {
                            image=leftWalking4;
                            
                    }
                        }
                    }
        }
        else if(men.tgc.fileTriggered==true) {
            if (direction=="right") {
                            if (SpriteNum==0) {
                            image=rightRun1;
                            
                    }
                    else if(SpriteNum==1) {
                            image=rightRun2;
                            
                    }
                    else if(SpriteNum==2) {
                            image=rightRun3;
                            
                    }
                    else if(SpriteNum==3) {
                            image=rightRun4;
                            
                    }
                    else if(SpriteNum==4) {
                            image=rightRun5;
                            
                    }
                        }
                        else if(direction=="left") {
                            if (SpriteNum==0) {
                            image=leftRun1;
                            
                    }
                    else if(SpriteNum==1) {
                            image=leftRun2;
                            
                    }
                    else if(SpriteNum==2) {
                            image=leftRun3;
                            
                    }
                    else if(SpriteNum==3) {
                            image=leftRun4;
                            
                    }
                    else if(SpriteNum==4) {
                            image=leftRun5;
                            
                    }
                        }
                        if (aimTimer!=0) {
                            if (aimTimer<=2) {
                                bombX=X;
                                bombY=Y;
                            }
                            if (direction=="left") {
                                image=aimLeftUp;
                                System.out.println("Running");
                            }
                            else if(direction=="right") {
                                image=aimRightUp;
                                System.out.println("Running");
                            }
                            if (bombY>men.screenHeight/2) {
                                g2.drawImage(bomb, bombX, bombY, men.resTileSize, men.resTileSize, null);
                                bombY-=6;
                            }
                            else {
                                finalTimer++;
                                g2.drawImage(explosion, bombX, bombY, men.resTileSize, men.resTileSize, null);
                                if (finalTimer>=50) {
                                    aimTimer=0;
                                    finalTimer=0;
                                    men.tgc.fileTriggered=false;
                                    animationFinished=true;
                                }
                            }
                        }
        }
            else if (men.m.playerSpeak==true) {
                        drawDialogue(g2);
                    }
                    if (pathfindingFinished==true) {
                        Rectangle windowrect=men.getFocusedWindow();
                        anotherTimer++;
                        if (anotherTimer<=2) {
                            bombX=X+10;
                        bombY=Y+solidArea.height;
                        if (X<men.screenWidth/2) {
                            direction="right";
                        }
                        else if(X>men.screenWidth/2) {
                            direction="left";
                        }
                        }
                            if (anotherTimer>100) {
                                if (anotherTimer>=1000) {
                                    pathfindingFinished=false;
                                        moving=false;
                                        idle=true;
                                        anotherTimer=0;
                                        timer=0;
                                        hangWindow=false;
                                }
                                if (Y>windowrect.y) {
                                    if (Y>(windowrect.y+windowrect.height)/2) {
                                        g2.drawImage(explosionMove, bombX, bombY, men.resTileSize, men.resTileSize, null);
                                    }
                             Y-=10;
                             if (direction=="right") {
                                image=jumpingRight;
                             }
                             else if(direction=="left") {
                                image=jumpingLeft;
                             } 
                                }
                                else {
                                    if (men.m.playerClicked==true) {
                                        pathfindingFinished=false;
                                        moving=false;
                                        idle=true;
                                        anotherTimer=0;
                                        timer=0;
                                        hangWindow=false;
                                    }
                                    if (direction=="right") {
                                        image=PlayerHangingRight;
                                    }
                                    else if(direction=="left") {
                                        image=PlayerHangingLeft;
                                    }
                                }
                            }
                            else {
                                if (direction=="right") {
                                    image=aimRightDown;
                        }
                        else if(direction=="left") {
                            image=aimLeftDown;
                        }
                            }
                    }
                    //g2.setColor(Color.RED);
                    bottomFloor=new Rectangle(0, 1035, men.screenWidth, men.screenHeight);
                    //g2.fillRect(bottomFloor.x, bottomFloor.y, bottomFloor.width, bottomFloor.height);
        g2.drawImage(image, X, Y, men.resTileSize*3, men.resTileSize*3, null);
    }
}
