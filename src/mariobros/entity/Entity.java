package mariobros.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import supermariobros.Game;
import supermariobros.Handler;
import supermariobros.Id;


public class Entity
{
    public int x,y;
    public int width, height;
    public int facing=0;

    public int status =0;
    
    public int frame=0;
    public int frameDelay=0;
    
    public boolean solid;
    public boolean jumping=false;
    public boolean falling=true;
    
    public int velX, velY;
    
    public Id id;
    
    public Handler handler;
    protected boolean animate = false;

    
    public double gravity = 0.0;
    
    
    public Entity(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.solid = solid;
        this.id=id;
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
    
    public Id getId()
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
        handler.removeEntity(this);
    }

    public Rectangle getBounds()
    {
        return new Rectangle(getX(),getY(),width,height);
    }
    
    public Rectangle getBoundsRight()
    {
        return new Rectangle(getX()+10+width-5,getY()+10,5,height-20);
    }
    
    public Rectangle getBoundsBottom()
    {
        return new Rectangle(getX()+10,getY()+width-5,width-20,5);
    }
    
    public Rectangle getBoundsLeft()
    {
        return new Rectangle(getX(),getY()+10,5,height-20);
    }
    
    public Rectangle getBoundsTop()
    {
        return new Rectangle(getX()+10,getY(),width-20,5);
    }
    
    public void render(Graphics g){};
    
    public void tick(){};
}