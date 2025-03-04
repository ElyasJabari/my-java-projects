import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

class ButtonPanel {
    public static JPanel createButtonPanel(NewDaily app, DefaultListModel<String> model, JList<String> list) {
        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
        panel.add(buildAddButton(app));
        panel.add(buildRenameButton(model, list));
        panel.add(buildDeleteButton(model, list));
        panel.add(buildRemoveAllButton(model));
        return panel;
    }

    public static JButton buildRandomSelectButton(DefaultListModel<String> model) {
        JButton button = new JButton("Zufallseintrag");
        button.addActionListener(event -> {
            if (model.size() > 0) {
                Random random = new Random();
                int index = random.nextInt(model.size());
                String entry = model.getElementAt(index);
                JOptionPane.showMessageDialog(null, entry, "Zufallsauswahl", JOptionPane.INFORMATION_MESSAGE);
                model.remove(index);
            } else {
                JOptionPane.showMessageDialog(null, "Liste ist leer!", "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        });
        return button;
    }

    private static JButton buildAddButton(NewDaily app) {
        JButton button = new JButton("Hinzufügen");
        button.addActionListener(event -> app.textField.dispatchEvent(new KeyEvent(app.textField, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, ' ')));
        return button;
    }

    private static JButton buildRenameButton(DefaultListModel<String> model, JList<String> list) {
        JButton button = new JButton("Umbenennen");
        button.addActionListener(event -> {
            int index = list.getSelectedIndex();
            if (index >= 0) {
                String newName = JOptionPane.showInputDialog("Neuer Name:", model.get(index));
                if (newName != null && !newName.trim().isEmpty()) {
                    model.set(index, newName.trim());
                }
            }
        });
        return button;
    }

    private static JButton buildDeleteButton(DefaultListModel<String> model, JList<String> list) {
        JButton button = new JButton("Löschen");
        button.addActionListener(event -> {
            int index = list.getSelectedIndex();
            if (index >= 0) {
                model.remove(index);
            }
        });
        return button;
    }

    private static JButton buildRemoveAllButton(DefaultListModel<String> model) {
        JButton button = new JButton("Alle Entfernen");
        button.addActionListener(event -> model.clear());
        return button;
    }
}
