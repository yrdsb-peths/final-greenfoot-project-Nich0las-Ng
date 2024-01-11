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
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        Human player = new Human();
        
        addObject(player, 200, 350);
        
        getBackground().scale(920, 760);
        
        addObject(new Floor(0), 300, 390);
        
        addObject(new Obstacles(2), 550, 365);
    }
}
