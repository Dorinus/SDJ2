package client.model;

import shared.util.PropretyChangeSubject;

public interface Model extends PropretyChangeSubject
{
  void login(String username, String paswwrod);
}
