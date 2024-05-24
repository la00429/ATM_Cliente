package co.edu.uptc.view;

import co.edu.uptc.config.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.util.ArrayList;

public class JPanelAdmin extends JPanelStart {

    private JPanel optionsMenu;
    private JButtonTraspUPTC logout;
    private JLabel name;
    private JTextPaneUPTC subTitle;
    private JComboBoxUPTC comboBoxUsers;
    private JButtonUPTC blockUser;
    private JButtonUPTC unblockUser;
    private JComboBoxUPTC comboBoxCourses;
    private JButtonUPTC blockCourse;
    private JButtonUPTC unblockCourse;

    public JPanelAdmin(ActionListener listener) {
        super(listener);
        initComponents2(listener);
        this.setVisible(false);
    }

    private void initComponents2(ActionListener listener) {
        GridBagConstraints gbc = new GridBagConstraints();
        getDimensionPanelLeft(listener, gbc);
        firstLine(gbc, listener);
        secondLine(gbc);
        thirdLine(gbc);
        fourLine(gbc, listener);
    }

    private void getDimensionPanelLeft(ActionListener listener, GridBagConstraints gbc) {
        panelLeft(gbc);
        panelRight(gbc);
        addNewComponents(listener);
    }

    private void panelRight(GridBagConstraints gbc) {
        getInfoPanel().setLayout(new GridBagLayout());
        gbc.gridx = 1;
        gbc.weightx = 1;
        add(getInfoPanel(), gbc);
    }

    private void panelLeft(GridBagConstraints gbc) {
        getImgUser().remove(getImgUser().getImgUserGrey());
        getImgUser().remove(getImgUser().getImgUPTC());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add(getImgUser(), gbc);
    }

    private void addNewComponents(ActionListener listener) {
        getImgUser().firstLineUser(96, 88);
        getImgUser().setInfo("Help");
        revalidate();
        repaint();
    }

    private void firstLine(GridBagConstraints gbc, ActionListener listener) {
        this.optionsMenu = new JPanel();
        this.optionsMenu.setPreferredSize(new Dimension(getWidth(), 20));
        this.optionsMenu.setLayout(new GridBagLayout());
        this.optionsMenu.setBackground(new Color(248, 203, 46));
        addButton(gbc, listener);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        getInfoPanel().add(this.optionsMenu, gbc);

    }

    private void addButton(GridBagConstraints gbc, ActionListener listener) {
        this.logout = new JButtonTraspUPTC("");
        this.logout.setIcon(modiImage());
        this.logout.setActionCommand("LogoutAdmin");
        this.logout.addActionListener(listener);
        gbc.insets = new Insets(16, 0, 10, 80);
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        gbc.fill = GridBagConstraints.NONE;
        this.optionsMenu.add(logout, gbc);
    }

    private ImageIcon modiImage() {
        ImageIcon imageIcon = new ImageIcon("img/logout.png");
        Image originalImage = imageIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(52, 65, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    private void secondLine(GridBagConstraints gbc) {
        this.name = new JLabel();
    }

    private void thirdLine(GridBagConstraints gbc) {
        this.subTitle = new JTextPaneUPTC();
        this.subTitle.setColorBack(Color.white);
        this.subTitle.setPreferredSize(new Dimension(12, 12));
        addTextPane();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(160, 76, 0, 61);
        getInfoPanel().add(subTitle, gbc);
    }

    private void addTextPane() {
        this.subTitle.setText(Message.MESSAGE_WELCOME_ADMIN);
    }

    private void fourLine(GridBagConstraints gbc, ActionListener listener) {
        addComboBoxUsers(gbc);
        addComboBoxCourses(gbc);
        addButtonBlockUser(listener, gbc);
        addButtonUnblockUser(listener, gbc);
        addButtonBlockCourse(listener, gbc);
        addButtonUnblockCourse(listener, gbc);
    }

    public void setNameUser(String text) {
        GridBagConstraints gbc = new GridBagConstraints();
        this.name = new JLabel();
        this.name.setText(text);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(100, 76, 0, 0);
        getInfoPanel().getTitle().setText("Hello " + this.name.getText());
        getInfoPanel().getTitle().setPreferredSize(new Dimension(getWidth(), 76));
        getInfoPanel().getTitle().setFont(new Font("Arial", Font.BOLD, 64));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        getInfoPanel().add(getInfoPanel().getTitle(), gbc);
    }

    public void addComboBoxUsers(GridBagConstraints gbc) {
        addLabelUsers(gbc);
        this.comboBoxUsers = new JComboBoxUPTC();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(50, 236, 0, 700);
        getInfoPanel().add(comboBoxUsers, gbc);
    }

    public void addLabelUsers( GridBagConstraints gbc) {
        JLabel label = new JLabel(Message.MESSAGE_TITLE_USERS);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 236, 0, 700);
        getInfoPanel().add(label, gbc);
    }
    public void addComboBoxCourses(GridBagConstraints gbc) {
        addLabelCourses(gbc);
        this.comboBoxCourses = new JComboBoxUPTC();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(50, 700, 0, 236);
        getInfoPanel().add(comboBoxCourses, gbc);
    }

    public void addLabelCourses( GridBagConstraints gbc) {
        JLabel label = new JLabel(Message.MESSAGE_TITLE_COURSES);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 700, 0, 236);
        getInfoPanel().add(label, gbc);
    }
    public void addButtonBlockUser(ActionListener listener, GridBagConstraints gbc) {
        this.blockUser = new JButtonUPTC("Block User");
        this.blockUser.setActionCommand("BlockUser");
        this.blockUser.addActionListener(listener);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(200, 236, 0, 700);
        getInfoPanel().add(blockUser, gbc);
    }

    public void addButtonUnblockUser(ActionListener listener, GridBagConstraints gbc) {
        this.unblockUser = new JButtonUPTC("Unblock User");
        this.unblockUser.setActionCommand("UnblockUser");
        this.unblockUser.addActionListener(listener);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(250, 236, 0, 700);
        getInfoPanel().add(unblockUser, gbc);
    }

    public void addButtonBlockCourse(ActionListener listener, GridBagConstraints gbc) {
        this.blockCourse = new JButtonUPTC("Block Course");
        this.blockCourse.setActionCommand("BlockCourse");
        this.blockCourse.addActionListener(listener);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(200, 700, 0, 236);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        getInfoPanel().add(blockCourse, gbc);
    }

    public void addButtonUnblockCourse(ActionListener listener, GridBagConstraints gbc) {
        this.unblockCourse = new JButtonUPTC("Unblock Course");
        this.unblockCourse.setActionCommand("UnblockCourse");
        this.unblockCourse.addActionListener(listener);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(250, 700, 10, 236);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        getInfoPanel().add(unblockCourse, gbc);
    }

    public void loadComboBoxUsers(ArrayList<String> items) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
        model.addElement("Choose one");
        for (String item : items) {
            model.addElement(item);
        }
        this.comboBoxUsers.setModel(model);
    }

    public void loadComboBoxCourses(ArrayList<String> items) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
        model.addElement("Choose one");
        for (String item : items) {
            model.addElement(item);
        }
        this.comboBoxCourses.setModel(model);
    }

    public String getSelectedUser() {
        return (String) this.comboBoxUsers.getSelectedItem();

    }

    public String getSelectedCourse() {
        return (String) this.comboBoxCourses.getSelectedItem();
    }

    public void cleanComboUsers() {
        this.comboBoxUsers.setSelectedItem("Choose one");
    }

    public void cleanComboCourses() {
        this.comboBoxCourses.setSelectedItem("Choose one");
    }

}
