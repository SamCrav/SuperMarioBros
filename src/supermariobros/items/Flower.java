package supermariobros.items;

import mariobros.entity.Entity;
import supermariobros.Game;
import supermariobros.Handler;
import supermariobros.Id;
import supermariobros.tile.Tile;

import java.awt.*;

public class Flower extends Entity
{
    public Flower(int x, int y, int width, int height, boolean solid, Id id, Handler handler)
    {
        super(x,y,width,height,solid,id,handler);
    }

    public void render(Graphics g){
        g.drawImage(Game.mushroom.getBufferedImage(),x,y,width,height,null);
    }

    public void tick()
    {

    }
}