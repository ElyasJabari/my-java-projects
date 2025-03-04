import java.util.List;

public class Main {
    public static void main(String[] args) {
        NumberProcessor processor = new NumberProcessor();
        List<Integer> allValues = processor.getUserInputAndConvert();
        processor.sortAndPrint(allValues);
    }
}