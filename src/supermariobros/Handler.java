package supermariobros;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import mariobros.entity.Entity;
import supermariobros.entity.mob.Goomba;
import supermariobros.entity.mob.Koopa;
import supermariobros.entity.mob.Player;
import supermariobros.gfx.SpriteSheet;
import supermariobros.tile.*;

import javax.imageio.ImageIO;

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
        g.drawImage(Game.background.getBufferedImage().getScaledInstance(1080,772,0),-Game.cam.getX(),-Game.cam.getY(),null);
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

                if(red==0&&green==0&&blue==1)addTile(new Brick(x*64,y*64, 64,64,true,Id.brick,this));
                if(red==0&&green==255&&blue==0)addTile(new Grass(x*64,y*64, 64,64,true,Id.wall,this));
                if(red==221&&green==255&&blue==0)addTile(new Sand(x*64,y*64, 64,64,true,Id.wall,this));
                if(red==255&&green==255&&blue==255)addEntity(new Player(x*64,y*64,64,64,true,Id.player,this));
                if(red==255&&green==244&&blue==0)addTile(new Special(x*64,y*64,64,64,true,Id.special,this));
                if(red==64&&green==64&&blue==64)addTile(new Wall(x*64,y*64,64,64,true,Id.wall,this));
                if(red==0&&green==0&&blue==255)addTile(new Top_Tube(x*64,y*64,128,64,true,Id.tube,this));
                if(red==0&&green==0&&blue==239)addTile(new Bottom_Tube(x*64,y*64,128,64,true,Id.tube,this));
                if(red==255&&green==0&&blue==0)addEntity(new Goomba(x*64,(y-1)*64,64,64,true,Id.goomba,this));
                if(red==240&&green==0&&blue==0)addEntity(new Koopa(x*64,(y-1)*64,64,96,true,Id.koopa,this));
            }
        }
    }
}
