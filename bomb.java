import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bomb extends Actor
{
    private int transparencyChange = 1; 
    private int minTransparency = 100;
    private int maxTransparency = 255;
    /**
     * Act - do whatever the bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public bomb()
    {
        // Retrieve the existing image associated with the actor
        GreenfootImage bombImage = getImage();
        
        // Resize the existing image to a specific width and height
        int newWidth = 120; // Set the desired width
        int newHeight = 160; // Set the desired height
        bombImage.scale(newWidth, newHeight);
        
        // Set the modified image back to the actor
        setImage(bombImage);
    }
    public void act()
    {
        int currentTransparency = getImage().getTransparency();

        // Increase or decrease transparency
        currentTransparency += 2*transparencyChange;

        // Ensure transparency stays within the specified range
        if (currentTransparency > maxTransparency) {
            currentTransparency = maxTransparency;
            transparencyChange = -transparencyChange; // Reverse the change direction
        } else if (currentTransparency < minTransparency) {
            currentTransparency = minTransparency;
            transparencyChange = -transparencyChange; // Reverse the change direction
        }

        // Set the new transparency
        getImage().setTransparency(currentTransparency);
    }
}
