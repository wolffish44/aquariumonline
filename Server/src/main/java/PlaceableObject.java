public abstract class PlaceableObject
{

    private int xLocation;
    private int yLocation;
    protected int size;
    public void place(int x,int y)
    {
        this.xLocation=x;
        this.yLocation=y;
    }
    public int getSize()
    {
        return size;
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
        return new HitBox(xLocation,yLocation,size);
    }
    public abstract void spawn();

}
