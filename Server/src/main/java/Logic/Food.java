package Logic;

import Model.PLACEABLETYPE;
import Model.PlaceableObject;

public class Food extends PlaceableObject
{
    public boolean canFall=true;
    transient Aquarium aquarium;
    int speed=2;
    public Food(Aquarium aquarium)
    {
        this.aquarium=aquarium;
        this.width=20;
        this.length=20;
        this.setPlaceabletype(PLACEABLETYPE.fish_food);
    }
    public void fall()
    {
        if(canFall)
            startFalling();
    }
    public void startFalling()
    {
        if(this.yLocation<aquarium.getAquariumHeight()-this.length)
        {
            this.yLocation=this.yLocation+speed;
        }
        for (PlaceableObject object:aquarium.getObjects())
        {
            if(this.collidesWith(object))
            {
                this.delete();
                canFall=false;
            }
        }
    }

}
