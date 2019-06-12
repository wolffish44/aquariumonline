import Model.PlaceableObject;

public class Food extends PlaceableObject
{
    public boolean canFall=true;
    Aquarium aquarium;
    public Food(Aquarium aquarium)
    {
        this.width=20;
        this.length=20;
    }
    public void fall()
    {
        if(canFall)
            startFalling();
    }
    public void startFalling()
    {
        if(this.yLocation<aquarium.getAquariumHeight())
        {
            this.yLocation=this.yLocation-1;
        }
        for (PlaceableObject object:aquarium.getObjects())
        {
            if(this.collidesWith(object))
            {
                this.xLocation=10000;
                this.yLocation=10000;
                canFall=false;
            }
        }
    }

}
