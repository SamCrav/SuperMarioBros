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
    
    /** variabile image di tipo BufferedImage (privata)*/
    private BufferedImage sheet;

    /**
        @brief metodo SpriteSheet

        usato try catch

        @param path 
    **/
    public SpriteSheet(String path) {
        try {
            sheet = ImageIO.read(getClass().getResource(path));
        } catch (IOException ex) {
            Logger.getLogger(SpriteSheet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
        @brief getter getSmallSprite
        * 
        * restituisce il valore di sheet.getSubimage
        * 
        * @param x orizzontale
        * @param y verticale
        * @param dim dimensione
        * 
        * @return sheet
    **/
    public BufferedImage getSmallSprite(int x, int y, int dim){
        return sheet.getSubimage(x*dim,y*dim,dim,dim);
    }

    /**
        @brief getter getShellSprite
        * 
        * restituisce il valore di sheet.getSubimage
        * 
        * @param x orizzontale
        * 
        * @return sheet
    **/
    public BufferedImage getShellSprite(int x){
        return sheet.getSubimage(x*18,28,18,18);
    }
    
    /**
        @brief getter getSprite
        * 
        * restituisce il valore di sheet.getSubimage
        * 
        * @param x orizzontale
        * @param y verticale
        * 
        * @return sheet
    **/
    public BufferedImage getSprite(int x, int y){
        return sheet.getSubimage(x*16,y*32,16,32);
    }

    /**
        @brief getter getTubeSprite
        * 
        * restituisce il valore di sheet.getSubimage
        * 
        * @param x orizzontale
        * @param y verticale
        * 
        * @return sheet
    **/
    public BufferedImage getTubeSprite(int x, int y){
        return sheet.getSubimage(x*32,y*16,32,16);
    }

    /**
        @brief getter getKoopaSprite
        * 
        * restituisce il valore di sheet.getSubimage
        * 
        * @param x orizzontale
        * @param y verticale
        * 
        * @return sheet
    **/
    public BufferedImage getKoopaSprite(int x, int y){
        return sheet.getSubimage(x*16,y*28,16,28);
    }

    /**
        @brief getter getBackGround
        * 
        * restituisce il valore di sheet.getSubimage
        * 
        * @return sheet
    **/
    public BufferedImage getBackGround(){
        return sheet;
    }
    
}
