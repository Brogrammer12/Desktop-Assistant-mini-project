package Main;
import javax.swing.JPanel;

import com.sun.jna.platform.WindowUtils;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.Netapi32Util.User;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.RECT;

import Characters.ExplosivelyUpwards;
import Characters.loadingStar;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.sun.jna.Native;
public class mainStuff extends JPanel implements Runnable{
    int FPS=60;
    public global_Hotkey gHotkey=new global_Hotkey(this);
    public loadingStar star=new loadingStar(this);
    ExplosivelyUpwards guy1=new ExplosivelyUpwards(this);
    public mouseListener m=new mouseListener(this);
    public collisionChecker cChecker=new collisionChecker(this);
    public triggerCheck tgc=new triggerCheck(this);
    Thread thread;
    public int resTileSize=48;
    public int frameCounter=0;
    public String focusedWindowTitle;
    public RECT focusedWindowR=new RECT();
    public Rectangle focusedWindowRectangle;
    public boolean stopX=false;
    public boolean stopXR=false;
    public boolean clickable=true;
    public int globalMouseX=0;
    public int globalMouseY=0;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        public int screenWidth = screenSize.width;
        public int screenHeight = screenSize.height;
    public mainStuff() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setOpaque(false);
        this.setBackground(new Color(0, 0, 0, 0)); // Solid black
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addMouseListener(m);
        this.addMouseMotionListener(m);
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
    logger.setLevel(Level.OFF);
    logger.setUseParentHandlers(false);

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(gHotkey);
    }
    @Override
public boolean isOpaque() {
    return false;
}

    public void startGameThread() {
        thread=new Thread(this);
        thread.start();
        /*JNAGlobalHook.setTarget(this);
        new Thread(() -> JNAGlobalHook.startMouseHook()).start(); */
    }
    @Override
    public void run() {
        double drawInterval=1000000000/FPS;
        double nextDrawTime=System.nanoTime()+drawInterval;
        while (thread!=null) {
            update();
            repaint();
            try {
                double remainingTime=nextDrawTime-System.nanoTime();
                remainingTime/=1000000;
                if(remainingTime<0) {
                    remainingTime=0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime+=drawInterval;
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
            
        }
    }
    public void setClickable() {
        if (clickable==true) {
            clickable=false;
            this.removeMouseListener(m);
            this.removeMouseMotionListener(m);
            this.setEnabled(false);
            this.setFocusable(false);
        }
        else if(clickable==false) {
            clickable=true;
            this.addMouseListener(m);
            this.addMouseMotionListener(m);
            this.setEnabled(true);
            this.setFocusable(true);
        }
    }
    public void update() {
        m.mouseRect=new Rectangle(m.mouseX, m.mouseY, 1, 1);
        /*if (m.mouseX!=globalMouseX) {
            m.mouseX=globalMouseX;
        }
        if (m.mouseY!=globalMouseY) {
            m.mouseY=globalMouseY;
        }*/
        guy1.update();
        star.update();
        tgc.checkFile();
    }
    public Rectangle getFocusedWindow() {
        //System.out.println(focusedWindowTitle);
        char[] buffer=new char[1024];
        HWND hwnd=User32.INSTANCE.GetForegroundWindow();
 User32.INSTANCE.GetWindowText(hwnd, buffer, 1024);
        focusedWindowTitle=Native.toString(buffer);
    if (focusedWindowTitle==null || hwnd==null || !User32.INSTANCE.IsWindowVisible(hwnd) || focusedWindowTitle.trim().isEmpty()) {
        focusedWindowRectangle = null;
        return null;
    }
        User32.INSTANCE.GetWindowRect(hwnd, focusedWindowR);
        focusedWindowRectangle=new Rectangle(
            focusedWindowR.left,
        focusedWindowR.top,
        focusedWindowR.right-focusedWindowR.left,
        focusedWindowR.bottom-focusedWindowR.top
        );
        return focusedWindowRectangle;
        //System.out.println(focusedWindowTitle+"x:"+focusedWindowRectangle.x);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        guy1.draw(g2);
        star.draw(g2);
        g2.dispose();
        //g2.setColor(Color.BLACK);
        //g2.fillRect(100, 100, 50, 50);
    }

}
