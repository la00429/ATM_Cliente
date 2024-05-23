package co.edu.uptc.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
public class JButtonUPTC extends JButton {

	private static final long serialVersionUID = 1L;


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
