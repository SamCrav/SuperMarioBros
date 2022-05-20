package supermariobros.tile;

import supermariobros.Game;
import supermariobros.Handler;
import supermariobros.Id;

import java.awt.*;

public class Grass extends Tile{
    public Grass(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
        super(x, y, width, height, solid, id, handler);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Game.grass.getBufferedImage(), x, y, width, height, null);
    }

    @Override
    public void tick() {

    }
}
