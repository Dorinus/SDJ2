/*
 * 29.08.2020 Switched to Runnable
 * 01.09.2019 Original version
 */


package dk.via.jpe.counting;


public class Counting
{
	public static void main( String[] args )
	{
		SynchronizedCounter counter = new SynchronizedCounter();
		
		// Creating two Threads, that executes the same code
		
		Thread c1 = new Thread( new CountingThread( counter ) );
		Thread c2 = new Thread( new CountingThread( counter ) );


		Thread c3= new Thread(new DecrementingThread(counter));

		c1.start();
		c2.start();
		c3.start();
		
		try {
			c1.join(); // waits for the c1 Thread to end
			c2.join();
			c3.join();
		} catch( InterruptedException ex ) {
			ex.printStackTrace();
		}
		
		System.out.println( counter.getCount() );
	}
}
