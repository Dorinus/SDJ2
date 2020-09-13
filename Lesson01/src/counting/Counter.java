/*
 * 01.09.2019 Original version
 */


// A small utility class used for counting

package counting;


public class Counter
{
	private long value = 0L;
	
	
	public void increment()
	{
		++value;
	}
	
	
	public long getCount()
	{
		return value;
	}
}
