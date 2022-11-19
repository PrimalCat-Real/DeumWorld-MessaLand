/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deumworld.models;

import deumworld.Main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.HashMap;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author PrimalCat
 */
public class Configs{
    private static String name;
    private static HashMap yamlMap;
    private static String configLink;
    private static HashMap params;
    private static File configFile;
    public static String getName() {
        params = (HashMap) yamlMap.get("launcher");
        name = (String) params.get("name");
        return name;
    }

    public static void setName(String name) {
        Configs.name = name;
        params = (HashMap) yamlMap.get("launcher");
        params.put("name",name);
        yamlMap.put("launcher", params);
        

    }
    public static void main() throws FileNotFoundException{
        Yaml yaml = new Yaml();
        
        configLink = System.getProperty("user.dir")+"\\src\\config.yaml";
//        System.out.println(configLink);
//        if(test.exists() && test.isDirectory()){
//        }else{
//            File yamlF = new File(System.getenv("APPDATA")+"\\test\\config.yaml");
//            System.out.println("Created");
//        }
        configFile = new File(configLink);
        System.out.println(configFile.exists());
        InputStream inputStream = new FileInputStream(configLink);
//        System.out.println(inputStream);
        yamlMap = yaml.load(inputStream);
 
    }
    
    public static void saveConfig() throws FileNotFoundException{
        PrintWriter writer = new PrintWriter(new File(configLink));
        Yaml yaml = new Yaml();
        yaml.dump(yamlMap, writer);
    }
    
    public static Object getIsDownloaded(){
        if(configFile.exists()){
            params = (HashMap) yamlMap.get("launcher");
            return params.get("downloaded");
        }else{
            return false;
        }
        
    }
    public static void setIsDownloaded(boolean isDownloaded){
        params = (HashMap) yamlMap.get("launcher");
        params.put("downloaded", isDownloaded);
        yamlMap.put("launcher", params);
    }

}
