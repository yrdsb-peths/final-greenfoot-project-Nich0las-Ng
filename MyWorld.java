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

    SimpleTimer scoreTimer = new SimpleTimer();
    public int score = 0;
    Label scoreLabel;
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
        Obstacles obstacles = new Obstacles(ySpeed);
        int place = Greenfoot.getRandomNumber(3);
        int x = 630;
        if(place % 2 == 0)
        {
            x = -30;
        }
        if(place % 2 ==1)
        {
            x = 630;
        }
        int y = 365;
        addObject(obstacles, x, y);
    }
    
    public void act() {
        if(scoreTimer.millisElapsed() > 1000) {
            scoreTimer.mark();
            increaseScore();
        }
        
        if(score % 30 == 0) {
            increaseLevel();
        }
        
        if(score % 2 == 0) {
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
        ySpeed = setSpeed;
    }
}
