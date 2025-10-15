package Main;

import java.awt.Rectangle;

import Characters.characters;

public class collisionChecker {
    mainStuff men;
    public collisionChecker(mainStuff men) {
        this.men=men;
    }
    public void checkGravity(characters player) {
        player.solidArea.x=player.X;
        player.solidArea.y=(int) (player.Y+player.velocityY);
        if (player.solidArea.intersects(men.guy1.bottomFloor)) {
            player.currentlyColliding=true;
            player.velocityY=0;
        }
        else {
            player.currentlyColliding=false;
        }
        if (player.currentlyColliding==false) {
            player.velocityY+=player.gravity;
            player.velocityY=Math.min(player.velocityY, player.maxFallSpeed);
            player.Y+=player.velocityY;
        }
        if (player.velocityX!=0) {
                if (men.stopX==true) {
                    player.velocityX+=player.XGravity;
        player.velocityX=Math.min(player.velocityX, player.maxFallSpeed);
        player.X+=player.velocityX;
                }
                else if(men.stopXR==true) {
                    player.velocityX-=player.XGravity;
        //entity.velocityX=Math.min(entity.velocityX, entity.maxFallSpeed);
        player.X+=player.velocityX;
                }
        }
        player.solidArea.y=player.Y;
    }
}
