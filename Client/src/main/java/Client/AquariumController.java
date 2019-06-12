package Client;

import Communication.AquariumControllable;
import Communication.DIRECTION;
import Model.PlaceableObject;
import javafx.animation.AnimationTimer;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class AquariumController implements AquariumControllable, Initializable {
    ClientManagerable clientManager;
    @FXML
    public Button ShopButton;
    @FXML
    public Canvas aquariumCanvas = new Canvas(700,500);
    @FXML
    public Pane aquariumPane;
    @FXML
    public ImageView foodBar;
     GraphicsContext graphicsContext ;
     public List<PlaceableObject> objects = new ArrayList<PlaceableObject>();
    final LongProperty lastUpdateTime = new SimpleLongProperty(0);
    public AquariumController()
    {

    }
    public void initialize(URL location, ResourceBundle resources)
    {
        aquariumPane.setStyle("-fx-background-color: #" + "00FFFF;"+"-fx-opacity: 0.3;");
        clientManager=new ClientManager(this);
        graphicsContext= aquariumCanvas.getGraphicsContext2D();
        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {

                graphicsContext.clearRect(0,0,700,500);
                for (PlaceableObject object :objects)
                {
                    graphicsContext.drawImage(getImage(object),object.xLocation,object.yLocation);
                }
            }
        }.start();
        initHover();
    }
    public void onShopButtonPressed(ActionEvent actionEvent) {
    }
    public void updateObjects(List<PlaceableObject> objects)
    {
       this.objects=objects;
    }
    public void startAnimations() {
        final AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long timestamp) {
                if (lastUpdateTime.get() > 0) {
                    long elapsedTime = timestamp - lastUpdateTime.get();

                }
                lastUpdateTime.set(timestamp);
            }
        };
        timer.start();
    }
    public Image getImage(PlaceableObject object)
    {
        Image img;
        switch (object.getPlaceabletype())
        {
            case neon_tetra:
                if(object.orientation== DIRECTION.left) {
                    img = new Image("neonTetraLeft.png", object.width, object.length, false, false);
                }
                else{
                img = new Image("neonTetraRight.png", object.width, object.length, false, false);
                }
                break;
            case angel_fish:
                if(object.orientation== DIRECTION.left) {
                    img = new Image("maanVisLeft.png", object.width, object.length, false, false);
                }
                else{
                    img = new Image("maanVisRight.png", object.width, object.length, false, false);
                }
                break;
            case wall:
                 img = new Image("wall.png",object.width,object.length,false,false);
                 break;
             default:
                 return  new Image("unknown.png",object.width,object.length,false,false);
        }

        return img;
    }
    public void initHover() {
        foodBar.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        foodBar.setImage(new Image("foodbarHover.png"));
                    }
                });

        foodBar.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        foodBar.setImage(new Image("foodbarDefault.png"));
                    }
                });
        foodBar.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        int xposition=(int)e.getX();
                        clientManager.dropFood(xposition);
                    }
                });

    }
}
