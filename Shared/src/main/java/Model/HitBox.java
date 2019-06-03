package Model;

import java.awt.*;

public class HitBox
{
    int originX;
    int originY;
    int objectSize;
    int width;
    int length;
    private Rectangle collisionBox;
    public HitBox(int originX,int originY,int width,int length)
    {
        collisionBox=new Rectangle(originX,originY,width,length);
        this.originX=originX;
        this.originY=originY;
        this.width=width;
        this.length=length;
    }
    public boolean collidesWith(HitBox hitbox)
    {
        if(!this.equals(hitbox)) {
            if (this.getCollisionBox().intersects(hitbox.collisionBox))
                return true;
        }
        return false;
    }
    public boolean equals(Object other)
    {
        if(other instanceof  HitBox)
        {
            HitBox otherHitbox = (HitBox)other;
            if(otherHitbox.getCollisionBox().equals(collisionBox))
            return true;
        }
        return false;
    }

    public Rectangle getCollisionBox() {
        return collisionBox;
    }
}
