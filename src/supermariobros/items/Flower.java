package supermariobros.items;

import mariobros.entity.Entity;
import supermariobros.Game;
import supermariobros.Handler;
import supermariobros.Id;
import supermariobros.tile.Tile;

import java.awt.*;

public class Flower extends Entity
{
    /**
        @brief costruttore parametrico

        inizializzato il costruttore Flower

        @param x orizzontale
        @param y verticale
        @param width larghezza
        @param height lunghezza 
        @param solid solido
        @param id id
        @param handler gestione
    **/
    public Flower(int x, int y, int width, int height, boolean solid, Id id, Handler handler)
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

    public void tick()
    {

    }
}