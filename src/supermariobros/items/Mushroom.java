package supermariobros.items;

import mariobros.entity.Entity;
import supermariobros.Game;
import supermariobros.Handler;
import supermariobros.Id;
import supermariobros.tile.Tile;

import java.awt.*;

public class Mushroom extends Entity
{
    /**
        @brief costruttore parametrico

        inizializzato il costruttore Mushroom

        @param x orizzontale
        @param y verticale
        @param width larghezza
        @param height lunghezza 
        @param solid solido
        @param id id
        @param handler gestione
    **/
    public Mushroom(int x, int y, int width, int height, boolean solid, Id id, Handler handler)
    {
        super(x,y,width,height,solid,id,handler);
    }

    /**
        @brief aggiorna grafica del tile

        aggiorna la grafica e viene visualizzata

        @param g grafica
         
        @throws  non funziona drawImage, non spawna
    **/
    public void render(Graphics g){
        g.drawImage(Game.mushroom.getBufferedImage(),x,y,width,height,null);
    }
    
    /**
        @brief aggiorna parametri

        aggiorna i parametri dell'oggetto
    **/
    public void tick()
    {
        x+=velX;
        y+=velY;
        
        for (int i = 0; i < handler.tile.size(); i++) {
            Tile t = handler.tile.get(i);
            if (t.isSolid()) {
                if (getBoundsBottom().intersects(t.getBounds())) {
                    setVelY(0);
                    if (falling) falling = false;

                    else if (!falling) {
                        falling = true;
                        gravity = 0.8;
                    }
                }
                if (getBoundsLeft().intersects(t.getBounds())) {
                    setVelX(2);
                } else if (getBoundsRight().intersects(t.getBounds())) {
                    setVelX(-2);
                }
            }
        }


        if(falling)
        {
            gravity+=0.1;
            setVelY((int)gravity);
        }


    }
}