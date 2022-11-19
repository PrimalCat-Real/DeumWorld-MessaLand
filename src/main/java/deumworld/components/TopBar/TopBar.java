/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deumworld.components.TopBar;

//import animatefx.animation.FadeOut;
import deumworld.Main;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static deumworld.Main.iconsPath;
import deumworld.models.URLReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author PrimalCat
 */
public class TopBar implements Initializable{
    @FXML
    public ImageView closeBtn;
    @FXML public ImageView expandBtn;
    @FXML public ImageView minBtn;
    @FXML private static BorderPane topBarPanel;
    private static double xOffset = 0;
    private static double yOffset = 0;
    

    public void closeWindow(MouseEvent event) {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
        URLReader.stopNewThread();
//        System.out.println(Main.getIconsPath());
    }

    public void makeCloseActive(MouseEvent event) {
        closeBtn.setImage(new Image(iconsPath + "Close.png"));
    }

    public void makeCloseUnActive(MouseEvent event) {
        closeBtn.setImage(new Image(iconsPath + "CloseDeff.png"));

    }
    
    public void expandWindow(MouseEvent event) {
        Stage stage = (Stage) expandBtn.getScene().getWindow();
        if(stage.isMaximized()){
            stage.setMaximized(false);
        }else{
            stage.setMaximized(true);
        }
    }
    
    public void makeExpandActive(MouseEvent event) {
        expandBtn.setImage(new Image(iconsPath + "Expand.png"));
    }

    

    public void makeExpandUnActive(MouseEvent event) {
        expandBtn.setImage(new Image(iconsPath + "ExpandDeff.png"));
    }

    public void minimazeWindow(MouseEvent event) {
        Stage obj = (Stage) minBtn.getScene().getWindow();
        obj.setIconified(true);
    }

    public void makeMinActive(MouseEvent event) {
        
//        new FadeIn(minBtn).play();
        minBtn.setImage(new Image(iconsPath + "Min.png"));
        
    }

    public void makeMinUnActive(MouseEvent event) {

//        new FadeIn(minBtn).play();
        minBtn.setImage(new Image(iconsPath + "MinDeff.png"));
        
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        new MakeMoveStage().makeMove(topBarPanel.getScene(), Main.getStage());
    }
}
