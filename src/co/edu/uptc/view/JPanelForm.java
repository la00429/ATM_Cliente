package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPanelForm extends JPanelStart {

	private static final long serialVersionUID = 1L;
	private JTextPaneUPTC paneDataStyles;
	private JComboBoxUPTC styles;

	public JPanelForm(ActionListener listener) {
		super(listener);

		initComponents2(listener);
		this.setVisible(false);
	}

	private void initComponents2(ActionListener listener) {
		getInfoPanel().setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		getDimensionPanelLeft(gbc);
		firstLine(gbc);
		secondLine(gbc);
		thirdLine(listener, gbc);

	}

	private void getDimensionPanelLeft(GridBagConstraints gbc) {
		getImgUser().removeAll();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 1.0;
		gbc.weightx = 0;
		gbc.fill = GridBagConstraints.BOTH;
		add(getImgUser(), gbc);

		gbc.gridx = 1;
		gbc.weightx = 1;
		add(getInfoPanel(), gbc);

		getImgUser().firstLineUser(96, 88);
		revalidate();
		repaint();
	}

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

	private void secondLine(GridBagConstraints gbc) {
		addTextPane();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 133, 0, 133);
		getInfoPanel().add(this.paneDataStyles, gbc);
	}

	private void addTextPane() {
		this.paneDataStyles = new JTextPaneUPTC();
		String paragraph = "<html><p style='font-family:Arial; font-size:20px;'> <b>Adaptador:</b> Es el estilo de aprendizaje que se basa en la experiencia concreta y la experimentaci�n activa. Las personas con este estilo son pr�cticas, flexibles, intuitivas y orientadas a la acci�n. Les gusta resolver problemas, asumir riesgos y aprender haciendo.</p>"
				+ "<p style='font-family:Arial; font-size:20px;'> <b>Asimilador:</b> Es el estilo de aprendizaje que se basa en la observaci�n reflexiva y la conceptualizaci�n abstracta. Las personas con este estilo son l�gicas, racionales, anal�ticas y te�ricas. Les gusta estudiar, investigar, planificar y crear modelos.</p>"
				+ "<p style='font-family:Arial; font-size:20px;'> <b>Divergente:</b> Es el estilo de aprendizaje que se basa en la experiencia concreta y la observaci�n reflexiva. Las personas con este estilo son creativas, imaginativas, emocionales y sensibles. Les gusta explorar, generar ideas, trabajar en grupo y expresarse.</p>"
				+ "<p style='font-family:Arial; font-size:20px;'> <b>Convergente:</b> Es el estilo de aprendizaje que se basa en la conceptualizaci�n abstracta y la experimentaci�n activa. Las personas con este estilo son pr�cticas, eficientes, objetivas y orientadas a los resultados. Les gusta aplicar lo que saben, tomar decisiones, resolver problemas y encontrar soluciones.</p></html>";
		this.paneDataStyles.setText(paragraph);
		this.paneDataStyles.setColorBack(Color.LIGHT_GRAY);

	}

	private void thirdLine(ActionListener listener, GridBagConstraints gbc) {
		this.styles = new JComboBoxUPTC();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 236, 47, 0);
		getInfoPanel().add(styles, gbc);

		getInfoPanel().getButton().setText("Registrarme");
		getInfoPanel().getButton().setActionCommand("Record");
		getInfoPanel().getButton().addActionListener(listener);
		gbc.gridx = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(0, 5, 47, 140);
		getInfoPanel().add(getInfoPanel().getButton(), gbc);

	}

	public void loadComboBoxStyles(ArrayList<String> items) {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("Elige uno");
		for (String item : items) {
			model.addElement(item);

		}
		this.styles.setModel(model);
	}

	public void cleanPanel() {
		this.styles.setSelectedItem("Elige uno");
	}

	public String getSelectStyle() {
		return (String) styles.getSelectedItem();
	}
}
