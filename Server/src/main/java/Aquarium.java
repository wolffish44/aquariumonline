import java.util.List;

public class Aquarium
{
    private int aquariumHeight;
    private int aquariumWidth;
    private List<PlaceableObject>objects;
    private List<Fish>fishes;
    private List<Decoration>decorations;
    public List<PlaceableObject> getObjects()
    {
        return objects;
    }
    public void addFish(Fish fish)
    {
        objects.add(fish);
        fishes.add(fish);
    }
    public void addDecoration(Decoration decoration)
    {

    }
    public List<Fish> getFishes() {
        return fishes;
    }
}
