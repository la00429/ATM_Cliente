package co.edu.uptc.presenter;

import co.edu.uptc.net.Connection;
import co.edu.uptc.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;

public class Presenter_Server extends MouseListener implements ActionListener, Contracts.IPresenter{
    private Contracts.IView view;
    private Connection connection;

    public Presenter_Server() throws IOException {
        this.view = new View(this, this);
        this.connection = new Connection();
    }

    @Override
        public void actionPerformed(ActionEvent e) {
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

            if (source.equals("Logout")) {
                logOutSystem();
            }

            if (source.equals("Help")) {
                showData(Message.HELP);

            }

            if (source.equals("Us")) {
                showData(Message.ABOUT_US);
            }

        }

}
