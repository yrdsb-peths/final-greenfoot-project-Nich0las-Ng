import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Human here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Human extends Actor
{
    /**
     * Act - do whatever the Human wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    static final int gravity = 2;
    static final int jumpForce = 20;
    int xSpeed = 4;
    int ySpeed = 0;
    
    public void act()
    {
        // Add your action code here.
        int x = getX();
        int y = getY();
        
        moveVertically();
    }
    
    private void moveVertically()
    {
        int worldHeight = getWorld().getHeight() - 30;
        int myHeight = getImage().getHeight();
        boolean onGround = false;
        ySpeed += gravity;
        setLocation(getX(), getY()+ySpeed);
        if(getY() > worldHeight - 10)
        {
            setLocation(getX(), worldHeight - myHeight / 2 + 13);
            ySpeed = 0;
            onGround = true;
        }
        
        int dy = (int)Math.signum(ySpeed);
        while(getOneIntersectingObject(null) != null)
        {
            setLocation(getX(), getY() - dy);
            if((dy > 0) && onGround == true)
            {
                ySpeed = 0;
            }
        }
        
        if(onGround && Greenfoot.isKeyDown("space")) 
        {
            ySpeed =-jumpForce;
        }
    }
}
