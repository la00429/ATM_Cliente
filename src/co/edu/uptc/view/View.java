package co.edu.uptc.view;

import java.awt.event.ActionListener;

public class View {
    private JFrameSystem frameApp;

    public View(ActionListener listener) {
        frameApp = new JFrameSystem(listener);
    }

    public void showData(String message) {
        this.getFrameApp().showMessageInfo(message);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void setCourse(String course) {
        this.getFrameApp().setCourse(course);
    }

    public JFrameSystem getFrameApp() {
        return frameApp;
    }

    public void accessLogin() {
        getFrameApp().stateCourse(false);
        getFrameApp().stateLoginUser(true);

    }

    public void accessCourse() {
        getFrameApp().stateLoginUser(false);
        getFrameApp().stateCourse(true);

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

}
