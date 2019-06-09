import Communication.USERCREATIONRESPONSE;

public class RestClientManager implements RestClientManagerable
{
    User user;
    ClientEndPointable clientEndPoint = new ClientEndPoint();
    @Override
    public void loginUser(String username, String password)
    {
      user=clientEndPoint.getUser(username,password);
    }
    public USERCREATIONRESPONSE createAccount(UserInfo userInfo)
    {
       return clientEndPoint.createAccount(userInfo);
    }
}
