import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * GameScore of a player
 * 
 * @author Matti Schmidt
 * @version 0.15
 */
public class GameScore extends Actor
{
    
    private GreenfootImage scoreImage;
    private int score;
    
    public GameScore() {
        scoreImage = new GreenfootImage(68, 30);
        setImage(scoreImage);
    }  
    
    public void setScore(int score) {
        this.score += score;
        
        scoreImage.clear();
        
        Color color = new Color(127, 127, 127, 127);
        scoreImage.setColor(color);
        scoreImage.fill();
        
        Font font = new Font("Impact", Font.PLAIN, 32);
        scoreImage.setFont(font);
        scoreImage.setColor(Color.BLACK);
        scoreImage.drawString(this.score + "", 2, 30);
        scoreImage.setColor(Color.WHITE);
        scoreImage.drawString(this.score + "", 0, 30);
        setImage(scoreImage);
    }
    
    public int getScore() {
        return score;
    }
}
