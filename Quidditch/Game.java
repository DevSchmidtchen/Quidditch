import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MainClass of Quidditch
 * 
 * @author Matti Schmidt
 * @version 0.1
 */
public class Game extends World
{

    private static final GreenfootImage BACKGROUND = new GreenfootImage("BackGround Der Echte.png");
    
    /**
     * Constructor for the Game.
     * 
     */
    public Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(288, 400, 1); 
        Greenfoot.start();
        Greenfoot.setSpeed(70);
        setBackground(BACKGROUND);
    }
}