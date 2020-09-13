/*
 * 01.09.2019 Original version
 */


// A small utility class used for counting

package dk.via.jpe.counting;


public class SynchronizedCounter
{
	private long value = 0L;
	
	
	public synchronized void increment()
	{
		++value;
	}

	public  synchronized void  decrement(){
		--value;
	}
	
	
	public synchronized long getCount()
	{
		return value;
	}
}
