import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends Actor
{
    /**
     * Act - do whatever the Floor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed;
    
    public void act()
    {
        // Add your action code here.
        int worldWidth = getWorld().getWidth();
        
        setLocation(getX() - speed, getY());
    }
    
    public Floor(int rate)
    {
        speed = rate;
        GreenfootImage image = new GreenfootImage(600,10);
        image.fill();
        setImage(image);
    }
}
