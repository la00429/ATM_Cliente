package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JChangePassword extends JPanelStart {
    private JLabel code;
    private JTextFieldUPTC codeInput;
    private JLabel password;
    private JPasswordUPTC passwordInput;
    private JButtonUPTC goBack;

    public JChangePassword(ActionListener listener) {
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
        sixLine(listener, gbc);
    }

    private void firstLine(GridBagConstraints gbc) {
        getInfoPanel().getTitle().setText("Change Password");
        getInfoPanel().getTitle().setFont(new Font("Arial", Font.BOLD, 64));
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(30, 30, 20, 0);
        getInfoPanel().add(getInfoPanel().getTitle(), gbc);
    }

    private void secondLine(GridBagConstraints gbc) {
        this.code = new JLabel("Code");
        this.code.setFont(new Font("Arial", Font.PLAIN, 32));
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(70, 100, 0, 100);
        getInfoPanel().add(code, gbc);

    }

    private void thirdLine(GridBagConstraints gbc) {
        this.codeInput = new JTextFieldUPTC();
        gbc.insets = new Insets(0, 100, 30, 100);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        getInfoPanel().add(codeInput, gbc);

    }

    private void fourLine(GridBagConstraints gbc) {
        this.password = new JLabel("Password");
        this.password.setFont(new Font("Arial", Font.PLAIN, 32));
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(30, 100, 0, 100);
        getInfoPanel().add(password, gbc);

    }

    private void fiveLine(GridBagConstraints gbc) {
        this.passwordInput = new JPasswordUPTC();
        gbc.insets = new Insets(0, 100, 70, 100);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        getInfoPanel().add(passwordInput, gbc);
    }

    private void sixLine(ActionListener listener, GridBagConstraints gbc) {
        addButtonGoBack(listener,gbc);
        addButtonAccept(listener,gbc);

    }

    private void addButtonAccept(ActionListener listener, GridBagConstraints gbc){
        getInfoPanel().getButton().setText("Accept");
        getInfoPanel().getButton().setActionCommand("Accept");
        getInfoPanel().getButton().addActionListener(listener);
        gbc.insets = new Insets(0, 10, 0, 0);
        getInfoPanel().add(getInfoPanel().getButton(), gbc);
    }

    private void addButtonGoBack(ActionListener listener, GridBagConstraints gbc){
        this.goBack = new JButtonUPTC("Go Back");
        this.goBack.setActionCommand("GoBackChange");
        this.goBack.addActionListener(listener);
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 100, 0, 0);
        getInfoPanel().add(this.goBack,gbc);
    }

    public void cleanPanel() {
        this.codeInput.setText("");
        this.passwordInput.setText("");
    }

    public String getUserInput() {
        return codeInput.getText();
    }

    public String getPasswordInput() {
        char[] passwordChars = passwordInput.getPassword();
        return new String(passwordChars);
    }

}
