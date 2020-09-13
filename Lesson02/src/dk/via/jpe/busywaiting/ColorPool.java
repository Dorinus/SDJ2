/*
 * 04.09.2019 Original version
 */


package dk.via.jpe.busywaiting;


import java.util.ArrayList;


public class ColorPool
{
	// list contains the colors, that are in pool at the moment
	
	private ArrayList<String> list = new ArrayList<String>();
	
	
	public ColorPool()
	{
		// add the colors
		
		list.add( "Red" );
		list.add( "Green" );
		list.add( "Blue" );
	}
	
	
	public synchronized String getColor()
	{
		if( list.size() == 0 )
			return null; // no colors available -- return null;
		else {
			return list.remove(0); // remove and return the first color
		}
	}
	
	
	public synchronized void returnColor( String c )
	{
		list.add( c ); // put a color back in the pool
	}
}
