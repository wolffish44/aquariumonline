public class GameManager
{
    int frameSpeed = 20;
    Aquarium aquarium;
    public void updateGame()
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
    }
}
