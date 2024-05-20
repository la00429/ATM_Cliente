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
 * The Class JPanelLogin.
 */
public class JPanelLogin extends JPanelStart {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The user. */
	private JLabel user;
	
	/** The user input. */
	private JTextFieldUPTC userInput;
	
	/** The password. */
	private JLabel password;
	
	/** The password input. */
	private JPasswordUPTC passwordInput;
	
	/** The forget password. */
	private JButtonTraspUPTC forgetPassword;
	
	/** The create count. */
	private JButtonTraspUPTC createCount;

	/**
	 * Instantiates a new j panel login.
	 *
	 * @param listener the listener
	 */
	public JPanelLogin(ActionListener listener ) {
		super(listener);
		initComponents2(listener);
		this.setVisible(true);
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
		sixLine(listener, gbc);
		sevenLine(listener, gbc);
		eightLine(listener, gbc);
	}

	/**
	 * First line.
	 *
	 * @param gbc the gbc
	 */
	private void firstLine(GridBagConstraints gbc) {
		getInfoPanel().getTitle().setText("Iniciar sesi�n");
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
		this.user = new JLabel("C�digo");
		this.user.setFont(new Font("Arial", Font.PLAIN, 32));
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(70, 30, 0, 0);
		getInfoPanel().add(user, gbc);

	}

	/**
	 * Third line.
	 *
	 * @param gbc the gbc
	 */
	private void thirdLine(GridBagConstraints gbc) {
		this.userInput = new JTextFieldUPTC();
		gbc.insets = new Insets(0, 30, 30, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(userInput, gbc);

	}

	/**
	 * Four line.
	 *
	 * @param gbc the gbc
	 */
	private void fourLine(GridBagConstraints gbc) {
		this.password = new JLabel("Contrase�a");
		this.password.setFont(new Font("Arial", Font.PLAIN, 32));
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(30, 30, 0, 0);
		getInfoPanel().add(password, gbc);

	}

	/**
	 * Five line.
	 *
	 * @param gbc the gbc
	 */
	private void fiveLine(GridBagConstraints gbc) {
		this.passwordInput = new JPasswordUPTC();
		gbc.insets = new Insets(0, 30, 70, 0);
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
		getInfoPanel().getButton().setText("Iniciar sesi�n");
		getInfoPanel().getButton().setActionCommand("Login");
		getInfoPanel().getButton().addActionListener(listener);
		gbc.insets = new Insets(70, 30, 0, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(getInfoPanel().getButton(), gbc);
	}

	/**
	 * Seven line.
	 *
	 * @param listener the listener
	 * @param gbc the gbc
	 */
	private void sevenLine(ActionListener listener, GridBagConstraints gbc) {
		this.forgetPassword = new JButtonTraspUPTC("Olvid� mi contrase�a");
		this.forgetPassword.setActionCommand("Forgot");
		this.forgetPassword.addActionListener(listener);
		gbc.insets = new Insets(0, 30, 0, 0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(forgetPassword, gbc);

	}

	/**
	 * Eight line.
	 *
	 * @param listener the listener
	 * @param gbc the gbc
	 */
	private void eightLine(ActionListener listener, GridBagConstraints gbc) {
		this.createCount = new JButtonTraspUPTC("Crear una cuenta");
		this.createCount.setActionCommand("Create");
		this.createCount.addActionListener(listener);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getInfoPanel().add(createCount, gbc);
	}

	/**
	 * Clean panel.
	 */
	public void cleanPanel() {
		this.userInput.setText("");
		this.passwordInput.setText("");
	}

	/**
	 * Gets the user input.
	 *
	 * @return the user input
	 */
	public String getUserInput() {
		return userInput.getText();
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
