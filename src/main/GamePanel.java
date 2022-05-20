/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import res.Mario.Mario;
import Input.input;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Andrea
 */
public class GamePanel extends JPanel {

    private float xDelta = 100, yDelta = 100;
    
    private Mario player= new Mario();

//    private BufferedImage img;
//    private BufferedImage[] small_movement, big_movement, fire_movement;
//    private int animationTick, animationIndex, animationSpeed = 10;
//    private BufferedImage[][] goomba;
//    int deathIndex=0;

    public GamePanel() {
        addKeyListener(new input(this));

//        importImg();
//        loadAnimations();

        setPanelSize();
    }

//    private void importImg() {
//        InputStream is = getClass().getResourceAsStream("../res/Enemies/goomba.png");
//
//        try {
//            img = ImageIO.read(is);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                is.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void loadAnimations() {
//        goomba = new BufferedImage[2][2];
//
//        for (int i = 0; i < goomba.length; i++) {
//            for (int j = 0; j < goomba[0].length; j++) {
//                goomba[i][j] = img.getSubimage(i * 18, j * 18, 18, 18);
//            }
//        }
//    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }
    //TO FIX{
    public void changexDelta(int val) {
        while(true){
            this.xDelta += val;
        }
    }

    public void changeyDelta(int val) {
        while(true){
            this.yDelta += val;
        }
    }
    //}
    
    
//    private void updateAnimationTick() {
//        if (xDelta < 1200) {
//            animationTick++;
//            //xDelta += 1;
//            if (animationTick >= animationSpeed) {
//                animationTick = 0;
//                animationIndex++;
//                if (animationIndex >= goomba[0].length) {
//                    animationIndex = 0;
//                }
//            }
//        }
//        else{
//            deathIndex=1;
//        }
//        
//    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        player.updateAnimationTick();

        g.drawImage(player.getFrame(), (int) xDelta, (int) yDelta, 48, 48, null);
    }

}
