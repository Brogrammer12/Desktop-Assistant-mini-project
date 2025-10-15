package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class triggerCheck {
    public boolean fileTriggered=false;
    mainStuff men;
    public triggerCheck(mainStuff men) {
        this.men=men;
    }
    public void checkFile() {
        Path filePath=Paths.get("C:/Users/NewAdmin/Downloads/Ianfiles/Documents/shortcut launcher/resources/trigger.txt");
    try {
        BufferedReader br = Files.newBufferedReader(filePath);
        String line;
        while ((line=br.readLine())!=null) {
            if (line.equals("launch_VSCode")) {
                System.out.println("Vs code was triggered wee woo wee woo");
                if (men.guy1.animationFinished==true) {
                    Process process=Runtime.getRuntime().exec("C:/Users/NewAdmin/AppData/Local/Programs/Microsoft VS Code/Code.exe");
                    Files.writeString(filePath, "");
                    men.guy1.animationFinished=false;
                    men.star.loadStar=true;
                    men.star.openedApp="Visual Studio Code";
                    fileTriggered=false;
                }
                else {
                    fileTriggered=true;
                }
            }
            else if(line.equals("launch_Roblox")) {
                System.out.println("Roblox was triggered wee woo wee woo");
                if (men.guy1.animationFinished==true) {
                    Process process=Runtime.getRuntime().exec("C:/Users/NewAdmin/AppData/Local/Roblox/Versions/version-494828652c274712/RobloxPlayerBeta.exe");
                    Files.writeString(filePath, "");
                    men.guy1.animationFinished=false;
                    men.star.loadStar=true;
                    men.star.openedApp="Roblox";
                    fileTriggered=false;
                }
                else {
                    fileTriggered=true;
                }
            }
            else if(line.equals("launch_Curseforge")) {
                System.out.println("Curseforge was triggered wee woo wee woo");
                if (men.guy1.animationFinished==true) {
                    Process process=Runtime.getRuntime().exec("cmd.exe /c runCurseforge.bat");
                    Files.writeString(filePath, "");
                    men.guy1.animationFinished=false;
                    men.star.loadStar=true;
                    men.star.openedApp="CurseForge";
                    fileTriggered=false;
                }
                else {
                    fileTriggered=true;
                }
            }
            else if(line.equals("launch_Steam")) {
                System.out.println("Steam was triggered wee woo wee woo");
                if (men.guy1.animationFinished==true) {
                    Process process=Runtime.getRuntime().exec("C:/Program Files (x86)/Steam/steam.exe");
                    Files.writeString(filePath, "");
                    men.guy1.animationFinished=false;
                    men.star.loadStar=true;
                    men.star.openedApp="Steam";
                    fileTriggered=false;
                }
                else {
                    fileTriggered=true;
                }
            }
        }
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
   

}
