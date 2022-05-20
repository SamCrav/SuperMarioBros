package supermariobros;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import mariobros.entity.Entity;
import supermariobros.entity.mob.Player;
import supermariobros.gfx.SpriteSheet;
import supermariobros.tile.Grass;
import supermariobros.tile.Sand;
import supermariobros.tile.Tile;
import supermariobros.tile.Wall;

import javax.imageio.ImageIO;

/**
 *
 * @author lainati_samuele
 */
public class Handler 
{
    public LinkedList<Entity> entity=new LinkedList<Entity>();
    public LinkedList<Tile> tile=new LinkedList<Tile>();

    private BufferedImage level;

    public Handler() {
        try {
            level = ImageIO.read(getClass().getResource("/resources/images/map/Level1_1.png"));
        } catch (IOException ex) {
            Logger.getLogger(SpriteSheet.class.getName()).log(Level.SEVERE, null, ex);
        }

        createLevel(level);
    }

    public void render(Graphics g)
    {
        for(Entity en:entity)
        {
            en.render(g);
        }
        for(Tile t:tile)
        {
            t.render(g);
        }
    }
    
    public void tick()
    {
        for(Entity en:entity)
        {
            en.tick();
        }
        for(Tile t:tile)
        {
            t.tick();
        }
    }
    
    public void addEntity(Entity add)
    {
        entity.add(add);
    }
    
    public void removeEntity(Entity rem)
    {
        entity.remove(rem);
    }
    
    public void addTile(Tile add)
    {
        tile.add(add);
    }
    
    public void removeTile(Tile rem)
    {
        tile.remove(rem);
    }
    
    public void createLevel(BufferedImage level){
        int width = level.getWidth();
        int height = level.getHeight();

        for (int y = 0;y<height;y++) {
            for (int x = 0; x < width; x++) {
                int pixel = level.getRGB(x,y);

                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;

                if(red==0&&green==0&&blue==1)addTile(new Wall(x*64,y*64, 64,64,true,Id.wall,this));
                if(red==0&&green==255&&blue==0)addTile(new Grass(x*64,y*64, 64,64,true,Id.wall,this));
                if(red==221&&green==255&&blue==0)addTile(new Sand(x*64,y*64, 64,64,true,Id.wall,this));
                if(red==255&&green==255&&blue==255)addEntity(new Player(x*64,y*64,64,64,true,Id.player,this));
            }
        }
    }
}
