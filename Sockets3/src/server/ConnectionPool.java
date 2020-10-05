package server;

import shared.Message;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool
{
  private List<ChatServerHandler> connections = new ArrayList<>();

  public void  addConnection(ChatServerHandler csh){
    connections.add(csh);
  }

  public void broadcast(Message msg){
    for(ChatServerHandler conn : connections){
      if(!conn.getClientName().equals(msg.getUser()))
      conn.sendMessageToClient(msg);
    }
  }

  public void removeConnection(ChatServerHandler csh)
  {
    connections.remove(csh);
  }
}
