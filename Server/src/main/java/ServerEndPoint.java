import com.google.gson.Gson;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint(value ="/game/")
public class ServerEndPoint {

    Gson gson = new Gson();
    @OnOpen
    public void onConnect(Session session)
    {
        System.out.println("[WebSocket Connected] SessionID: " + session.getId());
      //  String message = String.format("[New client with client side session ID]: %s", session.getId());
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
}
