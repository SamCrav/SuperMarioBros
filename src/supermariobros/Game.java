package supermariobros;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

import mariobros.entity.Entity;
import supermariobros.entity.mob.Player;
import supermariobros.gfx.Sprite;
import supermariobros.gfx.SpriteSheet;
import supermariobros.input.KeyInput;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 270;
    public static final int HEIGHT = WIDTH / 14 * 10;
    public static final int SCALE = 4;
    public static final String TITLE = "Mario";

    private Thread thread;
    private boolean running = false;
    
    public static Handler handler;

    public static Camera cam;

    public static SpriteSheet mario;
    public static SpriteSheet goomba;
    public static SpriteSheet koopa;

    public static SpriteSheet blocks;
    public static SpriteSheet ground;
    public static SpriteSheet tube;

    public static Sprite grass;
    public static Sprite sand;
    public static Sprite brick;
    public static Sprite special;
    public static Sprite solid;
    public static Sprite[] top_tube = new Sprite[2];
    public static Sprite[] bottom_tube = new Sprite[2];

    public static Sprite player[] = new Sprite[4];

    public Game() {
        Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }
    
    public void init(){
        handler = new Handler();
        mario=new SpriteSheet("/resources/images/mario/MarioSheet.png");
        blocks=new SpriteSheet("/resources/images/map/Blocks.png");
        ground=new SpriteSheet("/resources/images/map/Ground.png");
        tube=new SpriteSheet("/resources/images/map/Tube.png");
        cam = new Camera();
        addKeyListener(new KeyInput());

        brick=new Sprite(blocks,0,0, 16);
        grass=new Sprite(ground,0,0, 16);
        sand=new Sprite(ground,0,1, 16);
        solid=new Sprite(blocks,1,0, 16);
        for (int i = 0; i<top_tube.length;i++){
            top_tube[i]=new Sprite(tube,i,0, 16);
            bottom_tube[i]=new Sprite(tube,(i+2),0, 16);
        }


        for (int i = 0; i < player.length; i++) {
            player[i]=new Sprite(mario,i,0,16);
        }
        
        //handler.addEntity(new Player(400,700,64,64,true,Id.player,handler));
    }
    
    public synchronized void start() {
        if(running)return;
        running=true;
        thread=new Thread(this, "Thread");
        thread.start();
    }

    public synchronized void stop() {
        if(!running)return;
        running=false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
    
    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs==null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0,0,getWidth(),getHeight());
        g.translate(cam.getX(),cam.getY());
        handler.render(g);
        g.dispose();
        bs.show();
    }
    
    public void tick(){
        handler.tick();

        for(Entity e:handler.entity){
            if(e.getId()==Id.player){
                cam.tick(e);
            }
        }
    }

    public int getFrameWidth(){
        return WIDTH*SCALE;
    }

    public int getFrameHeight(){
        return HEIGHT*SCALE;
    }

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
