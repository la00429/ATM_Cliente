package co.edu.uptc.presenter;

import co.edu.uptc.config.Config;
import co.edu.uptc.config.Message;
import co.edu.uptc.model.Student;
import co.edu.uptc.model.User;
import co.edu.uptc.net.Connection;
import co.edu.uptc.net.Request;
import co.edu.uptc.net.Responsive;
import co.edu.uptc.persistence.LoadData;
import co.edu.uptc.view.View;
import com.google.gson.Gson;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;

public class Presenter implements ActionListener, WindowListener {

    private Connection connection;
    private View view;
    private LoadData loadData;

    public Presenter(String host) {
        try {
            this.connection = new Connection(host);
            loadProperties();
            this.view = new View(this, this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadData() {
        loadCourses();
        loadUsers();
        loadGender();
    }

    private void loadProperties() {
        this.loadData = new LoadData();
        Config config = new Config();
        config.loadMessages();
    }

    private void loadCourses() {
        try {
            connection.send(new Gson().toJson(new Request("Load_Courses")));
            Responsive response = new Gson().fromJson(connection.receive(), Responsive.class);
            view.loadNameCourses((ArrayList<String>) response.getCourseNames());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadUsers() {
        try {
            connection.send(new Gson().toJson(new Request("Load_Users")));
            Responsive response = new Gson().fromJson(connection.receive(), Responsive.class);
            view.loadUsers((ArrayList<String>) response.getCodeStudents());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadGender() {
        view.getFrameApp().loadComboGender(loadData.readTxt(Message.PATH_GENDER));
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
            switch (source) {
                case "Login":
                    verificationLogin();
                    break;
                case "Forgot":
                    forgotPassword();
                    break;
                case "Next":
                    createUserData();
                    break;
                case "Record":
                    loadDataCourse();
                    break;
                case "Accept":
                    updatePanelChangePasswaord();
                    break;
                case "Create":
                    changeToCreateUser();
                    break;
                case "BlockUser":
                    blockUser();
                    break;
                case "UnblockUser":
                    unblockUser();
                    break;
                case "BlockCourse":
                    blockCourse();
                    break;
                case "UnblockCourse":
                    unblockCourse();
                    break;
                case "CountStudents":
                    showCountCourse();
                    break;
                case "Logout":
                    logOutSystem();
                    break;
                case "GoBackChange":
                    goBackChangePassword();
                    break;
                case "GoBackCreate":
                    goBackCreateUser();
                    break;
                case "GoBackCourses":
                    goBackStyles();
                    break;
                case "LogoutAdmin":
                    logOutSystemAdmin();
                    break;
                case "Help":
                    showData(Message.HELP);
                    break;
                case "Us":
                    showData(Message.ABOUT_US);
                    break;
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

    private void verificationLogin() {
        String codeUser = view.getFrameApp().getLoginUser().getUserInput();
        String passwordUser = view.getFrameApp().getLoginUser().getPasswordInput();
        try {
            chooseUser(codeUser, passwordUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void chooseUser(String codeUser, String passwordUser) throws IOException {
        if (codeUser.equals("0") && passwordUser.equals("ADMIN")) {
            connection.send(new Gson().toJson(new Request("Login", codeUser, passwordUser)));
            showUserData(new Gson().fromJson(connection.receive(), Responsive.class).getVerification(), codeUser, passwordUser,"ADMIN");
        } else {
            connection.send(new Gson().toJson(new Request("Login", codeUser, passwordUser)));
            showUserData(new Gson().fromJson(connection.receive(), Responsive.class).getVerification(), codeUser, passwordUser, "student");
        }
    }

    private void showUserData(boolean verification, String codeUser, String passwordUser, String typeUser) throws IOException {
        if (verification) {
            loginAcess(codeUser, typeUser);
        } else {
            loginMessageShowUser(codeUser, passwordUser);
        }
    }

    private void loginMessageShowUser(String codeUser, String passwordUser) throws IOException {
        if (codeUser.isEmpty() || passwordUser.isEmpty()) {
            showData(Message.ERROR_NULL);
        } else {
            showData(Message.ERROR_NO_FOUND);
        }
    }

    private void forgotPassword() {
        view.accessChange();
    }

    private void createUserData() throws IOException {
        String name = view.getFrameApp().getCreateUser().getName();
        String gender = view.getFrameApp().getCreateUser().getSelectedGender();
        String code = view.getFrameApp().getCreateUser().getCode();
        String password = view.getFrameApp().getCreateUser().getPasswordInput();
        createUserMessage(name, gender, code, password);
    }

    private void createUserMessage(String name, String gender, String code, String password) throws IOException {
        if (name.isEmpty() || code.isEmpty() || gender.isEmpty() || password.isEmpty()) {
            showData(Message.ERROR_NULL);
        } else {
            connection.send(new Gson().toJson(new Request("Exist_User", code, 1)));
            Responsive response = new Gson().fromJson(connection.receive(), Responsive.class);
            loadMessageCreateUser(response);
        }
    }

    private void loadMessageCreateUser(Responsive response){
        if (response.getVerification()){
            showData(Message.ERROR_TWIN);
        } else {
            createUserNext();
        }
    }

    private void createUserNext() {
        view.accessForm();
    }

    private void logOutSystem() {
        view.accessToLogin();
    }

    private void logOutSystemAdmin() {
        view.accessToLoginAdmin();
    }

    private void goBackChangePassword() {
        view.goBackChangePassword();
    }

    private void goBackCreateUser() {
        view.goBackCreateUser();
    }

    private void goBackStyles() {
        view.goBackStyles();
    }

    private void changeToCreateUser() {
        view.accessCreate();
    }

    private void updatePanelChangePasswaord() throws IOException {
        String codeUser = view.getFrameApp().getChangePassword().getUserInput();
        String passwordUserNew = view.getFrameApp().getChangePassword().getPasswordInput();
        if (!codeUser.isEmpty() && !passwordUserNew.isEmpty()) {
            verificationUser(codeUser);
        } else {
            showData(Message.ERROR_NULL);
        }
    }

    private void verificationUser(String codeUser) throws IOException {
        connection.send(new Gson().toJson(new Request("Exist_User", codeUser, 1)));
        Responsive response = new Gson().fromJson(connection.receive(), Responsive.class);
        if (response.getVerification()) {
            updateStatePasword(codeUser);
        } else {
            showData(Message.ERROR_NO_FOUND);
        }
    }

    private void updateStatePasword(String codeUser) throws IOException {
        changeDataUser(codeUser);
        view.accessLoginChange();
        view.getFrameApp().getChangePassword().cleanPanel();
    }

    private void changeDataUser(String codeUser) throws IOException {
        connection.send(new Gson().toJson(new Request("Change_Password", codeUser, view.getFrameApp().getChangePassword().getPasswordInput())));
        Responsive response = new Gson().fromJson(connection.receive(), Responsive.class);
        if (response.getVerification()) {
            showData(Message.MESSAGE_CHANGES);
            view.cleanChangePassword();
        } else {
            showData(Message.MESSAGE_NO_CHANGES);
        }


    }

    private void loadDataCourse() throws IOException {
        getDataCourse();
        getDataUser();
        view.cleanCreateUser();
    }

    private void getDataCourse() throws IOException {
        String courseSelect = view.getFrameApp().selectCourse();
        String nameUser = view.getFrameApp().getCreateUser().getName();
        loadCourse(courseSelect, nameUser);
    }

    private void loadCourse(String courseSelect, String nameUser) throws IOException {
        connection.send(new Gson().toJson(new Request("Show_Course_CourseName", courseSelect, 2)));
        Responsive response = new Gson().fromJson(connection.receive(), Responsive.class);
        if (!response.getMessage().isEmpty()&& response.getMessage()!=null) {
           loadCourse(response, nameUser);
        } else {
            loadCourseError(response, nameUser);

        }
    }

    private void loadCourse(Responsive response,String nameUser){
        view.loadCourse(response.getMessage());
        view.getFrameApp().setNameUser(nameUser);
        view.accessCourseCreate();
    }

    private void loadCourseError(Responsive response, String nameUser ){
        view.showData(Message.ERROR_COURSE_NOT_AVAILABLE);
        view.loadCourse(response.getMessage());
        view.getFrameApp().setNameUser(nameUser);
        view.accessCourseCreate();
    }

    private void getDataUser() throws IOException {
        String name = view.getFrameApp().getCreateUser().getName();
        String gender = view.getFrameApp().getCreateUser().getSelectedGender();
        String styleLearning = view.getFrameApp().getFormStyleLearning().getSelectStyle();
        String code = view.getFrameApp().getCreateUser().getCode();
        String password = view.getFrameApp().getCreateUser().getPasswordInput();
        loadDataUser(name, gender, styleLearning, code, password);
    }

    private void loadDataUser(String name,String gender,String styleLearning,  String code, String password ) throws IOException {
        connection.send(new Gson().toJson(new Request("Add_User", new Student(name,gender,styleLearning, new User(code, password)))));
        Responsive response = new Gson().fromJson(connection.receive(), Responsive.class);
        showMessageAddUser(response);
    }

    private void showMessageAddUser(Responsive response) {
        if (response.getVerification()) {
            showData(Message.MESSAGE_SUCCESS);
        } else {
            showData(Message.MESSAGE_NO_SUCCESS);
            view.accessLoginErrorCreateUser();
        }
    }

    private void loginAcess(String codeUser,String typeUser) throws IOException {
        switch (typeUser) {
            case "ADMIN":
                acessAdmin(codeUser, typeUser);
                break;
            case "student":
                acessStudent(codeUser, typeUser);
                break;
        }
    }

    private void acessAdmin(String codeUser,String typeUser) throws IOException {
        view.getFrameApp().stateLoginUser(false);
        showName(codeUser, typeUser);
        view.accessAdminPanel();
        view.cleanPanelLogin();
    }

    private void acessStudent(String codeUser,String typeUser) throws IOException {
        view.getFrameApp().stateLoginUser(false);
        showName(codeUser, typeUser);
        selectCourse(codeUser);
        view.accessCourse();
        view.cleanPanelLogin();
    }


    private void selectCourse(String codeUser) throws IOException {
        connection.send(new Gson().toJson(new Request("Show_Course_CodeUser", codeUser, 1)));
        Responsive response = new Gson().fromJson(connection.receive(), Responsive.class);
        loadCoursePage(response);
    }

    private void loadCoursePage(Responsive response){
        if (!response.getMessage().isEmpty() && !response.getMessage().equals("null")) {
            view.getFrameApp().getCourse().getWebCourse().loadPage(response.getMessage());
        }else{
            view.showData(Message.ERROR_COURSE_NOT_AVAILABLE);
            view.getFrameApp().getCourse().getWebCourse().loadPage(response.getMessage());
        }
    }

    private void showName(String codeUser, String typeUser) throws IOException {
        if (typeUser.equals("ADMIN")) {
            connection.send(new Gson().toJson(new Request("Show_Name", codeUser, 1)));
            view.loadNameUserAdmin(new Gson().fromJson(connection.receive(), Responsive.class).getMessage());
        } else {
            connection.send(new Gson().toJson(new Request("Show_Name", codeUser, 1)));
            view.loadNameUserCourse(new Gson().fromJson(connection.receive(), Responsive.class).getMessage());
        }
    }

    private void blockUser() {
        String codeUser = view.getFrameApp().getAdminPanel().getSelectedUser();
        try {
            connection.send(new Gson().toJson(new Request("Block_User", codeUser, 1)));
            Responsive response = new Gson().fromJson(connection.receive(), Responsive.class);
            showMessageBlockUser(response);
            view.cleanAdminPanelUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showMessageBlockUser(Responsive response){
        if (response.getVerification()) {
            showData(Message.MESSAGE_BLOCK_USER);
        } else {
            showData(Message.MESSAGE_ERROR_BLOCK_USER);
        }
    }

    private void unblockUser() {
        String codeUser = view.getFrameApp().getAdminPanel().getSelectedUser();
        try {
            connection.send(new Gson().toJson(new Request("Unblock_User", codeUser, 1)));
            Responsive response = new Gson().fromJson(connection.receive(), Responsive.class);
            showMessageUnBlockUser(response);
            view.cleanAdminPanelUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showMessageUnBlockUser(Responsive response){
        if (response.getVerification()) {
            showData(Message.MESSAGE_UNBLOCK_USER);
        } else {
            showData(Message.MESSAGE_ERROR_UNBLOCK_USER);
        }
    }

    private void blockCourse() {
        String courseName = view.getFrameApp().getAdminPanel().getSelectedCourse();
        try {
            connection.send(new Gson().toJson(new Request("Block_Course", courseName, 2)));
            Responsive response = new Gson().fromJson(connection.receive(), Responsive.class);
            showMessageBlockCourse(response);
            view.cleanAdminPanelCourses();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showMessageBlockCourse(Responsive response){
        if (response.getVerification()) {
            showData(Message.MESSAGE_BLOCK_COURSE);
        } else {
            showData(Message.MESSAGE_ERROR_BLOCK_COURSE);
        }
    }

    private void unblockCourse() {
        String courseName = view.getFrameApp().getAdminPanel().getSelectedCourse();
        try {
            connection.send(new Gson().toJson(new Request("Unblock_Course", courseName, 2)));
            Responsive response = new Gson().fromJson(connection.receive(), Responsive.class);
            messagesUnLockCourse(response);
            view.cleanAdminPanelCourses();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCountCourse() {
        try {
            connection.send(new Gson().toJson(new Request("Show_Count_Course",view.getFrameApp().getAdminPanel().getSelectedCourse(),2)));
            Responsive response = new Gson().fromJson(connection.receive(), Responsive.class);
            view.loadCountCourse(response.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void messagesUnLockCourse(Responsive response){
        if (response.getVerification()) {
            showData(Message.MESSAGE_UNBLOCK_COURSE);
        } else {
            showData(Message.MESSAGE_ERROR_UNBLOCK_COURSE);
        }
    }

    private void showData(String message) {
        view.showData(message);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            connection.send(new Gson().toJson(new Request("Disconnect")));
            view.showMessage(new Gson().fromJson(connection.receive(), Responsive.class).getMessage());
            connection.disconnect();
            System.exit(0);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
