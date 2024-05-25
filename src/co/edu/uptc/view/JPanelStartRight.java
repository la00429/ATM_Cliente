package co.edu.uptc.view;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelStartRight extends JPanel {
    private JLabel title;
    private JButtonUPTC button;

    public JPanelStartRight() {
        this.setSize(getMaximumSize());
        initComponents();
        this.setBackground(new Color(255, 255, 255));
        this.setVisible(true);
    }

    private void initComponents() {
        title = new JLabel();
        button = new JButtonUPTC(null);
    }

    public JLabel getTitle() {
        return title;
    }

    public JButtonUPTC getButton() {
        return button;
    }

}
