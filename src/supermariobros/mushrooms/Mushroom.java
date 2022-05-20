package supermariobros.mushrooms;

import mariobros.entity.Entity;
import supermariobros.Handler;
import supermariobros.Id;
import supermariobros.tile.Tile;
/**
 *
 * @author lainati_samuele
 */
public class Mushroom extends Entity
{
    public Mushroom(int x, int y, int width, int height, boolean solid, Id id, Handler handler)
    {
        super(x,y,width,height,solid,id,handler);
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
                if(getBoundsBottom().intersects(t.getBounds()))
                {
                    setVelY(0);
                    if(falling)falling=false;
                    
                    else if(!falling)
                    {
                        falling=true;
                        gravity=0.8;
                    }
                }
                if(getBoundsLeft().intersects(t.getBounds()))
                {
                    setVelX(2);
                }
                else if(getBoundsRight().intersects(t.getBounds()))
                {
                    setVelX(-2);
                }
            }
            if(falling)
            {
                gravity+=0.1;
                setVelY((int)gravity);
            }
        }
    }
}