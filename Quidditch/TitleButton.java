import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Matti Schmidt
 * @version 0.20
 */
public class TitleButton extends Actor
{
    private static final GreenfootImage TITLE_BUTTON = new GreenfootImage("start_button.png");
    
    public TitleButton() {
        setImage(TITLE_BUTTON);
    }
    
    public void act() {
        showInstructions();
    }
    
    private void showInstructions() {
        if (Greenfoot.mouseClicked(this) || "space".equalsIgnoreCase(Greenfoot.getKey())) {
            Game level = (Game) getWorld();
            level.showInstructionScreen = true;
        }
    }
}
