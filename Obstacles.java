import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    public Obstacles()
    {
        for(int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("images/tumbleweed_idle/idle" + i + ".png");
        }
        animationTimer.mark();
        setImage(idle[0]);
    }
    
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
        
        animateTumbleweed();
    }
    
    
    
    public Obstacles(int rate)
    {
        speed = rate;
    }
}
