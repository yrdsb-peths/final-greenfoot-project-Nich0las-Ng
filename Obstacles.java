import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates tumbleweed.
 * 
 * @author (Nicholas N) 
 * @version (Jan 17 2024)
 */
public class Obstacles extends Actor
{
    /**
     * Act - do whatever the Obstacles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed;
    
    GreenfootImage[] idle = new GreenfootImage[8];
    SimpleTimer animationTimer = new SimpleTimer();
    
    /**
     * Constructor - The code that gets run one time when object is created
     */
    public Obstacles()
    {
        for(int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("images/tumbleweed_idle/idle"+i+".png");
            idle[i].scale(50, 50);
        }
        setImage(idle[0]);
    }
    
    /**
     * Animat the tumbleweed
     */
    int imageIndex = 0;
    public void animateTumbleweed()
    {
        if(animationTimer.millisElapsed() < 1000)
        {
            return;
        }
        animationTimer.mark();
        
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
    
    public void act()
    {
        // Add your action code here.
        int worldWidth = getWorld().getWidth();
        
        setLocation(getX() - speed, getY());
        
        // animateTumbleweed();
    }
    
    /**
     * Sets the speed of the tumbleweed
     */
    public Obstacles(int rate)
    {
        speed = rate;
    }
}
