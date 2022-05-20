/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermariobros.tile;

import java.awt.Color;
import java.awt.Graphics;

import supermariobros.Game;
import supermariobros.Handler;
import supermariobros.Id;

public class Wall extends Tile{

    /**
     * @brief costruttore parametrico
     *
     * inizializzato il costruttore Wall
     *
     * @param x orizzontale
     * @param y verticale
     * @param width larghezza
     * @param height lunghezza
     * @param solid solido
     * @param id id
     * @param handler gestione
    **/
    public Wall(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
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
        g.drawImage(Game.solid.getBufferedImage(), x, y, width, height, null);
    }

    @Override
    public void tick() {
        
    }
    
}
