import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * ITK Java kursuse i200 iseseisev projekt. Autor: Kirke Narusk, sügis-talv 2015.
 */
public class Java_fx extends Application {
    Stage primaryStage;
    Scene stseen;
    static BorderPane border = new BorderPane();

    public void start(Stage eLava)throws Exception {
        primaryStage = eLava;
        eLava.setResizable(false);
        border.setStyle("-fx-padding: 10");

        VasakVaade.vasakAar();
        KeskVaade.keskAla();
        AlumineVaade.alumineAar();

        stseen = new Scene(border, 600, 330);
        eLava.setScene(stseen);
        eLava.setTitle("Java prügikast");
        eLava.show();
        eLava.setOnCloseRequest(event -> System.exit(0));
    }
}
