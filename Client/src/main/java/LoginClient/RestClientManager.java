package LoginClient;

import Communication.USERCREATIONRESPONSE;
import Users.User;
import Users.UserInfo;

public class RestClientManager implements RestClientManagerable
{
    User user;
    RestClientEndPointable clientEndPoint = new RestClientEndPoint();
    @Override
    public User loginUser(String username, String password)
    {
      user=clientEndPoint.loginUser(username,password);
        return user;
    }
    public USERCREATIONRESPONSE createAccount(UserInfo userInfo)
    {
       return clientEndPoint.createAccount(userInfo);
    }
}
