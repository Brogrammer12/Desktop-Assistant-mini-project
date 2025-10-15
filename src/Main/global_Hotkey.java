package Main;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class global_Hotkey implements NativeKeyListener{
    mainStuff men;
    public global_Hotkey(mainStuff men) {
        this.men=men;
    }
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        if (e.getKeyCode()==NativeKeyEvent.VC_F12) {
            men.setClickable();
        }
    }

}
