/**
 * @author Andrea Fumagalli, Samuele Lainati
 * @version 0.7
 * @file Game.java
 *
 * @brief File per la gestione del gioco
 *
 */
package supermariobros;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

import mariobros.entity.Entity;
import supermariobros.gfx.Sprite;
import supermariobros.gfx.SpriteSheet;
import supermariobros.input.KeyInput;

/**
 * @class Game
 *
 * @brief Classe per la gestione del gioco
 *
 * Gestione del gioco Supermario bros
 */
public class Game extends Canvas implements Runnable {

    /**variabili intere width e height, larghezza e altezza, impostato valori*/
    public static final int WIDTH = 270;
    public static final int HEIGHT = WIDTH / 14 * 10;
    
    /**variabile intera static final scale, impostato valore a 4*/
    public static final int SCALE = 4;
    /**variabile stringa static final title, impostato valore a Mario*/
    public static final String TITLE = "Mario";

    private Thread thread;
    private boolean running = false;
    
    public static Handler handler;

    public static Camera cam;

    
    /**tutti gli elementi presenti nel gioco impostati come varibiali pubbliche statiche di tipo SpriteSheet*/
    public static SpriteSheet mario;
    public static SpriteSheet goomba_sheet;
    public static SpriteSheet koopa_sheet;

    public static SpriteSheet blocks;
    public static SpriteSheet ground;
    public static SpriteSheet tube;
    public static SpriteSheet items;
    public static SpriteSheet special_block;

    public static Sprite background;
    public static Sprite grass;
    public static Sprite sand;
    public static Sprite brick;
    public static Sprite[][] special = new Sprite[2][5];
    public static Sprite solid;
    public static Sprite top_tube;
    public static Sprite bottom_tube;

    public static Sprite[][] player = new Sprite[4][7];
    public static Sprite[][] goomba = new Sprite[2][2];

    public static Sprite[] koopa = new Sprite[4];

    public static Sprite[] shell = new Sprite[3];
    public static Sprite mushroom;

    
    /**
     * @brief Game
     * Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
     * setPreferredSize(size);
     * setMaximumSize(size);
     * setMinimumSize(size);
    **/
    public Game() {
        Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }
    
    /**
     * @brief public void init()
     *
     *
     *
    **/
    public void init(){
        handler = new Handler();
        mario=new SpriteSheet("/resources/images/mario/MarioSheet.png");
        blocks=new SpriteSheet("/resources/images/map/Blocks.png");
        ground=new SpriteSheet("/resources/images/map/Ground.png");
        tube=new SpriteSheet("/resources/images/map/Tube.png");
        items=new SpriteSheet("/resources/images/map/Items.png");
        special_block=new SpriteSheet("/resources/images/map/Special_Block.png");
        goomba_sheet=new SpriteSheet("/resources/images/enemies/GoombaSheet.png");
        koopa_sheet=new SpriteSheet("/resources/images/enemies/KoopaSheet.png");
        background=new Sprite(new SpriteSheet("/resources/images/map/Sky_background.png"),0,0,500);
        cam = new Camera();
        addKeyListener(new KeyInput());

        brick=new Sprite(blocks,0,0, 16);
        grass=new Sprite(ground,0,0, 16);
        sand=new Sprite(ground,0,1, 16);
        solid=new Sprite(blocks,1,0, 16);
        mushroom=new Sprite(items,0,0, 16);

        top_tube=new Sprite(tube,0,0, 24);
        bottom_tube=new Sprite(tube,1,0, 24);

        for (int c=0;c<special[0].length;c++){
            for (int r=0;r<special.length;r++){
                special[r][c]=new Sprite(special_block,c,r,16);
            }
        }


        for (int c=0;c<player.length;c++){
            for (int r=0;r<player[0].length-1;r++){
                if(r<2){
                        player[c][r]=new Sprite(mario,c,r,16);
                }
                else{
                        player[c][r]=new Sprite(mario,c,r-1,32);
                }
            }
        }


        for (int c=0;c<goomba[0].length;c++){
            for (int r=0;r<goomba.length;r++){
                    goomba[r][c]=new Sprite(goomba_sheet,c,0,18);
            }
        }

        for (int i = 0; i<koopa.length;i++){
            koopa[i]=new Sprite(koopa_sheet,i,0, 28);
        }

        for (int i = 0; i<shell.length;i++){
            shell[i]=new Sprite(koopa_sheet,i,1, 18);
        }
    }
    
    /**
     * @brief inizio
     *
     * inizia il gioco
     *
    **/
    public synchronized void start() {
        if(running)return;
        running=true;
        thread=new Thread(this, "Thread");
        thread.start();
    }

    /**
     * @brief fine
     *
     * finisce il gioco
     *
    **/
    public synchronized void stop() {
        if(!running)return;
        running=false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    /**
     * @brief run
     *
     * implementa il gioco
     *
    **/
    @Override
    public void run() {
        init();
        requestFocus();
        long lastTime=System.nanoTime();
        long timer=System.currentTimeMillis();
        double delta=0.0;
        double ns=1000000000.0/60.0;
        int frames=0;
        int ticks=0;
        while(running){
            long now=System.nanoTime();
            delta+=(now-lastTime)/ns;
            lastTime=now;
            while(delta>=1){
                tick();
                ticks++;
                delta--;
            }
            render();
            frames++;
            if(System.currentTimeMillis()-timer>1000){
                timer+=1000;
                frames=0;
                ticks=0;
            }
        }
        stop();
    }
    
    /**
     * @brief aggiorna tile
     *
     * aggiorna il tile e visualizza
     *
    **/
    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs==null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.translate(cam.getX(),cam.getY());
        handler.render(g);
        g.dispose();
        bs.show();
    }
    
    /**
     * @brief aggiorna
     *
     * aggiornamento dei parametri dell'oggetto
     *
    **/
    public void tick(){
        handler.tick();

        for(Entity e:handler.entity){
            if(e.getId()==Id.player){
                cam.tick(e);
            }
        }
    }

    /**
     * @brief getter frameWidth
     *
     * restituisce valore del Width*Scale
     *
     * @return Width*Scale
     *
    **/
    public int getFrameWidth(){
        return WIDTH*SCALE;
    }

    
    /**
     * @brief getter frameHeight
     *
     * restituisce valore del height*Scale
     *
     * @return height*Scale
    **/
    public int getFrameHeight(){
        return HEIGHT*SCALE;
    }
    
    /**
     * @brief avvia il gioco
     *
     * avvia il gioco con il debug
     *
     * @param args the command line arguments
    **/
    public static void main(String args[]) {
        Game game = new Game();
        JFrame frame = new JFrame(TITLE);
        frame.add(game);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        game.start();
    }
}