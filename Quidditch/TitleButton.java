import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Matti Schmidt
 * @version 0.18
 */
public class TitleButton extends Actor
{
    private static final GreenfootImage TITLE_BUTTON = new GreenfootImage("start_button.png");
    
    public TitleButton() {
        setImage(TITLE_BUTTON);
    }
    
    public void act() {
        startGame();
    }
    
    private void startGame() {
        
        if (Greenfoot.mouseClicked(this) || "space".equalsIgnoreCase(Greenfoot.getKey())) {
            Game level = (Game) getWorld();
            level.playGame = true;
        }
    }
}
