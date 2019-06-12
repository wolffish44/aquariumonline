public class GameManager
{
    int frameSpeed = 20;
    Aquarium aquarium = new Aquarium();
    ServerEndPointable serverEndPointable = new ServerEndPoint();
    Thread thread;
    public boolean isUpdating =true;
    public GameManager()
    {
        serverEndPointable.setManager(this);
        startGame();
    }
    public void startGame()
    {

        thread = new Thread(task);
        thread.start();

    }
    public void startUpdatingGame()
    {
        while(isUpdating) {
            if (System.currentTimeMillis() % 70 == 0) {
                updateGame();
            }
        }

    }
    private void updateGame()
    {
        aquarium.updateObjects();
        serverEndPointable.updateAquarium(aquarium.toClientAquarium());
    }
    Runnable task = () -> {
        String threadName = Thread.currentThread().getName();
        System.out.println("Started new game thread");
        startUpdatingGame();
    };

    public void placeFood(int xLocation)
    {
        aquarium.spawnFood(xLocation);
    }
}
