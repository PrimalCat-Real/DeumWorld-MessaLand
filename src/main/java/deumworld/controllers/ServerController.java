/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deumworld.controllers;

import deumworld.Main;
import deumworld.components.Card.CardController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 *
 * @author PrimalCat
 */
public class ServerController implements Initializable{

    
    
    @FXML public Label startText;
    @FXML public HBox serverList;
    @FXML public BorderPane cardBack;
    private static BorderPane card;
    static CardController myControllerHandle;
    private static HashMap<String,BorderPane> cards = new HashMap<String,BorderPane>();
    public static BorderPane getCard() {
        return card;
    }

    public static void setCard(String key, BorderPane card) {
            cards.put(key,card);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        System.out.println(card + " card");
        try {
            FXMLLoader loader = new FXMLLoader(Main.cardRoot);
            card = loader.load();
            setCard("MainServer", card);

            myControllerHandle = loader.getController();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

//        System.out.println(cards.size());
        for (BorderPane bp: cards.values()){
            serverList.getChildren().add(bp);
        }
        myControllerHandle.makePlayButton();
    }
    
    
}
