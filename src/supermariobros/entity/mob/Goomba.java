package supermariobros.entity.mob;

import java.awt.Graphics;
import java.util.Random;
import mariobros.entity.Entity;
import supermariobros.Game;
import supermariobros.Handler;
import supermariobros.Id;
import supermariobros.tile.Tile;

public class Goomba extends Entity {

    //private Random random = new Random();

    public Goomba(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
        super(x, y, width, height, solid, id, handler);
    }

    //int dir = random.nextInt(2);

    public void render(Graphics g) {
        /*switch (dir) {
            case 0:

//                facing = 0;
                break;
            case 1:
                setVelX(2);
//                facing = 1;
                break;
        }*/
        setVelX(-2);
//        if (facing == 0) {
            g.drawImage(Game.goomba[0][status].getBufferedImage(), x, y, width, height, null);
//        } else if (facing == 1) {
//            g.drawImage(Game.player.getBufferedImage(), x, y, width, height, null);
//        }
    }

    public void tick() {
        x += velX;
        y += velY;

        for (Tile t:handler.tile) {
            if (!t.solid) {
                break;
            }
            if (t.getID() == Id.wall) {
                if (getBoundsBottom().intersects(t.getBounds())) {
                    setVelY(0);
                    if (falling) {
                        falling = false;
                    }
                }
                else if (!falling && !jumping) {
                    gravity = 0.8;
                    falling = true;
                }
            }
            if (getBoundsLeft().intersects(t.getBounds())) {
                setVelX(0);
                x = t.getX() + t.width;
            }
            if (getBoundsRight().intersects(t.getBounds())) {
                setVelX(0);
                x = t.getX() - t.width;
            }
        }
//            Tile t = handler.tile.get(i);
            /*if (t.isSolid()) {
                if (getBoundsBottom().intersects(t.getBounds())) {
                    setVelY(0);
                    if (falling) {
                        falling = false;
                    } else if (!falling) {
                        falling = true;
                        gravity = 0.8;
                    }
                }
                if (getBoundsLeft().intersects(t.getBounds())) {
                    setVelX(2);
                } else if (getBoundsRight().intersects(t.getBounds())) {
                    setVelX(-2);
                }
            }
            if (falling) {
                gravity += 0.1;
                setVelY((int) gravity);
            }
        }*/
    }
}
