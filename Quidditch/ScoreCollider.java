import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class ScoreCollider here.
 * 
 * @author Matti Schmidt
 * @version 0.21
 */
public class ScoreCollider extends GameMember
{
    
    private GreenfootImage image = new GreenfootImage(10, 400);
    
    public ScoreCollider() {
        this.xSpeed = 4;
        image.setColor(Color.RED);
        image.fill();
        setImage(image);
        image.setTransparency(0);
    }
    
    /**
     * Act - do whatever the ScoreCollider wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.moveLeft();
        checkCollision();
    }    
    
    public void checkCollision() {
        Actor harry = getOneIntersectingObject(Harry.class);
        if (harry != null) {
            Game level = (Game) getWorld();
            GameScore score = level.getGameScore();
            score.setScore(1);
            getWorld().removeObject(this);
        } else if (getX() < -getImage().getWidth()) {
            getWorld().removeObject(this);
        }
    }
}
