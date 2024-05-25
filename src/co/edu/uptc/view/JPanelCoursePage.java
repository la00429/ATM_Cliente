package co.edu.uptc.view;

import co.edu.uptc.config.Message;

import javax.swing.*;
import java.awt.*;

public class JPanelCoursePage extends JPanel {

    private JEditorPane editorPane;

    public JPanelCoursePage() {
        setLayout(new BorderLayout());
        editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        editorPane.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(editorPane);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void loadPage(String htmlContent) {
        try {
            editorPane.setContentType("text/html");
            editorPane.setText(htmlContent);
        } catch (Exception e) {
            e.printStackTrace();
            editorPane.setText(Message.ERROR_LOAD_PAGE);
        }

    }
}
