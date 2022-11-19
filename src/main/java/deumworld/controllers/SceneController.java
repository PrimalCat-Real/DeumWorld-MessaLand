/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deumworld.controllers;

import deumworld.utilities.MakeMoveStage;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author PrimalCat
 */
public class SceneController{
   
    private static Stage stage;

    public SceneController(Stage stage) {
        this.stage = stage;
    }

    
    public static void setScene(Scene scene) throws IOException{
       stage.setScene(scene);
       stage.show();
       new MakeMoveStage().makeMove(scene, stage);
       
    }
    
//        
}
