package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public  class PlaceableObject
{

     public int xLocation;
     public int yLocation;
     public int width;
     public int length;
    PLACEABLETYPE placeabletype;
    public void place(int x,int y)
    {
        this.xLocation=x;
        this.yLocation=y;
    }
    public int getSize()
    {
        return width*length;
    }
    public int getX()
    {
        return xLocation;
    }
    public int getY()
    {
        return yLocation;
    }
    public boolean collidesWith(PlaceableObject other)
    {
        HitBox thisHitbox =this.getHitbox();
        HitBox otherHitbox=other.getHitbox();
        boolean collided=thisHitbox.collidesWith(otherHitbox);
        return collided;
    }
    public HitBox getHitbox()
    {
        return new HitBox(xLocation,yLocation,width,length);
    }
    public PLACEABLETYPE getPlaceabletype() {
        return placeabletype;
    }

    public void setPlaceabletype(PLACEABLETYPE placeabletype) {
        this.placeabletype = placeabletype;
    }

}
