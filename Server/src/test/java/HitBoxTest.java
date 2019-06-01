import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HitBoxTest {

    @Test
    public void testCollisionTrue()
    {
        Fish fish=new Fish("Neon Tetra",3);
        fish.place(40,40);
        fish.setSize(10);
        Fish secondFish=new Fish("Neon Tetra",3);
        secondFish.place(40,40);
        secondFish.setSize(10);
        Boolean actualFishesCollided = fish.collidesWith(secondFish);
        Boolean expectedFishesCollided = true;
        assertEquals(expectedFishesCollided,actualFishesCollided);

    }
    @Test
    public void testCollisionFalse()
    {
        Fish fish=new Fish("Neon Tetra",3);
        fish.place(40,40);
        fish.setSize(10);
        Fish secondFish=new Fish("Neon Tetra",3);
        secondFish.place(51,51);
        secondFish.setSize(100);
        Boolean actualFishesCollided = fish.collidesWith(secondFish);
        Boolean expectedFishesCollided = false;
        assertEquals(expectedFishesCollided,actualFishesCollided);

    }
}