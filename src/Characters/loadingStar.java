package Characters;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.w3c.dom.css.Rect;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.RECT;

import Main.mainStuff;

public class loadingStar extends characters{
    mainStuff men;
    public boolean corrupted=false;
    public boolean loadStar=false;
    public boolean starMinigame=false;
    public String openedApp;
    public BufferedImage star1, star2, star3, star4, star1c, star2c, star3c, star4c, tendLeft, tendRight, tendUp, tendDown;
    public loadingStar(mainStuff men) {
        this.men=men;
        X=men.screenWidth/2;
        Y=men.screenHeight/2;
        imageLoader();
    }
    public void imageLoader() {
        try {
            star1=ImageIO.read(getClass().getResourceAsStream("/resources/star/star1 normal.png"));
            star2=ImageIO.read(getClass().getResourceAsStream("/resources/star/star2 normal.png"));
            star3=ImageIO.read(getClass().getResourceAsStream("/resources/star/star3 normal.png"));
            star4=ImageIO.read(getClass().getResourceAsStream("/resources/star/star4 normal.png"));
            star1c=ImageIO.read(getClass().getResourceAsStream("/resources/star/star1 Corrupt.png"));
            star2c=ImageIO.read(getClass().getResourceAsStream("/resources/star/star2 Corrupt.png"));
            star3c=ImageIO.read(getClass().getResourceAsStream("/resources/star/star3 Corrupt.png"));
            star4c=ImageIO.read(getClass().getResourceAsStream("/resources/star/star4 Corrupt.png"));
            tendLeft=ImageIO.read(getClass().getResourceAsStream("/resources/star/tendrilLeft.png"));
            tendRight=ImageIO.read(getClass().getResourceAsStream("/resources/star/tendrilRight.png"));
            tendUp=ImageIO.read(getClass().getResourceAsStream("/resources/star/tendrilUp.png"));
            tendDown=ImageIO.read(getClass().getResourceAsStream("/resources/star/tendrilDown.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void update() {
timer++;
if (timer>=100) {
    timer=0;
}
if (loadStar==true) {
    if (openedApp!=null) {
        HWND hwnd = User32.INSTANCE.FindWindow(null, openedApp);
        if (User32.INSTANCE.IsWindowVisible(hwnd) && hwnd!=null) {
            RECT rect=new RECT();
            User32.INSTANCE.GetWindowRect(hwnd, rect);
            boolean hasSize = (rect.right - rect.left > 100) && (rect.bottom - rect.top > 100);
            if (hasSize==true) {
                loadStar=false;
            }
        }
    }

}
    }
    public void draw(Graphics2D g2) {
        X=men.screenWidth/2;
        Y=men.screenHeight/2;
        image=null;
        if (timer<=25) {
            image=star1;
        }
        else if(timer>25 && timer<=50) {
            image=star2;
        }
        else if(timer>50 && timer<=75) {
            image=star3;
        }
        else if(timer>75 && timer<100) {
            image=star4;
        }
        if (loadStar==true) {
            g2.drawImage(image, X, Y, men.resTileSize, men.resTileSize, null);
        g2.setColor(Color.RED);
        g2.setFont(new Font("Arial",Font.PLAIN, 20));
        g2.drawString("Loading...", X-10, Y+men.resTileSize+20);
        }
    }

}
