import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
@Path("/RestServer")
public class RestServerEndPoint
{
    Gson gson = new Gson();
    Databaseable database;
    public RestServerEndPoint()
    {
        database=new JavaDatabase();
    }
    @Path("/TestUser")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String returnUser()
    {
        User dummyUser = new User();
        dummyUser.setId(1);
        dummyUser.setUsername("example username");
        dummyUser.setPassword("example password");
        String result =gson.toJson(dummyUser);
        return result;
    }
    @Path("/GetUser/{userID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(@PathParam("userID") int userID)
    {
      User userFromDatabase= database.getUser(userID);
      String result=  gson.toJson(userFromDatabase);
      return result;
    }
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User user)
    {
        database.storeUser(user);
        return Response.status(200).entity(gson.toJson(user)).build();
    }
}
