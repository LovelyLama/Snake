/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.Deque;
import javax.swing.JPanel;

/**
 *
 * @author LovelyLama
 */
public class GamePanel extends JPanel {
    
    private final Point apple;
    private final Deque<Point> snakeBody;
    private final Dimension size;
    private final int scale;
    private Graphics2D g2d;

    public GamePanel(Dimension size, int scale, Point apple, Deque<Point> snakeBody) {
        this.size = size;
        this.scale = scale;
        this.apple = apple;
        this.snakeBody = snakeBody;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        paintDots();
        paintApple();
        paintSnake();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(size.width*scale, size.height*scale);
    }
    

    private void paintDots() {
        g2d.setStroke( new BasicStroke(0.25f) );
        g2d.setColor(Color.RED);
        for (int i = 0; i <= size.width*scale; i+=scale)
            for (int j = 0; j <= size.height*scale; j+=scale) {
                if (i == size.width*scale) {
                    g2d.fillRect(i - 1, j, 1, 1);
                } else if (j == size.height*scale) {
                    g2d.fillRect(i, j - 1, 1, 1);
                } else {
                    g2d.fillRect(i, j, 1, 1);
                }
            }
    }

    private void paintApple() {
        g2d.setStroke(new BasicStroke(1.5f));
        int xPos = (int) apple.getX()*scale;
        int yPos = (int) apple.getY()*scale;
        g2d.setColor(Color.green);
        g2d.drawLine(xPos + scale / 2, yPos, xPos + scale / 2, yPos - 1);
        g2d.drawLine(xPos + scale / 2, yPos, xPos + scale - 1, yPos - 2);
        g2d.setColor(Color.red);
        g2d.fillOval(xPos + 2, yPos + 2, scale - 4, scale - 3);
        g2d.fillOval(xPos + 4, yPos + 2, scale - 4, scale - 3);
    }

    private void paintSnake() {
        int xPos, yPos;
        for (Point position : snakeBody) {
            g2d.setColor(Color.GREEN);
            xPos = (int) position.getX()*scale;
            yPos = (int) position.getY()*scale;
            g2d.drawRoundRect(xPos + 2, yPos + 2, scale - 4, scale - 4, 2, 2);
        }
    }
    
    
    
    
    
    
    
    
}
