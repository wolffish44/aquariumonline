package Server;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import Communication.USERCREATIONRESPONSE;
import DAL.Databaseable;
import DAL.MsDatabase;
import Model.World;
import Users.User;
import Users.UserInfo;
import com.google.gson.Gson;
@Path("/RestServer")
public class RestServerEndPoint
{
    Gson gson = new Gson();
    Databaseable database=new MsDatabase();
    public RestServerEndPoint()
    {

    }
    @Path("/TestUser")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String returnUser()
    {
        User dummyUser = new User();
        dummyUser.setScore(1);
        dummyUser.setUsername("example username");
        dummyUser.setPassword("example password");
        String result =gson.toJson(dummyUser);
        return result;
    }
    @Path("/GetUser/{userID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(@PathParam("userName") String userName)
    {
      //Users.User userFromDatabase= database.getUser(userName);
     // String result=  gson.toJson(userFromDatabase);
      return null;
    }
    @Path("/GetWorld/{worldID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getWorlds(@PathParam("worldID") int userID)
    {
        World worldFromDatabase= database.getWorld(userID);
        String result=  gson.toJson(worldFromDatabase);
        return result;
    }
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public USERCREATIONRESPONSE addUser(UserInfo userInfo)
    {
        USERCREATIONRESPONSE userCreationResponse =database.createUser(userInfo);
        return userCreationResponse;
    }
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User loginUser(UserInfo userInfo)
    {
        User userCreationResponse =database.getUser(userInfo);
        return userCreationResponse;
    }
}
