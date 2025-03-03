import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ListMouseListener extends MouseAdapter {
    private final DefaultListModel<String> model;
    private final JList<String> list;

    public ListMouseListener(DefaultListModel<String> model, JList<String> list) {
        this.model = model;
        this.list = list;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            int index = list.locationToIndex(e.getPoint());
            ListActions.renameItem(model, list);
        }
    }
}
