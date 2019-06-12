package Communication;

import Client.ClientManager;
import Client.ClientManagerable;
import Model.Aquariumable;
import Model.ClientAquarium;
import Model.PlaceableObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import javax.websocket.*;
import javax.ws.rs.client.Client;
import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@ClientEndpoint
public class ClientEndPoint implements ClientEndPointable
{
    public Gson gson = new Gson();
    ClientManagerable clientManager ;
    ObjectMapper mapper = new ObjectMapper();
    private Session serverSession;
    ClientAquarium aquarium = new ClientAquarium();
    public ClientEndPoint(ClientManager clientManagerable)
    {
        clientManager=clientManagerable;
    }
        public  void startClient() {
            System.out.println("[WebSocket Client start]");
            try {
                WebSocketContainer container = ContainerProvider.getWebSocketContainer();
                serverSession =container.connectToServer(this, new URI("ws://localhost:10/game/"));

            } catch (Exception e) {
                System.out.println("Failed to connect to server...");
                e.printStackTrace();
            }
        }
        @OnMessage
        public void msgReceived(String message) throws Exception
        {
            System.out.println(message);
           ServerResponse response = mapper.readValue(message,ServerResponse.class);
           executeMessage(response);
        }
        public void executeMessage(ServerResponse response)
        {

            switch (response.getServerResponseType())
            {
                case SUCCESSFUL_CONNECT:
                    break;
                case AQUARIUMUPDATE:
                    ClientAquarium aquarium;
                    try {
                        LinkedHashMap<String,Object> objectTree= (LinkedHashMap<String,Object>)response.getParameter();
                        updateClientAquarium(objectTree);
                    }catch (Exception e)
                    {
                        aquarium=null;
                        e.printStackTrace();
                    }
                   // aquarium.getObjects();
                    break;
            }
        }
        public void updateClientAquarium(LinkedHashMap<String,Object> objectTree)
        {

           int aquariumHeight = (Integer)objectTree.get("aquariumHeight");
           int aquariumWidth = (Integer)objectTree.get("aquariumWidth");
           List<PlaceableObject> placeableObjects = new ArrayList<>();
            for(LinkedHashMap lhm: (List<LinkedHashMap>)objectTree.get("objects"))
            {
                PlaceableObject object;
                object= mapper.convertValue(lhm,PlaceableObject.class);
                placeableObjects.add(object);
            }
            aquarium.setObjects(placeableObjects);
            aquarium.setAquariumHeight(aquariumHeight);
            aquarium.setAquariumWidth(aquariumWidth);
            clientManager.updateAquarium(aquarium);
        }
        public void sendDropFoodRequest(int xLocation)
        {
            ClientResponse response = new ClientResponse();
            response.setClientResponseType(CLIENTRESPONSETYPE.place_food);
            response.setParameter(new Integer(xLocation));
            String messageToJson =gson.toJson(response);
            serverSession.getAsyncRemote().sendText(messageToJson);
        }


}
