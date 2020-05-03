/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import javax.swing.JPanel;

/**
 *
 * @author LovelyLama
 */
public class GameOverPanel extends JPanel {
    
    private final Dimension size;
    private final int scale;
    private int score;
    private Graphics2D g2d;

    public GameOverPanel(Dimension size, int scale) {
        this.size = size;
        this.scale = scale;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        paintGameOver();    
    }
    
    

    public void setScore(int score) {
        this.score = score;
    }

    private void paintGameOver() {
               g2d.setColor(Color.red);
        Font font = new Font("Monospaced", Font.PLAIN, size.width / 10);
        FontRenderContext frc = g2d.getFontRenderContext();
        GlyphVector gv = font.createGlyphVector(frc, "GAME OVER");
        g2d.drawGlyphVector(gv,
                size.width / 2 - ((int) gv.getVisualBounds().getWidth() / 2),
                size.height * 7 / 20 - ((int) gv.getVisualBounds().getHeight() / 2));
    }
    
    
            
            
    
}
