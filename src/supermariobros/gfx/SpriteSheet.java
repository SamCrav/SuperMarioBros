/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermariobros.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class SpriteSheet {
    
    private BufferedImage sheet;

    public SpriteSheet(String path) {
        try {
            sheet = ImageIO.read(getClass().getResource(path));
        } catch (IOException ex) {
            Logger.getLogger(SpriteSheet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public BufferedImage getSmallSprite(int x, int y, int dim){
        return sheet.getSubimage(x*dim,y*dim,dim,dim);
    }

    public BufferedImage getShellSprite(int x){
        return sheet.getSubimage(x*18,28,18,18);
    }
    
    public BufferedImage getSprite(int x, int y){
        return sheet.getSubimage(x*16,y*32,16,32);
    }

    public BufferedImage getTubeSprite(int x, int y){
        return sheet.getSubimage(x*32,y*16,32,16);
    }

    public BufferedImage getKoopaSprite(int x, int y){
        return sheet.getSubimage(x*28,y*16,16,28);
    }

    public BufferedImage getBackGround(){
        return sheet;
    }
    
}
