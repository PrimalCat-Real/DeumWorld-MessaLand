/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deumworld.components.ModElement;

import deumworld.components.ToggleSwitch.ToggleSwitch;
import deumworld.models.ModListModel;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author PrimalCat
 */
public class ModElement extends BorderPane{

    public ModElement(String name, ModListModel model) {
        setLeft(new Label(name));
        setWidth(500);
        setHeight(40);
        setMinHeight(40);
        ToggleSwitch switcher = new ToggleSwitch(model, name);
        setRight(switcher);
    
    }
    
}
