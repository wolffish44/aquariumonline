import Model.Aquariumable;
import Model.ClientAquarium;
import Model.PLACEABLETYPE;
import Model.PlaceableObject;

import javax.ws.rs.client.Client;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aquarium implements Aquariumable
{
    public List<Decoration> getDecorations() {
        return decorations;
    }
    private int aquariumHeight;
    private int aquariumWidth;
    private List<PlaceableObject>objects=new ArrayList<>();
    private transient List<Fish>fishes = new ArrayList<>();
    private List<Decoration>decorations= new ArrayList<>();
    private transient Random random = new Random();
    public List<PlaceableObject> getObjects()
    {
        return objects;
    }
    public Aquarium()
    {
        this.aquariumWidth=700;
        this.aquariumHeight=500;
        createBorders();
        int amountOfFishToSpawn =7;
        int amountOfFishSpawned=0;
        while(amountOfFishSpawned<amountOfFishToSpawn)
        {
            Fish newFish =FishFactory.createNeonTetra();
            spawnFish(newFish);
            amountOfFishSpawned++;
        }
        Fish newFish =FishFactory.createAngelFish();
        spawnFish(newFish);
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
    public void spawnFish(Fish fish)
    {

        int xLocation = random.nextInt(aquariumWidth);
        int yLocation = random.nextInt(aquariumHeight-fish.length);
        fish.place(xLocation,yLocation);
        while(!canSpawn(fish))
        {
            xLocation = random.nextInt(aquariumWidth);
            fish.place(xLocation, yLocation);
        }
        fish.setAquarium(this);
        addFish(fish);
    }
    public boolean canSpawn(Fish fish)
    {
        for (PlaceableObject object : objects)
        {
            if(fish.collidesWith(object))
            {
                return false;
            }
        }
        return true;
    }
    public int getHeight()
    {
        return aquariumHeight;
    }
    public int getWidth()
    {
        return  aquariumWidth;
    }
}
