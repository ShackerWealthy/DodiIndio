import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

public class MessageBox {

    Stage messageStage = new Stage();
    String title = "Choose Search Engine";
    String message = "Which of the following search engine do you like the most?";
    String url;
    boolean shouldClose = false;

    public void askUsersChoice() {
        showMessage2();

        if (shouldClose == false) {
            Label messageLabel = new Label(message);
            Button buttonSelect = new Button("Select");

            buttonSelect.setPrefHeight(30);
            buttonSelect.setPrefWidth(75);

            messageStage.setOnCloseRequest(e -> {
                shouldClose = true;
                messageStage.close();
            });

            RadioButton googleButton = new RadioButton("Google");
            RadioButton yahooButton = new RadioButton("Yahoo");
            RadioButton duckduckgoButton = new RadioButton("DuckDuckGo");
            RadioButton bingButton = new RadioButton("Bing");

            GridPane root = new GridPane();

            ToggleGroup radioGroup = new ToggleGroup();

            googleButton.setToggleGroup(radioGroup);
            yahooButton.setToggleGroup(radioGroup);
            duckduckgoButton.setToggleGroup(radioGroup);
            bingButton.setToggleGroup(radioGroup);

            googleButton.setPadding(new Insets(8, 8, 8, 8));
            yahooButton.setPadding(new Insets(8, 8, 8, 8));
            duckduckgoButton.setPadding(new Insets(8, 8, 8, 8));
            bingButton.setPadding(new Insets(8, 8, 8, 8));

            googleButton.setSelected(true);

            messageStage.initModality(Modality.WINDOW_MODAL);

            BorderPane buttonLayout = new BorderPane();
            buttonLayout.setRight(buttonSelect);

            GridPane.setConstraints(messageLabel, 0, 0);
            GridPane.setConstraints(googleButton, 0, 2);
            GridPane.setConstraints(yahooButton, 0, 3);
            GridPane.setConstraints(duckduckgoButton, 0, 4);
            GridPane.setConstraints(bingButton, 0, 5);
            GridPane.setConstraints(buttonLayout, 0, 7);

            buttonSelect.setOnAction(e -> {
                if (googleButton.isSelected()) {
                    url = "https://www.google.com";
                } else if (yahooButton.isSelected()) {
                    url = "https://www.yahoo.com";
                } else if (duckduckgoButton.isSelected()) {
                    url = "https://www.duckduckgo.com";
                } else if (bingButton.isSelected()) {
                    url = "https://www.bing.com";
                }

                messageStage.close();
            });

            root.setPadding(new Insets(8, 8, 8, 8));

            root.getChildren().addAll(messageLabel, googleButton, yahooButton, duckduckgoButton, bingButton, buttonLayout);

            Scene scene = new Scene(root, 410, 200);
            scene.getStylesheets().add(getClass().getResource("stylesheet2.css").toExternalForm());

            messageStage.setTitle(title);
            messageStage.setScene(scene);
            messageStage.showAndWait();
        }

        else {}
    }

    public void showMessage2() {
        showMessage1();

        if (shouldClose == false) {
            Stage stage2 = new Stage();
            stage2.initModality(Modality.WINDOW_MODAL);
            BorderPane layout = new BorderPane();
            Label label = new Label("The search engine that you choose as your favourite will also be set as your " +
                    "default search engine.\n\n");
            Button button = new Button("OK, Next");

            button.setPrefWidth(100);
            button.setOnAction(e -> {
                shouldClose = false;
                stage2.close();
            });

            layout.setPadding(new Insets(8, 8, 8, 8));

            stage2.setOnCloseRequest(e -> {
                shouldClose = true;
                stage2.close();
            });

            layout.setTop(label);
            layout.setCenter(button);

            Scene scene2 = new Scene(layout);
            scene2.getStylesheets().add(getClass().getResource("stylesheet2.css").toExternalForm());

            stage2.setScene(scene2);
            stage2.setTitle("Message");
            stage2.setResizable(false);
            stage2.showAndWait();
        }
        else {}
    }

    public void showMessage1() {
        Stage stage1 = new Stage();
        stage1.initModality(Modality.WINDOW_MODAL);
        BorderPane layout = new BorderPane();
        Label label = new Label("You need to give the entire URL of the website including the transfer protocols " +
                "of the website that you want to visit.\n\n");
        Button button = new Button("OK, Next");

        button.setPrefWidth(100);
        button.setOnAction(e -> {
            shouldClose = false;
            stage1.close();
        });

        layout.setPadding(new Insets(8,8,8,8));

        stage1.setOnCloseRequest(e -> {
            shouldClose = true;
            stage1.close();
        });

        layout.setTop(label);
        layout.setCenter(button);

        Scene scene1 = new Scene(layout);
        scene1.getStylesheets().add(getClass().getResource("stylesheet2.css").toExternalForm());

        stage1.setScene(scene1);
        stage1.setTitle("Message");
        stage1.setResizable(false);
        stage1.showAndWait();
    }

}
