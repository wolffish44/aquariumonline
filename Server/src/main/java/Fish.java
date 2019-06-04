import Model.PlaceableObject;

public class Fish extends PlaceableObject
{
    public transient String name;
    public transient int speed;
    public  transient String speciesName;
    public transient Aquarium aquarium;
    private transient FishMovement fishMovement;
    public Fish(String speciesName,int speed)
    {
        this.speciesName=speciesName;
        this.speed=speed;
    }
    public void setAquarium(Aquarium aquarium)
    {
        this.aquarium=aquarium;
        fishMovement = new FishMovement(this);
    }
    public void setDimensions(int width,int length)
    {
        this.width=width;
        this.length=length;
    }
    public void swim()
    {
        if(aquarium==null)
            throw new IllegalStateException();
       this.orientation= fishMovement.swim();
    }
    public void spawn()
    {
        swim();
    }
}
