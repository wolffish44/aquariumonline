package Server;

import Game.GameManager;
import Model.ClientAquarium;

public interface ServerEndPointable
{
    public void updateAquarium(ClientAquarium aquarium);
     void setManager( GameManager manager);

}
