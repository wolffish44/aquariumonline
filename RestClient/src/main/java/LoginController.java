import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        String test="x";
    }

    public void onLoginButtonPressed(ActionEvent actionEvent)
    {
        loginUser();
    }

    public void onCreateAccountButtonPressed(ActionEvent actionEvent)
    {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateAccountScene.fxml"));
            Stage stage = (Stage) usernameBox.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
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
}
