import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    //To keep count of what my labels are (real ones are below in prepare)
    Label titleLabel = new Label("Welcome to Tumbleweed", 60);
    Label moveLabel = new Label("Use Arrow Key to Move", 40);
    Label gameMecLabel = new Label("To Play Dogde the Tumbleweed", 40);
    Label startLabel = new Label("Press <<ENTER>> to start", 40);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        getBackground().scale(920, 760);

        prepare();
    }
    
    /**
     * Allows the user to entre the game using enter
     */
    public void act()
    {
        //Start the game if user presses the space bar
        if(Greenfoot.isKeyDown("enter"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     * Give game name, how to move, what to do and how to start playing
     */
    private void prepare()
    {
        Label label = new Label("Welcome to Tumbleweed", 60);
        addObject(label,348,90);
        label.setLocation(300,90);
        Label label2 = new Label("Use Arrow Key to Move", 40);
        addObject(label2,275,160);
        label2.setLocation(300,170);
        Label label3 = new Label("To Play Dogde the Tumbleweed", 40);
        addObject(label3,289,230);
        label3.setLocation(300,250);
        Label label4 = new Label("Press <<ENTER>> To Start", 40);
        addObject(label4,279,307);
        label4.setLocation(300,330);
    }
}
