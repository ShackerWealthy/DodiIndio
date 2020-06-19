import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;

public class DodiIndio extends Application {

    TextField textField = new TextField();
    Button loadButton = new Button("Load");
    Button reloadButton = new Button("Reload");
    WebView webView;
    WebEngine engine;

    @Override
    public void start(Stage primaryStage) throws Exception{
        MessageBox choose = new MessageBox();
        choose.askUsersChoice();

        if (choose.shouldClose == false) {
            webView = new WebView();
            engine = webView.getEngine();

            textField.setPromptText("Type in the URL of the website that you want to visit");
            textField.setPrefWidth(500);
            textField.setPrefHeight(35);
            textField.getStyleClass().add("textfield");

            loadButton.setPrefWidth(100);
            loadButton.setPrefHeight(35);
            reloadButton.setPrefWidth(100);
            reloadButton.setPrefHeight(35);

            loadButton.setOnAction(e -> engine.load(textField.getText()));

            reloadButton.getStyleClass().add("button-blue");

            VBox root = new VBox();
            HBox hbox = new HBox();

            hbox.getChildren().addAll(textField, loadButton, reloadButton);
            root.getChildren().addAll(hbox, webView);

            try {
                engine.load(choose.url);
            } catch (IllegalArgumentException e) {
                engine.loadContent("<html><body><p align=\"CENTER\">Sorry I can't find the link.</p></body></html>");
            }

            reloadButton.setOnAction(e -> engine.reload());

            Scene scene = new Scene(root, 1000, 500);
            scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());

            primaryStage.setTitle("Advanced Web Browser");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        }

        else {}
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
