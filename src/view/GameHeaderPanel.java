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
public class GameHeaderPanel extends JPanel{
    
    private final Dimension size;
    private final int scale;
    private Graphics2D g2d;
    private int score;

    public GameHeaderPanel(Dimension size, int scale) {
        this(size,scale,0);
    }

    public GameHeaderPanel(Dimension size, int scale, int score) {
        this.size = size;
        this.scale = scale;
        this.score = score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    @Override
    public Color getBackground() {
        return Color.black;
    }
    
     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        paintHeader();
    }
    
    public void paintHeader() {
        g2d.setColor(Color.white);
        Font font = new Font("Monospaced", Font.PLAIN, scale);
        FontRenderContext frc = g2d.getFontRenderContext();
        GlyphVector gv = font.createGlyphVector(frc, "Apples Eaten: " + score);
        g2d.drawGlyphVector(gv,
                size.width / 2,
                size.height / 2 - ((int) gv.getVisualBounds().getHeight() / 2));
    }

    @Override
    public Dimension getPreferredSize() {
        return size;
    }
    
    
    
    
}
