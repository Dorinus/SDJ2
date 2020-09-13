/*
 * 29.08.2020 Now implements Runnable
 * 02.09.2019 Original version
 */


package dk.via.jpe.clock;


public class UpdateTimer
	implements Runnable
{
	private static final int SECONDS_BETWEEN_UPDATE = 1;
	
	private static final long MILLISECONDS = 1000L;
	
	
	private Time time;
	
	
	public UpdateTimer( Time time )
	{
		this.time = time;
	}
	
	
	@Override
	public void run()
	{
		while( true ) {
			time.increment();
			
			try {
				Thread.sleep( SECONDS_BETWEEN_UPDATE * MILLISECONDS );
			} catch( InterruptedException ex ) {
			}
		}
	}
}
