import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DodiIndio extends Application {

    @Override
    public void start(Stage primaryStage) {
        MessageBox object = new MessageBox();

        object.showMessage("Disclaimer", "You can only visit a single website using this browser when you launch " +
                "this browser. If you want\n to visit another website after visiting the first website then you have " +
                "reopen the web browser.\nAnd if you face any problem then you can't complain me.");

        if (object.hasDisagreed == false) {
            WebView webView = new WebView();
            WebEngine engine;

            engine = webView.getEngine();

            TextField textField = new TextField("");
            textField.setPromptText("Type the URL of the website that you want to visit");
            textField.setPrefWidth(325);

            Button buttonLoad = new Button("Load");
            Button buttonLoadGoogle = new Button("Load Google");

            buttonLoad.setPrefWidth(162);
            buttonLoadGoogle.setPrefWidth(163);

            buttonLoad.setOnAction(e -> {
                if (textField.getText() != "") {
                    urlLoader(primaryStage, textField.getText(), webView, engine, false);
                } else {}
            });

            buttonLoadGoogle.setOnAction(e -> {
                urlLoader(primaryStage, "https://www.google.com", webView, engine, false);
            });

            GridPane layout = new GridPane();

            GridPane.setConstraints(textField, 0, 0);
            GridPane.setColumnSpan(textField, 3);
            GridPane.setConstraints(buttonLoad, 0, 1);
            GridPane.setConstraints(buttonLoadGoogle, 2, 1);

            layout.getChildren().addAll(textField, buttonLoad, buttonLoadGoogle);

            Scene scene = new Scene(layout, 325, 55);

            primaryStage.setTitle("Web Browser");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        }

        else {
            primaryStage.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void urlLoader(Stage primaryStage, String url, WebView webView, WebEngine engine, boolean shouldReload) {
        engine = webView.getEngine();

        Stage browserStage = new Stage();

        Pane layout = new Pane();
        layout.getChildren().add(webView);

        engine.load(url);

        if (shouldReload) {
            engine.reload();
        }

        browserStage.setTitle("Web Browser");
        browserStage.setScene(new Scene(layout, 800, 500));
        browserStage.show();
        browserStage.setResizable(false);

        primaryStage.close();
    }
}
