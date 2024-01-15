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
    int ySpeed = 1;
    
    SimpleTimer scoreTimer = new SimpleTimer();
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        Human player = new Human();
        
        addObject(player, 200, 350);
        
        getBackground().scale(920, 760);
        
        addObject(new Floor(0), 300, 390);
        
        addObject(new Obstacles(2), 630, 365);
        
        scoreTimer.mark();
        scoreLabel = new Label(0, 70);
        addObject(scoreLabel, 50, 50);
    }
    
    public void increaseScore()
    {
        score = scoreTimer.millisElapsed();
        scoreLabel.setValue(score);
        
        if(score % 1000 == 0)
        {
            level += 1;
        }
    }
    
    public void createObstacles()
    {
        Obstacles obstacles = new Obstacles(ySpeed + 1);
        int place = Greenfoot.getRandomNumber(2);
        int x = 0;
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
}
