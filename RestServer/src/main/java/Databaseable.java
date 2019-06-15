import Communication.USERCREATIONRESPONSE;
import Model.World;
import Users.User;
import Users.UserInfo;

public interface Databaseable
{
     USERCREATIONRESPONSE storeUser(UserInfo user);
     User getUser(UserInfo username);
     World getWorld(int id);
}
