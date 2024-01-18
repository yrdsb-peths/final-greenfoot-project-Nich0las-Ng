import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game Idea: Offline Dinasour game
 * 
 * @author (Nicholas Ng)
 * @version (Jan 9 2024)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    int ySpeed = 2;

    SimpleTimer obstacleTimer = new SimpleTimer();
    int summonSpeed = 2000;
    SimpleTimer levelIncrease = new SimpleTimer();
    SimpleTimer scoreTimer = new SimpleTimer();
    public int score = 1;
    Label scoreLabel;
    int level = 1;
    int objectSpeed = 2;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        //creates the player
        Human player = new Human();
        
        addObject(player, 200, 350);
        
        //set the background to fill the whole screen
        getBackground().scale(920, 760);
        
        //Adds the floor for the player to stand on
        addObject(new Floor(0), 300, 390);
        
        //Adds the first tumbleweed for the player to dodge
        addObject(new Obstacles(2), 630, 365);
        
        //Adds the score label
        scoreLabel = new Label(0, 70);
        addObject(scoreLabel, 50, 50);
    }
    
    /**
     * Print out Game Over on the screen
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    /**
     * Creates more obstacles
     */
    public void createObstacles()
    {
        int place = Greenfoot.getRandomNumber(3);
        int x = 630;
        int y = 365;
        if(place % 2 == 0)
        {
            x = -30;
            objectSpeed = -objectSpeed;
        }
        if(place % 2 ==1)
        {
            x = 630;
            objectSpeed = objectSpeed;
        }
        Obstacles obstacles = new Obstacles(objectSpeed);
        addObject(obstacles, x, y);
    }
    
    /**
     * This makes it to where after a certain amount of time the score would increase
     * Also increases the difficulty
     * Creates objects after a certain amount of time
     */
    public void act() {
        //increase score after 1 second
        if(scoreTimer.millisElapsed() > 1000) {
            scoreTimer.mark();
            increaseScore();
        }
        
        //increase level after 20 seconds
        if(levelIncrease.millisElapsed() > 20000) {
            levelIncrease.mark();
            increaseLevel();
        }
        
        //makes an object after 2 seconds
        if(obstacleTimer.millisElapsed() > summonSpeed) {
            obstacleTimer.mark();
            createObstacles();
        }
    }
    
    /**
     * This increases the score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);    
    }
    
    /**
     * Increases the level (making the game harder)
     * By making summon speed faster and speed of the tumbleweed
     */
    public void increaseLevel(){
        int setSpeed = ySpeed += 1;
        level = level += 1;
        ySpeed = setSpeed;
        objectSpeed = level + 1;
        summonSpeed = 2000 - 100 * (level - 1);
    }
}
