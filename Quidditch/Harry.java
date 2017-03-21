import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * object of the character of the game
 * 
 * @author Matti Schmidt 
 * @version 0.5
 */
public class Harry extends GameMember
{

    private static final GreenfootImage HARRY_FRONT = new GreenfootImage("HarryPotter_Front.png");
    private static final GreenfootImage HARRY_DOWN = new GreenfootImage("HarryPotter_Fly_Down.png");

    private double velocity = 0;
    private static final double GRAVITY = 0.5;
    private static final double BOOSTSPEED = -6.0;

    public Harry() {
        setImage(HARRY_FRONT);
        this.animationDelay = 4;
    }

    /**
     * Act - do whatever the Harry wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        applyGravity();
        checkKeys();
        animateHarry();
    }    

    private void applyGravity() {
        setLocation(getX(), (int) (getY() + velocity));
        velocity = velocity + GRAVITY;
    }

    private void checkKeys() {
        if (Greenfoot.isKeyDown("space") == true || Greenfoot.mouseClicked(null) == true) {
            velocity = BOOSTSPEED;
            setImage(HARRY_FRONT);
        } else {
            setImage(HARRY_DOWN);
        }
    }
    
    private void animateHarry() {
        //TODO create images
    }
}