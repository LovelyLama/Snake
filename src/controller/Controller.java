/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import model.Model;
import util.Direction;
import view.GamePanel;

/**
 *
 * @author LovelyLama
 */
public class Controller implements KeyListener{
    
    private  ActionListener taskPerformer;
    private  int TICKS_PER_SECOND = 1000/8;
    private  Timer timer;
    private Model model;
    private GamePanel gp;

    

    public Controller() {
        Dimension size = new Dimension(30,30);
        model = new Model(size);        
        
        JFrame jf = new JFrame("Snake");
        jf.setSize(600,600);
        gp = new GamePanel(size, 17, model.getApple(), model.getSnakeBody());
        jf.add(gp);
        taskPerformer = (ActionEvent e) -> {
            model.moveSnake();
            gp.repaint();
        };
        
        timer = new Timer(100, taskPerformer);
        timer.setInitialDelay(0);
        timer.start();
        jf.setVisible(true);
        jf.setResizable(false);
        jf.addKeyListener(this);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
    
    public static void main(String[] args) {
        Controller controller = new Controller();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                model.setMovementDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                model.setMovementDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                model.setMovementDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                model.setMovementDirection(Direction.RIGHT);
                break;
                
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
