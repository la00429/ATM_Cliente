package co.edu.uptc.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * Clase que representa un componente de visualización web con funcionalidad de
 * zoom. Extiende JFXPanel y contiene un WebView para mostrar contenido web y
 * botones para controlar el zoom.
 */
public class WebCourse extends JFXPanel{

	/**  SerialVersionUID para la serialización de la clase. */
	private static final long serialVersionUID = 1L;
	
	/** The web view. */
	private WebView webView; // Componente WebView para mostrar contenido web
	
	/** The zoom in button. */
	private Button zoomInButton; // Botón para aumentar el zoom
	
	/** The zoom out button. */
	private Button zoomOutButton; // Botón para reducir el zoom

	/**
	 * Inicializa el WebView con la URL proporcionada y configura los botones de
	 * zoom.
	 *
	 * @param path La ruta o URL del contenido web a cargar en el WebView.
	 */
	
	private void initializeWebView(String path) {
		webView = new WebView();
		webView.getEngine().load(path);
		zoomInButton = new Button("Zoom In");
		zoomOutButton = new Button("Zoom Out");
		zoomInButton.setOnAction(e -> changeZoom(webView, 0.1));
		zoomOutButton.setOnAction(e -> changeZoom(webView, -0.1));

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(webView);
		borderPane.setBottom(new FlowPane(zoomInButton, zoomOutButton));

		// Set the preferred size of the BorderPane
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screen.getWidth();
		double height = screen.getHeight();
		borderPane.setPrefSize(width, height);

		Scene scene = new Scene(borderPane);
		this.setScene(scene);
	}

	/**
	 * Cambia el nivel de zoom del WebView.
	 *
	 * @param webView       El WebView al que se aplica el cambio de zoom.
	 * @param zoomIncrement Incremento/decremento del nivel de zoom.
	 */
	private void changeZoom(WebView webView, double zoomIncrement) {
		double currentZoom = webView.getZoom();
		double newZoom = currentZoom + zoomIncrement;
		if (newZoom >= 0.1 && newZoom <= 3.0) {
			webView.setZoom(newZoom);
		}
	}

	/**
	 * Carga una nueva página en el WebView.
	 *
	 * @param path La ruta o URL de la nueva página a cargar en el WebView.
	 */
	public void loadPage(String path) {
		Platform.runLater(() -> initializeWebView(path));

	}
}
