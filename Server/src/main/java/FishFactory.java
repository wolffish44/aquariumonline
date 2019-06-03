import Model.PLACEABLETYPE;

public class FishFactory
{
    public static Fish createNeonTetra()
    {
        Fish neonTetra = new Fish("Neon Tetra",8);
        neonTetra.setDimensions(32,32);
        neonTetra.setPlaceabletype(PLACEABLETYPE.neon_tetra);
        return neonTetra;
    }
}
