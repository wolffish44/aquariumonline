import java.sql.*;
public class DatabaseConnection
{

    String user ="dbi413407";
    String link ="jdbc:sqlserver://mssql.fhict.local";
    String password ="tetrasilver1";
    Connection currentConnection;
    public DatabaseConnection()
    {
        connect();
    }
    public void connect()
    {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(link,user,password);
            currentConnection=con;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }



}
