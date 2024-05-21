package co.edu.uptc.view;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;

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
        try{
			editorPane.setPage(htmlContent);
		}catch (IOException e) {
			e.printStackTrace();
			editorPane.setText("<html><body><h1>Error loading page</h1><p>Could not load the content.</p></body></html>");
		}

    }
}
