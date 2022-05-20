/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermariobros.entity.mob;

import java.awt.Graphics;
import mariobros.entity.Entity;
import supermariobros.Handler;
import supermariobros.Id;

/**
 *
 * @author lainati_samuele
 */
public class Koopa extends Entity 
{
    public Koopa(int x, int y, int width, int height, boolean solid, Id id, Handler handler)
    {
        super(x,y,width,height,solid,id,handler);
    }
    
    public void render(Graphics g)
    {
        if(facing==0)
        {
            g.drawImage(Game.player[4+frame].getBufferedImage(),x,y,width,height,null);
        }
        else if(facing==1)
        {
            g.drawImage(Game.player[frame].getBufferedImage(),x,y,width,height,null);
        }
    }
}