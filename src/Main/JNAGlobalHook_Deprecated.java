package Main;


import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.HMODULE;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.WinUser.MSLLHOOKSTRUCT;
import com.sun.jna.win32.StdCallLibrary;

public class JNAGlobalHook_Deprecated {
public static mainStuff men;
public static void setTarget(mainStuff e) {
    men=e;
}
    public static final int WM_MOUSEMOVE = 0x0200;
     public interface User32 extends StdCallLibrary {
        User32 INSTANCE = (User32) Native.load("user32", User32.class);

        WinUser.HHOOK SetWindowsHookExW(int idHook, WinUser.LowLevelMouseProc lpfn, WinDef.HMODULE hMod, int dwThreadId);
        WinDef.LRESULT CallNextHookEx(WinUser.HHOOK hhk, int nCode, WinUser.WPARAM wParam, WinUser.LPARAM lParam);
        boolean UnhookWindowsHookEx(WinUser.HHOOK hhk);
        boolean GetMessageW(WinUser.MSG lpMsg, WinUser.HWND hWnd, int wMsgFilterMin, int wMsgFilterMax);
    }

    // Hook handle
    private static WinUser.HHOOK hHook;

    public static void main(String[] args) {
        startMouseHook();
    }

    public static void startMouseHook() {
        // Define the callback for mouse events
        WinUser.LowLevelMouseProc mouseHook = new WinUser.LowLevelMouseProc() {
            public WinDef.LRESULT callback(int nCode, WinUser.WPARAM wParam, MSLLHOOKSTRUCT lParam) {
                if (nCode >= 0 && wParam.intValue() == WM_MOUSEMOVE) {
                    onMouseMove(lParam.pt.x, lParam.pt.y);
                }
                return User32.INSTANCE.CallNextHookEx(hHook, nCode, wParam, new WinUser.LPARAM(Pointer.nativeValue(lParam.getPointer())));
            }
        };

        // Register the global mouse hook
        hHook = User32.INSTANCE.SetWindowsHookExW(WinUser.WH_MOUSE_LL, mouseHook, null, 0);

        // Message loop to keep the hook alive
        WinUser.MSG msg = new WinUser.MSG();
        while (User32.INSTANCE.GetMessageW(msg, null, 0, 0)) {
            // No need to process messages—just keep the hook alive
        }

        // Unhook when done (this line won't be reached unless the loop exits)
        User32.INSTANCE.UnhookWindowsHookEx(hHook);
    }

    // Custom method to handle mouse movement
    public static void onMouseMove(int x, int y) {
       men.globalMouseX=x;
       men.globalMouseY=y;
        // You can trigger animations or other logic here
    }

}


//I'll be completely honest, i copy pasted this bad boy from AI. i have no clue how it works lol