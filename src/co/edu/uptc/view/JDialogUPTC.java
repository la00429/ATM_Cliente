package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JDialog;
import javax.swing.JFrame;

// TODO: Auto-generated Javadoc
/**
 * The Class JDialogUPTC.
 */
public class JDialogUPTC extends JDialog {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The text pane. */
	private JTextPaneUPTC textPane;

	/**
	 * Instantiates a new j dialog UPTC.
	 *
	 * @param parent the parent
	 */
	public JDialogUPTC(JFrame parent) {
		super(parent, "", true);
		setBackground(Color.BLACK);
		setLayout(new GridBagLayout());
		initComponents();
		pack();
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(false);
	}

	/**
	 * Inits the components.
	 */
	private void initComponents() {
		GridBagConstraints gbc = new GridBagConstraints();
		this.textPane = new JTextPaneUPTC();
		this.textPane.setPreferredSize(new Dimension(400, 300));
		this.textPane.setColorBack(Color.WHITE);
		gbc.insets = new Insets(15, 15, 15, 15);
		add(textPane, gbc);

	}

	/**
	 * Gets the text pane.
	 *
	 * @return the text pane
	 */
	public JTextPaneUPTC getTextPane() {
		return textPane;
	}

}
