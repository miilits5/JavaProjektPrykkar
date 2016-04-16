
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.File;


/**
 * BorderPane vasak vaade
 */
public class VasakVaade {
    static Konteiner paberPapp = new Konteiner("Paber ja papp"); //loon uue Konteiner tyypi objekti, mille liik on paber ja papp
    static Konteiner bio = new Konteiner("Biolagunevad jäätmed");   //loon uue Konteiner tyypi objekti, mille liik on biol. j22tmed
    static Konteiner elektroonika = new Konteiner("Kodutehnika"); //loon uue Konteineri tyypi objekti, mille liik on vana elektroonika (k�lmkapid, arvutid, telekad)
    static Konteiner ohtlikud = new Konteiner("Ohtlikud jäätmed"); //loon uue Konteineri tyypi objekti, mille liik on ohtlikud jäätmed (värvid, kodukeemia, akud) (NB! nende vastuvõtmine on piiratud koguseliselt)
    static Konteiner ehitus = new Konteiner("Ehitusprügi ja segajäätmed"); //Selle eest tuleb maksta j22tmejaamas. 20€ kuupmeeter.
    static Konteiner sega = new Konteiner("Segapakendid");

    static Stage konteinerLava; //eraldi aken konteinerite sisu kuvamiseks

    //MEETODID:
    public static void vasakAar() throws Exception {
        VBox konteineridHbox = new VBox(7); //l2heb leftVbox'i
        VBox leftVbox = new VBox();
        leftVbox.setSpacing(7);
       leftVbox.setPadding(new Insets(15, 15, 15, 0)); //ülemine, parem, alumine, Vasak


        Label selgitusKonteineritele = new Label ("KONTEINERID");
        selgitusKonteineritele.setStyle("-fx-font: 12 Verdanaw;-fx-font-weight: bold");
        Nupp paberNupp = new Nupp("Paber ja papp", "Pane papp või paber vastavasse konteinerisse!","#CCFFCC");
        Nupp bioNupp = new Nupp("Biojäätmed","Pane biojäätmed vastavasse konteinerisse!","#CCFFCC");
        Nupp metallNupp = new Nupp("Vanametall", "Vii elektroonika elektroonikakauplusesse või jäätmejaama!", "#CCFFCC");
        Nupp ohtlikNupp = new Nupp("Ohtlikud jäätmed","Vii ohtlikud jäätmed jäätmejaama või ohtlike jäätmete konteinerisse","#CCFFCC" );
        Nupp ehitusNupp = new Nupp("Ehitusjäätmed", "Vii ehituspraht vastavalt jäätmejaama personali juhistele õigesse konteinerisse", "#CCFFCC");
        Nupp segaNupp = new Nupp("Segapakendid", "Vii segapakendit vastavalt jäätmejaama personali juhistele õigesse konteinerisse", "#CCFFCC");

        prygiKonteinerisse();

        // Konteinerite nupud.
        nupuvajutus(bioNupp,bio); //Bioloogiliselt lagunevate jäätmete nupp
        nupuvajutus(paberNupp, paberPapp); //Paberi ja papii nupp action!
        nupuvajutus(metallNupp, elektroonika);  //elektroonija ja vanametalli nupp Action
        nupuvajutus(ohtlikNupp, ohtlikud);  //ohtlikute jäätmete nupp Action
        nupuvajutus(ehitusNupp, ehitus); //ehitusjäätmete nupp Action
        nupuvajutus(segaNupp, sega); //segapakendijäätmete nupp Action

        konteineridHbox.getChildren().addAll(paberNupp, bioNupp, metallNupp, ohtlikNupp, segaNupp, ehitusNupp);
        leftVbox.getChildren().addAll(selgitusKonteineritele, konteineridHbox);
        Java_fx.border.setLeft(leftVbox);
    }

    public static void prygiKonteinerisse() throws Exception {
        //eri liiki prygi listid l2hevad eri liiki konteineritesse
        paberPapp.setPrygi(paberPapp.jarjend(new File("paber.txt")));
        bio.setPrygi(bio.jarjend(new File("bio.txt")));
        elektroonika.setPrygi(elektroonika.jarjend(new File("elekter.txt")));
        ohtlikud.setPrygi(ohtlikud.jarjend(new File("ohtlik.txt")));
        ehitus.setPrygi(ehitus.jarjend(new File("ehitus.txt")));
        sega.setPrygi(sega.jarjend(new File("sega.txt")));
    }
    //konteineri nuppude ACTION MEETOD: kui konteineri nuppu vajutatakse, kuvatakse sinna konteinerisse sobiv prygi
    public static void nupuvajutus(Nupp nupp, Konteiner konteiner) {
        nupp.setOnMouseClicked(event -> {
            VBox konteinerLayout = new VBox();
            konteinerLayout.setSpacing(5);
            konteinerLayout.setPadding(new Insets(10,15,15,15));
            Label konteinerLabel = new Label(konteiner.prindiKonteineriList().toString());
            konteinerLayout.getChildren().addAll(konteinerLabel);
            Scene konteinerScene = new Scene(konteinerLayout, konteinerLayout.getPrefWidth(), konteinerLayout.getPrefHeight());

            konteinerLava= new Stage();
            konteinerLava.setScene(konteinerScene);
            konteinerLava.show();
        });
    }
}
