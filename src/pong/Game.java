package pong;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable
{

    public static int WIDTH = 240;
    public static int HEIGHT = 120;
    public static int SCALE = 3;
    public Player player;

    public BufferedImage layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    public Game()
    {
        this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        player = new Player();
    }

    public static void main(String[] args)
    {

        Game game = new Game();
        JFrame frame = new JFrame("Pong");

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        new Thread(game).start();

    }

    public void tick()
    {

    }

    public void render()
    {
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = layer.getGraphics();
        player.render(g);

        g = bs.getDrawGraphics();
        g.drawImage(layer, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);

        bs.show();
    }

    @Override
    public void run()
    {

        while (true)
        {
            tick();
            render();

            try
            {
                Thread.sleep(1000 / 60);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
    }
}
