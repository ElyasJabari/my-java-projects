import java.util.InputMismatchException;
import java.util.Scanner;


public class Pickup extends Order {
    Scanner scan = new Scanner(System.in);
    Appointment appointment = new Appointment();


    public void getPickupTime() {
        System.out.println("Möchten Sie Sofort(1) abholen oder machen Sie einene Termin(2)?");
        try {
            int value = scan.nextInt();
            while (true){
                if (value == 1){
                    System.out.println("Bitte kommen Sie in 30 Minuten zu uns.");
                    break;
                } else if (value == 2){
                    appointment.getAppointment();
                    break;
                } else {
                    System.out.println("Ungültige Eingabe.");
                    System.out.println("Möchten Sie Sofort(1) abholen oder machen Sie einene Termin(2)?");
                    value = scan.nextInt();
                }
            }
        } catch (InputMismatchException exception){
            System.out.println("Falsche Eingabe. Geben Sie nummer ein.");
        }

    }
}
