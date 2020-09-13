package dk.via.jpe.counting;

public class DecrementingThread implements Runnable
{

  private static final int COUNT = 25000000;

  private SynchronizedCounter sc;

  public DecrementingThread(SynchronizedCounter sc)
  {
    this.sc = sc;
  }

  @Override public void run()
  {
    for(int i=0; i<COUNT;i++){
      sc.decrement();
    }
  }
}
