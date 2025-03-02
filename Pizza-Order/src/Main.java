import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Order bestellung;

        System.out.println("Herzlich Wilkommen bei MSP Pizza\n");
        System.out.println("(1)Lieferung, (2)Abholung");
        int value = scan.nextInt();

        if (value == 1) {
            bestellung = new Delivery();
            ((Delivery) bestellung).getAddress();
            ((Delivery) bestellung).korrekt();
        } else if (value == 2){
            bestellung = new Pickup();
            ((Pickup) bestellung).getPickupTime();
        }else {
            System.out.println("Ungültige Angabe");
            return;
        }
        while (true) {

            int ende = bestellung.getBestellung();

            if (ende == 0) {
                for (int i = 0; i < bestellung.getAnzahl().length; i++) {
                    System.out.println(+ bestellung.getAnzahl()[i] + "x " + bestellung.bestellungart[i]);
                }

                break;
            }

        }

        File datei = new File("CSV.txt");

        try {
            Writer writer = new FileWriter(datei, true);
                if (datei.length() == 0) {
                    writer.write("Menge;Artikel;Preis\n");
                }
            writer.write(bestellung.toString());
            writer.flush();
        } catch (IOException e) {
            System.out.println("Datei konnte nicht bearbeitet werden");
        }
    }
}
