package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JFrame;


/**
 * Clase que representa la ventana principal de la aplicaci�n. Extiende JFrame y
 * contiene diferentes paneles para mostrar la interfaz de usuario.
 */
public class JFrameSystem extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The login user. */
	private JPanelLogin loginUser; // Panel para el inicio de sesi�n

	/** The create user. */
	private JPanelCreateUser createUser; // Panel para la creaci�n de usuarios

	/** The form style learning. */
	private JPanelForm formStyleLearning; // Panel para la selecci�n de estilo de aprendizaje

	/** The change password. */
	private JChangePasswaord changePassword; // Panel para cambiar contrase�a

	/** The course. */
	private JPanelCourse course; // Panel para los cursos

	/** The show info. */
	private JDialogUPTC showInfo; // Di�logo para mostrar informaci�n adicional

	/**
	 * Constructor de la clase JFrameSystem. Inicializa la ventana principal con los
	 * componentes necesarios.
	 *
	 * @param listener      ActionListener para manejar eventos de botones.
	 * @param listenerMouse MouseAdapter para manejar eventos de rat�n.
	 */
	public JFrameSystem(ActionListener listener) {
		super("Aprendamos Juntos");
		this.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width,
				Toolkit.getDefaultToolkit().getScreenSize().height));
		this.setBackground(new Color(255, 255, 255));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents(listener);
		pack();
		this.setVisible(true);
	}

	/**
	 * Inicializa los atributos (paneles) de la clase.
	 * 
	 * @param listener      escuchador de eventos.
	 */
	private void initComponents(ActionListener listener) {
		createUser = new JPanelCreateUser(listener);
		formStyleLearning = new JPanelForm(listener);
		changePassword = new JChangePasswaord(listener);
		course = new JPanelCourse(listener);
		loginUser = new JPanelLogin(listener);
		this.add(loginUser);
	}

	/**
	 * Muestra un mensaje en un di�logo emergente.
	 * @param message El mensaje a mostrar en el di�logo.
	 */
	public void showMessageInfo(String message) {
		this.showInfo = new JDialogUPTC(this);
		this.showInfo.getTextPane().setText(message);
		this.showInfo.setVisible(true);
	}

	/**
	 * Establece el estado del panel de inicio de sesi�n.
	 *
	 * @param state El estado para establecer la visibilidad del panel.
	 */
	public void stateLoginUser(boolean state) {
		this.add(loginUser);
		this.loginUser.setVisible(state);
	}

	/**
	 * Establece el estado para el panel de creaci�n de usuario.
	 * 
	 * @param state Estado a asignar al panel.
	 */
	public void stateCreateUser(boolean state) {
		this.add(createUser);
		this.createUser.setVisible(state);
	}

	/**
	 * Establece el estado para el panel donde el uausurio elige el estili de
	 * aprendizaje.
	 * 
	 * @param state Estado a asignar el panel.
	 */
	public void stateFormStyleLearning(boolean state) {
		this.add(formStyleLearning);
		this.formStyleLearning.setVisible(state);
	}

	/**
	 * Establece el estado del panel de cambio de contrase�a.
	 * 
	 * @param state Estado a asignar el panel.
	 */
	public void stateChangePassword(boolean state) {
		this.add(changePassword);
		this.changePassword.setVisible(state);
	}

	/**
	 * Establece el estado del panel donde se visualiza el curso.
	 * 
	 * @param state Estado a asignar el panel.
	 */
	public void stateCourse(boolean state) {
		this.add(course);
		this.course.setVisible(state);
	}

	/**
	 * Carga los items de combo box de sexo que se encuentra en el panel de creaci�n
	 * de usuario.
	 * 
	 * @param items ArrayList de String donde se encuentran los items a cargar.
	 */
	public void loadComboGender(ArrayList<String> items) {
		this.createUser.loadComboBoxGender(items);
	}

	/**
	 * Carga los items de combo box de estilos que se encuentra en el panel de
	 * elecci�n de estilo de aprendizaje.
	 * 
	 * @param items items ArrayList de String donde se encuentran los items a
	 *              cargar.
	 */
	public void loadComboStyles(ArrayList<String> items) {
		this.formStyleLearning.loadComboBoxStyles(items);
	}

	/**
	 * Obtiene la elecci�n de estilo de aprendizaje.
	 * 
	 * @return El estilo de aprendizaje seleccionado.
	 */
	public String selectCourse() {
		return this.formStyleLearning.getSelectStyle();
	}

	/**
	 * Asigna el nombre de usuario a la etiqueta name que se ecnuentra en el panel
	 * del curso.
	 * 
	 * @param name Nombre del usuario.
	 */
	public void setNameUser(String name) {
		this.course.setNameUser(name);
	}

	/**
	 * Establece la ruta de la web a mostrar en la ventana del curso que est� en el
	 * panel de curso.
	 * 
	 * @param path Ruta del la web.
	 */
	public void setCourse(String path) {

		this.course.setPathCourse(path);

	}

	/**
	 * Obtiene el panel de inicio de sesi�n.
	 *
	 * @return El panel de inicio de sesi�n.
	 */
	public JPanelLogin getLoginUser() {
		return loginUser;
	}

	/**
	 * Obtiene el panel para la creaci�n de usuarios.
	 *
	 * @return El panel para la creaci�n de usuarios.
	 */
	public JPanelCreateUser getCreateUser() {
		return createUser;
	}

	/**
	 * Obtiene el panel donde el usuario elige su estilo de aprendizaje.
	 * 
	 * @return El panel para elegir el estilo de aprendizaje.
	 */
	public JPanelForm getFormStyleLearning() {
		return formStyleLearning;
	}

	/**
	 * Obtiene el panel donde se cambia la contrase�a.
	 * 
	 * @return El panel para cambiar la contrase�a.
	 */
	public JChangePasswaord getChangePassword() {
		return changePassword;
	}

	/**
	 * Obtiene el panel donde se visualiza el curso.
	 * 
	 * @return El panel donde se visualiza el curso.
	 */
	public JPanelCourse getCourse() {
		return course;
	}
}
