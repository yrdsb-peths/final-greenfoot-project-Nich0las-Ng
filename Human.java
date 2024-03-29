import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Makes the player
 * 
 * @author (Nicholas N) 
 * @version (Jan 17 2024)
 */
public class Human extends Actor
{
    /**
     * Act - do whatever the Human wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    static final double gravity = 0.4;
    static final int jumpForce = 11;
    double ySpeed = 0;
    int xSpeed = 3;
    
    public void act()
    {
        // Add your action code here.
        moveVertically();
        moveHorizontally();
    }
    
    /**
     * Allows the Player to move left and right 
     * using the left and right arrow keys
     */
    private void moveHorizontally()
    {
        int dx = 0;
        if(Greenfoot.isKeyDown("left"))
        {
            dx--;
        }
        if(Greenfoot.isKeyDown("right"))
        {
            dx++;
        }
        setLocation(getX() + dx * xSpeed, getY());
    }
    
    /**
     * Allows the player to jump using the up arrow key
     */
    private void moveVertically()
    {
        int worldHeight = getWorld().getHeight() - 30;
        int myHeight = getImage().getHeight();
        
        boolean onGround = false;
        
        ySpeed += gravity;
        
        setLocation(getX(), getY() + (int)ySpeed);
        if(getY() > worldHeight - 10)
        {
            setLocation(getX(), worldHeight - myHeight / 2 + 13);
            ySpeed = 0;
            onGround = true;
        }
        
        int dy = (int)Math.signum(ySpeed);
        while(getOneIntersectingObject(Floor.class)!= null)
        {
            setLocation(getX(), getY() - dy);
            if((dy > 0) && onGround == true)
            {
                ySpeed = 0;
            }
        }
        
        if(onGround && Greenfoot.isKeyDown("up")) 
        {
            ySpeed =-jumpForce;
        }
        
        /**
         * Sets the player screen to Game Over when they touch a tumbleweed
         */
        MyWorld world = (MyWorld) getWorld();
        if(isTouching(Obstacles.class))
        {
            world.gameOver();
            Greenfoot.stop();
        }
    }
    
    
}
