import Model.PLACEABLETYPE;

public class FishFactory
{
    public static Fish createNeonTetra()
    {
        Fish neonTetra = new Fish("Neon Tetra",4);
        neonTetra.setSize(32);
        neonTetra.setPlaceabletype(PLACEABLETYPE.neon_tetra);
        return neonTetra;
    }
}
