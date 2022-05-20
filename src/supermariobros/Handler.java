/**
 * @author Andrea Fumagalli, Samuele Lainati
 * @version 1.0
 * @file Handler.java
 *
 * @brief File per la gestione di tutti gli elementi
 *
 */
package supermariobros;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import mariobros.entity.Entity;
import supermariobros.entity.mob.Goomba;
import supermariobros.entity.mob.Koopa;
import supermariobros.entity.mob.Player;
import supermariobros.gfx.SpriteSheet;
import supermariobros.items.Flower;
import supermariobros.items.Mushroom;
import supermariobros.tile.*;

import javax.imageio.ImageIO;

/**
 * @class Handler
 *
 * @brief Classe per la gestione di tutti gli elementi
 *
 * Gestione di tutti gli elementi presenti nei file
 */
public class Handler 
{
    /**
     * Lista delle entità
     */
    public List<Entity> entity= Collections.synchronizedList(new LinkedList<Entity>());
    /**
     * Lista dei tile della mappa
     */
    public LinkedList<Tile> tile=new LinkedList<Tile>();

    /**
     * buffered image
     */
    private BufferedImage level;

    /**
     * posizioni degli oggetti asse x e y
     */
    private int itemX=0,itemY=0;

    /**
     * moneta
     */
    private Entity coin = new Entity(itemX*64,itemY*64,64,64,true,Id.coin,this);
    /**
     * fungo
     */
    private Mushroom mushroom = new Mushroom(itemX*64,itemY*64,64,64,true,Id.mushroom,this);
    /**
     * fiore
     */
    private Flower flower = new Flower(itemX*64,itemY*64,64,64,true,Id.flower,this);

    
    /**
     * @brief visualizza schermo
     *
     * aggiorna la grafica e viene visualizzato lo schermo
     *
    **/
    public Handler() {
        try {
            level = ImageIO.read(getClass().getResource("/resources/images/map/Level1_1.png"));
        } catch (IOException ex) {
            Logger.getLogger(SpriteSheet.class.getName()).log(Level.SEVERE, null, ex);
        }

        createLevel(level);
    }

    /**
     * @brief visualizza schermo
     *
     * aggiorna la grafica e viene visualizzato lo schermo
     *
     * @param g grafica
    **/
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
    
    /**
     * @brief aggiorna handler
     *
     * viene richiamato ogni tick per aggiornare lo stato del gioco
     *
     * gioco viene aggiornato
    **/
    public void tick()
    {
        entity.forEach(en -> {en.tick();});
        for(Tile t:tile)
        {
            t.tick();
        }
    }
    
    /**
     * @brief aggiunta entità
     *
     * aggiunge l'entità al gioco
     *
     * @param add aggiunge
    **/
    public void addEntity(Entity add)
    {
        entity.add(add);
    }
    
    /**
     * @brief rimuove entità
     *
     * rimuove l'entità dal gioco
     *
     * @param rem rimuove
    **/
    public void removeEntity(Entity rem)
    {
        entity.remove(rem);
    }
    
    /**
     * @brief aggiunta tile della mappa
     *
     * aggiunge tile della mappa al gioco
     *
     * @param add aggiunge
    **/
    public void addTile(Tile add)
    {
        tile.add(add);
    }
    
    /**
     * @brief rimuove tile della mappa
     *
     * rimuove tile della mappa dal gioco
     *
     * @param rem rimuove
    **/
    public void removeTile(Tile rem)
    {
        tile.remove(rem);
    }
    
    /**
     * @brief carica la mappa
     *
     * carica la mappa del gioco
     *
     * @param level
    **/
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
                if(red==255&&green==244&&blue==0)addTile(new Special(x*64,y*64,64,64,true,Id.special,this,coin));
                if(red==255&&green==244&&blue==0)addTile(new Special(x*64,y*64,64,64,true,Id.special,this,mushroom));
                if(red==255&&green==244&&blue==0)addTile(new Special(x*64,y*64,64,64,true,Id.special,this,flower));
                if(red==64&&green==64&&blue==64)addTile(new Wall(x*64,y*64,64,64,true,Id.wall,this));
                if(red==0&&green==0&&blue==255)addTile(new Top_Tube(x*64,y*64,128,64,true,Id.tube,this));
                if(red==0&&green==0&&blue==239)addTile(new Bottom_Tube(x*64,y*64,128,64,true,Id.tube,this));
                if(red==255&&green==0&&blue==0)addEntity(new Goomba(x*64,(y-1)*64,64,64,true,Id.goomba,this));
                if(red==240&&green==0&&blue==0)addEntity(new Koopa(x*64,(y-1)*64,64,96,true,Id.koopa,this));
            }
        }
    }
}