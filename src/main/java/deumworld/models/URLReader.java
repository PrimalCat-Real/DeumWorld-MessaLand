/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deumworld.models;

import deumworld.components.Card.CardController;
import deumworld.components.Rings.RingProgresBar;
import deumworld.utilities.UnzipFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import javafx.application.Platform;
import javafx.scene.layout.BorderPane;
/**
 *
 * @author PrimalCat
 */
public class URLReader {
    private RingProgresBar rpb;
    private CardController cc;
    private BorderPane buttonBack;
    private BorderPane cardBack;
    private static Thread newThread;

    public static void stopNewThread() {
        newThread.stop();
    }


    public void copyURLToFile(RingProgresBar rpb, BorderPane buttonBack, BorderPane cardBack) throws MalformedURLException {
            this.buttonBack = buttonBack;
            this.cardBack = cardBack;
            String sUrl = "https://download852.mediafire.com/qhvyo4xuusjg/7q0c5e6gi6w0ec4/test.zip";
            // for test
//            String sUrl = "https://media.forgecdn.net/files/3606/443/Dandelion+X+1.18.1.zip";
            URL url = new URL(sUrl);
            this.rpb = rpb;
            File file = new File(System.getenv("APPDATA")+"/test.zip");
            newThread = new Thread(() -> {
                 try {
                    InputStream input = url.openStream();
                    
                    if (file.exists()) {
                            if (file.isDirectory())
                                    throw new IOException("File '" + file + "' is a directory");

                            if (!file.canWrite())
                                    throw new IOException("File '" + file + "' cannot be written");
                    } else {
                            File parent = file.getParentFile();
                            if ((parent != null) && (!parent.exists()) && (!parent.mkdirs())) {
                                    throw new IOException("File '" + file + "' could not be created");
                            }
                    }

                    FileOutputStream output = new FileOutputStream(file);

                    byte[] buffer = new byte[4096];
                    int n = 0;
                    long totalBytesRead = 0;
                    float percentCompleted = 0;
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    long fileSize = con.getContentLength();
                    while (-1 != (n = input.read(buffer))) {
                            output.write(buffer, 0, n);
                            totalBytesRead += n;
                            
                            percentCompleted = (float) totalBytesRead / fileSize * 100;
                            System.out.println(roundFloat(percentCompleted));
                            rpb.upDateBar(roundFloat(percentCompleted));
                    }
                    
                    input.close();
                    output.close();

//                    System.out.println("File '" + file + "' downloaded successfully!");
                    UnzipFile.unZip();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            cc.makePlayButton();
                        }
                    });
                    
                }
                catch(IOException ioEx) {
                        ioEx.printStackTrace();
                }
            });
           newThread.start();
    }
    public static float roundFloat(float in) {
        return ((int)((in*100f)+0.5f))/100f;
    }
    public URLReader(CardController cc) {
        this.cc = cc;
    
    }

}
