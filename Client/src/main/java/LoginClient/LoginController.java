package LoginClient;

import Users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable
{
    RestClientManager manager = new RestClientManager();
    User currentUser;
    @FXML
    TextField usernameBox;
    @FXML
    PasswordField passwordBox;
    @FXML
    Button loginButton;
    @FXML
    Text loginFeedbackLabel;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void loginUser()
    {
        String username = usernameBox.getText();
        String password = passwordBox.getText();
        currentUser =  manager.loginUser(username,password);
        showLoginInfo();
    }

    public void onLoginButtonPressed(ActionEvent actionEvent)
    {
        loginUser();
        if(currentUser.getUsername().length()>1)
        {
            UserManager.currentUser=currentUser;
            loadScene("/aquarium.fxml");
        }
    }

    public void onCreateAccountButtonPressed(ActionEvent actionEvent)
    {
        loadScene("/CreateAccountScene.fxml");
    }
    public void showLoginInfo()
    {
        if(currentUser!=null)
        {
            loginFeedbackLabel.setText("logged in successfully with username "+currentUser.getUsername());
        }
        else
            {
                loginFeedbackLabel.setText("password/username incorrect!");
            }
    }
    public void loadScene(String name)
    {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(name));
            Stage stage = (Stage) usernameBox.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}
