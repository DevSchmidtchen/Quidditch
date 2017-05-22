import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Matti Schmidt
 * @version 0.21
 */
public class TitleButton extends Actor
{
    private static final GreenfootImage TITLE_BUTTON = new GreenfootImage("start_button.png");
    private StartOption startOption;
    
    public TitleButton(StartOption startOption) {
        setImage(TITLE_BUTTON);
        this.startOption = startOption;
    }
    
    public void act() {
        if (startOption == StartOption.RESTART) {
            restartGame();
        } else if (startOption == StartOption.START) {
            showInstructions();
        }
    }
    
    private void restartGame() {
        if (Greenfoot.mouseClicked(this) || "escape".equalsIgnoreCase(Greenfoot.getKey())) {
            Game level = new Game();
            level.showGameOverScreen = false;
            level.showTitleScreen = true;
            Greenfoot.setWorld(level);
        }
    }
    
    private void showInstructions() {
        if (Greenfoot.mouseClicked(this) || "space".equalsIgnoreCase(Greenfoot.getKey())) {
            Game level = (Game) getWorld();
            level.showInstructionScreen = true;
        }
    }
    
    public enum StartOption {
        RESTART,
        START;
    }
}
