import java.util.Scanner;


public class Appointment {
    Scanner scan = new Scanner(System.in);

    public void getAppointment() {
        System.out.println("Geben Sie Ihre gewünschte Termin ein (dd.MM.yyyy-hh:mm): ");
        String date = scan.next();
        System.out.println(date + " Iher Termin ist gespeichert");
    }

}
