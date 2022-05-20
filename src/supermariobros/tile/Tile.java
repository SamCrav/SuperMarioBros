package supermariobros.tile;

import java.awt.Graphics;
import java.awt.Rectangle;
import supermariobros.Handler;
import supermariobros.Id;
/**
 *
 * @author Utente
 */
public abstract class Tile 
{
    public int x,y;
    public int width, height;
    public boolean solid;
    
    public int velX, velY;
    
    public Id id;
    
    public Handler handler;
    
    
    public Tile(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.solid = solid;
        this.id = id;
        this.handler=handler;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }
    
    public boolean isSolid() {
        return solid;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public int getVelX() {
        return velX;
    }

    public int getVelY() {
        return velY;
    }
    
    public Id getID()
    {
        return id;
    }
    
    public void incrementa()
    {
        x+=velX;
        y+=velY;
    }
    
    public void die()
    {
        handler.removeTile(this);
    }
    
    public abstract void render(Graphics g);
    
    public abstract void tick();
    
    public Rectangle getBounds()
    {
        return new Rectangle(getX(),getY(),width,height);
    }
}