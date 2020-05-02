
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LovelyLama
 */
public class Gameplay extends JPanel implements ActionListener, KeyListener{
    
    Graphics2D g2d;
    
    int[] snakeXlength = new int[750];
    int[] snakeYlength = new int[750];
    
    Timer timer;
    int delay = 100;
    int snakelength = 4;

    public Gameplay() {
        addKeyListener(this);
        timer = new Timer(delay, this);
    }
    
    @Override
    public void paint (Graphics g) {
        
        //super.paintComponent(g);
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        paintTitle();
        paintSnake();
    }
    
    
    private void paintTitle() {
        int width = 200;
        int height = 100;
        g2d.setColor(Color.WHITE);
        g2d.drawRect(10, 10, 460, 50);
        g2d.setColor(Color.BLACK);
        g2d.fillRect(11, 11, 458, 48);
        
        g2d.setColor(Color.green);
        Font font = new Font("Monospaced", Font.PLAIN, width / 10);
        FontRenderContext frc = g2d.getFontRenderContext();
        GlyphVector gv = font.createGlyphVector(frc, "Speed Snake");
        g2d.drawGlyphVector(gv,
                width / 2 - ((int) gv.getVisualBounds().getWidth() / 2),
                height / 2 - ((int) gv.getVisualBounds().getHeight() / 2));
        
        
        // game area
        g2d.setColor(Color.WHITE);
        g2d.drawRect(10, 70, 460, 480);
        
        g2d.setColor(Color.BLACK);
        g2d.fillRect(11, 71, 458, 478);
        

    }
    
    private void paintSnake() {
        for(int a = 0; a < snakelength; ++a) {
            
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
