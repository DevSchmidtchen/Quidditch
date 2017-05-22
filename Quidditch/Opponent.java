import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Matti Schmidt
 * @version 1.0
 */
public class Opponent extends GameMember
{
    private MovementDirection direction;
    private static final GreenfootImage OPPONENT = new GreenfootImage("HarryOpponent.png");
    public boolean shouldMove = false;
    private int movementSpeed;
    
    public Opponent(int speed) {
        this.xSpeed = 4;
        this.movementSpeed = speed;
        int random = Greenfoot.getRandomNumber(2);
        if (random == 0) {
            direction = MovementDirection.DOWN;
        } else {
            direction = MovementDirection.UP;
        }
        setImage(OPPONENT);
    }
    
    public void act() 
    {
        this.moveLeft();
        removeOpponent();
        moveAtPosition();
    }
    
    private void moveAtPosition() {
        if (shouldMove) {
            if (direction == MovementDirection.DOWN && this.getY() < getWorld().getHeight() - 50) {
                setLocation(getX(), getY() + movementSpeed);
            } else if (direction == MovementDirection.DOWN && this.getY() >= getWorld().getHeight() - 50) {
                setLocation(getX(), getY() - movementSpeed);
                direction = MovementDirection.UP;
            } else if (direction == MovementDirection.UP && this.getY() > 25) {
                setLocation(getX(), getY() - movementSpeed);
            } else if (direction == MovementDirection.UP && this.getY() <= 25) {
                setLocation(getX(), getY() + movementSpeed);
                direction = MovementDirection.DOWN;
            }
        }
    }
    
    public void removeOpponent() {
        if (getX() < 10) {
            this.getWorld().removeObject(this);
            this.shouldMove = false;
        }
    }
    
    private enum MovementDirection {
        UP,
        DOWN;
    }
}
