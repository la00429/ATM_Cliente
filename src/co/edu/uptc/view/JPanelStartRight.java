package co.edu.uptc.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class JPanelStartRight.
 */
public class JPanelStartRight extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The title. */
	private JLabel title;
	
	/** The button. */
	private JButtonUPTC button;

	/**
	 * Instantiates a new j panel start right.
	 */
	public JPanelStartRight() {
		this.setSize(getMaximumSize());
		initComponents();
		this.setBackground(new Color(255, 255, 255));
		this.setVisible(true);
	}

	/**
	 * Inits the components.
	 */
	private void initComponents() {
		title = new JLabel();
		button = new JButtonUPTC(null);
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public JLabel getTitle() {
		return title;
	}

	/**
	 * Gets the button.
	 *
	 * @return the button
	 */
	public JButtonUPTC getButton() {
		return button;
	}

}
