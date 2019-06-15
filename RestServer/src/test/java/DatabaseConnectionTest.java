import Communication.USERCREATIONRESPONSE;
import DAL.DatabaseConnection;
import DAL.MsDatabase;
import Users.User;
import Users.UserInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest
{
    @Test
    public void testDatabaseConnection()
    {
        DatabaseConnection connection = new DatabaseConnection();
        connection.connect();
    }

    @Test
    public void testMsDatabaseGetUser()
    {
        String username ="Martin";
        String password ="wachtwoord";
        MsDatabase db = new MsDatabase();
        UserInfo userInfo = new UserInfo();
        userInfo.setPassword(password);
        userInfo.setUsername(username);
       User result =db.getUser(userInfo);
        assertEquals(username,result.getUsername());
    }
    @Test
    public void testMsDatabaseCreateUser()
    {
        String username ="Keesje";
        String password ="wachtwoord";
        MsDatabase db = new MsDatabase();
        UserInfo userInfo = new UserInfo();
        userInfo.setPassword(password);
        userInfo.setUsername(username);
        USERCREATIONRESPONSE userCreationResponse=db.createUser(userInfo);
        assertEquals(USERCREATIONRESPONSE.SUCCESSFUL,userCreationResponse);
    }
}