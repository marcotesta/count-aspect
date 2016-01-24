package it.mondogrua.countapp;

import it.mondogrua.count.Count;
import it.mondogrua.count.DateCount;
import it.mondogrua.javafx_count_view.AltJFXBuilder;
import it.mondogrua.javafx_count_view.JFXBuilder;
import it.mondogrua.swing_count_view.SwingBuilder;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class CountApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Count count = new DateCount();

        createCountViewContainer(primaryStage, count, "JavaFX DateCount Example", new JFXBuilder());
        createCountViewContainer(new Stage(), count, "Alternative JavaFX DateCount Example", new AltJFXBuilder());
        createCountViewContainer(new Stage(), count, "SWING DateCount Example", new SwingBuilder());
    }

    private void createCountViewContainer(Stage stage, Count count, String lable, Builder builder) {
        CountViewContainer countViewContainer = new CountViewContainer();
        countViewContainer.openOn(count, builder);
        
        Scene scene = builder.getScene(350, 100);

        stage.setScene(scene);
        stage.setTitle(lable);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
