/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import util.Direction;

/**
 * Model of the snake game in MVC design pattern.
 * @author LovelyLama
 */
public class Model {
    
    private final int GROWTH_SPURT = 8; // starting length of the snake
    
    private int squaresToGrow = 0;
    private Direction movementDirection = Direction.UP; 
    
    
    private final Dimension mapSize;
    private final Point apple = new Point();
    private final Random random = new Random();
    private final Deque<Point> snakeBody = new ArrayDeque<>();
    private final Set<Point> occupiedPositions = new LinkedHashSet();

    public Model(Dimension mapSize) {
        this.mapSize = mapSize;
        generateApple();
        generateSnakeAtCenter(); // by default moves up
        
    }
    
    /**
     * Generates snake at center of grid.
     */
    private void generateSnakeAtCenter() {
        int x = mapSize.width / 2;
        int y = mapSize.height / 2;
        snakeBody.add(new Point(x,y));
        occupiedPositions.add(snakeBody.getFirst());
        squaresToGrow += GROWTH_SPURT;
    }
    
    /**
     * Generates an apple position randomly and avoids collisions.
     */
    private void generateApple() {
        int x = 0;
        int y = 0;
        boolean spaceIsOccupied;
        do {
            spaceIsOccupied = false;
            x = random.nextInt(mapSize.width);
            y = random.nextInt(mapSize.height);
            for (Point point : occupiedPositions) {
                if (point.getX() == x && point.getY() == y) {
                    spaceIsOccupied = true;
                }
            }
        } while (spaceIsOccupied);
        apple.setLocation(x, y);
    }
    
    public int moveSnake() {
        int nextHeadX = snakeBody.getFirst().x;
        int nextHeadY = snakeBody.getFirst().y;
        
        
        switch (movementDirection) {
            case UP:
                --nextHeadY;
                break;
            case DOWN:
                ++nextHeadY;
                break;
            case RIGHT:
                ++nextHeadX;
                break;
            case LEFT:
                --nextHeadX;
                break;
            default:
                break;
        }
        
        Point nextHead = new Point(nextHeadX, nextHeadY);
        
        if ( collided(nextHead) ) {
            clearModel();
            generateSnakeAtCenter();
            return 1; // game over
        } 
        
        snakeBody.getLast().setLocation(nextHead);
        if ( ateApple(nextHead) ) {
            snakeBody.addFirst(nextHead);
            occupiedPositions.add(snakeBody.getFirst());
            generateApple();         
        } else if (squaresToGrow > 0) {
            snakeBody.addFirst(nextHead);
            occupiedPositions.add(snakeBody.getFirst());
            --squaresToGrow;
        } else {
            snakeBody.addFirst( snakeBody.removeLast() );
        }
        return 0;
    }

    
    private boolean collided(Point p) {
        boolean snakeCollision = snakeBody.contains(p); // with itself
        boolean leftEdgeCollision = p.x < 0;
        boolean rightEdgeCollision = p.x > mapSize.width;
        boolean topEdgeCollision = p.y < 0;
        boolean bottomEdgeCollision = p.y > mapSize.height;
        return snakeCollision
                || leftEdgeCollision
                || rightEdgeCollision
                || topEdgeCollision
                || bottomEdgeCollision;
    }

    private boolean ateApple(Point p) {
        return snakeBody.getFirst().equals(apple);
    }

    public Deque<Point> getSnakeBody() {
        return snakeBody;
    }

    public Point getApple() {
        return apple;
    }

    public void setMovementDirection(Direction movementDirection) {
        this.movementDirection = movementDirection;
    }
    
    public void clearModel() {
        occupiedPositions.clear();
        snakeBody.clear();
    }
    
    
    
}
