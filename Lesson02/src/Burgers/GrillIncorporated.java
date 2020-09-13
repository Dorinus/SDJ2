package Burgers;

public class GrillIncorporated
{
  public static void main(String[] args)
  {
    Burgers burgers = new Burgers(20,0);

    Thread cook = new Thread(new CookThread(burgers));
    Thread cook1 = new Thread(new CookThread(burgers));
    Thread client1 = new Thread(new ClientThread(burgers));
 // Thread client2 = new Thread(new ClientThread(burgers));

    cook.start();
    cook1.start();
    client1.start();
 // client2.start();
  }
}
