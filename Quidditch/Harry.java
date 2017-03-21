import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * object of the character of the game
 * 
 * @author Matti Schmidt 
 * @version 0.4
 */
public class Harry extends GameMember
{

    private static final GreenfootImage HARRY_FRONT = new GreenfootImage("HarryPotter Front.png");

    private double velocity = 0;
    private static final double GRAVITY = 0.5;
    private static final double BOOSTSPEED = -6;

    public Harry() {
        setImage(HARRY_FRONT);
    }

    /**
     * Act - do whatever the Harry wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        applyGravity();
        checkKeys();
    }    

    private void applyGravity() {
        setLocation(getX(), (int) (getY() + velocity));
        velocity+=GRAVITY;
    }

    private void checkKeys() {
        if (Greenfoot.isKeyDown("space") || Greenfoot.mouseClicked(null)) {
            velocity = GRAVITY;
        }
    }
}