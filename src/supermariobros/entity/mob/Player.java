package supermariobros.entity.mob;

import mariobros.entity.Entity;
import supermariobros.Game;
import supermariobros.Handler;
import supermariobros.Id;
import supermariobros.tile.Tile;

import java.awt.*;

public class Player extends Entity {

    /**
     * @brief costruttore parametrico
     *
     * @param x       orizzontale
     * @param y       verticale
     * @param width   larghezza
     * @param height  lunghezza
     * @param solid   solido
     * @param id      id
     * @param handler gestione
     *
     * inizializzato il costruttore Player
     **/
    public Player(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
        super(x, y, width, height, solid, id, handler);
        setVelX(0);
    }

    /**
     * setta lo status
     *
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @brief aggiorna grafica del giocatore
     *
     * visualizza il giocatore aggiornato
     *
     * @param g grafica
     **/
    public void render(Graphics g) {
        System.out.println(x);
        if (facing == 0) {
            if (status == 1) {
                g.drawImage(Game.player[frame + 1][status].getBufferedImage(), x, y, width, height, null);
            } else {
                g.drawImage(Game.player[frame + 2][status].getBufferedImage(), x, y, width, height, null);
            }
        } else if (facing == 1) {
            g.drawImage(Game.player[frame][status].getBufferedImage(), x, y, width, height, null);
        }
    }

    /**
     * @brief aggiorna l'entità
     *
     * aggiorna il giocatore
     **/
    public void tick() {
        x += velX;
        y += velY;
        if (y >= 960) die();

        if (velX != 0) animate = true;
        else animate = false;

        if (x < 0) {
            x = 0;
            setVelX(0);
        }
        if (x > 13520) {
            x = 13520;
            setVelX(0);
        }
        for (Tile t : handler.tile) {
            if (!t.solid) {
                break;
            }
            if (t.getID() == Id.wall) {
                if (getBoundsTop().intersects(t.getBounds())) {
                    setVelY(0);
                    if (jumping) {
                        jumping = false;
                        gravity = 0.8;
                        falling = true;
                    }
                }
                if (getBoundsBottom().intersects(t.getBounds())) {
                    setVelY(0);
                    if (falling) {
                        falling = false;
                    }
                } else if (!falling && !jumping) {
                    gravity = 0.8;
                    falling = true;
                }
            }
            if (t.getID() == Id.special) {
                if (getBoundsTop().intersects(t.getBounds())) {
                    setVelY(0);
                    if (jumping) {
                        jumping = false;
                        gravity = 0.8;
                        falling = true;
                    }
                    t.status = 1;
                }
                if (getBoundsBottom().intersects(t.getBounds())) {
                    setVelY(0);
                    if (falling) {
                        falling = false;
                    }
                } else if (!falling && !jumping) {
                    gravity = 0.8;
                    falling = true;
                }
            }
            if (t.getID() == Id.brick) {
                if (getBoundsTop().intersects(t.getBounds())) {
                    if (status > 1) {
                        t.die();
                    }
                    setVelY(0);
                    if (jumping) {
                        jumping = false;
                        gravity = 0.8;
                        falling = true;
                    }
                }
                if (getBoundsBottom().intersects(t.getBounds())) {
                    setVelY(0);
                    if (falling) {
                        falling = false;
                    }
                } else if (!falling && !jumping) {
                    gravity = 0.8;
                    falling = true;
                }
            }
            if (t.getID() == Id.tube) {
                if (getBoundsTop().intersects(t.getBounds())) {
                    setVelY(0);
                    if (jumping) {
                        jumping = false;
                        gravity = 0.8;
                        falling = true;
                    }
                }
                if (getBoundsBottom().intersects(t.getBounds())) {
                    setVelY(0);
                    if (falling) {
                        falling = false;
                    }
                } else if (!falling && !jumping) {
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
                x = t.getX() - 64;
            }

        }
        handler.entity.forEach(e -> {

            if (e.getId() == Id.mushroom) {
                if (getBounds().intersects(e.getBounds())) {
                    int tpX = getX();
                    int tpY = getY();
                    status = 2;
                    e.die();
                }
            } else if (e.getId() == Id.goomba) {
                if (getBoundsBottom().intersects(e.getBoundsTop())) {
                    e.die();
                } else if (getBounds().intersects(e.getBounds())) {
                    if (status < 2) die();
                    else if (status == 6) status -= 4;
                    else status -= 2;

                }
            }
        });
        if (jumping) {
            gravity -= 0.1;
            setVelY((int) -gravity);
            if (gravity <= 0.0) {
                jumping = false;
                falling = false;
            }
        }
        if (falling) {
            gravity += 0.1;
            setVelY((int) gravity);
        }

        if (jumping) {
            frame = 0;
            status = 1;
        } else {
            status = 0;
            if (animate) {
                frameDelay++;
                if (frameDelay >= 6) {
                    frame++;
                    if (frame > 1) {
                        frame = 0;
                    }
                    frameDelay = 0;
                }
            } else {
                frame = 0;
            }
        }
    }

}
