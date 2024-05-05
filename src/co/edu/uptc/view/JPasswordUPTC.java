package co.edu.uptc.view;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;

// TODO: Auto-generated Javadoc
/**
 * The Class JPasswordUPTC.
 */
public class JPasswordUPTC extends JPasswordField {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The show hide button. */
	private   JToggleButton showHideButton;

	/**
	 * Instantiates a new j password UPTC.
	 */
	public JPasswordUPTC() {
		setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setForeground(Color.BLACK);
        setPreferredSize(new Dimension(420, 50));
        setFont(new Font("Arial", Font.PLAIN, 20));
    }

    /**
     * Paint component.
     *
     * @param g the g
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
