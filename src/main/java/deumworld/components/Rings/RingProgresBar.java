/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deumworld.components.Rings;


import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

/**
 *
 * @author PrimalCat
 */
public class RingProgresBar extends StackPane{

    private int progress;
    private Arc arc;
    private Label progressText;
    private static final double INSET = 11;

    private static final double ARC_RADIUS = 38;
    private static final double INITIAL_ARC_LENGTH  = 0;
    private static final double ARC_STROKE_WIDTH = 2;
    private static final double ARC_REGION_SIZE = ARC_RADIUS * 2 + ARC_STROKE_WIDTH + INSET * 2;

    
    public RingProgresBar() {

        BorderPane bp = new BorderPane();
        setMinWidth(80);
        setMinHeight(80);
        setMaxHeight(80);
        setMaxWidth(80);
        arc = new Arc(ARC_REGION_SIZE / 2, ARC_REGION_SIZE / 2,
                ARC_RADIUS, ARC_RADIUS,
                0,
                INITIAL_ARC_LENGTH);
        
        final double fillSize = ARC_RADIUS * 2 + arc.getStrokeWidth() + INSET * 2;
        Rectangle fill = new Rectangle(fillSize, fillSize, Color.TRANSPARENT);
        Group centeredArcGroup = new Group(fill, arc);
        
        arc.setCenterX(49.3f);
        arc.setCenterY(49.3f);
         arc.setStrokeLineCap(StrokeLineCap.ROUND);
        BorderPane insideCircle = new BorderPane();
        insideCircle.setMaxWidth(72);
        insideCircle.setMaxHeight(72);
        insideCircle.setShape(new Circle(50,50,30));
        arc.setStroke(Color.LIME);
        arc.setStrokeWidth(2);
        arc.setFill(Color.TRANSPARENT);
        progressText = new Label("00%");
        progressText.setStyle("-fx-text-fill: #F4F5F3; -fx-font-size: 16;");
        insideCircle.setStyle("-fx-background-color: #313237; -fx-effect: dropshadow(three-pass-box, rgba(87, 87, 87, 0.489), 10, 1, 0, 0);");
        insideCircle.setCenter(progressText);
        Group root = new Group(centeredArcGroup); 

        getChildren().add(bp);
        bp.setCenter(root);
        getChildren().add(1, insideCircle);
    }

    
    
    public void upDateBar(float p){
         Platform.runLater(new Runnable() {
             @Override
             public void run() {
                 arc.setLength(p*3.6);
                 progressText.setText(p + "%");
             }
         });
             
        
    }
    
}
