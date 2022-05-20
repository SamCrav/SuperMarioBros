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

/**
 *
 * @author Andrea
 */
public class Wall extends Tile{

    public Wall(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
        super(x, y, width, height, solid, id, handler);
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Game.brick.getBufferedImage(), x, y, width, height, null);
    }

    @Override
    public void tick() {
        
    }
    
}
