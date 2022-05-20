package supermariobros.tile;

import supermariobros.Game;
import supermariobros.Handler;
import supermariobros.Id;

import java.awt.*;

public class Bottom_Tube extends Tile{
    public Bottom_Tube(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
        super(x, y, width, height, solid, id, handler);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Game.bottom_tube.getBufferedImage(), x, y, width, height, null);
    }

    @Override
    public void tick() {

    }

}
