package Client;

import Communication.AquariumControllable;
import Model.PlaceableObject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.List;


public class AquariumController implements AquariumControllable {
    ClientManagerable clientManager;
    @FXML
    Button ShopButton;
    public AquariumController()
    {
        clientManager=new ClientManager(this);
    }
    public void onShopButtonPressed(ActionEvent actionEvent) {
    }
    public void updateObjects(List<PlaceableObject> objects)
    {

    }
}
