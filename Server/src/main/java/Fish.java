public class Fish extends PlaceableObject
{
    public String name;
    public int speed;
    public String speciesName;
    public Aquarium aquarium;
    private FishMovement fishMovement;
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
    public void setSize(int size)
    {
        this.size=size;
    }
    public void swim()
    {
        if(aquarium==null)
            throw new IllegalStateException();
        fishMovement.swim();
    }
    public void spawn()
    {
        swim();
    }
}
