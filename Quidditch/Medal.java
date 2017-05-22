import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Matti Schmidt 
 * @version 0.20
 */
public class Medal extends Actor
{
    public Medal (MedalType type) {
        setImage(type.getImage());
    }
    
    public enum MedalType {
        BRONZE (new GreenfootImage("bronze_medal.png")),
        SILBER (new GreenfootImage("silber_medal.png")),
        GOLD (new GreenfootImage("gold_medal.png"));
        
        private GreenfootImage image;
        
        private MedalType (GreenfootImage image) {
            this.image = image;
        }
        
        public GreenfootImage getImage() {
            return image;
        }
    }
}
