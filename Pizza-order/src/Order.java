import java.util.Scanner;


public class Order {
    Scanner scan = new Scanner(System.in);
    String[] bestellungart = {"Margherita Pizza", "Thunfisch Pizza", "Vegetarisch Pizza"};
    double [] preis = {9.59, 8.99, 11.99};
    int [] anzahl = new int[3];
    int choose;


    public int[] getAnzahl() {
        return anzahl;
    }

    public int getBestellung() {
        System.out.println("Wählen Sie mit eine Nummer Ihre Bestellung aus (oder 0 für Ende):");

        for (int i = 0; i < bestellungart.length; i++) {
            System.out.println((i + 1) + ". " + bestellungart[i] + " " + preis[i] + "€");
        }

        choose = scan.nextInt();
        if (choose > 0 && choose <= bestellungart.length){
            anzahl[choose-1]++;

        }
        double sum= 0.;
        for (int i = 0; i < bestellungart.length; i++) {
            sum = sum + (preis[i] * anzahl[i]);
        }
        System.out.println("Gesamt: " + sum);

        return choose;
    }

    public String toString (){
        String result = "";
        for (int i = 0; i < getAnzahl().length; i++) {
            result = result + getAnzahl()[i] + ";" + bestellungart[i] + ";" + (preis[i] * getAnzahl()[i]) + "\n";

        }
        return result;
    }

}