import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MainClass of Quidditch
 * 
 * @author Matti Schmidt
 * @version 0.6
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
        Greenfoot.setSpeed(50);
        setBackground(BACKGROUND);
        
        // spawn Harry Potter as character on 100 and height/2
        Harry character = new Harry();
        addObject(character, 100, getHeight() / 2);
    }
}
