package Main;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class mouseListener implements MouseListener, MouseMotionListener{
mainStuff men;
public boolean playerClicked=false;
public boolean playerSpeak=false;
public boolean playerDragged=false;
public boolean mouseclicked=false;
public int mouseX;
public int mouseY;
public int offsetX;
public int offsetY;
public Rectangle mouseRect;
public mouseListener(mainStuff men) {
    this.men=men;
}
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int button=e.getButton();
       mouseX=e.getX();
        mouseY=e.getY();
        offsetX = mouseX - men.guy1.X;
offsetY = mouseY - men.guy1.Y;
if (button==MouseEvent.BUTTON1) {
    mouseclicked=true;
}
        mouseRect=new Rectangle(mouseX, mouseY, 1, 1);
        if (mouseRect.intersects(men.guy1.solidArea)) {
            if (button==MouseEvent.BUTTON1) {
                playerClicked=true;
            }
            else if(button==MouseEvent.BUTTON3) {
                playerSpeak=true;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
        mouseclicked=false;
        playerClicked=false;
        playerDragged=false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
    
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
        men.guy1.solidArea.setLocation(men.guy1.X, men.guy1.Y);
        if (playerClicked==true) {
            playerDragged=true;
            men.guy1.X = mouseX - offsetX;
            men.guy1.Y = mouseY - offsetY;
           // men.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
    }

}
