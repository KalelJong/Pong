package pong;

import java.awt.*;

public class Player {

    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(100, 120 - 10, 40, 10);
    }
}