import Communication.DIRECTION;

import java.util.Random;

public abstract class FishMovement
{
    Aquarium aquarium;
    Fish fish;
    public FishMovement(Fish fish)
    {
        this.aquarium=fish.aquarium;
        this.fish=fish;
    }
    public abstract DIRECTION swim();

}
