package LoginClient;

import Communication.USERCREATIONRESPONSE;
import Users.UserInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateAccountController implements Initializable
{
    RestClientManager manager = new RestClientManager();

    @FXML
    TextField usernameBox;
    @FXML
    PasswordField passwordBox;
    @FXML
    PasswordField passwordBoxConfirm;
    @FXML
    Button loginButton;
    @FXML
    Label accountCreationResponseLabel;
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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginScene.fxml"));
            Stage stage = (Stage) usernameBox.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }

    public void onCreateAccountButtonPressed(ActionEvent actionEvent)
    {
        if(passwordInputIsCorrect())
        {
            UserInfo userInfo = generateUserInfo();
          USERCREATIONRESPONSE response = manager.createAccount(userInfo);
          showResponse(response);

        }
        else
            {
                showIncorrectPassword();
            }
    }
    public boolean passwordInputIsCorrect()
    {
        if(passwordBox.getText().equals(passwordBoxConfirm.getText()))
        {
            return true;
        }
        return false;
    }
    public void showIncorrectPassword()
    {
        accountCreationResponseLabel.setText("Passwords do not match.");
    }
    public void showResponse(USERCREATIONRESPONSE response)
    {
        switch (response)
        {
            case SUCCESSFUL:
                accountCreationResponseLabel.setText("Successfully created account!");
               break;
            case UNSUCCESSFUl:
                accountCreationResponseLabel.setText("This username is already taken.");
        }
    }
    public UserInfo generateUserInfo()
    {
        UserInfo userInfo = new UserInfo();
        String username = usernameBox.getText();
        String password = passwordBox.getText();
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        return userInfo;
    }
}
