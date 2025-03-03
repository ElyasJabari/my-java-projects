import javax.swing.*;

class CalculatorUI {
    private JFrame frame;
    private JTextField textField;
    private JTextField textField1;
    private JTextField textFieldResult;

    public CalculatorUI() {
        frame = new JFrame("Taschenrechner");
        frame.setSize(400, 400);
        frame.setLocation(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);
        frame.setLayout(null);
    }

    public void openUI() {
        JLabel text = new JLabel("Geben Sie die erste und zweite Zahl ein");
        text.setBounds(50, 50, 400, 30);

        textField = new JTextField();
        textField.setBounds(50, 100, 200, 30);

        textField1 = new JTextField();
        textField1.setBounds(50, 150, 200, 30);

        textFieldResult = new JTextField();
        textFieldResult.setBounds(50, 270, 200, 30);
        textFieldResult.setEnabled(false);

        frame.add(text);
        frame.add(textField);
        frame.add(textField1);
        frame.add(textFieldResult);

        addButtons();

        frame.setVisible(true);
    }

    private void addButtons() {
        frame.add(CalculatorButton.createButton(textField, textField1, textFieldResult, 50, "+"));
        frame.add(CalculatorButton.createButton(textField, textField1, textFieldResult, 80, "-"));
        frame.add(CalculatorButton.createButton(textField, textField1, textFieldResult, 110, "*"));
        frame.add(CalculatorButton.createButton(textField, textField1, textFieldResult, 140, "/"));
    }
}
