/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deumworld.components.ToggleSwitch;

import deumworld.models.ModListModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
/**
 *
 * @author PrimalCat
 */
public class ToggleSwitch extends HBox{
	private static ModListModel model;
	private final Label label = new Label();
	private final Button button = new Button();
        private static String modName;
        private static int modId;
	
	private SimpleBooleanProperty switchedOn = new SimpleBooleanProperty(false);
	public SimpleBooleanProperty switchOnProperty() { return switchedOn; }
	
	private void init() {
                
		setMaxHeight(24);
		label.setText("");
		
		getChildren().addAll(label, button);	
		button.setOnAction((e) -> {
			switchedOn.set(!switchedOn.get());
		});
		label.setOnMouseClicked((e) -> {
			switchedOn.set(!switchedOn.get());
		});
//                
		setStyle();
		bindProperties();
	}
	
	private void setStyle() {
                button.setMinHeight(15);
                button.setMaxHeight(15);
                button.setMinWidth(15);
                button.setMaxWidth(15);
                
		setWidth(42);
                setMinWidth(42);
                setPadding(new Insets(0,3,1,3));
                if(model.isDisable(modName)){
                    switchedOn.set(true);
                    setStyle("-fx-background-color: #5D6169;-fx-text-fill:black; -fx-background-radius: 5;");
                    label.toFront();
                    setAlignment(Pos.CENTER_RIGHT);
                    button.setStyle("-fx-background-radius : 5; -fx-border-radius : 5; -fx-radius : 5; -fx-background-color: #AAAAAA;");
                }else{
                    button.setStyle("-fx-background-radius : 5; -fx-border-radius : 5; -fx-radius : 5; -fx-background-color: #F8F8F8;");
                    
                    label.setAlignment(Pos.CENTER);
                    setStyle("-fx-background-color: grey; -fx-text-fill:black; -fx-background-radius: 5;");
                    setAlignment(Pos.CENTER_LEFT);
                }
                
	}
	
	private void bindProperties() {
		label.prefWidthProperty().bind(widthProperty().divide(2));
		label.prefHeightProperty().bind(heightProperty());
		button.prefWidthProperty().bind(widthProperty().divide(2));
		button.prefHeightProperty().bind(heightProperty());
	}
	
	public ToggleSwitch(ModListModel model, String modName) {
            this.model = model;
            this.modName = modName;
		init();
		switchedOn.addListener((a,b,c) -> {
			 if (c) {
                            model.disableMod(modName);
                		label.setText("");
                		setStyle("-fx-background-color: #5D6169; -fx-background-radius: 5;");
                		label.toFront();
                                button.setStyle("-fx-background-radius : 5; -fx-border-radius : 5; -fx-radius : 5; -fx-background-color: #AAAAAA;");
            		}else{
                            model.enableMod(modName);
                            button.setStyle("-fx-background-radius : 5; -fx-border-radius : 5; -fx-radius : 5; -fx-background-color: #F8F8F8;");
                            label.setText("");
                            setStyle("-fx-background-color: grey; -fx-background-radius: 5;");
                            button.toFront();
            		}
		});
	}
}
