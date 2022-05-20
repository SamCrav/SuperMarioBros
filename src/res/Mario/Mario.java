/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package res.Mario;

import Input.input;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import main.GamePanel;
/**
 *
 * @author fumagalli_andrea04
 */
public class Mario {
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

    private float xDelta = 100, yDelta = 100;

    private BufferedImage img;
    private BufferedImage[] small_movement, big_movement, fire_movement;
    private int animationTick, animationIndex, animationSpeed = 10;
    private BufferedImage[][] goomba;
    int deathIndex=0;

    public Mario() {
        importImg();
        loadAnimations();
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("./Mario.png");

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadAnimations() {
        goomba = new BufferedImage[2][2];

        for (int i = 0; i < goomba.length; i++) {
            for (int j = 0; j < goomba[0].length; j++) {
                goomba[i][j] = img.getSubimage(i * 16, j * 16, 16, 16);
            }
        }
    }

    public void changexDelta(int val) {
        this.xDelta += val;
    }

    public void changeyDelta(int val) {
        this.yDelta += val;
    }

    public void updateAnimationTick() {
        if (xDelta < 1200) {
            animationTick++;
            //xDelta += 1;
            if (animationTick >= animationSpeed) {
                animationTick = 0;
                animationIndex++;
                if (animationIndex >= goomba[0].length) {
                    animationIndex = 0;
                }
            }
        }
        else{
            deathIndex=1;
        }
        
    }
    
    public Image getFrame(){
        return goomba[animationIndex][deathIndex];
    }

//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        updateAnimationTick();
//
//        g.drawImage(goomba[animationIndex][deathIndex], (int) xDelta, (int) yDelta, 48, 48, null);
//    }

}

