import Model.PlaceableObject;

import java.util.List;

public class GameManager
{
    int frameSpeed = 20;
    Aquarium aquarium = new Aquarium();
    ServerEndPointable serverEndPointable;
    public GameManager(ServerEndPointable serverEndPointable)
    {
        this.serverEndPointable= serverEndPointable;
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
            if (System.currentTimeMillis() % 20 == 0) {
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
        List<PlaceableObject>objects = aquarium.getObjects();
        serverEndPointable.updateAquariumObjects(objects);
    }
}
