package Burgers;

public class Burgers
{
  private int maxNrOfBurgers;
  private int burgersNow;

  public Burgers(int maxNrOfBurgers, int burgersNow)
  {
    this.maxNrOfBurgers = maxNrOfBurgers;
    this.burgersNow = burgersNow;
  }

  public synchronized void make(){
    burgersNow++;
  }

  public synchronized void sellBurger(int i){
    burgersNow-=i;
  }

  public  int getMaxNrOfBurgers()
  {
    return maxNrOfBurgers;
  }

  public  int getBurgersNow()
  {
    return burgersNow;
  }
}
