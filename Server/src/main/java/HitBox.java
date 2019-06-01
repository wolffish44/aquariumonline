public class HitBox
{
    int originX;
    int originY;
    int objectSize;
    public HitBox(int originX,int originY,int objectSize)
    {
        this.originX=originX;
        this.originY=originY;
        this.objectSize=objectSize;
    }
    public boolean collidesWith(HitBox hitbox)
    {
        if(this.getLeftX()>=hitbox.getLeftX())
            if(this.getRightX()<=hitbox.getRightX())
            return true;
        if(this.getTopY()>=hitbox.getTopY())
            if(this.getBotY()>=hitbox.getBotY())
                return true;
         return false;
    }
    public int getLeftX()
    {
        return originX;
    }
    public int getRightX()
    {
        return originX+objectSize;
    }
    public int getTopY()
    {
        return originY;
    }
    public int getBotY()
    {
        return originY+objectSize;
    }
}
