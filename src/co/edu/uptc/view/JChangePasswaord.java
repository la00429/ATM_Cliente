package co.edu.uptc.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JLabel;

// TODO: Auto-generated Javadoc
/**
 * The Class JChangePasswaord.
 */
public class JChangePasswaord extends JPanelStart {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The code. */
	private JLabel code;
	
	/** The code input. */
	private JTextFieldUPTC codeInput;
	
	/** The password. */
	private JLabel password;
	
	/** The password input. */
	private JPasswordUPTC passwordInput;

	/**
	 * Instantiates a new j change passwaord.
	 *
	 * @param listener the listener
	 * @param listenerMouse the listener mouse
	 */
	public JChangePasswaord(ActionListener listener, MouseAdapter listenerMouse) {
		super(listener, listenerMouse);

		initComponents2(listener, listenerMouse);
		this.setVisible(false);
	}

	/**
	 * Inits the components 2.
	 *
	 * @param listener the listener
	 * @param listenerMouse the listener mouse
	 */
	private void initComponents2(ActionListener listener, MouseAdapter listenerMouse) {
		getInfoPanel().setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		firstLine(gbc);
		secondLine(gbc);
		thirdLine(gbc);
		fourLine(gbc);
		fiveLine(gbc);
		sixLine(listener, gbc);
	}

	/**
	 * First line.
	 *
	 * @param gbc the gbc
	 */
	private void firstLine(GridBagConstraints gbc) {
		getInfoPanel().getTitle().setText("Cambiar contraseña");
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
		this.code = new JLabel("Código");
		this.code.setFont(new Font("Arial", Font.PLAIN, 32));
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(70, 126, 0, 0);
		getInfoPanel().add(code, gbc);

	}

	/**
	 * Third line.
	 *
	 * @param gbc the gbc
	 */
	private void thirdLine(GridBagConstraints gbc) {
		this.codeInput = new JTextFieldUPTC();
		gbc.insets = new Insets(0, 126, 30, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(codeInput, gbc);

	}

	/**
	 * Four line.
	 *
	 * @param gbc the gbc
	 */
	private void fourLine(GridBagConstraints gbc) {
		this.password = new JLabel("Contraseña");
		this.password.setFont(new Font("Arial", Font.PLAIN, 32));
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(30, 126, 0, 0);
		getInfoPanel().add(password, gbc);

	}

	/**
	 * Five line.
	 *
	 * @param gbc the gbc
	 */
	private void fiveLine(GridBagConstraints gbc) {
		this.passwordInput = new JPasswordUPTC();
		gbc.insets = new Insets(0, 126, 70, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(passwordInput, gbc);
	}

	/**
	 * Six line.
	 *
	 * @param listener the listener
	 * @param gbc the gbc
	 */
	private void sixLine(ActionListener listener, GridBagConstraints gbc) {
		getInfoPanel().getButton().setText("Aceptar");
		getInfoPanel().getButton().setActionCommand("Accept");
		getInfoPanel().getButton().addActionListener(listener);
		gbc.insets = new Insets(70, 30, 0, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(getInfoPanel().getButton(), gbc);
	}
	
	/**
	 * Clean panel.
	 */
	public void cleanPanel() {
		this.codeInput.setText("");
		this.passwordInput.setText("");
	}

	/**
	 * Gets the user input.
	 *
	 * @return the user input
	 */
	public String getUserInput() {
		return codeInput.getText();
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
