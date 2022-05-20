package supermariobros.tile;

import mariobros.entity.Entity;
import supermariobros.Game;
import supermariobros.Handler;
import supermariobros.Id;

import java.awt.*;

public class Special extends Tile{

    /** variabile di tipo Entity contain*/
    public Entity contain;
    
    /**
        @brief costruttore parametrico

        inizializzato il costruttore Special

        @param x orizzontale
        @param y verticale
        @param width larghezza
        @param height lunghezza 
        @param solid solido
        @param id id
        @param handler gestione
    **/
    public Special(int x, int y, int width, int height, boolean solid, Id id, Handler handler,Entity contain) {
        super(x, y, width, height, solid, id, handler);
        this.contain=contain;
    }

    /** variabile int frame*/
    private int frame=0;
    /** variabile int frameDelay*/
    private int frameDelay=0;


    /**
        @brief aggiorna grafica del tile

        aggiorna la grafica e viene visualizzata

        @param g grafica
    **/
    public void render(Graphics g){

            g.drawImage(Game.special[status][frame].getBufferedImage(), x, y, width, height, null);
    }

    /**
        @brief aggiorna il tile

        aggiorna il tile senza visualizzare
    **/
    public void tick() {

        frameDelay++;
        if (frameDelay >= 15) {
            frame++;
            if (frame > 4) {
                frame = 0;
            }
            frameDelay = 0;
        }
    }
}
