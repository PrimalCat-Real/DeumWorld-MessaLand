/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deumworld.models;

import java.io.File;
import java.util.HashMap;


/**
 *
 * @author PrimalCat
 */
public class ModListModel {
  private static HashMap<Integer, String> modList = new HashMap<Integer, String>();
  private static File[] listOfFiles;
  public static HashMap<Integer, String> getModListMap() {
    return modList;
  }

  public static void setModList(HashMap<Integer, String> modList) {
    ModListModel.modList = modList;
  }

  private static String global_link = System.getenv("APPDATA")+"\\test";


  public void getModsList() {
    File folder = new File(global_link + "\\Instances\\MessaLandLauncher\\mods");
    if(folder.exists()){
        listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
          if (listOfFiles[i].isFile()) {
            modList.put(i, listOfFiles[i].getName());
          } 
        }
    }
    
  }

  public static void disableMod(String modName) {
    File mod = new File(global_link + "\\Instances\\MessaLandLauncher\\mods\\" + modName);
    File rename_mod = new File(global_link + "\\Instances\\MessaLandLauncher\\mods\\" + modName + ".disabled");
    boolean success = mod.renameTo(rename_mod);
//      System.out.println(success + "diss succes");
  }
  public static void enableMod(String modName){
      File mod = new File(global_link + "\\Instances\\MessaLandLauncher\\mods\\" + modName);
      File rename_mod = new File(global_link + "\\Instances\\MessaLandLauncher\\mods\\" + modName.substring(0, modName.length()-9));
//      boolean success = mod.renameTo(rename_mod);
//      System.out.println(success + "enable succes");
  }
  
  public static boolean isDisable(String name){
      String n = name;
     
      if(n.subSequence(n.length()-8, n.length()).equals("disabled")){
          return true;
      }else{
          return false;
      }
      
  }


}
