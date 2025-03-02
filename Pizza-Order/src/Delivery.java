import java.util.Scanner;


public class Delivery
        extends Order {

    private static final Scanner scan = new Scanner(System.in);
    Appointment appointment = new Appointment();

    int    postleitzahl;
    String straßennamen;
    int    hausnummer;
    int    value;


    public void getAddress() {
        System.out.println("Lieferadresse: ");

        System.out.println("Drücken Sie (1) für Adresse Hinzufügen");
        value = scan.nextInt();
        while (true) {
            if (value == 1) {
                System.out.println("Geben Sie Ihre Postleitzahl");
                postleitzahl = scan.nextInt();

                System.out.println("Geben Sie Ihre Straßenname");
                straßennamen = scan.next();

                System.out.println("Geben Sie Ihre Hausnummer");
                hausnummer = scan.nextInt();

            } else {
                System.out.println("Ungültige Angabe");
            }
            break;
        }

    }

    public void korrekt() {
        System.out.println("ist die Angaben Richtig: " + postleitzahl + ", " + straßennamen + " " + hausnummer);
        System.out.println("Ja oder Nein");
        String valueText = scan.next();

        while (true) {
            if ("Ja".equals(valueText)) {
                System.out.println("Ihre Daten ist gespeichert. \nSofort (1) oder mit Termin (2)");
                int value1 = scan.nextInt();

                if (value1 == 2){
                    appointment.getAppointment();
                }
            }

            break;
        }

    }
}
