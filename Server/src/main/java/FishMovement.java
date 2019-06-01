public class FishMovement
{
    Aquarium aquarium;
    Fish fish;
    Direction directionHeading = Direction.right;
    public FishMovement(Fish fish)
    {
        this.aquarium=fish.aquarium;
        this.fish=fish;
    }
    public void swim()
    {
        fish.place(fish.getX()+getNextPositionOffset(),fish.getY());
        if(hasCollided())
        {
            fish.place(fish.getX()-getNextPositionOffset(),fish.getY());
            switchDirection();
        }
    }
    public void switchDirection()
    {
        if(directionHeading==Direction.left)
            directionHeading=Direction.right;
        else
            directionHeading=Direction.left;
    }
    public int getNextPositionOffset()
    {
        int amount =fish.speed;
        if(directionHeading==Direction.right)
            return amount;
        if(directionHeading==Direction.left)
            return -amount;
        return 0;
    }
    private boolean hasCollided()
    {
        for (PlaceableObject object:aquarium.getObjects())
        {
            if(fish.collidesWith(object))
                return true;
        }
        return false;
    }
}
