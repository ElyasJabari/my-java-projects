import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class CalculatorButton {
    public static JButton createButton(JTextField textField, JTextField textField1, JTextField textFieldResult, int xCoordinate, String operator) {
        JButton button = new JButton(operator);
        button.setBounds(xCoordinate, 220, 40, 30);

        button.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(textField.getText());
                int num2 = Integer.parseInt(textField1.getText());
                switch (operator) {
                    case "+":
                        textFieldResult.setText(String.valueOf(num1 + num2));
                        break;
                    case "-":
                        textFieldResult.setText(String.valueOf(num1 - num2));
                        break;
                    case "*":
                        textFieldResult.setText(String.valueOf(num1 * num2));
                        break;
                    case "/":
                        if (num2 == 0) {
                            textFieldResult.setText("Man teilt nicht durch null");
                        } else {
                            textFieldResult.setText(String.valueOf(num1 / num2));
                        }
                        break;
                }
            } catch (NumberFormatException exception) {
                textFieldResult.setText("Ungültige Angabe");
            }
        });

        applyMouseEffect(button, textField, textField1);
        return button;
    }

    private static void applyMouseEffect(JButton button, JTextField textField, JTextField textField1) {
        Color yellow = new Color(255, 255, 0);
        final Color[] defaultBackground = new Color[1];

        button.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                defaultBackground[0] = textField.getBackground();
                textField.setBackground(yellow);
                textField1.setBackground(yellow);
            }

            public void mouseReleased(MouseEvent me) {
                textField.setBackground(defaultBackground[0]);
                textField1.setBackground(defaultBackground[0]);
            }
        });
    }
}
