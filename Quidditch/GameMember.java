import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * this class is used to store shared information about the members of the game
 * 
 * @author Matti Schmidt 
 * @version 0.9
 */
public class GameMember extends Actor
{
    protected int frame;
    protected int animationDelay;
    protected int xSpeed;
    
    protected void moveLeft() {
        setLocation(getX() - xSpeed, getY());
    }
}
