import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class NewDaily {
    final JTextField textField = new JTextField(20);
    private final DefaultListModel<String> model = new DefaultListModel<>();
    private final JList<String> list = new JList<>(model);

    public NewDaily() {
        JFrame frame = new JFrame("Teilnehmer Liste");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Schreiben Sie Namen der Teilnehmer an: ");
        topPanel.add(label);
        topPanel.add(textField);
        topPanel.add(ButtonPanel.buildRandomSelectButton(model));

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addTextToList();
                }
            }
        });

        JPanel leftPanel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(list);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        leftPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel rightPanel = ButtonPanel.createButtonPanel(this, model, list);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(leftPanel, BorderLayout.CENTER);
        frame.add(rightPanel, BorderLayout.EAST);

        frame.setVisible(true);
    }

    private void addTextToList() {
        String text = textField.getText().trim();
        if (!text.isEmpty()) {
            model.addElement(text);
            textField.setText("");
        }
    }
}