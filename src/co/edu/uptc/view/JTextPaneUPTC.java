package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JTextPane;

// TODO: Auto-generated Javadoc
/**
 * The Class JTextPaneUPTC.
 */
public class JTextPaneUPTC extends JTextPane {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The color back. */
	private Color colorBack;

	/**
	 * Instantiates a new j text pane UPTC.
	 */
	public JTextPaneUPTC() {
		super();
		setOpaque(false); // Establecer la opacidad en falso para que el fondo sea transparente
		setEditable(false);
		setContentType("text/html");
		setSize(new Dimension(930, 380));
	}

	/**
	 * Paint component.
	 *
	 * @param g the g
	 */
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// Dibuja un rectángulo con esquinas redondeadas
		g2d.setColor(getColorBack());
		g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 16, 16));

		// Llama al método paintComponent de la clase padre para dibujar el contenido
		super.paintComponent(g2d);

		g2d.dispose();
	}

	/**
	 * Sets the color back.
	 *
	 * @param colorBack the new color back
	 */
	public void setColorBack(Color colorBack) {
		this.colorBack = colorBack;
	}

	/**
	 * Gets the color back.
	 *
	 * @return the color back
	 */
	public Color getColorBack() {
		return colorBack;
	}
}