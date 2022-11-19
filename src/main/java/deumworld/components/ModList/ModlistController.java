/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deumworld.components.ModList;

import deumworld.components.Card.CardController;
import deumworld.components.ModElement.ModElement;
import deumworld.models.ModListModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;



/**
 *
 * @author PrimalCat
 */
public class ModlistController implements Initializable{
    @FXML public VBox scrollcontainer;
    private static HashMap<Integer, String> modList;
    private BorderPane bp;
    List<BorderPane> bplist = new ArrayList<>();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ModListModel model = new ModListModel();
        model.getModsList();
        modList = model.getModListMap();
        try{
            for (int i = 0; i < modList.size(); i++) {
                bplist.add(new ModElement(modList.get(i),model));
            }
            scrollcontainer.getChildren().addAll(bplist);
        }catch (Exception ex){
            System.out.println("Cannot get mods");
        }

    }
    
}
