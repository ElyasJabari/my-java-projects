import javax.swing.*;
import java.awt.*;

class AppFrame extends JFrame {
    private DefaultListModel<String> model;
    private JList<String> list;

    public AppFrame() {
        setTitle("To-Do App");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        model = new DefaultListModel<>();
        list = new JList<>(model);
        model.addElement("A");
        model.addElement("B");
        model.addElement("C");
        model.addElement("D");
        model.addElement("E");

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        list.addMouseListener(new ListMouseListener(model, list));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        leftPanel.add(new JScrollPane(list));

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50));

        JButton addButton = new JButton("Add");
        JButton renameButton = new JButton("Rename");
        JButton deleteButton = new JButton("Delete");
        JButton removeAllButton = new JButton("Remove All");

        addButton.addActionListener(e -> ListActions.addItem(model));
        renameButton.addActionListener(e -> ListActions.renameItem(model, list));
        deleteButton.addActionListener(e -> ListActions.deleteItem(model, list));
        removeAllButton.addActionListener(e -> model.clear());

        rightPanel.add(addButton);
        rightPanel.add(renameButton);
        rightPanel.add(deleteButton);
        rightPanel.add(removeAllButton);

        panel.add(leftPanel);
        panel.add(rightPanel);
        add(panel);

        setVisible(true);
    }
}