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
    
    public void act()
    {
        // Add your action code here.
        int worldWidth = getWorld().getWidth();
        
        setLocation(getX() - speed, getY());
    }
    
    public Obstacles(int rate)
    {
        speed = rate;
    }
}
