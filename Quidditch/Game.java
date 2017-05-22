import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Quidditch is real and you can play it! NOW! PLAY! For only 66,66€
 * 
 * @author Matti Schmidt
 * @version 0.16
 */
public class Game extends World
{

    private static final GreenfootImage BACKGROUND = new GreenfootImage("BackGround Der Echte.png");
    private int pipeCount;
    private GameScore gameScore = new GameScore();
    
    /**
     * Constructor for the Game.
     * 
     */
    public Game() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(288, 400, 1, false);
        Greenfoot.start();
        Greenfoot.setSpeed(50);
        setBackground(BACKGROUND);
        
        // set paint order
        setPaintOrder(GameScore.class, Ground.class, Harry.class, Pipe.class);
        
        // spawn Harry Potter as character on 100 and height/2
        Harry character = new Harry();
        addObject(character, 100, getHeight()/2);
        
        // generate underground
        Ground underground = new Ground();
        addObject(underground, 150, getHeight());
        
        addObject(gameScore, getWidth() / 2 + 25, 30);
        gameScore.setScore(0);
    }
    
    public void act() {
        createGround();
        createPipe();
    }
    
    private void createGround() {
        if (getObjects(Ground.class).size() < 2) {
            Ground additionalGround = new Ground();
            addObject(additionalGround, 450, getHeight());
        }
    }
    
    private void createPipe() {
        ScoreCollider scoreCollider = new ScoreCollider();
        
        Pipe top_pipe = new Pipe(Pipe.PipeType.TOP);
        Pipe bottom_pipe = new Pipe(Pipe.PipeType.BOTTOM);
        
        int pipeSpacing = 150;
        
        GreenfootImage image = bottom_pipe.getImage();
        
        int numOfPipes = Greenfoot.getRandomNumber(10) + 4;
        
        pipeCount++;
        if (pipeCount == 50) {
            if (getObjects(Pipe.class).size() < numOfPipes) {
                addObject(bottom_pipe, getWidth(), getHeight() / 2 + image.getHeight() - Greenfoot.getRandomNumber(100) - 10);
                addObject(top_pipe, getWidth(), bottom_pipe.getY() - image.getHeight() - pipeSpacing);
                addObject(scoreCollider, getWidth() + 20, getHeight() / 2);
            }
            pipeCount = 0;
        }
    }
    
    public GameScore getGameScore() {
        return gameScore;
    }
    
    public void reset() {
        
    }
}
