import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RestController implements Initializable
{
    RestClientManager manager = new RestClientManager();

    @FXML
    TextField usernameBox;
    @FXML
    PasswordField passwordBox;
    @FXML
    Button loginButton;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void loginUser()
    {
        String username = usernameBox.getText();
        String password = passwordBox.getText();
        manager.loginUser(username,password);
    }

    public void onLoginButtonPressed(ActionEvent actionEvent)
    {
        loginUser();
    }
}
