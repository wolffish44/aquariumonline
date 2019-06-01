package Communication;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnMessage;
import javax.websocket.WebSocketContainer;
import java.net.URI;
@ClientEndpoint
public class ClientEndPoint implements ClientEndPointable
{

        public  void startClient() {
            System.out.println("[WebSocket Client start]");
            try {
                WebSocketContainer container = ContainerProvider.getWebSocketContainer();
                container.connectToServer(this, new URI("ws://localhost:10/game/"));

            } catch (Exception e) {
                System.out.println("Failed to connect to server...");
                e.printStackTrace();
            }
        }
        @OnMessage
        public void msgReceived(String message)
        {

            JsonObject recievedJson = new JsonParser().parse(message).getAsJsonObject();

        }


}
