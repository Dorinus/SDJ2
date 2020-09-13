package threads;/*
 * 01.09.2019 Original version
 */

// Two different ways to create Threads

public class SecondThreads
{
	public static void main( String[] args )
	{
		Thread t1 = new Thread( new ThreadOne() );
		Thread t2 = new Thread( new ThreadTwo() );
		
		t1.start();
		t2.start();
	}
}
