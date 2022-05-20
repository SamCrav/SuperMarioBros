package supermariobros.entity.mob;

import java.awt.Graphics;
import mariobros.entity.Entity;
import supermariobros.Handler;
import supermariobros.Id;
import supermariobros.tile.Tile;
/**
 *
 * @author lainati_samuele
 */
public class Player extends Entity
{
    public Player(int x, int y, int width, int height, boolean solid, Id id, Handler handler)
    {
        super(x,y,width,height,solid,id,handler);
    }
    
    //real
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
    
    public void tick()
    {
        x+=velX;
        y+=velY;
        
        for (int i = 0; i < handler.tile.size(); i++) 
        {
            Tile t=handler.tile.get(i);
            if(t.isSolid())
            {
                if(getBoundsTop().intersects(t.getBounds()))
                {
                    setVelY(0);
                    if(jumping)
                    {
                        jumping=false;
                        gravity=0.8;
                        falling=true;
                    }
                }
                if(getBoundsBottom().intersects(t.getBounds()))
                {
                    setVelY(0);
                    if(falling)falling=false;
                }
                else if(!falling&&!jumping)
                {
                        gravity=0.8;
                        falling=true;
                    }
                }
            if(getBoundsLeft().intersects(t.getBounds()))
                {
                    setVelX(0);
                    x=t.getX()+t.width;
                }
            if(getBoundsRight().intersects(t.getBounds()))
                {
                    setVelX(0);
                    x=t.getX()+t.width;
                }
            
            }
        }
    
    for(int i=0; i<handler.entity.size();i++)
    {
        Entity e= handler.entity.get();
        
    if(f.getId()==Id.mushroom)
    {
        if(getBounds().intersects(e.getBounds()))
        {
            int tpX=getX();
            int tpY=getY();
            width*=2;
            height*=2;
            setX(tpX-width);
            setY(tpY-height);
            e.die();
        }
    }
        else if(e.getId()==Id.goomba)
        {
            if(getBoundsBottom()intersects(e.getBoundsTop()))
            {
                e.die();
            }
            else if(getBounds.intersects(e.getBounds()))
            {
               die();
            }
        }
    }
    if(jumping)
    {
        setVelY((int)-gravity);
        if(gravity<=0.0)
        {
            jumping=false;
            falling=false;
        }
    }
    if (falling)
    {
        gravity+=0.1;
        setVelY((int)gravity);
    }
    
    if(velX!=0)
    {
        frameDelay++;
        if(frameDelay>=10)
        {
            frame++;
            if(frame>3)
            {
                frame=0;
            }
            frameDelay=0;
        }
    }
}