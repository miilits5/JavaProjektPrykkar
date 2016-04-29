import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.List;

/**
 * BorderPane kesk vaade
 */
public class KeskVaade {
    public static VBox centerVbox;
    public static Label kysimus;
    public static TextField kasutajaInput;
    public static Button sorteeriNupp;

    //MEETODID:
    public static void keskAla() {
        centerVbox = new VBox(); //l2heb borderPane'i keskele
        centerVbox.setSpacing(7);
        centerVbox.setPadding(new Insets(15, 0, 0, 0));
        centerVbox.setPrefWidth(220);

        kysimus = new Label("Sisesta prügi mida soovid sorteerida!");
        kasutajaInput = new TextField(); //kasutaja sisestab prygi, mida soovib sorteerida
        kasutajaInput.setMaxWidth(200);
        sorteeriNupp = new Button("Sorteeri");
        sorteeriNupp.setStyle("-fx-font: 12 Verdana");

        centerVbox.getChildren().addAll(kysimus, kasutajaInput, sorteeriNupp);
        nupuvajutus(sorteeriNupp,kasutajaInput);
        Java_fx.border.setCenter(centerVbox);
    }

    public static void nupuvajutus(Button sorteeriNupp, TextField kasutajaInput) {
        //"Sorteeri!" nupp ACTION!
        Pane sobivKonteinerLayout = new Pane();
        sorteeriNupp.setOnAction(event -> {
            sobivKonteinerLayout.getChildren().clear();
            String input = kasutajaInput.getText().toLowerCase();
            String sobivKonteiner = "";
            if (input.isEmpty()) {
                sobivKonteiner = "Unustasid pürgi sisestada!";
            } else if (VasakVaade.bio.kuhuVisata(input) != "") {
                sobivKonteiner = VasakVaade.bio.kuhuVisata(input);
            } else if (VasakVaade.elektroonika.kuhuVisata(input) != "") {
                sobivKonteiner = VasakVaade.elektroonika.kuhuVisata(input);
            } else if (VasakVaade.paberPapp.kuhuVisata(input) != "") {
                sobivKonteiner = VasakVaade.paberPapp.kuhuVisata(input);
            } else if (VasakVaade.ohtlikud.kuhuVisata(input) != "") {
                sobivKonteiner = VasakVaade.ohtlikud.kuhuVisata(input);
            } else if (VasakVaade.ehitus.kuhuVisata(input) != "") {
                sobivKonteiner = VasakVaade.ehitus.kuhuVisata(input);
            } else if (VasakVaade.sega.kuhuVisata(input) != "") {
                sobivKonteiner = VasakVaade.sega.kuhuVisata(input);
            } else {
                sobivKonteiner = "Hetkel sobivat prügikonteinerit ei leitud. Kliki konteineritel, et leida midagi sarnast.";
            }
            kasutajaInput.clear();
            Label sobivKonteinerLabel = new Label(sobivKonteiner);
            sobivKonteinerLabel.setMaxWidth(220);
            sobivKonteinerLabel.setWrapText(true);
            sobivKonteinerLayout.getChildren().add(sobivKonteinerLabel);
        });
        centerVbox.getChildren().add(sobivKonteinerLayout);
    }
}
