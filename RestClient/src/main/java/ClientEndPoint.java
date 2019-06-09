import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClientEndPoint implements ClientEndPointable
{
    Gson gson = new Gson();
    String restServerUrl ="http://localhost:11/RestServer";
    String addFragment ="/add/";
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
    public String executePostRequest(String urlString)
    {
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            String response=  readResponse(con);
            return response;
        }catch (Exception e)
        {
            System.out.println(e.getStackTrace().toString());
            throw new NullPointerException();
        }
    }
    public void postUser(User user)
    {
        String jsonUser =gson.toJson(user);
        String resultUrl =restServerUrl+addFragment+jsonUser;
        String result =executePostRequest(resultUrl);
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
            return "";
        }
    }

    @Override
    public User getUser(String username, String password) {
        return null;
    }
}
