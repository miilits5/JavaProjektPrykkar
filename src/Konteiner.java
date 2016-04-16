import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 Prügikonteinerite klass: igal konteineril on liik (nt "ohtlikud jäätmed" või "paber ja papp") ja prügi nimekiri, mis sinna konteinerisse sobib.
 Lisaks meetodid prügi nimekirja failist lugemiseks ja kuvamiseks, kontrollimiseks, kas kasutaja poolt sisestatud prügi sobib sellesse konteinerisse või
 on konteineris sarnase nimega prügi, mida kasutaja võis mõelda.
 Lisaks meetodid Prykkari äraarvamise mängu tarvis.
 */
public class Konteiner {
    public String liik; //konteineri liik
    public List<String> prygi; //konteinerisse sobiv prygi

    Konteiner(String liik) {
        this.liik = liik;
    }
    Konteiner(List<String> prygi) {
        this.prygi = prygi;
    }
    String getLiik() {
        return liik;
    }
    List<String> getPrygi() {
        return prygi;
    }
    void setPrygi(List<String> prygi){
        this.prygi = prygi;
    }

    //MEETOD "jarjend": loeb failist prügi ja viskab selle arraylisti, mille ka tagastab
    public  ArrayList<String> jarjend(File fail) throws Exception {
        Scanner sc = new Scanner(fail);
        ArrayList<String> jaatmeList = new ArrayList<>();
        while (sc.hasNextLine()) {
            String rida = sc.nextLine();
            jaatmeList.add(rida);
        }
        jaatmeList.remove(0);
        sc.close();
        return jaatmeList;
    }

    //MEETOD "prindiKonteinerList" prindib välja konteinerisse sobiva prygi
    public  StringBuilder prindiKonteineriList() {
        List<String> prygiList = this.getPrygi();
        Collections.sort(prygiList);
        StringBuilder sb = new StringBuilder();
        for (String s : prygiList) {
            sb.append(s);
            sb.append("\n");
        }return sb;
    }
    //MEETOD "kuhuVisata": ytleb kasutajale, millisesse konteinerisse prygi visata
    public String kuhuVisata(String kasutajaPrygi) {
        String sobivKonteiner = "";
        for (int i = 0; this.getPrygi().size() > i; i++) {
            if (this.getPrygi().get(i).equals(kasutajaPrygi)) {//kontrollin, kas kasutaja prygi sobib antud konteinerisse; stringide puhul toimib meetod equals()!!! mitte ==
                sobivKonteiner = this.getLiik();
            }
        } return sobivKonteiner;
    }

}

