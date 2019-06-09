import Communication.USERCREATIONRESPONSE;
import com.google.gson.Gson;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ClientEndPoint implements ClientEndPointable
{
    Gson gson = new Gson();
    String restServerUrl ="http://localhost:11/RestServer";
    String addFragment ="/add/";
    ResteasyClient client = new ResteasyClientBuilder().build();
    public User getTestUser()
    {
            String response = executeGetRequest(restServerUrl+"/TestUser");
            User generatedUser =gson.fromJson(response,User.class);
            return generatedUser;

    }

    public String executeGetRequest(String urlString)
    {
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            String response=  readResponse(con);
            return response;
        }catch (Exception e)
        {
            System.out.println(e.getStackTrace().toString());
            throw new NullPointerException();
        }
    }

    public USERCREATIONRESPONSE postUser(UserInfo userInfo)
    {
        WebTarget webTarget = client.target(restServerUrl+"/").path("add");
        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(userInfo, MediaType.APPLICATION_JSON));
        USERCREATIONRESPONSE generatedResponse =response.readEntity(USERCREATIONRESPONSE.class);
        return generatedResponse;
    }



    public String readResponse( HttpURLConnection con)
    {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return content.toString();
        }
        catch (Exception e)
        {
            return "error";
        }
    }

    @Override
    public User getUser(String username, String password) {
        return null;
    }

    @Override
    public USERCREATIONRESPONSE createAccount(UserInfo Userinfo) {
        return postUser(Userinfo);
    }
}
