import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MainClass of Quidditch
 * 
 * @author Matti Schmidt
 * @version 0.9
 */
public class Game extends World
{

    private static final GreenfootImage BACKGROUND = new GreenfootImage("BackGround Der Echte.png");
    
    /**
     * Constructor for the Game.
     * 
     */
    public Game() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(288, 400, 1, false);
        Greenfoot.start();
        Greenfoot.setSpeed(50);
        setBackground(BACKGROUND);
        
        // spawn Harry Potter as character on 100 and height/2
        Harry character = new Harry();
        addObject(character, 100, getHeight()/2);
        
        // generate underground
        Ground underground = new Ground();
        addObject(underground, 150, getHeight());
    }
    
    public void act() {
        createGround();
    }
    
    private void createGround() {
        if (getObjects(Ground.class).size() < 2) {
            Ground additionalGround = new Ground();
            addObject(additionalGround, 450, getHeight());
        }
    }
}
