package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class JFrameSystem extends JFrame {
    private JPanelLogin loginUser;
    private JPanelCreateUser createUser;
    private JPanelForm formStyleLearning;
    private JChangePassword changePassword;
    private JPanelCourse course;
    private JPanelAdmin adminPanel;
    private JDialogUPTC showInfo;

    public JFrameSystem(ActionListener listener, WindowListener windowListener) {
        super("Lets learn together");
        this.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width,
                Toolkit.getDefaultToolkit().getScreenSize().height));
        this.setBackground(new Color(255, 255, 255));
        this.addWindowListener(windowListener);
        initComponents(listener);
        pack();
        this.setVisible(true);
    }

    private void initComponents(ActionListener listener) {
        createUser = new JPanelCreateUser(listener);
        formStyleLearning = new JPanelForm(listener);
        changePassword = new JChangePassword(listener);
        course = new JPanelCourse(listener);
        adminPanel = new JPanelAdmin(listener);
        loginUser = new JPanelLogin(listener);
        this.add(loginUser);
    }

    public void showMessageInfo(String message) {
        this.showInfo = new JDialogUPTC(this);
        this.showInfo.getTextPane().setText(message);
        this.showInfo.setVisible(true);
    }

    public void stateLoginUser(boolean state) {
        this.add(loginUser);
        this.loginUser.setVisible(state);
    }

    public void stateCreateUser(boolean state) {
        this.add(createUser);
        this.createUser.setVisible(state);
    }

    public void stateFormStyleLearning(boolean state) {
        this.add(formStyleLearning);
        this.formStyleLearning.setVisible(state);
    }

    public void stateChangePassword(boolean state) {
        this.add(changePassword);
        this.changePassword.setVisible(state);
    }

    public void stateAdminPanel(boolean state) {
        this.add(adminPanel);
        this.adminPanel.setVisible(state);
    }

    public void stateCourse(boolean state) {
        this.add(course);
        this.course.setVisible(state);
    }

    public void loadComboGender(ArrayList<String> items) {
        this.createUser.loadComboBoxGender(items);
    }

    public void loadComboCourses(ArrayList<String> items) {
        this.formStyleLearning.loadComboBoxStyles(items);
        this.adminPanel.loadComboBoxCourses(items);
    }
    public void loadComboUsers(ArrayList<String> items) {
        this.adminPanel.loadComboBoxUsers(items);
    }

    public String selectCourse() {
        return this.formStyleLearning.getSelectStyle();
    }

    public void setNameUser(String name) {
        this.course.setNameUser(name);
    }

    public void loadCourse(String path) {
        this.course.loadCourse(path);
    }

    public JPanelLogin getLoginUser() {
        return loginUser;
    }

    public JPanelCreateUser getCreateUser() {
        return createUser;
    }

    public JPanelForm getFormStyleLearning() {
        return formStyleLearning;
    }

    public JChangePassword getChangePassword() {
        return changePassword;
    }

    public JPanelCourse getCourse() {
        return course;
    }

    public JPanelAdmin getAdminPanel() {
        return adminPanel;
    }
}
