import Model.PLACEABLETYPE;

public class FishFactory
{
    public static Fish createNeonTetra()
    {
        Fish neonTetra = new Fish("Neon Tetra",1);
        neonTetra.setDimensions(48,48);
        neonTetra.setPlaceabletype(PLACEABLETYPE.neon_tetra);
        return neonTetra;
    }
    public static Fish createAngelFish()
    {
        Fish angelfish = new Fish("AngelFish",1);
        angelfish.setDimensions(80,100);
        angelfish.setPlaceabletype(PLACEABLETYPE.angel_fish);
        return angelfish;
    }
}
