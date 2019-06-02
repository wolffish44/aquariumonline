import Communication.SERVERRESPONSETYPE;
import Communication.ServerResponse;
import Model.ClientAquarium;
import Model.PlaceableObject;
import com.google.gson.Gson;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.List;


@ServerEndpoint(value ="/game/")
public class ServerEndPoint implements ServerEndPointable{

    Gson gson = new Gson();
    private static final List<Session> sessions = new ArrayList();
    @OnOpen
    public void onConnect(Session session)
    {
        System.out.println("[WebSocket Connected] SessionID: " + session.getId());
        sessions.add(session);
        String messageResult = createSuccessfulConnectMessage();
        session.getAsyncRemote().sendText(messageResult);
    }
    public String createSuccessfulConnectMessage()
    {
      String result ="";
      ServerResponse serverResponse = new ServerResponse();
      serverResponse.setServerResponseType(SERVERRESPONSETYPE.SUCCESSFUL_CONNECT);
      result = gson.toJson(serverResponse);
      return result;
    }
    public void updateAquarium(ClientAquarium aquarium)
    {
        ServerResponse newResponse = new ServerResponse();
        newResponse.setServerResponseType(SERVERRESPONSETYPE.AQUARIUMUPDATE);
        newResponse.setParameter(aquarium);
        sendMessageToAllClients(newResponse);

    }
    public void sendMessageToAllClients(ServerResponse serverResponse)
    {
        String response=gson.toJson(serverResponse);
        for (Session session:sessions)
        {
            session.getAsyncRemote().sendText(response);
        }
    }
}
