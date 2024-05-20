package co.edu.uptc.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

// TODO: Auto-generated Javadoc
/**
 * Panel para crear un nuevo usuario con campos como nombre, c�digo, sexo,
 * contrase�a, etc. Extiende JPanelStart para agregar funcionalidades
 * adicionales y mostrar informaci�n.
 */
public class JPanelCreateUser extends JPanelStart {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The name. */
	private JLabel name;
	
	/** The name input. */
	private JTextFieldUPTC nameInput;
	
	/** The code. */
	private JLabel code;
	
	/** The code input. */
	private JTextFieldUPTC codeInput;
	
	/** The gender. */
	private JLabel gender;
	
	/** The gender input. */
	private JComboBox<String> genderInput;
	
	/** The password. */
	private JLabel password;
	
	/** The password input. */
	private JPasswordUPTC passwordInput;

	/**
	 * Constructor de JPanelCreateUser.
	 *
	 * @param listener ActionListener para manejar eventos del bot�n.
	 */
	public JPanelCreateUser(ActionListener listener) {
		super(listener);

		initComponents2(listener);
		this.setVisible(false);
	}

	/**
	 * Inits the components 2.
	 *
	 * @param listener the listener
	 */
	private void initComponents2(ActionListener listener) {
		getInfoPanel().setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		firstLine(gbc);
		secondLine(gbc);
		thirdLine(gbc);
		fourLine(gbc);
		fiveLine(gbc);
		sixLine(gbc);
		sevenLine(gbc);
		eightLine(gbc);
		nineLine(gbc);
		tenLine(listener, gbc);
	}

	/**
	 * First line.
	 *
	 * @param gbc the gbc
	 */
	private void firstLine(GridBagConstraints gbc) {
		getInfoPanel().getTitle().setText("Crear Usuario");
		getInfoPanel().getTitle().setFont(new Font("Arial", Font.BOLD, 64));
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(30, 30, 20, 0);
		getInfoPanel().add(getInfoPanel().getTitle(), gbc);
	}

	/**
	 * Second line.
	 *
	 * @param gbc the gbc
	 */
	private void secondLine(GridBagConstraints gbc) {
		this.name = new JLabel("Nombre");
		this.name.setFont(new Font("Arial", Font.PLAIN, 32));
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(20, 30, 0, 0);
		getInfoPanel().add(name, gbc);

	}

	/**
	 * Third line.
	 *
	 * @param gbc the gbc
	 */
	private void thirdLine(GridBagConstraints gbc) {
		this.nameInput = new JTextFieldUPTC();
		gbc.insets = new Insets(0, 30, 5, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(nameInput, gbc);
	}

	/**
	 * Four line.
	 *
	 * @param gbc the gbc
	 */
	private void fourLine(GridBagConstraints gbc) {
		this.code = new JLabel("C�digo");
		this.code.setFont(new Font("Arial", Font.PLAIN, 32));
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(20, 30, 0, 0);
		getInfoPanel().add(code, gbc);

	}

	/**
	 * Five line.
	 *
	 * @param gbc the gbc
	 */
	private void fiveLine(GridBagConstraints gbc) {
		this.codeInput = new JTextFieldUPTC();
		gbc.insets = new Insets(0, 30, 5, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(codeInput, gbc);
	}

	/**
	 * Six line.
	 *
	 * @param gbc the gbc
	 */
	private void sixLine(GridBagConstraints gbc) {
		this.gender = new JLabel("Sexo");
		this.gender.setFont(new Font("Arial", Font.PLAIN, 32));
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(20, 30, 0, 0);
		getInfoPanel().add(gender, gbc);

	}

	/**
	 * Seven line.
	 *
	 * @param gbc the gbc
	 */
	private void sevenLine(GridBagConstraints gbc) {
		this.genderInput = new JComboBoxUPTC();
		gbc.insets = new Insets(0, 30, 5, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(genderInput, gbc);
	}

	/**
	 * Eight line.
	 *
	 * @param gbc the gbc
	 */
	private void eightLine(GridBagConstraints gbc) {
		this.password = new JLabel("Contrase�a");
		this.password.setFont(new Font("Arial", Font.PLAIN, 32));
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(20, 30, 0, 0);
		getInfoPanel().add(password, gbc);

	}

	/**
	 * Nine line.
	 *
	 * @param gbc the gbc
	 */
	private void nineLine(GridBagConstraints gbc) {
		this.passwordInput = new JPasswordUPTC();
		gbc.insets = new Insets(0, 30, 5, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(passwordInput, gbc);
	}

	/**
	 * Ten line.
	 *
	 * @param listener the listener
	 * @param gbc the gbc
	 */
	private void tenLine(ActionListener listener, GridBagConstraints gbc) {
		getInfoPanel().getButton().setText("Siguiente");
		getInfoPanel().getButton().setActionCommand("Next");
		getInfoPanel().getButton().addActionListener(listener);
		gbc.insets = new Insets(30, 30, 0, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(getInfoPanel().getButton(), gbc);
	}

	/**
	 * Carga el combo box con los items.
	 *
	 * @param items Un arrayList con los sexos
	 */
	public void loadComboBoxGender(ArrayList<String> items) {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("Elige uno");
		for (String item : items) {
			model.addElement(item);

		}
		this.genderInput.setModel(model);
	}

	/**
	 * Clean panel.
	 */
	public void cleanPanel() {
		this.nameInput.setText("");
		this.codeInput.setText("");
		this.genderInput.setSelectedItem("Elige uno");
		this.passwordInput.setText("");
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return nameInput.getText();
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return codeInput.getText();
	}

	/**
	 * Gets the selected gender.
	 *
	 * @return the selected gender
	 */
	public String getSelectedGender() {
		return (String) genderInput.getSelectedItem();
	}

	/**
	 * Gets the password input.
	 *
	 * @return the password input
	 */
	public String getPasswordInput() {
		char[] passwordChars = passwordInput.getPassword();
		return new String(passwordChars);
	}

}
