package LoginClient;

import Communication.USERCREATIONRESPONSE;
import Users.User;
import Users.UserInfo;

public interface RestClientManagerable
{
    User loginUser(String username, String password);
    USERCREATIONRESPONSE createAccount(UserInfo Userinfo);

}
