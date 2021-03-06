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
import javax.swing.Timer;
import model.Model;
import model.ObserverModel;
import util.Direction;
import view.GamePanel;
import view.View;

/**
 *
 * @author LovelyLama
 */
public class Controller implements KeyListener, ObserverModel{
    
    private ActionListener taskPerformer;
    private int TICKS_PER_SECOND = 1000/8;
    private Timer timer;
    private Model model;
    private View view;
    private GamePanel gp;
    private int score = 0;

    

    public Controller() {
        Dimension size = new Dimension(30,30);
        model = new Model(size);
        model.attach(this);
        view = new View(size, model.getApple(), model.getSnakeBody());
        view.addKeyListener(this);

        taskPerformer = (ActionEvent e) -> {
            model.moveSnake();
            view.repaint();
        };
        
        timer = new Timer(100, taskPerformer);
        timer.setInitialDelay(0);
        timer.start();        
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

    @Override
    public void appleEaten() {
        view.updateScore(++score);
    }

    @Override
    public void gameOver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
