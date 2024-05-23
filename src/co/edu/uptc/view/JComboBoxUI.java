package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class JComboBoxUI extends BasicComboBoxUI {

	private static final int ROUNDNESS = 15;

	@Override
	protected JButton createArrowButton() {
		super.configureArrowButton();
		JButton arrowButton = new BasicArrowButton(BasicArrowButton.SOUTH);
		arrowButton.setContentAreaFilled(false);
		arrowButton.setBorder(BorderFactory.createEmptyBorder());
		arrowButton.setForeground(Color.BLACK);
		arrowButton.setBackground(new Color(0, 0, 0, 0));
		return arrowButton;
	}

	@Override
	protected void installDefaults() {
		super.installDefaults();
		JComboBoxBorder roundBorder = new JComboBoxBorder(ROUNDNESS);
		comboBox.setBorder(roundBorder);
		comboBox.setOpaque(false);
	}

	@Override
	public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
		if (comboBox.isEnabled() && !comboBox.isEditable()) {
			g.setColor(Color.WHITE);
			g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
		} else if (hasFocus) {
			g.setColor(comboBox.getBackground());
			g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
		}
	}
}
