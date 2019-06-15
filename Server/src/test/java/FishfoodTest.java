import Logic.Aquarium;
import Logic.Fish;
import Logic.FishFactory;
import Logic.Food;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class FishfoodTest
{
    @Test
    public void testFallIsOkay()
    {
        Aquarium aquarium = new Aquarium();
        Food food = new Food(aquarium);
        food.place(200,200);
        food.fall();
        int expectedYOfFood = 202;
        assertEquals(expectedYOfFood,food.getY());
    }
    public void testFallOnTopOfFishOkay()
    {
        Aquarium aquarium = new Aquarium();
        Fish neon = FishFactory.createNeonTetra();
        neon.place(200,200-neon.getSize());
        Food food = new Food(aquarium);
        food.place(200,200);
        food.fall();
        int expectedYOfFood = 202;
        assertEquals(expectedYOfFood,food.getY());
    }

}
