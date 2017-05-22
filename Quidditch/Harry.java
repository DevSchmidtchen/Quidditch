import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * object of the character of the game
 * 
 * @author Matti Schmidt 
 * @version 0.21
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
        rotate();
        upperBoundary();
        checkCollision();
    }    
    
    private void reset() {
        velocity = 0.0;
        setRotation(0);
        setImage(HARRY_FRONT);
    }

    private void applyGravity() {
        setLocation(getX(), (int) (getY() + velocity));
        velocity+=GRAVITY;
    }

    private void checkKeys() {
        if (Greenfoot.isKeyDown("space") || Greenfoot.mouseClicked(null)) {
            velocity = BOOSTSPEED;
            setImage(HARRY_FRONT);
        } else {
            setImage(HARRY_DOWN);
        }
    }
    
    private void rotate() {
        if (velocity < 1) {
            setRotation(-30);
        } else if (velocity < 8) {
            setRotation(0);
        } else if (velocity < 12) {
            setRotation(30);
        } else if (velocity < 30) {
            setRotation(80);
        }
    }
    
    private void checkCollision() {
        Actor collisionGround = getOneIntersectingObject(Ground.class);
        Actor collisionOpponent = getOneIntersectingObject(Opponent.class);
        if (collisionGround != null || collisionOpponent != null) {
            Game level = (Game) getWorld();
            level.showGameOverScreen = true;
            level.removeObject(this);
        }
    }
    
    private void upperBoundary() {
        if (this.getY() <= 14) {
            setLocation(getX(), 14);
        }
    }
}