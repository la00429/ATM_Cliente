package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPanelCreateUser extends JPanelStart {
    private JLabel name;
    private JTextFieldUPTC nameInput;
    private JLabel code;
    private JTextFieldUPTC codeInput;
    private JLabel gender;
    private JComboBox<String> genderInput;
    private JLabel password;
    private JPasswordUPTC passwordInput;

    public JPanelCreateUser(ActionListener listener) {
        super(listener);
        initComponents2(listener);
        this.setVisible(false);
    }

    private void initComponents2(ActionListener listener) {
        getInfoPanel().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        firstLine(gbc);
        secondLine(gbc);
        thirdLine(gbc);
        fourLine(gbc);
        fiveLine(gbc);
        sixLine(gbc);
        sevenLine(gbc);
        eightLine(gbc);
        nineLine(gbc);
        tenLine(listener, gbc);
    }

    private void firstLine(GridBagConstraints gbc) {
        getInfoPanel().getTitle().setText("Create User");
        getInfoPanel().getTitle().setFont(new Font("Arial", Font.BOLD, 64));
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(30, 30, 20, 0);
        getInfoPanel().add(getInfoPanel().getTitle(), gbc);
    }

    private void secondLine(GridBagConstraints gbc) {
        this.name = new JLabel("Name");
        this.name.setFont(new Font("Arial", Font.PLAIN, 32));
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(20, 30, 0, 0);
        getInfoPanel().add(name, gbc);

    }

    private void thirdLine(GridBagConstraints gbc) {
        this.nameInput = new JTextFieldUPTC();
        gbc.insets = new Insets(0, 30, 5, 0);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        getInfoPanel().add(nameInput, gbc);
    }

    private void fourLine(GridBagConstraints gbc) {
        this.code = new JLabel("Code");
        this.code.setFont(new Font("Arial", Font.PLAIN, 32));
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(20, 30, 0, 0);
        getInfoPanel().add(code, gbc);

    }

    private void fiveLine(GridBagConstraints gbc) {
        this.codeInput = new JTextFieldUPTC();
        gbc.insets = new Insets(0, 30, 5, 0);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        getInfoPanel().add(codeInput, gbc);
    }

    private void sixLine(GridBagConstraints gbc) {
        this.gender = new JLabel("Sex");
        this.gender.setFont(new Font("Arial", Font.PLAIN, 32));
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(20, 30, 0, 0);
        getInfoPanel().add(gender, gbc);

    }

    private void sevenLine(GridBagConstraints gbc) {
        this.genderInput = new JComboBoxUPTC();
        gbc.insets = new Insets(0, 30, 5, 0);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        getInfoPanel().add(genderInput, gbc);
    }

    private void eightLine(GridBagConstraints gbc) {
        this.password = new JLabel("Password");
        this.password.setFont(new Font("Arial", Font.PLAIN, 32));
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(20, 30, 0, 0);
        getInfoPanel().add(password, gbc);

    }

    private void nineLine(GridBagConstraints gbc) {
        this.passwordInput = new JPasswordUPTC();
        gbc.insets = new Insets(0, 30, 5, 0);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        getInfoPanel().add(passwordInput, gbc);
    }

    private void tenLine(ActionListener listener, GridBagConstraints gbc) {
        getInfoPanel().getButton().setText("Next");
        getInfoPanel().getButton().setActionCommand("Next");
        getInfoPanel().getButton().addActionListener(listener);
        gbc.insets = new Insets(30, 30, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        getInfoPanel().add(getInfoPanel().getButton(), gbc);
    }

    public void loadComboBoxGender(ArrayList<String> items) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
        model.addElement("Choose one");
        for (String item : items) {
            model.addElement(item);
        }
        this.genderInput.setModel(model);
    }

    public void cleanPanel() {
        this.nameInput.setText("");
        this.codeInput.setText("");
        this.genderInput.setSelectedItem("Choose one");
        this.passwordInput.setText("");
    }

    public String getName() {
        return nameInput.getText();
    }

    public String getCode() {
        return codeInput.getText();
    }

    public String getSelectedGender() {
        return (String) genderInput.getSelectedItem();
    }

    public String getPasswordInput() {
        char[] passwordChars = passwordInput.getPassword();
        return new String(passwordChars);
    }
}
