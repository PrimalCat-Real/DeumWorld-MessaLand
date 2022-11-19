module deumworld.deumworld {
    requires javafx.controls;
    requires javafx.fxml;
    requires AnimateFX;
    requires org.yaml.snakeyaml;


    opens deumworld to javafx.fxml;
    exports deumworld;
    exports deumworld.controllers;
    exports deumworld.components.TopBar;
    exports deumworld.components.Card;
    exports deumworld.components.ModList;
}