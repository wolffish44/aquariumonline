import Communication.ClientEndPoint;
import Communication.ClientEndPointable;

public class ClientManager implements ClientManagerable
{
    ClientEndPointable clientEndPointable;
    public ClientManager()
    {
        this.clientEndPointable=new ClientEndPoint();
        clientEndPointable.startClient();
    }
}
