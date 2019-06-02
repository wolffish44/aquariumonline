package Model;

import java.util.ArrayList;
import java.util.List;

public class ClientAquarium implements Aquariumable
{
    private int aquariumHeight;
    private int aquariumWidth;
    private List<PlaceableObject> objects=new ArrayList<>();
    public List<PlaceableObject> getObjects()
    {
        return objects;
    }
    public void setObjects(List<PlaceableObject> objects)
    {
        this.objects=objects;
    }
    public int getAquariumHeight() {
        return aquariumHeight;
    }

    public int getAquariumWidth() {
        return aquariumWidth;
    }
    public void setAquariumWidth(int amount)
    {
        this.aquariumWidth=amount;
    }
    public void setAquariumHeight(int amount)
    {
        this.aquariumHeight=amount;
    }


}
