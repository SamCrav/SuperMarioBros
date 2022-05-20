/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermariobros.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import mariobros.entity.Entity;
import supermariobros.Game;
import supermariobros.Id;

public class KeyInput implements KeyListener {

    /**
        @brief KeytYped
        * 
        * @param e di tipo KeyEvent
    **/
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    /**
        @brief keyPressed, gestisce pressione tasto
        * 
        * gestisce la pressione di un tasto
        * 
        * @param e di tipo KeyEvent
    **/
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (Entity en : Game.handler.entity)
        {
            if(en.getId()== Id.player){  //se l'id dell'entità è uguale a quello del giocatore
                switch (key) {
                    case KeyEvent.VK_W:
                        if(!en.jumping) 
                        {
                            en.jumping=true;
                            en.gravity=8.0;
                        }
                        break;
                    case KeyEvent.VK_A:
                        en.setVelX(-8);
                        en.facing=0;
                        break;
                /*case KeyEvent.VK_S:
                    en.setVelY(-5);
                    break;*/
                    case KeyEvent.VK_D:
                        en.setVelX(8);
                        en.facing=1;
                        break;
                }
            }

        }
    }

    
    /**
        @brief keyReleased, gestisce pressione tasto
        * 
        * gestisce il rilascio di un tasto
        * 
        * @param e di tipo KeyEvent
    **/
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (Entity en : Game.handler.entity) {
            if (en.getId() == Id.player) {
                switch (key) {
                    case KeyEvent.VK_W:
                        en.setVelY(0);
                        break;
                    case KeyEvent.VK_A:
                        en.setVelX(0);
                        break;
                /*case KeyEvent.VK_S:
                    en.setVelY(0);
                    break;*/
                    case KeyEvent.VK_D:
                        en.setVelX(0);
                        break;
                }
            }
        }
    }

}
