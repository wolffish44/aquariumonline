import Model.Aquariumable;
import Model.ClientAquarium;
import Model.PLACEABLETYPE;
import Model.PlaceableObject;

import javax.ws.rs.client.Client;
import java.util.ArrayList;
import java.util.List;

public class Aquarium implements Aquariumable
{
    private int aquariumHeight;
    private int aquariumWidth;
    private List<PlaceableObject>objects=new ArrayList<>();
    private transient List<Fish>fishes = new ArrayList<>();
    private List<Decoration>decorations= new ArrayList<>();
    public List<PlaceableObject> getObjects()
    {
        return objects;
    }
    public Aquarium()
    {
        this.aquariumWidth=700;
        this.aquariumHeight=500;
        Fish initialFish =FishFactory.createNeonTetra();
        initialFish.place(200,200);
        initialFish.setAquarium(this);
        addFish(initialFish);
        createBorders();
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

    public int getAquariumHeight() {
        return aquariumHeight;
    }

    public int getAquariumWidth() {
        return aquariumWidth;
    }
    public ClientAquarium toClientAquarium()
    {
        ClientAquarium aquarium = new ClientAquarium();
        aquarium.setObjects(objects);
        aquarium.setAquariumHeight(aquariumHeight);
        aquarium.setAquariumWidth(aquariumWidth);
        return aquarium;
    }
    public void createBorders()
    {
        int borderSize =30;

        Decoration leftBorderWall = new Decoration();
        leftBorderWall.setDimensions(borderSize,aquariumHeight);
        leftBorderWall.place(0,0);
        leftBorderWall.setPlaceabletype(PLACEABLETYPE.wall);
        Decoration rightBorderWall = new Decoration();
        rightBorderWall.setDimensions(borderSize,aquariumHeight);
        rightBorderWall.place(aquariumWidth-borderSize,0);
        rightBorderWall.setPlaceabletype(PLACEABLETYPE.wall);

        objects.add(leftBorderWall);
        objects.add(rightBorderWall);

    }
}
