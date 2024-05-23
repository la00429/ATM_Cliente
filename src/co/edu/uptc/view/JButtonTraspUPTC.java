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

public class JButtonTraspUPTC extends JButton {
	
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
