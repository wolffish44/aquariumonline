package DAL;

import Communication.USERCREATIONRESPONSE;
import Model.World;
import Users.User;
import Users.UserInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MsDatabase implements Databaseable
{
    Connection currentConnection;
    public  MsDatabase()
    {
        DatabaseConnection connection = new DatabaseConnection();
       this.currentConnection= connection.currentConnection;
    }

    @Override
    public USERCREATIONRESPONSE createUser(UserInfo user)
    {
       if(userNameExists(user.getUsername()))
       {
           return USERCREATIONRESPONSE.UNSUCCESSFUl;
       }
       else
           {
               try {
                   Statement sqlQuery=currentConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                   sqlQuery.executeUpdate("INSERT INTO AquariumOnlineUser(username,password)" +
                           "VALUES ('"+user.getUsername()+"','"+user.getPassword()+"')");
                   return USERCREATIONRESPONSE.SUCCESSFUL;
               }

               catch (SQLException e)
               {
                   e.printStackTrace();
                   return USERCREATIONRESPONSE.UNSUCCESSFUl;
               }
           }
    }

    @Override
    public void updateUser(User user) {

    }

    public User getUser(UserInfo userInfo)
    {
        try {
            Statement sqlQuery=currentConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet =sqlQuery.executeQuery("SELECT username,score FROM dbo.AquariumOnlineUser\n" +
                    "WHERE password='"+userInfo.getPassword()+"' AND username='"+userInfo.getUsername()+"'");
            resultSet.next();
            String username = resultSet.getString("username");
            username=username.trim();
            int score = resultSet.getInt("score");
            User generatedUser = new User();
            generatedUser.setUsername(username);
            generatedUser.setScore(score);
            return generatedUser;
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public boolean userNameExists(String name)
    {
        try {
            Statement sqlQuery=currentConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet =sqlQuery.executeQuery("SELECT username FROM dbo.AquariumOnlineUser\n" +
                    "WHERE username='"+name+"'");
            resultSet.next();
            String username = resultSet.getString("username");
            return true;
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public World getWorld(int id) {
        return null;
    }
}
