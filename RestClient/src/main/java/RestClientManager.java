import Communication.USERCREATIONRESPONSE;

public class RestClientManager implements RestClientManagerable
{
    User user;
    ClientEndPointable clientEndPoint = new ClientEndPoint();
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
