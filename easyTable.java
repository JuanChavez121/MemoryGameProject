import greenfoot.*;

/**
 * Write a description of class table here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class easyTable extends World
{

    /**
     * Constructor for objects of class table.
     * 
     */
    private int delayCounter = 0;
    public boolean instructionsVisible = true;
    private leftCup cup1;  
    private middleCup cup2;
    private rightCup cup3;
    private int moveSpeed = 15; 
    public int numSwaps = 10; 
    private int moveSpeedup = 1; 
    private int targetY = 425;
    public easyTable()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        cup1 = new leftCup();  
        addObject(cup1, 325, 525);
        cup3 = new rightCup();
        addObject(cup3, 675, 525);
        ball ball2 = new ball();
        addObject(ball2, 500, 575);
        cup2 = new middleCup();
        addObject(cup2, 500, 425);
        String instructionsText = "Don't lose track of the ball!";
        showText(instructionsText, 500, 300);
    }
    public void act() {
        if (instructionsVisible) {
            delayCounter++;
            if (delayCounter >= 180) { 
                showText("", 500, 300); 
                instructionsVisible = false;
            }
        }
        else if(!instructionsVisible && numSwaps > 0){
            numSwaps--;
            int randomSwap = Greenfoot.getRandomNumber(3);
    
            if (randomSwap == 0){
                animateCupSwap(cup1, cup2);
            }
            else if (randomSwap == 1){
                animateCupSwap(cup2, cup3);
            }
            else
            if (randomSwap == 2){
                animateCupSwap(cup1, cup3);
            
        }       
    }

    }

    private void animateCupSwap(Actor cupA, Actor cupB) {
        int tempX = cupA.getX();
        
        while (cupA.getX() < cupB.getX()) {
            cupA.setLocation(cupA.getX() + moveSpeed, cupA.getY());
            Greenfoot.delay(1); 
        }
        while (cupA.getX() > cupB.getX()) {
            cupA.setLocation(cupA.getX() - moveSpeed, cupA.getY());
            Greenfoot.delay(1); 
        }

        while (cupB.getX() > tempX) {
            cupB.setLocation(cupB.getX() - moveSpeed, cupB.getY());
            Greenfoot.delay(1); 
        }
        while (cupB.getX() < tempX) {
            cupB.setLocation(cupB.getX() + moveSpeed, cupB.getY());
            Greenfoot.delay(1); 
        }
    }
}

    






    
    
    
