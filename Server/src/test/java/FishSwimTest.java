import Logic.Aquarium;
import Logic.Fish;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class FishSwimTest
{
    Fish fish = new Fish("Neon Tetra",10);
    Aquarium aquarium = new Aquarium();
    @Test
    public void testSwim()
    {
        fish.setAquarium(aquarium);
        fish.place(100,100);
        fish.swim();
       assertEquals(104,fish.getX());
    }

}
