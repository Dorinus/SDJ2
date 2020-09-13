package Homework;

public class Time
{
  private int hours, minutes, seconds;

  public Time(int hours, int minutes, int seconds)
  {
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
  }

  public void tick(){
    if(seconds == 59 && minutes ==59 && hours ==23){
      hours=0;
      minutes=0;
      seconds=0;
    } else if(seconds == 59 && minutes ==59 && hours<22)
    {
      hours++;
      seconds = 0;
      minutes=0;
    }else if(seconds == 59)
    {
      seconds = 0;
      minutes++;
    } else {
      seconds++;
    }
  }

  public void setHours(int hours)
  {
    this.hours = hours;
  }

  public void setMinutes(int minutes)
  {
    this.minutes = minutes;
  }

  public void setSeconds(int seconds)
  {
    this.seconds = seconds;
  }

  public void tick(int seconds){
    for(int i=0;i<seconds;i++){
      tick();
    }
  }

  public void set(int hours, int minutes,int seconds){
    this.hours=hours;
    this.minutes=hours;
    this.seconds=hours;
  }

  public int getHours()
  {
    return hours;
  }

  public int getMinutes()
  {
    return minutes;
  }

  public int getSeconds()
  {
    return seconds;
  }

  @Override public String toString()
  {
    return hours+"/"+minutes+"/"+seconds;
  }
}
