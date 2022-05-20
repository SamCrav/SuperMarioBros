package supermariobros.tile;

import mariobros.entity.Entity;
import supermariobros.Game;
import supermariobros.Handler;
import supermariobros.Id;

import java.awt.*;

public class Special extends Tile{

    public Entity contain;
    public Special(int x, int y, int width, int height, boolean solid, Id id, Handler handler,Entity contain) {
        super(x, y, width, height, solid, id, handler);
        this.contain=contain;
    }

    private int frame=0;
    private int frameDelay=0;


    public void render(Graphics g){

            g.drawImage(Game.special[status][frame].getBufferedImage(), x, y, width, height, null);
    }

    public void tick() {

        frameDelay++;
        if (frameDelay >= 15) {
            frame++;
            if (frame > 4) {
                frame = 0;
            }
            frameDelay = 0;
        }
    }
}
