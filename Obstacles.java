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
    GreenfootImage[] idle = new GreenfootImage[6];
    
    int speed;
    public void act()
    {
        // Add your action code here.
        int worldWidth = getWorld().getWidth();
        
        setLocation(getX() - speed, getY());
    }
    
    public void idle()
    {
        for(int i = 0; i < 6; i++)
        {
            idle[i] = new GreenfootImage("image/tumbleweed_idle/idle" + i + "png");
        }
        setImage(idle[0]);
    }
    
    int imageIndex = 0;
    public void animateTumbleweed()
    {
        setImage(idle[imageIndex]);
        imageIndex = imageIndex + 1 % idle.length;
    }
    
    public Obstacles(int rate)
    {
        speed = rate;
    }
}
