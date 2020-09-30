/*
 * 04.09.2020 Switched to Runnable
 * 08.09.2019 Original version
 */


package dk.via.jpe.grill;


public class Cook
	implements Runnable
{
	private static final long PRODUCTION_TIME = 6000L;
	
	
	private int cookNo;
	private Grill grill;
	
	
	public Cook( int cookNo, Grill grill )
	{
		this.cookNo = cookNo;
		this.grill = grill;
	}
	
	
	@Override
	public void run()
	{
		System.out.println( "Cook #" + cookNo + " is ready" );
		
		while( true ) {
			grill.startProducing();
			
			System.out.println( "Cook #" + cookNo + " starts producing a burger" );
			
			try {
				Thread.sleep( PRODUCTION_TIME );
			} catch( InterruptedException ex ) {
			}
			
			System.out.println( "Cook #" + cookNo + " has produced a burger and is ready" );
			
			grill.burgerCompleted();
		}
	}
}
