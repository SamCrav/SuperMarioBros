package supermariobros.tile;

import supermariobros.Handler;
import supermariobros.Id;

import java.awt.*;

public abstract class Tile {

    /**
     * variabili intere x e y, orizzontale e verticale
     */
    public int x, y;
    /**
     * variabili intere width e height, larghezza e altezza
     */
    public int width, height;


    /**
     * variabile intera status inizializzata a 0
     */
    public int status = 0;


    /**
     * variabile booleana solid
     */
    public boolean solid;


    /**
     * variabili intere velX e velY, orizzontale e verticale
     */
    public int velX, velY;

    /**
     * variabili intera dell'id
     */
    public Id id;

    /**
     * variabili di tipo Handler dell'handler
     */
    public Handler handler;


    /**
     * @brief costruttore parametrico
     *
     * @param x       orizzontale
     * @param y       verticale
     * @param width   larghezza
     * @param height  lunghezza
     * @param solid   solido
     * @param id      id
     * @param handler gestione
     *
     * inizializzato il costruttore Tile
     **/
    public Tile(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.solid = solid;
        this.id = id;
        this.handler = handler;
    }

    /**
     * @brief getter di x
     *
     * restituisce il valore dell'attributo x
     *
     * nessun cambiamento
     *
     * @return valore dell'attributo x
     **/
    public int getX() {
        return x;
    }

    /**
     * @brief setter di x
     *
     * @param x nuova posizione sull'asse x
     *
     * cambia il valore dell'attributo x
     *
     * riposiziona la visuale
     **/
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @brief getter di y
     *
     * restituisce il valore dell'attributo y
     *
     * nessun cambiamento
     *
     * @return valore dell'attributo y
     **/
    public int getY() {
        return y;
    }

    /**
     * @brief setter di y
     *
     * @param y nuova posizione sull'asse y
     *
     * cambia il valore dell'attributo y
     *
     * riposiziona la visuale
     **/
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @brief setter di velX
     **/
    public boolean isSolid() {
        return solid;
    }

    /**
     * @brief setter di Solid
     *
     * @param solid
     **/
    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    /**
     * @brief setter di velX
     *
     * restituisce valore x
     *
     * @return valore di velX
     **/
    public int getVelX() {
        return velX;
    }

    /**
     * @brief setter di velX
     *
     * @param velX
     **/
    public void setVelX(int velX) {
        this.velX = velX;
    }

    /**
     * @brief setter di velY
     *
     * restituisce valore y
     *
     * @return valore di velY
     **/
    public int getVelY() {
        return velY;
    }

    /**
     * @brief setter di velY
     *
     * @param velY
     **/
    public void setVelY(int velY) {
        this.velY = velY;
    }

    /**
     * @brief getID
     *
     * restituisce valore dell'id
     *
     * @return valore di id
     **/
    public Id getID() {
        return id;
    }

    /**
     * @brief incrementa
     *
     * rincrementa valore di x e y = velX e velY
     **/
    public void incrementa() {
        x += velX;
        y += velY;
    }

    /**
     * @brief morte di un tile
     *
     * il tile che viene "ucciso" viene rimosso dall'handler
     **/
    public void die() {
        handler.removeTile(this);
    }

    public abstract void render(Graphics g);

    public abstract void tick();

    /**
     * @brief get dei bordi
     *
     * @return un rettangolo che occupa la posizione dell'oggetto
     **/
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), width, height);
    }
}