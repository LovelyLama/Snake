/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.util.Deque;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author LovelyLama
 */
public final class View {
    
    private JFrame mainWindow;
    private JPanel content;
    private Dimension size;
    private int scale;
    private final GamePanel gamePanel;
    private final GameOverPanel gameOverPanel;

    public View(Dimension size, Point apple, Deque<Point> snakeBody) {
        int scale = 17;
        //Dimension scaledSize = new Dimension(size.width*scale, size.height*scale);
        gamePanel = new GamePanel(size, scale, apple, snakeBody);
        gameOverPanel = new GameOverPanel(size, scale);
        this.size = size;
        this.scale = scale;
        initGridView();
    }

    private void initGridView() {
        mainWindow = new JFrame("Snake");
        
        content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBorder(BorderFactory.createEmptyBorder(scale, scale, scale, scale));
        content.setBackground(Color.black);
        content.add(gamePanel);

        mainWindow.add(content);
        mainWindow.setResizable(false);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.pack();
        mainWindow.setVisible(true);
        }
    
    public void addKeyListener(KeyListener k) {
        mainWindow.addKeyListener(k);
    }
    
    public void repaint() {
        mainWindow.repaint();
    }
}
