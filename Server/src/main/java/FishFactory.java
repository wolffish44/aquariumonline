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
}
