public class FishFactory
{
    public Fish createNeonTetra()
    {
        Fish neonTetra = new Fish("Neon Tetra",4);
        neonTetra.size =100;
        return neonTetra;
    }
}
