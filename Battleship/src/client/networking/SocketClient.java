package client.networking;

import shared.EventType;
import shared.datatransfer.Request;
import shared.datatransfer.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClient implements Client
{

  private PropertyChangeSupport support;
  private Socket socket;
  private ObjectOutputStream outToServer;

  public SocketClient()
  {
    this.support = new PropertyChangeSupport(this);
    start();
  }

  public void start(){
    try
    {
      socket = new Socket("localhost",2910);
      new Thread(this::listenToServer).start();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void listenToServer(){
    try
    {
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
      outToServer = new ObjectOutputStream(socket.getOutputStream());

      while (true){
        Request request = (Request) inFromServer.readObject();
        support.firePropertyChange(request.type.toString(),null,(String)request.arg);


//        if(request.type == EventType.LOGIN_RESULT){
//          support.firePropertyChange(EventType.LOGIN_RESULT.toString(),null,(String)request.arg);
        }
      }

    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }


  }

  @Override public void login(User user)
  {
    Request request = new Request(EventType.LOGIN_REQUEST,user);
    try
    {
      outToServer.writeUnshared(request);
    }
    catch (IOException e)
    {
      support.firePropertyChange(EventType.LOGIN_RESULT.toString(),null,"Connection lost, restart program");
    }
  }
  @Override public void addPropretyChangeListener(String name, PropertyChangeListener listener)
  {
    if(name==null){
      addPropretyChangeListener(listener);
    } else {
      support.addPropertyChangeListener(name,listener);
    }

  }

  @Override public void addPropretyChangeListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removePropretyChangeListener(String name, PropertyChangeListener listener)
  {
    if(name==null){
      removePropretyChangeListener(listener);  //why no support
    } else {
      support.removePropertyChangeListener(name, listener);
    }
  }

  @Override public void removePropretyChangeListener(PropertyChangeListener listener)
  {

    support.removePropertyChangeListener(listener);
  }
}
