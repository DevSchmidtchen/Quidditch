import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Matti Schmidt
 * @version 0.20
 */
public class Instruction extends Actor
{
    private static final GreenfootImage INSTRUCTION_TAP = new GreenfootImage("instructions_tap.png");
    private static final GreenfootImage INSTRUCTION_READY = new GreenfootImage("instructions_ready.png");
    
    public Instruction(InstructionSelection instructionSelection) {
        setImage(instructionSelection.getImage());
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
    
    public enum InstructionSelection {
        GET_READY (new GreenfootImage("instructions_ready.png")),
        TAP (new GreenfootImage("instructions_tap.png"));
        
        private GreenfootImage image;
        
        private InstructionSelection(GreenfootImage image) {
            this.image = image;
        }
        
        public GreenfootImage getImage() {
            return image;
        }
    }
}
