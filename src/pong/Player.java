package pong;

import java.awt.*;

public class Player {

    public boolean right, left;

    public int x, y, width, height;

    public Player(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 10;
    }

    public void tick() {

        if (right)
        {
            x++;
        } else if (left)
        {
            x--;
        }

        if (x + width > Game.WIDTH)
        {
            x = Game.WIDTH - width;
            System.out.println("Collision with right wall");

        } else if (x < 0)
        {
            x = 0;
            System.out.println("Collision with left wall");
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, width, height);
    }
}
