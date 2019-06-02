package Communication;

import Client.ClientManager;
import Client.ClientManagerable;
import Model.Aquariumable;
import Model.ClientAquarium;
import com.google.gson.Gson;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnMessage;
import javax.websocket.WebSocketContainer;
import javax.ws.rs.client.Client;
import java.net.URI;

@ClientEndpoint
public class ClientEndPoint implements ClientEndPointable
{
    public Gson gson = new Gson();
    ClientManagerable clientManager ;
    public ClientEndPoint(ClientManager clientManagerable)
    {
        clientManager=clientManagerable;
    }
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
            System.out.println(message);
           ServerResponse response = gson.fromJson(message,ServerResponse.class);
           executeMessage(response);
        }
        public void executeMessage(ServerResponse response)
        {

            switch (response.getServerResponseType())
            {
                case AQUARIUMUPDATE:
                  //   ClientAquarium aquarium= gson.fromJson(response.getParameter(),ClientAquarium.class);
                   // clientManager.updateAquarium(aquarium);
                    break;
            }
        }



}
