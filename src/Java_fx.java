import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * ITK Java kursuse i200 iseseisev projekt. Autor: Tarvi Tihhanov, Kirke Narusk, sügis-talv 2015. Alustasime koos projekti ja paljud asjad koos tehtud. Kuna Kirke jõudis töödega eest ära joosta ostsutamise projekti lahku lüüa.
 * Sai tehtud ka piisavalt vara commite mille tõttu lubasite lisaks 10 punkti projektile anda.
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
