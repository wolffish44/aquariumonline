import Communication.DIRECTION;
import Model.PlaceableObject;

import java.util.Random;

public class FishMovement
{
    Aquarium aquarium;
    Fish fish;
    DIRECTION directionHeading = DIRECTION.right;
    Random random = new Random();
    public FishMovement(Fish fish)
    {
        this.aquarium=fish.aquarium;
        this.fish=fish;
    }
    public DIRECTION swim()
    {
        fish.place(fish.getX()+getNextPositionOffset(),fish.getY());
        if(hasCollided())
        {
            fish.place(fish.getX()-getNextPositionOffset(),fish.getY());
            switchDirection();
        }
        return directionHeading;
    }
    public void switchDirection()
    {
        if(directionHeading== DIRECTION.left)
            directionHeading= DIRECTION.right;
        else
            directionHeading= DIRECTION.left;
    }
    public int getNextPositionOffset()
    {
        int amount =fish.speed;
        if(directionHeading== DIRECTION.right)
            return amount;
        if(directionHeading== DIRECTION.left)
            return -amount;
        return 0;
    }
    private boolean hasCollided()
    {
        for (PlaceableObject object:aquarium.getObjects())
        {
            if(fish.collidesWith(object)&&!fish.getHitbox().equals(object.getHitbox()))
                return true;
        }
        return false;
    }

}
