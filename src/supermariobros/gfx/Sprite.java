/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermariobros.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author fumagalli_andrea04
 */
public class Sprite {

    public SpriteSheet sheet;
    
    public BufferedImage image;
    
    public Sprite(SpriteSheet sheet, int x, int y, int dim) {
        if(dim==16)image=sheet.getSmallSprite(x, y);
        else image=sheet.getSprite(x, y);
    }
    
    public BufferedImage getBufferedImage(){
        return image;
    }
}
