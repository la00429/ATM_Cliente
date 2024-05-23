package co.edu.uptc.presenter;

import co.edu.uptc.model.Student;
import co.edu.uptc.model.User;
import co.edu.uptc.net.Connection;
import co.edu.uptc.net.Request;
import co.edu.uptc.net.Responsive;
import co.edu.uptc.view.View;
import com.google.gson.Gson;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.util.ArrayList;

public class Presenter extends MouseAdapter implements ActionListener {

    private Connection connection;
    private View view;

    public Presenter() {
        try {
            this.connection = new Connection();
            this.view = new View(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadData() {
        loadStyles();
        loadGender();
    }

    private void loadStyles() {
        try {
            connection.send(new Gson().toJson(new Request("Load_Styles")));
            view.getFrameApp().loadComboStyles((ArrayList<String>) new Gson().fromJson(connection.receive(), Responsive.class).getStylesLearning());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadGender() {
        try {
            connection.send(new Gson().toJson(new Request("Gender")));
            view.getFrameApp().loadComboGender((ArrayList<String>) new Gson().fromJson(connection.receive(), Responsive.class).getGenders());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            establishConnection();
            loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        try {
        String source = e.getActionCommand();
        if (source.equals("Login")) {
            verificationLogin();
        }

        if (source.equals("Forgot")) {
            forgotPassword();
        }

        if (source.equals("Next")) {
            createUserData();
        }

        if (source.equals("Record")) {
            loadDataCourse();
        }

        if (source.equals("Accept")) {
            updatePanelChangePasswaord();
        }

        if (source.equals("Create")) {
            changeToCreateUser();
        }

            if (source.equals("BlockUser")) {
                blockUser();
            }

            if (source.equals("UnblockUser")) {
                unblockUser();
            }

            if (source.equals("BlockCourse")) {
                blockCourse();
            }

            if (source.equals("UnblockCourse")) {
                unblockCourse();
            }

        if (source.equals("Logout")) {
            logOutSystem();
        }

        if (source.equals("Help")) {
            connection.send(new Gson().toJson(new Request("Help")));
            showData(new Gson().fromJson(connection.receive(), Responsive.class).getMessage());
        }

        if (source.equals("Us")) {
            connection.send(new Gson().toJson(new Request("Us")));
            showData(new Gson().fromJson(connection.receive(), Responsive.class).getMessage());

        }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void establishConnection() throws IOException {
        try {
            connection.connect();
            view.showMessage(new Gson().fromJson(connection.receive(), Responsive.class).getMessage());
            connection.send(new Gson().toJson(new Responsive("Client connected to server")));
        } catch (IOException e) {
            view.showMessage(e.getMessage());
        }
    }

    public void verificationLogin() {
        String codeUser = view.getFrameApp().getLoginUser().getUserInput();
        System.out.println(codeUser);
        String passwordUser = view.getFrameApp().getLoginUser().getPasswordInput();
        System.out.println(passwordUser);
        try {
            chooseUser(codeUser, passwordUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void chooseUser(String codeUser, String passwordUser) throws IOException {
        if (codeUser.equals("0") && passwordUser.equals("ADMIN")) {
            connection.send(new Gson().toJson(new Request("Login", codeUser, passwordUser, "ADMIN")));
            showUserData(new Gson().fromJson(connection.receive(), Responsive.class).getVerification(), codeUser, passwordUser);
        } else {
            connection.send(new Gson().toJson(new Request("Login", codeUser, passwordUser, "student")));
            showUserData(new Gson().fromJson(connection.receive(), Responsive.class).getVerification(), codeUser, passwordUser);
        }
    }

    private void showUserData(boolean verification, String codeUser, String passwordUser) throws IOException {
        System.out.println(verification);
        if (verification) {
            loginAcess(codeUser);
        } else {
            loginMessage(codeUser, passwordUser);
        }
    }

    public void forgotPassword() {
        view.accessChange();
    }

    public void createUserData() throws IOException {
        String name = view.getFrameApp().getCreateUser().getName();
        String gender = view.getFrameApp().getCreateUser().getSelectedGender();
        String code = view.getFrameApp().getCreateUser().getCode();
        String password = view.getFrameApp().getCreateUser().getPasswordInput();
        createUserMessage(name, gender, code, password);
    }

    private void createUserMessage(String name, String gender, String code, String password) throws IOException {
        if (name.isEmpty() || code.isEmpty() || gender.isEmpty() || password.isEmpty()) {
            try {
                connection.send(new Gson().toJson(new Request("Error_Null")));
                showData(new Gson().fromJson(connection.receive(), Responsive.class).getMessage());

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            connection.send(new Gson().toJson(new Request("Error_Twin")));
            Responsive response = new Gson().fromJson(connection.receive(), Responsive.class);
            System.out.println(response.getMessage());
            if (response.getVerification()){
                showData(response.getMessage());
            } else {
                createUserNext();
            }
        }
    }

    public void logOutSystem() {
        view.accessLogin();
    }

    public void changeToCreateUser() {
        view.accessCreate();
    }

    public void updatePanelChangePasswaord() throws IOException {
        String codeUser = view.getFrameApp().getChangePassword().getUserInput();
        String passwordUserNew = view.getFrameApp().getChangePassword().getPasswordInput();
        if (!codeUser.isEmpty() && !passwordUserNew.isEmpty()) {
            verificationUser(codeUser);
        } else {
            connection.send(new Gson().toJson(new Request("Error_Null")));
            view.getFrameApp().showMessageInfo(new Gson().fromJson(connection.receive(), Responsive.class).getMessage());
        }
    }

    private void verificationUser(String codeUser) throws IOException {
        connection.send(new Gson().toJson(new Request("Exist_User", codeUser, 1)));
        Responsive response = new Gson().fromJson(connection.receive(), Responsive.class);
        if (response.getVerification()) {
            updateStatePasword(codeUser);
        } else {
            view.getFrameApp().showMessageInfo(response.getMessage());
        }
    }

    private void updateStatePasword(String codeUser) throws IOException {
        changeDataUser(codeUser);
        view.accessLoginChange();
        view.getFrameApp().getChangePassword().cleanPanel();
    }

    private void changeDataUser(String codeUser) throws IOException {
        connection.send(new Gson().toJson(new Request("Change_Password", codeUser, view.getFrameApp().getChangePassword().getPasswordInput())));
        view.showData(new Gson().fromJson(connection.receive(), Responsive.class).getMessage());

    }

    public void loadDataCourse() throws IOException {
        getDataCourse();
        getDataUser();
        cleanDataPanel();
    }

    private void getDataCourse() throws IOException {
        String courseSelect = view.getFrameApp().selectCourse();
        String nameUser = view.getFrameApp().getCreateUser().getName();
        loadCourse(courseSelect, nameUser);
    }

    private void loadCourse(String courseSelect, String nameUser) throws IOException {
        connection.send(new Gson().toJson(new Request("Show_Course_CourseName", courseSelect, 2)));
        view.getFrameApp().setCourse(new Gson().fromJson(connection.receive(), Responsive.class).getMessage());
        view.getFrameApp().setNameUser(nameUser);
        view.accessCourseCreate();
    }

    private void getDataUser() throws IOException {
        String name = view.getFrameApp().getCreateUser().getName();
        String gender = view.getFrameApp().getCreateUser().getSelectedGender();
        String styleLearning = view.getFrameApp().getFormStyleLearning().getSelectStyle();
        String code = view.getFrameApp().getCreateUser().getCode();
        String password = view.getFrameApp().getCreateUser().getPasswordInput();
        loadDataUser(name,gender,styleLearning, password, code);
    }

    private void loadDataUser(String name,String gender,String styleLearning,  String code, String password ) throws IOException {
        connection.send(new Gson().toJson(new Request("Add_User", new Student(name,gender,styleLearning, new User(code, password)))));
        showData(new Gson().fromJson(connection.receive(), Responsive.class).getMessage());
    }

    private void cleanDataPanel() {
        view.getFrameApp().getCreateUser().cleanPanel();
        view.getFrameApp().getFormStyleLearning().cleanPanel();
    }

    private void createUserNext() {
        view.accessForm();
    }

    private void loginAcess(String codeUser) throws IOException {
        view.getFrameApp().stateLoginUser(false);
        showName(codeUser);
        selectCourse(codeUser);
        view.accessCourseCreate();
        view.getFrameApp().getLoginUser().cleanPanel();
    }

    private void loginMessage(String codeUser, String passwordUser) throws IOException {
        if (codeUser.isEmpty() || passwordUser.isEmpty()) {
            connection.send(new Gson().toJson(new Request("Error_Null")));
            showData(new Gson().fromJson(connection.receive(), Responsive.class).getMessage());
        } else {
            connection.send(new Gson().toJson(new Request("Error_No_Found")));
            showData(new Gson().fromJson(connection.receive(), Responsive.class).getMessage());
        }
    }

    private void selectCourse(String codeUser) throws IOException {
        connection.send(new Gson().toJson(new Request("Show_Course_CodeUser", codeUser, 1)));
        view.getFrameApp().getCourse().getWebCourse().loadPage(new Gson().fromJson(connection.receive(), Responsive.class).getMessage());
    }

    private void showName(String codeUser) throws IOException {
        connection.send(new Gson().toJson(new Request("Show_Name", codeUser, 1)));
        view.getFrameApp().getCourse().setNameUser(new Gson().fromJson(connection.receive(), Responsive.class).getMessage());
    }

    private void blockUser() {
    }

    private void unblockUser() {
    }

    private void blockCourse() {
    }

    private void unblockCourse() {
    }

    public void showData(String message) {
        view.showData(message);
    }

}
