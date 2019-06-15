package Logic;

import Communication.DIRECTION;

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
