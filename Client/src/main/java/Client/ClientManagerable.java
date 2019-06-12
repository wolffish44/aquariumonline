package Client;

import Model.Aquariumable;

public interface ClientManagerable
{
    public void updateAquarium(Aquariumable aquariumable);

    void dropFood(int xposition);
}
