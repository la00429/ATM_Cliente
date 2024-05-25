package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class JDialogUPTC extends JDialog {
    private JTextPaneUPTC textPane;

    public JDialogUPTC(JFrame parent) {
        super(parent, "", true);
        setBackground(Color.BLACK);
        setLayout(new GridBagLayout());
        initComponents();
        pack();
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(false);
    }

    private void initComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        this.textPane = new JTextPaneUPTC();
        this.textPane.setPreferredSize(new Dimension(400, 300));
        this.textPane.setColorBack(Color.WHITE);
        gbc.insets = new Insets(15, 15, 15, 15);
        add(textPane, gbc);

    }

    public JTextPaneUPTC getTextPane() {
        return textPane;
    }

}
