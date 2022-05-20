package mariobros.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import supermariobros.Game;
import supermariobros.Handler;
import supermariobros.Id;


public class Entity
{
    /**variabili intere x e y, orizzontale e verticale*/
    public int x,y;
    /**variabili intere width e height, larghezza e altezza*/
    public int width, height;
    /**variabile intera facing inizializzata a 0*/
    public int facing=0;

    /**variabile intera status inizializzata a 0*/
    public int status =0;
    
    /**variabile intera frame inizializzata a 0 */
    public int frame=0;
    /**variabile intera frameDelay inizializzata a 0 */
    public int frameDelay=0;
    
    /**variabile booleana solid */
    public boolean solid;
    /**variabile booleana del salto inizializzata a false */
    public boolean jumping=false;
    /**variabile booleana della caduta inizializzata a true */
    public boolean falling=true;
    
    /**variabili intere velX e velY, orizzontale e verticale*/
    public int velX, velY;
    
    /**variabili intera dell'id*/
    public Id id;
    
    /**variabili di tipo Handler dell'handler*/
    public Handler handler;
    /**variabile booleana dell'animazione inizializzata a false */
    protected boolean animate = false;

    /**variabile di tipo double della gravità inizializzata a 0.0 */
    public double gravity = 0.0;
    
    /**
        @brief costruttore parametrico

        inizializzato il costruttore Entity

        @param x orizzontale
        @param y verticale
        @param width larghezza
        @param height lunghezza 
        @param solid solido
        @param id id
        @param handler gestione
    **/
    public Entity(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.solid = solid;
        this.id=id;
        this.handler=handler;
    }

    /**
     @brief setter di x

     @param x nuova posizione sull'asse x
     **/
    public void setX(int x) {
        this.x = x;
    }

    /**
     @brief setter di y

     @param y nuova posizione sull'asse y
     **/
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     @brief getter di x

     restituisce il valore dell'attributo x

     @return valore dell'attributo x
     **/
    public int getX() {
        return x;
    }

    /**
     @brief getter di y

     restituisce il valore dell'attributo y

     @return valore dell'attributo y
     **/
    public int getY() {
        return y;
    }

    /**
     @brief setter di Solid

     @param solid
     **/
    public void setSolid(boolean solid) {
        this.solid = solid;
    }
    
    /**
     @brief setter di velX

     **/
    public boolean isSolid() {
        return solid;
    }

    /**
     @brief setter di velX

     @param velX
     **/
    public void setVelX(int velX) {
        this.velX = velX;
    }

    /**
     @brief setter di velY

     @param velY
     **/
    public void setVelY(int velY) {
        this.velY = velY;
    }

    /**
     @brief setter di velX
     * 
     * restituisce valore x

     * @return valore di velX
     **/
    public int getVelX() {
        return velX;
    }

    /**
     @brief setter di velY
     * 
     * restituisce valore y

     * @return valore di velY
     **/
    public int getVelY() {
        return velY;
    }
    
    /**
     @brief getId
     * 
     * restituisce valore dell'id

     * @return valore di id
     **/
    public Id getId()
    {
        return id;
    }
    
    /**
     @brief incrementa
     * 
     * rincrementa valore di x e y = velX e velY

     **/
    public void incrementa()
    {
        x+=velX;
        y+=velY;
    }
    
    /**
     @brief morte del giocatore
     * 
     * morte del giocatore, toglie il giocatore dal game

     **/
    public void die()
    {
        handler.removeEntity(this);
    }

    /**
     @brief restituisce posizione del bordo
     * 
     * restituisce posizione del bordo

     **/
    public Rectangle getBounds()
    {
        return new Rectangle(getX(),getY(),width,height);
    }
    
    /**
     @brief restituisce posizione del bordo
     * 
     * restituisce posizione del bordo a destra

     **/
    public Rectangle getBoundsRight()
    {
        return new Rectangle(getX()+10+width-5,getY()+10,5,height-20);
    }
    
    /**
     @brief restituisce posizione del bordo
     * 
     * restituisce posizione del bordo inferiore

     **/
    public Rectangle getBoundsBottom()
    {
        return new Rectangle(getX()+10,getY()+width-5,width-20,5);
    }
    
    /**
     @brief restituisce posizione del bordo
     * 
     * restituisce posizione del bordo a sinistra

     **/
    public Rectangle getBoundsLeft()
    {
        return new Rectangle(getX(),getY()+10,5,height-20);
    }
    
    /**
     @brief restituisce posizione del bordo
     * 
     * restituisce posizione del bordo in alto

     **/
    public Rectangle getBoundsTop()
    {
        return new Rectangle(getX()+10,getY(),width-20,5);
    }
    
    public void render(Graphics g){};
    
    public void tick(){};
}