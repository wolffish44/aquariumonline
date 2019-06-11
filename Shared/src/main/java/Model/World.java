package Model;

import Model.PLACEABLETYPE;

import java.util.ArrayList;
import java.util.List;

public  class World
{
    public List<PLACEABLETYPE> getPlaceables() {
        return placeables;
    }

    public void setPlaceables(List<PLACEABLETYPE> placeables) {
        this.placeables = placeables;
    }

    List<PLACEABLETYPE> placeables = new ArrayList<>();


}