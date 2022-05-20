package supermariobros;

import java.awt.Graphics;
import java.util.LinkedList;
import mariobros.entity.Entity;
import supermariobros.tile.Tile;

/**
 *
 * @author lainati_samuele
 */
public class Handler 
{
    public LinkedList<Entity> entity=new LinkedList<Entity>();
    public LinkedList<Tile> tile=new LinkedList<Tile>();
    
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
    
    public void addTile(Entity add)
    {
        entity.add(add);
    }
    
    public void removeTile(Entity rem)
    {
        entity.remove(rem);
    }
}
