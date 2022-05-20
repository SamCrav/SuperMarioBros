/**
 * @author Andrea Fumagalli, Samuele Lainati
 * @version 1.0
 * @file Camera.java
 *
 * @brief File per la gestione della camera di gioco
 *
 */
package supermariobros;

import mariobros.entity.Entity;

/**
 * @class Camera
 *
 * @brief Classe per la gestione della visuale di gioco
 *
 * In questa classe l'oggetto che viene creato contiene i voti che
 * vengono inseriti dal main, i metodi permettono di modificarli o di
 * visualizzarli.
 */
public class Camera {

    /**posizione sull'asse x**/
    public int x;
    /**posizione sull'asse y**/
    public int y;

    /**
     * @brief aggiorna camera
     *
     * viene richiamato ogni tick per aggiornare la posizione della visuale
     *
     * la visuale viene aggiornata
     *
     * @param player giocatore
    **/
    public void tick(Entity player ){
        if(-player.getX() + Game.WIDTH>0){
            setX(0);
        }
        else if(-player.getX() + Game.WIDTH<-13000){
            setX(-13000);
        }
        else{
            setX(-player.getX() + Game.WIDTH);
        }
        setY(-Game.HEIGHT-64);
    }

    /**
     * @brief setter di x
     *
     * cambia il valore dell'attributo x
     *
     * riposiziona la visuale
     *
     * @param x nuova posizione sull'asse x
     **/
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @brief setter di y
     *
     * cambia il valore dell'attributo y
     *
     * riposiziona la visuale
     *
     * @param y nuova posizione sull'asse y
     **/
    public void setY(int y) {
        this.y = y;
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
}