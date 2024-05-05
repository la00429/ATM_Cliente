package co.edu.uptc.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class JPanelStart.
 */
public class JPanelStart extends JPanel {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The img user. */
    private JPanelStartLeft imgUser;
    
    /** The info panel. */
    private JPanelStartRight infoPanel;

    /**
     * Instantiates a new j panel start.
     *
     * @param listener the listener
     * @param listenerMouse the listener mouse
     */
    public JPanelStart(ActionListener listener, MouseAdapter listenerMouse) {
        this.setBackground(new Color(255, 255, 255));
        this.setLayout(new GridBagLayout());
        initComponents(listener, listenerMouse);
        this.setVisible(true);
    }

    /**
     * Inits the components.
     *
     * @param listener the listener
     * @param listenerMouse the listener mouse
     */
    private void initComponents(ActionListener listener, MouseAdapter listenerMouse) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5; // Cada panel ocupar� la mitad del ancho
        gbc.weighty = 1.0; // Para llenar verticalmente
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        imgUser = new JPanelStartLeft(listener);
        add(imgUser, gbc);

        gbc.gridx = 1;
        infoPanel = new JPanelStartRight();
        add(infoPanel, gbc);
    }

    /**
     * Gets the img user.
     *
     * @return the img user
     */
    public JPanelStartLeft getImgUser() {
        return imgUser;
    }

    /**
     * Gets the info panel.
     *
     * @return the info panel
     */
    public JPanelStartRight getInfoPanel() {
        return infoPanel;
    }

}
