package javapracticegame;

/**
 *
 * @author Adrian
 * Haven't implemented this class into the actual code yet,
 * thought I should upload something so you guys could see
 * what I'm doing and how it'll work
 */
public class Timer 
{
    private long startTime = 0;
    private long stopTime = 0;
    public boolean running = false;

    public void start() 
    {
        this.startTime = System.currentTimeMillis();
   	this.running = true;
    }

    public void stop() 
    {
        this.stopTime = System.currentTimeMillis();
    	this.running = false;
    }


    //time in milliseconds
    //Not sure if we want it this precise 
    //or just seconds so both are included
    public long getTime() 
    {
        long elapsed;
    	if (running) 
	{
            elapsed = (System.currentTimeMillis() - startTime);
    	}
    	else 
	{
            elapsed = (stopTime - startTime);
    	}
    	return elapsed;
    }


    //time in seconds
    public int getTimeSeconds() 
    {
        long elapsed;
    	if (running) 
	{
          	elapsed = ((System.currentTimeMillis() - startTime) / 1000);
    	}
    	else 
	{
           	elapsed = ((stopTime - startTime) / 1000);
    	}
    	return (int) elapsed;
    }

}
