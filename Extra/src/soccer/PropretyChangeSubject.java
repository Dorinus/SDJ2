package soccer;

import java.beans.PropertyChangeListener;

public interface PropretyChangeSubject
{
  public void addListener(PropertyChangeListener listener);
  public void removeListener(PropertyChangeListener listener);

  public void addListener(String name,PropertyChangeListener listener);
  public void removeListener(String name, PropertyChangeListener listener);
}
