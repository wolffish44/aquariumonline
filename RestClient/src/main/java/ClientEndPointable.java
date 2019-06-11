import Communication.USERCREATIONRESPONSE;

public interface ClientEndPointable
{
     User loginUser(String username,String password);
     USERCREATIONRESPONSE createAccount(UserInfo Userinfo);
}
