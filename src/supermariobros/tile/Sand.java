package supermariobros.tile;

import supermariobros.Game;
import supermariobros.Handler;
import supermariobros.Id;

import java.awt.*;

public class Sand extends Tile{
    
    /**
     * @brief costruttore parametrico
     *
     * inizializzato il costruttore Sand
     *
     * @param x orizzontale
     * @param y verticale
     * @param width larghezza
     * @param height lunghezza
     * @param solid solido
     * @param id id
     * @param handler gestione
    **/
    public Sand(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
        super(x, y, width, height, solid, id, handler);
    }

    /**
     * @brief aggiorna grafica del tile
     *
     * visualizza il tile
     *
     * @param g grafica
     **/
    @Override
    public void render(Graphics g) {
        g.drawImage(Game.sand.getBufferedImage(), x, y, width, height, null);
    }

    @Override
    public void tick() {

    }
}
