package client.networking;

import shared.datatransfer.User;
import shared.util.PropretyChangeSubject;

public interface Client extends PropretyChangeSubject
{
  void login(User user);
}
