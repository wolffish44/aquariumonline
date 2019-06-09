public class RestClientManager implements RestClientManagerable
{
    User user;
    ClientEndPointable clientEndPoint = new ClientEndPoint();
    @Override
    public void loginUser(String username, String password)
    {
      user=clientEndPoint.getUser(username,password);
    }
}
