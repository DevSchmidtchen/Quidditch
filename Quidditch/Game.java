import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Quidditch is real and you can play it! NOW! PLAY! For only 66,66€
 * 
 * @author Matti Schmidt
 * @version 0.20
 */
public class Game extends World
{

    private static final GreenfootImage BACKGROUND = new GreenfootImage("BackGround Der Echte.png");
    private int pipeCount;
    
    public boolean showTitleScreen = true;
    public boolean showInstructionScreen = false;
    public boolean playGame = false;
    private boolean addFaby = true;
    private boolean titleObjectsAdded = false;
    private boolean instructionObjectsAdded = false;
    private boolean gameObjectsAdded = false;
    
    private GameScore gameScore = new GameScore();
    private Title title = new Title();
    private TitleButton titleButton = new TitleButton();
    private Harry harry = new Harry();
    private Instruction tap = new Instruction(Instruction.InstructionSelection.TAP);
    private Instruction ready = new Instruction(Instruction.InstructionSelection.GET_READY);
    
    /**
     * Constructor for the Game.
     * 
     */
    public Game() {    
        super(288, 400, 1, false);
        Greenfoot.start();
        Greenfoot.setSpeed(50);
        setBackground(BACKGROUND);
        
        // set paint order
        setPaintOrder(GameScore.class, Ground.class, Harry.class, Pipe.class);
        
        // generate underground
        Ground underground = new Ground();
        addObject(underground, 150, getHeight());
    }
    
    public void act() {
        createGround();
        
        if (showTitleScreen && !titleObjectsAdded) {
            addObject(title, getWidth() / 2, 100);
            addObject(titleButton, getWidth() / 2, getHeight() / 2);
            titleObjectsAdded = true;
        }else if (showInstructionScreen && !instructionObjectsAdded) {
            removeObject(title);
            removeObject(titleButton);
            addObject(ready, getWidth() / 2, getHeight() / 2 - 75);
            addObject(tap, getWidth() / 2, getHeight() / 2 + 50);
            instructionObjectsAdded = true;
        } else if (playGame) {
            removeObject(ready);
            removeObject(tap);
            if (!gameObjectsAdded) {
                addObject(gameScore, getWidth() / 2 + 25, 30);
                gameScore.setScore(0);
                
                // spawn Harry Potter on 100 and height/2
                addObject(harry, 100, getHeight()/2);
                
                gameObjectsAdded = true;
            }
            createPipe();
        }
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
