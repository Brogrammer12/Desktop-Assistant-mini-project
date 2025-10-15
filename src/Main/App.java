package Main;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JWindow;
import com.sun.jna.Native;
import com.sun.jna.platform.WindowUtils;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
public class App {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.noddraw", "true");
        JWindow window=new JWindow();
        //window.setUndecorated(true);
        window.setAlwaysOnTop(true);
        window.setBackground(new Color(0, 0, 0, 0));
        //((java.awt.Window) window).setOpacity(0f); // Alternative for full transparency
        //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(0, 0);
        mainStuff window2=new mainStuff();
        window.add(window2);
        window.setSize(window2.screenWidth, window2.screenHeight);
        window.setVisible(true);
        //WindowUtils.setWindowTransparent(window, true);
        //WindowUtils.setWindowAlpha(window, 1.0f); // Fully visible
        WindowUtils.setWindowMask(window, (java.awt.Shape) null);
        window2.startGameThread();
    }
}
