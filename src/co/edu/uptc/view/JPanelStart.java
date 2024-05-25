package co.edu.uptc.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class JPanelStart extends JPanel {
    private JPanelStartLeft imgUser;
    private JPanelStartRight infoPanel;

    public JPanelStart(ActionListener listener) {
        this.setBackground(new Color(255, 255, 255));
        this.setLayout(new GridBagLayout());
        initComponents(listener);
        this.setVisible(true);
    }

    private void initComponents(ActionListener listener) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        imgUser = new JPanelStartLeft(listener);
        add(imgUser, gbc);

        gbc.gridx = 1;
        infoPanel = new JPanelStartRight();
        add(infoPanel, gbc);
    }

    public JPanelStartLeft getImgUser() {
        return imgUser;
    }

    public JPanelStartRight getInfoPanel() {
        return infoPanel;
    }

}
