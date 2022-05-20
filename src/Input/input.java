/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.GamePanel;

/**
 *
 * @author Andrea
 */
public class input implements KeyListener {

    private GamePanel gamepanel;
    public input(GamePanel gamepanel) {
        this.gamepanel=gamepanel;
    }
    
    

    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                gamepanel.changeyDelta(-5);
                break;
            case KeyEvent.VK_A:
                gamepanel.changexDelta(-5);
                break;
            case KeyEvent.VK_S:
                gamepanel.changeyDelta(5);
                break;
            case KeyEvent.VK_D:
                gamepanel.changexDelta(5);
                break;
        }
    }
    //TO FIX
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                gamepanel.changeyDelta(0);
                break;
            case KeyEvent.VK_A:
                gamepanel.changexDelta(0);
                break;
            case KeyEvent.VK_S:
                gamepanel.changeyDelta(0);
                break;
            case KeyEvent.VK_D:
                gamepanel.changexDelta(0);
                break;
        }
    }
}
