/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deumworld.controllers;

import deumworld.Main;
import deumworld.controllers.SceneController;
import deumworld.models.LoginModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

/**
 *
 * @author PrimalCat
 */
public class LoginController implements Initializable{
    
    @FXML public TextField loginTextField;
    private static ResourceBundle language;
    private static SceneController screenController;
    private static String nickname = "Player";
    private static LoginModel loginModel;
    
    public void logIn() throws IOException{
        
        if(validString(loginTextField.getText())){
           nickname = loginTextField.getText(); 
           URL mainRoot = Main.getRoot_main();
           language = ResourceBundle.getBundle("deumworld/lang/dashboard");
           Parent root_main = FXMLLoader.load(mainRoot,language);
           Scene scene = new Scene(root_main);
           screenController = Main.getScreenController();
           screenController.setScene(scene);
           loginModel.checkName(nickname);
        }else{
           loginTextField.setStyle("-fx-prompt-text-fill: #BB514E;");
           loginTextField.setText("");
           loginTextField.setPromptText(Main.getBundle().getString("invalid.nickname"));
           
        }
         
    }
    
    public void styleTextField(){
        loginTextField.setStyle("-fx-prompt-text-fill: #C4C4C4;");
        loginTextField.setPromptText(Main.getBundle().getString("nickname.text"));
    }
    
    public static boolean validString(String text){
        if(text.length() < 3 || text.length() > 16){
            return false;
        }else{
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || Character.isDigit(c)){
                    System.out.println("login is valid");
                }else{
                    return false;
                }
            }
            return true;
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginModel = new LoginModel();
    }
    
    
    
}
