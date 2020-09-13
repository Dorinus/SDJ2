package threads;/*
 * 25.08.2020 Switched from Thread to Runnable
 * 01.09.2019 Original version
 */

public class ThreadOne
	implements Runnable
{
	private static final int NO_OF_REPETITIONS = 10;
	private static final long TIME_TO_WAIT = 1300L; // milliseconds
	
	// All threads must have a public void run() method
	
	@Override
	public void run()
	{
		for( int i = 0; i < NO_OF_REPETITIONS; ++i ) {
			System.out.println( "The eagle has landed " + i );
			
			try {
				Thread.sleep( TIME_TO_WAIT ); // wait (at least) TIME_TO_WAIT milliseconds
			} catch( InterruptedException ex ) {
			}
		}
	}
}
