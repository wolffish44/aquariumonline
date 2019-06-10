import Communication.USERCREATIONRESPONSE;

public interface RestClientManagerable
{
    User loginUser(String username, String password);
    USERCREATIONRESPONSE createAccount(UserInfo Userinfo);

}
