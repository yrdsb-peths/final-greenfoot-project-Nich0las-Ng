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
    SimpleTimer scoreTimer = new SimpleTimer();
    public int score = 1;
    Label scoreLabel;
    int level = 1;
    int objectSpeed = 2;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);

        Human player = new Human();

        addObject(player, 200, 350);

        getBackground().scale(920, 760);

        addObject(new Floor(0), 300, 390);

        addObject(new Obstacles(2), 630, 365);
        
        scoreLabel = new Label(0, 70);
        addObject(scoreLabel, 50, 50);
    }
    
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }

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
    
    public void act() {
        if(scoreTimer.millisElapsed() > 1000) {
            scoreTimer.mark();
            increaseScore();
        }
        
        if(score % 20 == 0) {
            increaseLevel();
        }
        
        if(obstacleTimer.millisElapsed() > summonSpeed) {
            obstacleTimer.mark();
            createObstacles();
        }
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);    
    }

    public void increaseLevel(){
        int setSpeed = ySpeed += 1;
        level = level += 1;
        ySpeed = setSpeed;
        objectSpeed = level + 1;
    }
}
