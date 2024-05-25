package co.edu.uptc.view;

import co.edu.uptc.config.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPanelForm extends JPanelStart {
    private static final long serialVersionUID = 1L;
    private JTextPaneUPTC paneDataStyles;
    private JComboBoxUPTC styles;
    private JButtonUPTC goBack;

    public JPanelForm(ActionListener listener) {
        super(listener);
        initComponents2(listener);
        this.setVisible(false);
    }

    private void initComponents2(ActionListener listener) {
        getInfoPanel().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        getDimensionPanelLeft(gbc);
        firstLine(gbc);
        secondLine(gbc);
        thirdLine(listener, gbc);
    }

    private void getDimensionPanelLeft(GridBagConstraints gbc) {
        addImageUser(gbc);
        locateImageUser(gbc);
    }

    private void addImageUser(GridBagConstraints gbc){
        getImgUser().removeAll();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add(getImgUser(), gbc);
    }

    private void locateImageUser(GridBagConstraints gbc){
        gbc.gridx = 1;
        gbc.weightx = 1;
        add(getInfoPanel(), gbc);
        getImgUser().firstLineUser(96, 88);
        revalidate();
        repaint();
    }

    private void firstLine(GridBagConstraints gbc) {
        getInfoPanel().getTitle().setText("Choose your learning style");
        getInfoPanel().getTitle().setFont(new Font("Arial", Font.BOLD, 64));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(36, 250, 0, 126);
        getInfoPanel().add(getInfoPanel().getTitle(), gbc);
    }

    private void secondLine(GridBagConstraints gbc) {
        addTextPane();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 133, 0, 133);
        getInfoPanel().add(this.paneDataStyles, gbc);
    }

    private void addTextPane() {
        this.paneDataStyles = new JTextPaneUPTC();
        this.paneDataStyles.setText(Message.MESSAGE_LEARNING_STYLES);
        this.paneDataStyles.setColorBack(Color.LIGHT_GRAY);

    }

    private void thirdLine(ActionListener listener, GridBagConstraints gbc) {
        addComboStyles(listener,gbc);
        addButtonGoBack(listener,gbc);
        addButtonNext(listener,gbc);
    }

    private void addComboStyles(ActionListener listener, GridBagConstraints gbc){
        this.styles = new JComboBoxUPTC();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 47, 0);
        getInfoPanel().add(styles, gbc);
    }

    private void addButtonGoBack(ActionListener listener, GridBagConstraints gbc){
        this.goBack = new JButtonUPTC("Go Back");
        this.goBack.setActionCommand("GoBackCourses");
        this.goBack.addActionListener(listener);
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 100, 47, 0);
        getInfoPanel().add(this.goBack,gbc);
    }

    private void addButtonNext(ActionListener listener, GridBagConstraints gbc){
        getInfoPanel().getButton().setText("Register");
        getInfoPanel().getButton().setActionCommand("Record");
        getInfoPanel().getButton().addActionListener(listener);
        gbc.gridx = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(0, 0, 47, 100);
        getInfoPanel().add(getInfoPanel().getButton(), gbc);
    }

    public void loadComboBoxStyles(ArrayList<String> items) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
        model.addElement("Choose one");
        for (String item : items) {
            model.addElement(item);
        }
        this.styles.setModel(model);
    }

    public void cleanPanel() {
        this.styles.setSelectedItem("Choose one");
    }

    public String getSelectStyle() {
        return (String) styles.getSelectedItem();
    }
}
