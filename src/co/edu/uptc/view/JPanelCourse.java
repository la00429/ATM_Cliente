package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * Clase que representa el panel de visualización de cursos en la interfaz de
 * usuario. Extiende JPanelStart e incluye componentes para mostrar información
 * del curso y el contenido del mismo.
 */
public class JPanelCourse extends JPanelStart {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The options menu. */
	private JPanel optionsMenu; // Panel para mostrar el menú de opciones

	/** The logout. */
	private JButtonTraspUPTC logout; // Botón para cerrar sesión

	/** The name. */
	private JLabel name; // Etiqueta para mostrar el nombre del usuario

	/** The sub title. */
	private JTextPaneUPTC subTitle; // Panel de texto para mostrar información adicional

	/** The panel course. */
	private JPanel panelCourse; // Panel principal del curso

	/** The web course. */
	private WebCourse webCourse; // Componente para visualizar el contenido web del curso

	/**
	 * Constructor de la clase JPanelCourse. Inicializa los componentes necesarios
	 * para la visualización del panel de curso.
	 *
	 * @param listener      ActionListener para manejar eventos de botones.
	 * @param listenerMouse MouseAdapter para manejar eventos del ratón.
	 */
	public JPanelCourse(ActionListener listener, MouseAdapter listenerMouse) {
		super(listener, listenerMouse);
		initComponents2(listener, listenerMouse);
		this.setVisible(false);
	}

	/**
	 * Inicializa los combonentes con disposición de GridBagConstraints gbc.
	 * 
	 * @param listener      Escuchador de eventos.
	 * @param listenerMouse Escuchador de mouse.
	 */
	private void initComponents2(ActionListener listener, MouseAdapter listenerMouse) {
		GridBagConstraints gbc = new GridBagConstraints();
		getDimensionPanelLeft(listener, gbc);
		firstLine(gbc, listener);
		secondLine(gbc);
		thirdLine(gbc);
		fourLine(gbc);
	}

	/**
	 * Redimensipna el panel de la derecha.
	 *
	 * @param listener Escuchador de eventos.
	 * @param gbc      Objecto para disposiciónes.
	 * @return the dimension panel left
	 */
	private void getDimensionPanelLeft(ActionListener listener, GridBagConstraints gbc) {
		panelLeft(gbc);
		panelRight(gbc);
		addNewComponents(listener);
	}

	/**
	 * Redimensiona el panel derecho.
	 * 
	 * @param gbc Objeto para disposiciones.
	 */
	private void panelRight(GridBagConstraints gbc) {
		getInfoPanel().setLayout(new GridBagLayout());
		gbc.gridx = 1;
		gbc.weightx = 1;
		add(getInfoPanel(), gbc);
	}

	/**
	 * Redimensiona el panel izquierdo.
	 * 
	 * @param gbc Objeto para disposicione.
	 */
	private void panelLeft(GridBagConstraints gbc) {
		getImgUser().remove(getImgUser().getImgUserGrey());
		getImgUser().remove(getImgUser().getImgUPTC());
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 1.0; // Peso para la fila
		gbc.weightx = 0; // Peso para la columna
		gbc.fill = GridBagConstraints.BOTH;
		add(getImgUser(), gbc);
	}

	/**
	 * Añade los nuevos componentes al panel de la derecha.
	 * 
	 * @param listener Eschucador de eventos.
	 */
	private void addNewComponents(ActionListener listener) {
		getImgUser().firstLineUser(96, 88);
		getImgUser().setInfo("Ayuda");
		revalidate();
		repaint();
	}

	/**
	 * Ubica los elementos de la primera línea del panel de la derecha.
	 * 
	 * @param gbc      Objeto para disposiciones.
	 * @param listener Escuchador de eventos.
	 */
	private void firstLine(GridBagConstraints gbc, ActionListener listener) {
		this.optionsMenu = new JPanel();
		this.optionsMenu.setPreferredSize(new Dimension(getWidth(), 20));
		this.optionsMenu.setLayout(new GridBagLayout());
		this.optionsMenu.setBackground(new Color(248, 203, 46));
		addButton(gbc, listener);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(this.optionsMenu, gbc);

	}

	/**
	 * Añade el boton de salir al panel de opciones.
	 * 
	 * @param gbc      Objeto para disposiciones.
	 * @param listener Escuchador de eventos.
	 */
	private void addButton(GridBagConstraints gbc, ActionListener listener) {
		this.logout = new JButtonTraspUPTC("");
		this.logout.setIcon(modiImage());
		this.logout.setActionCommand("Logout");
		this.logout.addActionListener(listener);
		gbc.insets = new Insets(16, 0, 10, 80);
		gbc.anchor = GridBagConstraints.LAST_LINE_END;
		gbc.fill = GridBagConstraints.NONE;
		this.optionsMenu.add(logout, gbc);
	}

	/**
	 * Modifica una imagen, le da nuevas dimensiones.
	 * 
	 * @return La imagen modificada.
	 */
	private ImageIcon modiImage() {
		ImageIcon imageIcon = new ImageIcon("img/logout.png");
		Image originalImage = imageIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance(52, 65, Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}

	/**
	 * Solo declara la etiqueta donde se mostrará el nombre de usuario.
	 * 
	 * @param gbc Objeto para disposiciones.
	 */
	private void secondLine(GridBagConstraints gbc) {
		this.name = new JLabel();
	}

	/**
	 * Third line.
	 *
	 * @param gbc the gbc
	 */
	private void thirdLine(GridBagConstraints gbc) {
		this.subTitle = new JTextPaneUPTC();
		this.subTitle.setColorBack(Color.white);
		this.subTitle.setPreferredSize(new Dimension(12, 12));
		addTextPane();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.insets = new Insets(160, 76, 0, 61);
		getInfoPanel().add(subTitle, gbc);
	}

	/**
	 * Añade el texto en formato html que va ir en el subtitulo del panel.
	 */
	private void addTextPane() {
		String paragraph = "<html><p style='font-family:Arial; font-size:24px;'> Este es el curso de acuerdo al estilo de aprendizaje que más se acomoda a ti. Gracias por estar aquí. </p></html>";
		this.subTitle.setText(paragraph);
	}

	/**
	 * Agrega los componentes que van en las últimas posiciones. Es decir, la
	 * ventana del curso.
	 * 
	 * @param gbc Objeto para disposiciones.
	 */
	private void fourLine(GridBagConstraints gbc) {
		this.panelCourse = new JPanel();
		panelCourse = new JPanel(new BorderLayout());
		this.webCourse = new WebCourse();
		this.panelCourse.add(webCourse, BorderLayout.CENTER);
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(216, 76, 0, 76);
		getInfoPanel().add(panelCourse, gbc);

	}

	/**
	 * Asigna el nombre de usuario a la etiqueta name.
	 * 
	 * @param text Nombre de usuario.
	 */
	public void setNameUser(String text) {
		GridBagConstraints gbc = new GridBagConstraints();
		this.name = new JLabel();
		this.name.setText(text);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(100, 76, 0, 0);
		getInfoPanel().getTitle().setText("Hola " + this.name.getText());
		getInfoPanel().getTitle().setPreferredSize(new Dimension(getWidth(), 76));
		getInfoPanel().getTitle().setFont(new Font("Arial", Font.BOLD, 64));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		getInfoPanel().add(getInfoPanel().getTitle(), gbc);
	}

	/**
	 * Carga la ruta de la web a la ventana webCourse.
	 * 
	 * @param pathCouse La ruta de la web del curso.
	 */
	public void setPathCourse(String pathCouse) {
		this.webCourse.loadPage(pathCouse);
	}

	public WebCourse getWebCourse() {
		return webCourse;
	}

}
