import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * obstacle
 * 
 * @author Matti Schmidt
 * @version 0.18
 */
public class Pipe extends GameMember
{
    
    private static final GreenfootImage BOTTOM_OBSTACLE = new GreenfootImage("bottom_pipe.png");
    private static final GreenfootImage TOP_OBSTACLE = new GreenfootImage("top_pipe.png");
    
    public Pipe(PipeType type) {
        this.xSpeed = 4;
        switch (type) {
            case TOP:
                setImage(TOP_OBSTACLE);
                break;
            case BOTTOM:
                setImage(BOTTOM_OBSTACLE);
                break;
        }
    }
    
    /**
     * Act - do whatever the Pipe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.moveLeft();
        removePipe();
    }
    
    public void removePipe() {
        if (getX() < - getImage().getWidth()) {
            this.getWorld().removeObject(this);
        }
    }
    
    public enum PipeType {
        TOP,
        BOTTOM;
    }
}
