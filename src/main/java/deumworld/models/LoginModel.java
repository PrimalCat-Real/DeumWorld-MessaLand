/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deumworld.models;

import deumworld.Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 *
 * @author PrimalCat
 */
public class LoginModel {
    public void checkName(String nickname) throws FileNotFoundException{
        Configs config = Main.getConfigs();

        LaunchGameModel.setName(nickname);
        config.setName(nickname);
        System.out.println("nick " + nickname);
        config.saveConfig();

    }

    
}
