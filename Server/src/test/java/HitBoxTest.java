import Logic.Fish;
import Model.HitBox;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HitBoxTest {

    @Test
    public void testCollisionTrue()
    {
        Fish fish=new Fish("Neon Tetra",3);
        fish.place(40,40);
        fish.setDimensions(10,10);
        Fish secondFish=new Fish("Neon Tetra",3);
        secondFish.place(40,40);
        secondFish.setDimensions(11,10);
        Boolean actualFishesCollided = fish.collidesWith(secondFish);
        Boolean expectedFishesCollided = true;
        assertEquals(expectedFishesCollided,actualFishesCollided);

    }
    @Test
    public void testCollisionFalse()
    {
        Fish fish=new Fish("Neon Tetra",3);
        fish.place(40,40);
        fish.setDimensions(10,10);
        Fish secondFish=new Fish("Neon Tetra",3);
        secondFish.place(51,51);
        secondFish.setDimensions(10,10);
        Boolean actualFishesCollided = fish.collidesWith(secondFish);
        Boolean expectedFishesCollided = false;
        assertEquals(expectedFishesCollided,actualFishesCollided);

    }
    @Test
    public void testHitBox()
    {
        HitBox hitBox = new HitBox(0,0,30,700);
        Fish maanvis = new Fish("neon",4);
        maanvis.place(200,200);
        maanvis.setDimensions(32,32);
        assertFalse(hitBox.collidesWith(maanvis.getHitbox()));
    }
    @Test
    public void testHitBoxTrue()
    {
        HitBox hitBox = new HitBox(0,0,30,700);
        Fish maanvis = new Fish("neon",4);
        maanvis.place(0,15);
        maanvis.setDimensions(32,32);
        HitBox maanvisHitBox =maanvis.getHitbox();
        assertTrue(hitBox.collidesWith(maanvisHitBox));
    }
}