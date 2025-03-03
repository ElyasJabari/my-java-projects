import javax.swing.*;

class ListActions {
    public static void addItem(DefaultListModel<String> model) {
        String text = JOptionPane.showInputDialog("Add a new item");
        if (text != null && !text.isBlank()) {
            model.addElement(text.trim());
        }
    }

    public static void renameItem(DefaultListModel<String> model, JList<String> list) {
        int index = list.getSelectedIndex();
        if (index != -1) {
            String item = model.getElementAt(index);
            String newText = JOptionPane.showInputDialog("Rename item", item);
            if (newText != null && !newText.trim().isEmpty()) {
                model.set(index, newText.trim());
            }
        }
    }

    public static void deleteItem(DefaultListModel<String> model, JList<String> list) {
        int index = list.getSelectedIndex();
        if (index >= 0) {
            model.remove(index);
        }
    }
}