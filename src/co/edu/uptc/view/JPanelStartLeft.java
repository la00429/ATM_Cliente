package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class JPanelStartLeft.
 */
public class JPanelStartLeft extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The img user grey. */
	private JLabel imgUserGrey;
	
	/** The img UPTC. */
	private JLabel imgUPTC;
	
	/** The info. */
	private JButtonTraspUPTC info;
	
	/** The radio. */
	public final int radio = 5;

	/**
	 * Instantiates a new j panel start left.
	 *
	 * @param listener the listener
	 */
	public JPanelStartLeft(ActionListener listener) {
		this.setSize(getMaximumSize());
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(248, 203, 46));
		GridBagConstraints gbc = new GridBagConstraints();
		borderPanel();
		initComponents(listener, gbc);
		this.setVisible(true);
	}

	/**
	 * Border panel.
	 */
	private void borderPanel() {
		this.setOpaque(false);
	}

	/**
	 * Paint component.
	 *
	 * @param g the g
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();

		int width = getWidth();
		int height = getHeight();
		RoundRectangle2D roundedRect = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, 30, 30);
		g2d.setColor(getBackground());
		g2d.fill(roundedRect);
		g2d.dispose();
	}

	/**
	 * Inits the components.
	 *
	 * @param listenerMouse the listener mouse
	 * @param gbc the gbc
	 */
	private void initComponents(ActionListener listenerMouse, GridBagConstraints gbc) {
		firstLineUser(gbc);
		secondLineUser(listenerMouse, gbc);
	}

	/**
	 * First line user.
	 *
	 * @param gbc the gbc
	 */
	private void firstLineUser(GridBagConstraints gbc) {
		imgUserGrey = new JLabel();
		imgUserGrey.setSize(469, 465);
		ImageIcon originalImageIcon = new ImageIcon("img/user.png");
		Image originalImage = originalImageIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance((int) (imgUserGrey.getWidth() * 0.9),
				(int) (imgUserGrey.getHeight() * 0.9), Image.SCALE_SMOOTH);
		ImageIcon scaledImageIcon = new ImageIcon(resizedImage);
		imgUserGrey.setIcon(scaledImageIcon);

		gbc.insets = new Insets(50, 0, 0, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.PAGE_START;
//		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		this.add(imgUserGrey, gbc);
	}

	/**
	 * First line user.
	 *
	 * @param width the width
	 * @param height the height
	 */
	public void firstLineUser(int width, int height) {
		GridBagConstraints gbc = new GridBagConstraints();
		imgUserGrey = new JLabel();
		imgUserGrey.setSize(width, height);
		ImageIcon originalImageIcon = new ImageIcon("img/user.png");
		Image originalImage = originalImageIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance((int) (imgUserGrey.getWidth() * 0.9),
				(int) (imgUserGrey.getHeight() * 0.9), Image.SCALE_SMOOTH);
		ImageIcon scaledImageIcon = new ImageIcon(resizedImage);
		imgUserGrey.setIcon(scaledImageIcon);

		gbc.insets = new Insets(30, 0, 5, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		this.add(imgUserGrey, gbc);
	}

	/**
	 * Second line user.
	 *
	 * @param listener the listener
	 * @param gbc the gbc
	 */
	private void secondLineUser(ActionListener listener, GridBagConstraints gbc) {
		imgUPTC = new JLabel();
		ImageIcon imageIcon = new ImageIcon("img/logoUPTC.png");
		Image originalImage = imageIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance(308, 132, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		imgUPTC.setIcon(resizedIcon);

		// Configuraci�n de GridBagConstraints para ubicar en la esquina inferior
		// izquierda
		gbc.anchor = GridBagConstraints.SOUTHWEST; // Esquina inferior izquierda
		gbc.fill = GridBagConstraints.NONE; // Sin relleno
		gbc.weightx = 0.0; // No expandir en el eje X
		gbc.weighty = 0.0; // No expandir en el eje Y
		gbc.gridx = 0; // Posici�n en la columna cero
		gbc.gridy = 1; // Posici�n en la fila uno
		gbc.insets = new Insets(0, 5, 10, 5); // Relleno para separaci�n
		this.add(imgUPTC, gbc);

		info = new JButtonTraspUPTC("Sobre nosotros");
		this.info.setActionCommand("Us");
		this.info.addActionListener(listener);
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(30, 30, 45, 50);
		this.add(info, gbc);
	}

	/**
	 * Gets the img UPTC.
	 *
	 * @return the img UPTC
	 */
	public JLabel getImgUPTC() {
		return imgUPTC;
	}

	/**
	 * Gets the img user grey.
	 *
	 * @return the img user grey
	 */
	public JLabel getImgUserGrey() {
		return imgUserGrey;
	}

	/**
	 * Gets the info.
	 *
	 * @return the info
	 */
	public JButtonTraspUPTC getInfo() {
		return info;
	}
	
	/**
	 * Sets the info.
	 *
	 * @param text the new info
	 */
	public void setInfo(String text) {
		GridBagConstraints gbc = new GridBagConstraints();
		this.info.setText(text);
		this.info.setActionCommand("Help");
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(30, 30, 45, 50);
		this.add(info, gbc);
	}

}
