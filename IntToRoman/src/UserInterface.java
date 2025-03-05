import java.util.InputMismatchException;
import java.util.Scanner;

class UserInterface {
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        try {
            while (true) {
                System.out.println("Für Abbrechen (0)");
                System.out.print("Bitte geben Sie eine Zahl ein, um die entsprechende römische Zahl anzuzeigen: ");

                int input = scanner.nextInt();

                if (input == 0) {
                    System.out.println("Programm beendet.");
                    break;
                }

                String romanNumber = RomanConverter.convertToRoman(input);
                if (romanNumber == null){
                    System.out.println("In diesem Projekt sind nur Zahlen von 1 bis 1099 möglich.");
                } else {
                    System.out.println(input + " ist als römische Zahl: " + romanNumber);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Ungültige Eingabe. Bitte geben Sie eine ganze Zahl ein.");
        }
    }
}