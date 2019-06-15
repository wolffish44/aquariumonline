package LoginClient;

import Communication.USERCREATIONRESPONSE;
import Users.User;
import Users.UserInfo;

public interface RestClientEndPointable
{
     User loginUser(String username, String password);
     USERCREATIONRESPONSE createAccount(UserInfo Userinfo);
}
