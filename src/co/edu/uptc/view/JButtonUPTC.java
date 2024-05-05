package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class JButtonUPTC.
 */
public class JButtonUPTC extends JButton {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new j button UPTC.
	 *
	 * @param text the text
	 */
	public JButtonUPTC(String text) {
		super(text);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setBackground(new Color(248, 203, 46));
		setForeground(Color.GRAY);
		setFocusPainted(false);
		setFont(new Font("Arial", Font.BOLD, 20));
		setBorderPainted(false);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setPreferredSize(new Dimension(275, 72));
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
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
		super.paintComponent(g);
	}
	
}
