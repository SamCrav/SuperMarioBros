/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermariobros.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import mariobros.entity.Entity;
import supermariobros.Game;

/**
 *
 * @author Andrea
 */
public class KeyInput implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (Entity en : Game.handler.entity)
        {
            switch (key) {
                case KeyEvent.VK_W:
                    if(!en.jumping&&!en.falling)
                    {
                        en.jumping=true;
                        en.gravity=10.0;
                    }
                    break;
                case KeyEvent.VK_A:
                    en.setVelX(-5);
                    en.facing=0;
                    break;
                /*case KeyEvent.VK_S:
                    en.setVelY(-5);
                    break;*/
                case KeyEvent.VK_D:
                    en.setVelX(5);
                    en.facing=1;
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (Entity en : Game.handler.entity)
        {
            switch (key) {
                /*case KeyEvent.VK_W:
                    en.setVelY(0);
                    break;*/
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