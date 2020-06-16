import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class MessageBox {

    public Stage stage = new Stage();
    public Scene scene;
    public boolean hasDisagreed = false;

    public void showMessage(String title, String message) {
        Label label = new Label(message);

        stage.initModality(Modality.WINDOW_MODAL);

        stage.setOnCloseRequest(e -> {
            stage.close();
            hasDisagreed = true;
        });

        label.setPadding(new Insets(8, 8, 0, 8));

        Button buttonAgree = new Button("I Agree");
        buttonAgree.setPrefWidth(80);
        buttonAgree.setPrefHeight(30);
        buttonAgree.setPadding(new Insets(8, 8, 8, 8));

        Button buttonDisagree = new Button("I Disagree");
        buttonDisagree.setPrefWidth(80);
        buttonDisagree.setPrefHeight(30);
        buttonDisagree.setPadding(new Insets(8, 8, 8, 8));

        buttonAgree.setOnAction(e -> stage.close());
        buttonDisagree.setOnAction(e -> {
            stage.close();
            hasDisagreed = true;
        });

        BorderPane root = new BorderPane();
        AnchorPane layout = new AnchorPane();
        HBox hbox = new HBox();

        hbox.getChildren().addAll(buttonAgree, buttonDisagree);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        layout.getChildren().add(hbox);

        AnchorPane.setRightAnchor(hbox, 10d);

        root.setTop(label);
        root.setBottom(layout);

        scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle(title);
        stage.setResizable(false);
        stage.showAndWait();
    }
}
