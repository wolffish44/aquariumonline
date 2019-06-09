import Communication.USERCREATIONRESPONSE;
import Model.PLACEABLETYPE;
import Model.World;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaDatabase implements Databaseable
{
    Map<String,User> userDatabase = new HashMap<String, User>();
    Map<Integer,World>worldDatabase = new HashMap<>();

    public JavaDatabase()
    {
        User user = new User();
        user.setUsername("Henk");
        user.setPassword("MijnHuisdier1");
        user.setId(2);
        storeUser(user);
        List<PLACEABLETYPE> firstWorldObjects= new ArrayList<PLACEABLETYPE>();
        firstWorldObjects.add(PLACEABLETYPE.neon_tetra);
        firstWorldObjects.add(PLACEABLETYPE.angel_fish);
        World newWorld = new World();
        newWorld.setPlaceables(firstWorldObjects);
        worldDatabase.put(0,newWorld);
    }

    public void storeUser(User user)
    {
        userDatabase.put(user.getUsername(),user);
    }

    @Override
    public USERCREATIONRESPONSE storeUser(UserInfo user)
    {
        if(userDatabase.get(user.getUsername())!=null){
            return USERCREATIONRESPONSE.UNSUCCESSFUl;
        }
        return USERCREATIONRESPONSE.SUCCESSFUL;

    }

    public User getUser(int id)
    {
        try
        {
            return userDatabase.get(id);
        }
        catch (NullPointerException e)
        {
            System.out.println("User with id "+id+" could not be found.");
            throw new NullPointerException();
        }
    }

    public World getWorld(int id)
    {
        return worldDatabase.get(id);
    }

}
