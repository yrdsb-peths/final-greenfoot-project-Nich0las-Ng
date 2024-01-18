import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Something for the player to stand on.
 * 
 * @author (Nicholas N) 
 * @version (Jan 17 2024)
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
    
    /**
     * Create a black line/floor for the player to stand on
     */
    public Floor(int rate)
    {
        speed = rate;
        GreenfootImage image = new GreenfootImage(600,10);
        image.fill();
        setImage(image);
    }
}
