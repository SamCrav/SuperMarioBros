/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermariobros.gfx;

import java.awt.image.BufferedImage;

public class Sprite {

    /** variabile sheet di tipo SpriteSheet (pubblica)*/
    public SpriteSheet sheet;
    
    /** variabile image di tipo BufferedImage (pubblica)*/
    public BufferedImage image;
    
    /**
     * @brief metodo Sprite
     *
     * dimensione delle immagini
     *
     * @param x orizzontale
     * @param y verticale
     * @param dim dimensione
     * @param sheet
    **/
    public Sprite(SpriteSheet sheet, int x, int y, int dim) {
        if(dim==16)image=sheet.getSmallSprite(x, y, dim);
        else if(dim==17) image=sheet.getShellSprite(x);
        else if(dim==18) image=sheet.getSmallSprite(x, y, dim);
        else if(dim==24) image=sheet.getTubeSprite(x, y);
        else if(dim==28) image=sheet.getKoopaSprite(x, y);
        else if(dim>200) image=sheet.getBackGround();
        else image=sheet.getSprite(x, y);
    }
    
    /**
     * @brief getter BufferedImage
     *
     * restituisce il valore di image
     *
     * @return image--> immagine
    **/
    public BufferedImage getBufferedImage(){
        return image;
    }
}
