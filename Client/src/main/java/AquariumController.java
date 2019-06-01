import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class AquariumController {
    ClientManagerable clientManager;
    @FXML
    Button ShopButton;
    public AquariumController()
    {
        clientManager=new ClientManager();
    }
    public void onShopButtonPressed(ActionEvent actionEvent) {
    }
}
