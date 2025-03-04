import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class NumberProcessor {
    public List<Integer> getUserInputAndConvert() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie Zahlen ein: ");
        String input = scanner.nextLine();

        List<Integer> values = new ArrayList<>();
        for (char c : input.toCharArray()) {
            values.add(Character.getNumericValue(c));
        }

        return values;
    }

    public void sortAndPrint(List<Integer> values) {
        System.out.println("Before swap: " + values);
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < values.size(); i++) {
                int current = values.get(i);
                int previous = values.get(i - 1);

                if (current < previous) {
                    Collections.swap(values, i - 1, i);
                    swapped = true;
                    printSwapDetails(values, current, previous);
                }
            }
        }
    }

    private void printSwapDetails(List<Integer> values, int current, int previous) {
        System.out.println("current ist kleiner als previous");
        System.out.println("current: " + current);
        System.out.println("previous: " + previous);
        System.out.println("After swap: " + values);
        System.out.println("###########################################");
    }
}