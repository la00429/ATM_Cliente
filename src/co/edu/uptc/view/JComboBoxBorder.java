package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.border.AbstractBorder;

public class JComboBoxBorder extends AbstractBorder {

	private int roundness;

	public JComboBoxBorder(int roundness) {
		super();
		this.roundness = roundness;
	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		c.setBackground(Color.WHITE);
		g2.drawRoundRect(x, y, width - 1, height - 1, roundness, roundness);
		g2.dispose();
	}

	@Override
	public Insets getBorderInsets(Component c) {
		int borderWidth = roundness / 4;
		return new Insets(borderWidth, borderWidth, borderWidth, borderWidth);
	}

	@Override
	public boolean isBorderOpaque() {
		return true;
	}
}
