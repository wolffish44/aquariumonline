import Communication.USERCREATIONRESPONSE;

public interface RestClientManagerable
{
    void loginUser(String username,String password);
    USERCREATIONRESPONSE createAccount(UserInfo Userinfo);

}
