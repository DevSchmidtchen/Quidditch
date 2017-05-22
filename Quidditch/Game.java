import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Quidditch is real and you can play it! NOW! PLAY! For only 66,66€
 * 
 * @author Matti Schmidt
 * @version 0.21
 */
public class Game extends World
{

    private static final GreenfootImage BACKGROUND = new GreenfootImage("BackGround Der Echte.png");
    private int pipeCount;

    public boolean showTitleScreen = true;
    public boolean showInstructionScreen = false;
    public boolean showGameOverScreen = false;
    public boolean playGame = false;
    private boolean addFaby = true;
    private boolean titleObjectsAdded = false;
    private boolean instructionObjectsAdded = false;
    private boolean gameObjectsAdded = false;
    private boolean gameOverObjectsAdded = false;

    private GameScore gameScore = new GameScore();
    private Title title = new Title();
    private TitleButton titleButton = new TitleButton(TitleButton.StartOption.START);
    private Harry harry = new Harry();
    private Instruction tap = new Instruction(Instruction.InstructionSelection.TAP);
    private Instruction ready = new Instruction(Instruction.InstructionSelection.GET_READY);
    private GameOver gameOver = new GameOver();
    private Scoreboard scoreboard = new Scoreboard();
    private TitleButton restartButton = new TitleButton(TitleButton.StartOption.RESTART);

    private Medal bronze = new Medal(Medal.MedalType.BRONZE);
    private Medal silver = new Medal(Medal.MedalType.SILBER);
    private Medal gold = new Medal(Medal.MedalType.GOLD);

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
        setPaintOrder(GameScore.class, Medal.class, Scoreboard.class, GameOver.class, TitleButton.class, Ground.class, Harry.class, Opponent.class);

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
            showTitleScreen = false;
        } else if (playGame) {
            removeObject(ready);
            removeObject(tap);
            if (!gameObjectsAdded) {
                addObject(gameScore, getWidth() / 2 + 25, 30);
                gameScore.setScore(0);

                // spawn Harry Potter on 100 and height/2
                addObject(harry, 100, getHeight()/2);

                gameObjectsAdded = true;
                showInstructionScreen = false;
            }
            createPipe();
        }
        if (showGameOverScreen && !gameOverObjectsAdded) {
            playGame = false;
            addObject(gameOver, getWidth() / 2, getHeight()/2-125);
            addObject(scoreboard, getWidth() / 2, getHeight()/2-10);
            addObject(restartButton, getWidth() / 2, getHeight()/2+100);

            gameScore.setLocation(getWidth()/2+60, getHeight()/2 - 10);

            if (gameScore.getScore() >= 10 && gameScore.getScore() < 50) {
                addObject(bronze, getWidth() / 2 - 55, getHeight()/2);
            } else if (gameScore.getScore() >= 50 && gameScore.getScore() < 100) {
                addObject(silver, getWidth() / 2 - 55, getHeight()/2);
            } else if (gameScore.getScore() >= 100) {
                addObject(gold, getWidth() / 2 - 55, getHeight()/2);
            }
            gameOverObjectsAdded = true;
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

        Opponent opponent = new Opponent(Greenfoot.getRandomNumber(5) + 1);
        
        int numOfOpponents = Greenfoot.getRandomNumber(10) + 4;

        pipeCount++;
        if (pipeCount == 50) {
            if (getObjects(Opponent.class).size() < numOfOpponents) {
                /*
                addObject(bottom_pipe, getWidth(), getHeight() / 2 + image.getHeight() - Greenfoot.getRandomNumber(100) - 10);
                addObject(top_pipe, getWidth(), bottom_pipe.getY() - image.getHeight() - pipeSpacing);
                */
               addObject(opponent, getWidth(), getHeight() / 2);
                addObject(scoreCollider, getWidth() + 20, getHeight() / 2);
                opponent.shouldMove = true;
            }
            pipeCount = 0;
        }
    }

    public GameScore getGameScore() {
        return gameScore;
    }
}
