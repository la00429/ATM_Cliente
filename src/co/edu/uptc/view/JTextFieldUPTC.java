package co.edu.uptc.view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * Clase JTextFieldUPTC que extiende JTextField para proporcionar un JTextField
 * con características especiales.
 */
public class JTextFieldUPTC extends JTextField {
	/**
	 * Identificador de versión para la serialización.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor por defecto de la clase JTextFieldUPTC. Configura el JTextField
	 * con características personalizadas.
	 */
	public JTextFieldUPTC() {
		setOpaque(false);
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setForeground(Color.BLACK);
		setPreferredSize(new Dimension(420, 50));
		setFont(new Font("Arial", Font.PLAIN, 20));
	}

	/**
	 * Método para pintar el componente. Se encarga de dibujar el fondo redondeado y
	 * el borde del JTextField.
	 * 
	 * @param g Objeto Graphics usado para dibujar.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();

		// Guardar los atributos originales del gráfico
		RenderingHints rh = g2d.getRenderingHints();

		// Configurar renderización para obtener bordes más suaves
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		// Dibujar el fondo redondeado con transparencia
		g2d.setColor(getBackground());
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
		g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 15, 15));

		// Restaurar la configuración original del gráfico
		g2d.setRenderingHints(rh);

		// Llamar al método paintComponent del padre para dibujar el texto
		super.paintComponent(g2d);

		// Dibujar el borde redondeado
		g2d.setColor(Color.BLACK);
		g2d.draw(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 15, 15));

		g2d.dispose();
	}
}
