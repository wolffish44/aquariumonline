package Communication;

import Model.Aquariumable;
import Model.PlaceableObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnMessage;
import javax.websocket.WebSocketContainer;
import java.net.URI;
import java.util.List;

@ClientEndpoint
public class ClientEndPoint implements ClientEndPointable
{
    public Gson gson = new Gson();
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
           ServerResponse response = gson.fromJson(message,ServerResponse.class);
           executeMessage(response);
        }
        public void executeMessage(ServerResponse response)
        {

            switch (response.getServerResponseType())
            {
                case AQUARIUMUPDATE:

            }
        }

}
