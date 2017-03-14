import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * object of the character of the game
 * 
 * @author Matti Schmidt 
 * @version 0.3
 */
public class Harry extends GameMember
{
    
    private static final GreenfootImage HARRY_FRONT = new GreenfootImage("HarryPotter Front.png");
    
    private double velocity = 0;
    private static final double gravitiy = 0.5;
    
    public Harry() {
        setImage(HARRY_FRONT);
    }
    
    /**
     * Act - do whatever the Harry wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    private void applyGravity() {
        setLocation(getX(), (int) (getY() + velocity));
    }
    
    private void checkKeys() {
    
    }
}
