/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermariobros.entity.mob;

import java.awt.Graphics;
import mariobros.entity.Entity;
import supermariobros.Game;
import supermariobros.Handler;
import supermariobros.Id;
import supermariobros.tile.Tile;

public class Koopa extends Entity
{
    /**
        @brief costruttore parametrico

        inizializzato il costruttore Koopa

        @param x orizzontale
        @param y verticale
        @param width larghezza
        @param height lunghezza 
        @param solid solido
        @param id id
        @param handler gestione
    **/
    public Koopa(int x, int y, int width, int height, boolean solid, Id id, Handler handler)
    {
        super(x,y,width,height,solid,id,handler);
    }

    /*@Override
    public void render(Graphics g)
    {
        if(facing==0)
        {
            g.drawImage(Game.koopa[frame].getBufferedImage(),x,y,width,height,null);
        }
        else if(facing==1)
        {
            g.drawImage(Game.koopa[0].getBufferedImage(),x,y,width,height,null);
        }
    }*/
    public void render(Graphics g) {
        for (Entity e : handler.entity) {
            if (e.getId() == Id.player&&(getX()-e.getX())<=100) {
                if(getVelX()==0){
                    setVelX(-2);
                }
            }
        }
        if (facing == 0) {
                g.drawImage(Game.koopa[frame+1].getBufferedImage(), x, y, width, height, null);

        } else if (facing == 1) {
            g.drawImage(Game.koopa[frame].getBufferedImage(), x, y, width, height, null);
        }
    }

    public void tick() {
        x += velX;
        y += velY;
        /*if(x+width>=1080)x=1080-width;
        if(y+height>=771)y=771-height;*/

        if(velX!=0)animate=true;
        else animate=false;

        for (Tile t : handler.tile) {
//            Tile t = handler.tile.get(i);
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
            if (t.getID() == Id.special) {
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
            if (t.getID() == Id.brick) {
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
            if (t.getID() == Id.tube) {
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
                setVelX(2);
                x = t.getX() + t.width;
            }
            if (getBoundsRight().intersects(t.getBounds())) {
                setVelX(-2);
                x = t.getX()-72;

            }

        }


        /*x += velX;
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
        }*/
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

        if (falling) {
            gravity += 0.1;
            setVelY((int) gravity);
        }

        if(animate){
            frameDelay++;
            if (frameDelay >= 6) {
                frame++;
                if (frame > 1) {
                    frame = 0;
                }
                frameDelay = 0;
            }
        }
    }
}
