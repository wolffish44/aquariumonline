package DAL;

import Communication.USERCREATIONRESPONSE;
import Model.World;
import Users.User;
import Users.UserInfo;

public interface Databaseable
{
     USERCREATIONRESPONSE createUser(UserInfo user);
     void updateUser(User user);
     User getUser(UserInfo username);
     World getWorld(int id);
}
