package co.edu.uptc.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import co.edu.uptc.presenter.Contracts;

// TODO: Auto-generated Javadoc
/**
 * The Class View.
 */
public class View implements Contracts.IView {
	
	/** The frame app. */
	private JFrameSystem frameApp;

	/**
	 * Instantiates a new view.
	 *
	 * @param listener the listener
	 * @param listenerMouse the listener mouse
	 */
	public View(ActionListener listener, MouseAdapter listenerMouse) {
		frameApp = new JFrameSystem(listener, listenerMouse);
	}

	/**
	 * Muestra un mensaje en la vista.
	 *
	 * @param message El mensaje a mostrar.
	 */
	public void showData(String message) {
		this.getFrameApp().showMessageInfo(message);
	}

	/**
	 * Establece el nombre del curso en la vista.
	 *
	 * @param course El nombre del curso a establecer.
	 */
	public void setCourse(String course) {
		this.getFrameApp().setCourse(course);
	}

	/**
	 * Gets the frame app.
	 *
	 * @return the frame app
	 */
	public JFrameSystem getFrameApp() {
		return frameApp;
	}

	/**
	 * Accede al inicio de sesi�n.
	 */
	public void accessLogin() {
		getFrameApp().stateCourse(false);
		getFrameApp().stateLoginUser(true);

	}

	/**
	 * Accede al curso.
	 */
	public void accessCourse() {
		getFrameApp().stateLoginUser(false);
		getFrameApp().stateCourse(true);

	}

	/**
	 * Accede al panel de creaci�n de usuario.
	 */
	public void accessCreate() {
		getFrameApp().stateLoginUser(false);
		getFrameApp().stateCreateUser(true);

	}

	/**
	 * Accede al curso desde la ruta de paneles para crear un usuario.
	 */
	public void accessCourseCreate() {
		getFrameApp().stateFormStyleLearning(false);
		getFrameApp().stateCourse(true);

	}

	/**
	 * Accede al cambio de contrase�a.
	 */
	public void accessChange() {
		getFrameApp().stateLoginUser(false);
		getFrameApp().stateChangePassword(true);

	}

	/**
	 * Accede al formulario de estilos de aprendizaje.
	 */
	public void accessForm() {
		getFrameApp().stateCreateUser(false);
		getFrameApp().stateFormStyleLearning(true);

	}

	/**
	 * Accede al sesi�n desde el cambio de contrase�a.
	 */
	public void accessLoginChange() {
		getFrameApp().stateChangePassword(false);
		getFrameApp().stateLoginUser(true);
		
	}

}
