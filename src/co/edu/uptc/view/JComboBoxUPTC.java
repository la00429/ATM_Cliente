package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;

// TODO: Auto-generated Javadoc
/**
 * The Class JComboBoxUPTC.
 */
public class JComboBoxUPTC extends JComboBox<String> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new j combo box UPTC.
	 */
	public JComboBoxUPTC() {
		setFont(new Font("Arial", Font.PLAIN, 20));
		setForeground(Color.BLACK);
		setPreferredSize(new Dimension(420, 50));
		setUI(new JComboBoxUI());
		setRenderer(new JComboCell());
	}

}
