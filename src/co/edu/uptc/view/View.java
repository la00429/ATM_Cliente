package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class View {

    private JOptionPane jOptionPane;
    private JFrameSystem frameApp;

    public View(ActionListener listener, WindowListener windowListener) {
        frameApp = new JFrameSystem(listener, windowListener);
    }

    public View() {
        this.jOptionPane = new JOptionPane();
    }

    public void showData(String message) {
        this.getFrameApp().showMessageInfo(message);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String readData(String message){
        return jOptionPane.showInputDialog(message);
    }

    public void loadCourse(String course) {
        this.getFrameApp().loadCourse(course);
    }

    public void loadUsers(ArrayList<String> users) {
        this.getFrameApp().loadComboUsers(users);
    }

    public void loadNameCourses(ArrayList<String> courses) {
        this.getFrameApp().loadComboCourses(courses);
    }

    public JFrameSystem getFrameApp() {
        return frameApp;
    }

    public void accessToLogin() {
        getFrameApp().stateCourse(false);
        getFrameApp().stateLoginUser(true);
    }

    public void accessToLoginAdmin() {
        getFrameApp().stateAdminPanel(false);
        getFrameApp().stateLoginUser(true);
    }

    public void goBackChangePassword(){
        getFrameApp().stateChangePassword(false);
        getFrameApp().stateLoginUser(true);
    }

    public void goBackCreateUser(){
        getFrameApp().stateCreateUser(false);
        getFrameApp().stateLoginUser(true);
    }

    public void goBackStyles(){
        getFrameApp().stateFormStyleLearning(false);
        getFrameApp().stateCreateUser(true);
    }

    public void accessCourse() {
        getFrameApp().stateLoginUser(false);
        getFrameApp().stateCourse(true);

    }

    public void loadNameUserCourse(String name) {
        this.getFrameApp().getCourse().setNameUser(name);
    }

    public void loadNameUserAdmin(String name) {
        this.getFrameApp().getAdminPanel().setNameUser(name);
    }

    public void accessCreate() {
        getFrameApp().stateLoginUser(false);
        getFrameApp().stateCreateUser(true);

    }

    public void accessCourseCreate() {
        getFrameApp().stateFormStyleLearning(false);
        getFrameApp().stateCourse(true);

    }

    public void accessChange() {
        getFrameApp().stateLoginUser(false);
        getFrameApp().stateChangePassword(true);

    }

    public void accessForm() {
        getFrameApp().stateCreateUser(false);
        getFrameApp().stateFormStyleLearning(true);

    }

    public void accessLoginChange() {
        getFrameApp().stateChangePassword(false);
        getFrameApp().stateLoginUser(true);

    }

    public void accessLoginErrorCreateUser(){
        getFrameApp().stateFormStyleLearning(false);
        getFrameApp().stateLoginUser(true);
    }

    public void accessAdminPanel() {
        getFrameApp().stateLoginUser(false);
        getFrameApp().stateAdminPanel(true);
    }

    public void cleanPanelLogin() {
        getFrameApp().getLoginUser().cleanPanel();
    }

    public void cleanCreateUser() {
        getFrameApp().getCreateUser().cleanPanel();
        getFrameApp().getFormStyleLearning().cleanPanel();
    }

    public void cleanChangePassword() {
        getFrameApp().getChangePassword().cleanPanel();
    }

    public void cleanAdminPanelUsers() {
        getFrameApp().getAdminPanel().cleanComboUsers();
    }

    public void cleanAdminPanelCourses() {
        getFrameApp().getAdminPanel().cleanComboCourses();
    }

    public void closeApp(){
        getFrameApp().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
