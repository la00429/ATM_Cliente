package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.border.AbstractBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class JComboBoxBorder.
 */
public class JComboBoxBorder extends AbstractBorder {

	/** The roundness. */
	private int roundness;

	/**
	 * Instantiates a new j combo box border.
	 *
	 * @param roundness the roundness
	 */
	public JComboBoxBorder(int roundness) {
		super();
		this.roundness = roundness;
	}

	/**
	 * Paint border.
	 *
	 * @param c the c
	 * @param g the g
	 * @param x the x
	 * @param y the y
	 * @param width the width
	 * @param height the height
	 */
	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		c.setBackground(Color.WHITE);
		g2.drawRoundRect(x, y, width - 1, height - 1, roundness, roundness);
		g2.dispose();
	}

	/**
	 * Gets the border insets.
	 *
	 * @param c the c
	 * @return the border insets
	 */
	@Override
	public Insets getBorderInsets(Component c) {
		int borderWidth = roundness / 4;
		return new Insets(borderWidth, borderWidth, borderWidth, borderWidth);
	}

	/**
	 * Checks if is border opaque.
	 *
	 * @return true, if is border opaque
	 */
	@Override
	public boolean isBorderOpaque() {
		return true;
	}

}
