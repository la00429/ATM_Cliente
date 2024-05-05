package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class JButtonTraspUPTC.
 */
public class JButtonTraspUPTC extends JButton {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new j button trasp UPTC.
	 *
	 * @param text the text
	 */
	public JButtonTraspUPTC(String text) {
		super(text);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setForeground(new Color(90, 90, 90));
		setFocusPainted(false);
		setFont(new Font("Arial", Font.BOLD, 20));
		setBorderPainted(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	/**
	 * Paint component.
	 *
	 * @param g the g
	 */
	@Override
	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(Color.lightGray);
		} else {
			g.setColor(getBackground());
		}
		super.paintComponent(g);
	}
}
