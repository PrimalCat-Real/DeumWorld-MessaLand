/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deumworld.components.Card;

import static deumworld.Main.iconsPath;
import deumworld.components.Rings.RingProgresBar;
//import deumworld.components.Rings.RingProgressIndicator;
import deumworld.models.Configs;
import deumworld.models.LaunchGameModel;
import deumworld.models.URLReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;



/**
 *
 * @author PrimalCat
 */
public class CardController implements Initializable{

    private static boolean isDownloaded;

    public static boolean isIsDownloaded() {
        return isDownloaded;
    }

    private RingProgresBar rpb = new RingProgresBar();
    @FXML public ImageView mainBtn;
    @FXML public BorderPane buttonBack;
    @FXML public BorderPane cardBack;
    private URLReader urlr = new URLReader(this);
    
    public void startGame() throws IOException, InterruptedException{
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                 if(!isDownloaded){
                    cardBack.getChildren().remove(buttonBack);
                    cardBack.setCenter(rpb);
                    if(cardBack.getCenter().equals(rpb)){
                        try {
                            urlr.copyURLToFile(rpb, buttonBack, cardBack);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
            
                }else{
                     try {
                         new LaunchGameModel().startGame("messaland");
                     } catch (IOException ex) {
                         ex.printStackTrace();
                     } catch (InterruptedException ex) {
                         ex.printStackTrace();
                     }
                }
            }
        });
    }
    public void makePlayButton(){
        isDownloaded = Boolean.parseBoolean(Configs.getIsDownloaded().toString());
        cardBack.getChildren().remove(rpb);
        cardBack.setCenter(buttonBack);
//        System.out.println(isDownloaded);
        if(isDownloaded){
            mainBtn.setImage(new Image(iconsPath + "playIconDeff.png"));
        }else{
            mainBtn.setImage(new Image(iconsPath + "DownloadDeff.png"));
        }
    }
    
    public void enterButton(){
        if(isDownloaded){
            mainBtn.setImage(new Image(iconsPath + "playIcon.png"));
        }else{
            mainBtn.setImage(new Image(iconsPath + "Download.png"));
        }
        
    }
    public void exitButton(){
        if(isDownloaded){
            mainBtn.setImage(new Image(iconsPath + "playIconDeff.png"));
        }else{
            mainBtn.setImage(new Image(iconsPath + "DownloadDeff.png"));
        }
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        isDownloaded = Boolean.parseBoolean(Configs.getIsDownloaded().toString());
        if(isDownloaded){
            mainBtn.setImage(new Image(iconsPath + "playIconDeff.png"));
        } else {
            mainBtn.setImage(new Image(iconsPath + "DownloadDeff.png"));
        }
    }

    
}
