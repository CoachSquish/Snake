/* Snake Game
 * Author: Colin Blum
 * Date: 11/1/2024
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        final int FPS = 60;
        final int frameDuration = 1000/ FPS; //milliseconds

        JFrame frame = new JFrame();
        frame.setTitle("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Grid.xFrame, Grid.yFrame);
        frame.getContentPane().setBackground(Color.BLACK);

        BufferedImage image = new BufferedImage(Grid.xFrame, Grid.yFrame, BufferedImage.TYPE_INT_RGB);
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.setVisible(true);

        Object snake = new Snake();
        Object AppleObject = new Apple();

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent key) {
                Snake snakeObject = (Snake) snake;
                snakeObject.getDirection(key);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Not Needed
            }

            @Override
            public void keyTyped(KeyEvent e) {
                //Not Needed
            }
        });
        Grid.initializeGrid();
        snake.Spawn();
        int count = 1;
        while(!Snake.gameOver) {
            long startTime = System.currentTimeMillis();

            // start every frame from scratch
            Graphics g = image.getGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, image.getWidth(), image.getHeight());

            // Move snake every 12 frames
            if(count % 10 == 0) {
                Snake snakeObject = (Snake) snake;
                snakeObject.moveSnake();
            }

            
            // if there is no apple, spawn an apple
            if(!Grid.isApple) {
                AppleObject.Spawn();
            }

            // Draws the next frame
            for (int i = 0; i < Grid.grid.length; i++) {
                for (int j = 0; j < Grid.grid[i].length; j++) {
                    if(Grid.grid[i][j] != null) {
                        g = Grid.grid[i][j].Draw(g, i, j);
                    }
                    else {
                        g = Grid.drawSquare(g, Color.BLACK, i, j);
                    }
                }
            }
            

            g.dispose();

            label.repaint();

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameDuration - elapsedTime;
            if(sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count++;            
        }
    }
}