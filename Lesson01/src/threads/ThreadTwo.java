package threads;/*
 * 25.08.2020 Renamed to ThreadTwo
 * 01.09.2019 Original version
 */


// A thread that extends class Thread directly

import java.util.Random;


public class ThreadTwo
	implements Runnable
{
	private static final int NO_OF_REPETITIONS = 10;
	private static final int MAX_WAIT = 3000; // milliseconds
	
	private Random random = new Random(); // A random number generator
	
	// All threads must have a public void run() method
	
	@Override
	public void run()
	{
		for( int i = 0; i < NO_OF_REPETITIONS; ++i ) {
			System.out.println( "We're number one on the runway " + i );
						
			try {
				Thread.sleep( random.nextInt( MAX_WAIT) ); // wait (at least) a random number of milliseconds
			} catch( InterruptedException ex ) {
			}
		}
	}
}
