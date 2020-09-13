package soccer2;

import java.beans.PropertyChangeListener;

public interface DayAndNightSubject
{
  public void addListener(PropertyChangeListener listener);
  public void removeListener(PropertyChangeListener listener);
}
