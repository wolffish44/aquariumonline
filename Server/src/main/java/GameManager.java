import Model.PlaceableObject;

import java.util.List;

public class GameManager
{
    int frameSpeed = 20;
    Aquarium aquarium = new Aquarium();
    ServerEndPointable serverEndPointable = new ServerEndPoint();
    public GameManager()
    {
      //  this.serverEndPointable= serverEndPointable;
        startGame();
    }
    public void startGame()
    {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Started new game thread");
            startUpdatingGame();
        };
        Thread thread = new Thread(task);
        thread.start();
    }
    public void startUpdatingGame()
    {
        while(true) {
            if (System.currentTimeMillis() % 1000 == 0) {
                moveFishes();
            }
        }

    }
    private void moveFishes()
    {
        for (Fish fish:aquarium.getFishes())
        {
            fish.swim();
        }
        serverEndPointable.updateAquarium(aquarium.toClientAquarium());
    }
}
