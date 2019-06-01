import java.util.HashMap;
import java.util.Map;

public class JavaDatabase implements Databaseable
{
    Map<Integer,User> userDatabase = new HashMap<Integer, User>();

    public JavaDatabase()
    {
        User user = new User();
        user.setUsername("Henk");
        user.setPassword("MijnHuisdier1");
        user.setId(2);
        storeUser(user);
    }
    public void storeUser(User user)
    {
        userDatabase.put(user.getId(),user);
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
}
