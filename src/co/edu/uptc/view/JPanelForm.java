package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

// TODO: Auto-generated Javadoc
/**
 * The Class JPanelForm.
 */
public class JPanelForm extends JPanelStart {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The pane data styles. */
	private JTextPaneUPTC paneDataStyles;
	
	/** The styles. */
	private JComboBoxUPTC styles;

	/**
	 * Instantiates a new j panel form.
	 *
	 * @param listener the listener
	 */
	public JPanelForm(ActionListener listener) {
		super(listener);

		initComponents2(listener);
		this.setVisible(false);
	}

	/**
	 * Inits the components 2.
	 *
	 * @param listener the listener
	 * @param listenerMouse the listener mouse
	 */
	private void initComponents2(ActionListener listener) {
		getInfoPanel().setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		getDimensionPanelLeft(gbc);
		firstLine(gbc);
		secondLine(gbc);
		thirdLine(listener, gbc);

	}

	/**
	 * Gets the dimension panel left.
	 *
	 * @param gbc the gbc
	 * @return the dimension panel left
	 */
	private void getDimensionPanelLeft(GridBagConstraints gbc) {
		getImgUser().removeAll();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 1.0; // Peso para la fila
		gbc.weightx = 0; // Peso para la columna
		gbc.fill = GridBagConstraints.BOTH;
		add(getImgUser(), gbc);

		gbc.gridx = 1;
		gbc.weightx = 1; // Peso para la columna
		add(getInfoPanel(), gbc);

		getImgUser().firstLineUser(96, 88);
		revalidate();
		repaint();
	}

	/**
	 * First line.
	 *
	 * @param gbc the gbc
	 */
	private void firstLine(GridBagConstraints gbc) {
		getInfoPanel().getTitle().setText("Elije tu estilo de aprendizaje");
		getInfoPanel().getTitle().setFont(new Font("Arial", Font.BOLD, 64));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(36, 250, 0, 126);
		getInfoPanel().add(getInfoPanel().getTitle(), gbc);
	}

	/**
	 * Second line.
	 *
	 * @param gbc the gbc
	 */
	private void secondLine(GridBagConstraints gbc) {
//		configurationPanelStyles();
		addTextPane();
//		this.panelStyles.add(paneDataStyles, BorderLayout.CENTER);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 133, 0, 133);
		getInfoPanel().add(this.paneDataStyles, gbc);
	}

	/**
	 * Adds the text pane.
	 */
	private void addTextPane() {
		this.paneDataStyles = new JTextPaneUPTC();
		String paragraph = "<html><p style='font-family:Arial; font-size:20px;'> <b>Adaptador:</b> Es el estilo de aprendizaje que se basa en la experiencia concreta y la experimentaci�n activa. Las personas con este estilo son pr�cticas, flexibles, intuitivas y orientadas a la acci�n. Les gusta resolver problemas, asumir riesgos y aprender haciendo.</p>"
				+ "<p style='font-family:Arial; font-size:20px;'> <b>Asimilador:</b> Es el estilo de aprendizaje que se basa en la observaci�n reflexiva y la conceptualizaci�n abstracta. Las personas con este estilo son l�gicas, racionales, anal�ticas y te�ricas. Les gusta estudiar, investigar, planificar y crear modelos.</p>"
				+ "<p style='font-family:Arial; font-size:20px;'> <b>Divergente:</b> Es el estilo de aprendizaje que se basa en la experiencia concreta y la observaci�n reflexiva. Las personas con este estilo son creativas, imaginativas, emocionales y sensibles. Les gusta explorar, generar ideas, trabajar en grupo y expresarse.</p>"
				+ "<p style='font-family:Arial; font-size:20px;'> <b>Convergente:</b> Es el estilo de aprendizaje que se basa en la conceptualizaci�n abstracta y la experimentaci�n activa. Las personas con este estilo son pr�cticas, eficientes, objetivas y orientadas a los resultados. Les gusta aplicar lo que saben, tomar decisiones, resolver problemas y encontrar soluciones.</p></html>";
		this.paneDataStyles.setText(paragraph);
		this.paneDataStyles.setColorBack(Color.LIGHT_GRAY);

	}

	/**
	 * Third line.
	 *
	 * @param listener the listener
	 * @param gbc the gbc
	 */
	private void thirdLine(ActionListener listener, GridBagConstraints gbc) {
		this.styles = new JComboBoxUPTC();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1; // Ancho del JComboBox
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 236, 47, 0); // Ajusta los m�rgenes seg�n lo necesites
		getInfoPanel().add(styles, gbc);

		getInfoPanel().getButton().setText("Registrarme");
		getInfoPanel().getButton().setActionCommand("Record");
		getInfoPanel().getButton().addActionListener(listener);
		gbc.gridx = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER; // Resto del ancho disponible
		gbc.insets = new Insets(0, 5, 47, 140); // Ajusta los m�rgenes seg�n lo necesites
		getInfoPanel().add(getInfoPanel().getButton(), gbc);

	}

	/**
	 * Carga el combo box con los items de estilos.
	 *
	 * @param items Un arrayList con los estilos.
	 */
	public void loadComboBoxStyles(ArrayList<String> items) {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("Elige uno");
		for (String item : items) {
			model.addElement(item);

		}
		this.styles.setModel(model);
	}

	/**
	 * Clean panel.
	 */
	public void cleanPanel() {
		this.styles.setSelectedItem("Elige uno");
	}

	/**
	 * Gets the select style.
	 *
	 * @return the select style
	 */
	public String getSelectStyle() {
		return (String) styles.getSelectedItem();

	}

}
