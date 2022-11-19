package deumworld.controllers;

import animatefx.animation.FadeInUp;
import static deumworld.Main.iconsPath;

import deumworld.Main;
import deumworld.controllers.SceneController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 *
 * @author PrimalCat
 */
public class DashboardController implements Initializable{
    
    private boolean animationActive = false;
    private boolean isMenuExpanded = false;
    
    @FXML public ImageView dashboardBtn;
    @FXML public ImageView logoutBtn;
    @FXML public ImageView modsBtn;
    @FXML public ImageView settingsBtn;
    
    @FXML public Pane secondBar;
    @FXML public Pane firthBar;
    @FXML public BorderPane sideMenu;
    
    @FXML public VBox mainBlock;
    private ScrollPane servers;
    private BorderPane modlist;
    private static ResourceBundle language;
    private static SceneController screenController;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Created");
        System.out.println(servers + " servers");
        try {
            modlist = FXMLLoader.load(getClass().getResource("/deumworld/components/ModList/ModList.fxml"));
            servers = FXMLLoader.load(getClass().getResource("/deumworld/components/Servers/Servers.fxml"));
            new FadeInUp(servers).play();
            mainBlock.getChildren().add(servers);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            // TODO
//            servers = FXMLLoader.load(getClass().getResource("components/Servers/Servers.fxml"));
//
////            modlist = FXMLLoader.load(getClass().getResource("/deumworld/components/ModList/ModList.fxml"));
////            new FadeInUp(modlist).play();
////            System.out.println(modlist + " modlist");
////            mainBlock.getChildren().add(servers);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
        System.out.println(servers + " servers");
    }   
    
    public void expandSideMenu(MouseEvent event){
        
        if(isMenuExpanded){
//            sideMenu.setPrefWidth(50);
            animationActive = true;
            TranslateTransition  pt1 = new TranslateTransition (Duration.millis(500), firthBar); 
                secondBar.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #FBA16C, #FEC484);");
                firthBar.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #FBA16C, #FEC484);");
                pt1.setToY(0);
                RotateTransition rt2 = new RotateTransition(Duration.millis(500), secondBar);
                rt2.setByAngle(44);
                
                RotateTransition rt1 = new RotateTransition(Duration.millis(500), firthBar);
                rt1.setByAngle(-44);
                
                rt1.setOnFinished(e -> {animationActive = false; isMenuExpanded = false;});
                rt2.play();
                
                rt1.play();
                pt1.play();
        }else if(!animationActive){
//                sideMenu.setPrefWidth(150);
                secondBar.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #FBA16C, #FEC484);");
                firthBar.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #FBA16C, #FEC484);");
            
                animationActive = true;
                TranslateTransition  pt1 = new TranslateTransition (Duration.millis(500), firthBar); 
                pt1.setToY(9);
                RotateTransition rt2 = new RotateTransition(Duration.millis(500), secondBar);
                rt2.setByAngle(-44);
                
                RotateTransition rt1 = new RotateTransition(Duration.millis(500), firthBar);
                rt1.setByAngle(44);
                
                rt1.setOnFinished(e -> {animationActive = false; isMenuExpanded = true;});
                
                rt2.play();
                rt1.play();
                pt1.play();
                
        }
        
        
    }
    
    public void logOut(MouseEvent event) throws IOException{
        language = ResourceBundle.getBundle("deumworld/lang/login");
        Parent root_main = FXMLLoader.load(Main.loginRoot,language);
        Scene scene = new Scene(root_main);
        screenController = Main.getScreenController();
        screenController.setScene(scene);
    }
    
    public void makeBarsActive(MouseEvent event){
        secondBar.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #FBA16C, #FEC484);");
        firthBar.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #FBA16C, #FEC484);");
    }
    public void makeBarsUnActive(MouseEvent event){
        secondBar.setStyle("-fx-background-color: #DEE0E4;");
        firthBar.setStyle("-fx-background-color: #DEE0E4;");
    }
    
    public void makeActiveLogoutBtn(MouseEvent event){
        logoutBtn.setImage(new Image(iconsPath + "Logout.png"));
        
    }
    public void makeUnActiveLogoutBtn(MouseEvent event){
        logoutBtn.setImage(new Image(iconsPath + "LogoutDeff.png"));
    }
    
    public void makeActiveSettingsBtn(MouseEvent event){
        settingsBtn.setImage(new Image(iconsPath + "Settings.png"));
    }
    public void makeUnActiveSettingsBtn(MouseEvent event){
         settingsBtn.setImage(new Image(iconsPath + "SettingsDeff.png"));
    }
    public void makeActiveModsBtn(MouseEvent event){
        modsBtn.setImage(new Image(iconsPath + "Mods.png"));
    }
    public void makeUnActiveModsBtn(MouseEvent event){
        modsBtn.setImage(new Image(iconsPath + "ModsDeff.png"));
    }
    public void makeActiveDashboardBtn(MouseEvent event){
        dashboardBtn.setImage(new Image(iconsPath + "Dassboard.png"));
    }
    public void makeUnActiveDashboardBtn(MouseEvent event){
        dashboardBtn.setImage(new Image(iconsPath + "DassboardDeff.png"));
    }
    
    public void openMods(){
        mainBlock.getChildren().remove(2);
        new FadeInUp(modlist).play();
        mainBlock.getChildren().add(modlist);
    }
    
    public void openServers(){
        System.out.println(mainBlock.getChildren().get(1));
        mainBlock.getChildren().remove(2);
        new FadeInUp(servers).play();
        mainBlock.getChildren().add(servers);
    }
    
}
