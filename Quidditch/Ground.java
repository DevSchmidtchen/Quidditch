import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ground is the underground of the game to achieve a movement effect
 * 
 * @author Matti Schmidt
 * @version 0.11
 */
public class Ground extends GameMember
{
    
    private static final GreenfootImage GROUND = new GreenfootImage("Underground.png");
    
    public Ground() {
        setImage(GROUND);
        this.xSpeed = 4;
    }
    
    /**
     * Act - do whatever the Ground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.moveLeft();
        remove();
    }    
    
    private void remove() {
        if (getX() < - getImage().getWidth() / 2) {
            getWorld().removeObject(this);
        }
    }
}
