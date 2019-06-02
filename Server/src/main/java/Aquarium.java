import Model.Aquariumable;
import Model.PlaceableObject;

import java.util.ArrayList;
import java.util.List;

public class Aquarium implements Aquariumable
{
    private int aquariumHeight;
    private int aquariumWidth;
    private List<PlaceableObject>objects=new ArrayList<>();
    private List<Fish>fishes = new ArrayList<>();
    private List<Decoration>decorations= new ArrayList<>();
    public List<PlaceableObject> getObjects()
    {
        return objects;
    }
    public Aquarium()
    {
        Fish initialFish =FishFactory.createNeonTetra();
        initialFish.place(200,200);
        initialFish.setAquarium(this);
        addFish(initialFish);
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
