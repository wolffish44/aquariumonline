package Client;

import Communication.AquariumControllable;
import Model.PlaceableObject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

import java.util.List;


public class AquariumController implements AquariumControllable {
    ClientManagerable clientManager;
    @FXML
    public Button ShopButton;
    @FXML
    public Canvas aquariumCanvas;
    final GraphicsContext graphicsContext ;
    public AquariumController()
    {
        clientManager=new ClientManager(this);
        graphicsContext= aquariumCanvas.getGraphicsContext2D();
    }
    public void onShopButtonPressed(ActionEvent actionEvent) {
    }
    public void updateObjects(List<PlaceableObject> objects)
    {
        for (PlaceableObject object :objects)
        {
            graphicsContext.drawImage(getImage(),object.xLocation,object.yLocation);
        }
    }
    public Image getImage()
    {
        Image img = new Image("neonTetra.png");
        return img;
    }
}
