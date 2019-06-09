import Communication.USERCREATIONRESPONSE;

public interface ClientEndPointable
{
     User getUser(String username,String password);
     USERCREATIONRESPONSE createAccount(UserInfo Userinfo);
}
