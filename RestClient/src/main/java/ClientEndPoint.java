import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClientEndPoint
{
    Gson gson = new Gson();
    public User getTestUser()
    {
            String response = executeGetRequest("http://localhost:11/RestServer/TestUser");
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
}
