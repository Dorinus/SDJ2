/*
 * 29.08.2020 Threads now defined as Runnable
 * 02.09.2019 Original version
 */


package dk.via.jpe.clock;


import javax.swing.JOptionPane;


public class Clock
{
	public static void main( String[] args )
	{
		Time time = new Time();
		Thread disp = new Thread( new DisplayTimer( time ) );
		Thread upd = new Thread( new UpdateTimer( time ) );

		disp.start();
		upd.start();

		while( true ) {
			String newTime = JOptionPane.showInputDialog( null, "New Time" );
			
			time.setTime( Integer.parseInt( newTime ) );
		}
	}
}
