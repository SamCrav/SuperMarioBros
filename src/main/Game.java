/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Andrea
 */
public class Game implements Runnable {

    private GameWindow gamewindow;
    private GamePanel gamepanel;

    private Thread gameThread;
    private final int FPS_SET = 120;

    public Game() {
        gamepanel = new GamePanel();
        gamewindow = new GameWindow(gamepanel);
        gamepanel.requestFocus();
        startGameLoop();
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double timePerFrame = 1000000000 / FPS_SET;
        long lastFrame = System.nanoTime();
        long firstFrame = System.nanoTime();
        
        int fps = 0;
        long lastCheck = System.currentTimeMillis();

        while (true) {

            firstFrame = System.nanoTime();
            if (firstFrame - lastFrame >= timePerFrame) {
                gamepanel.repaint();
                lastFrame = firstFrame;
                fps++;
            }
            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println(fps);
                fps = 0;
            }
        }
    }

}
