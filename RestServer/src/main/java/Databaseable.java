import Communication.USERCREATIONRESPONSE;
import Model.ClientAquarium;
import Model.World;

public interface Databaseable
{
     USERCREATIONRESPONSE storeUser(UserInfo user);
     User getUser(UserInfo username);
     World getWorld(int id);
}
