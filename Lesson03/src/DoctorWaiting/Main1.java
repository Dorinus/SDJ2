package DoctorWaiting;

public class Main1
{
  public static void main(String[] args)
  {
    WaitingRoom waitingRoom = new WaitingRoom();

    Patient patient = new Patient(0);
    Patient1 patient1 = new Patient1(1,  waitingRoom);
    Patient2 patient2 = new Patient2(2,waitingRoom);


    waitingRoom.addListener(patient);

    Thread thread = new Thread(waitingRoom);
    thread.start();
  }
}
