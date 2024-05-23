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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelCourse extends JPanelStart {

    private static final long serialVersionUID = 1L;
    private JPanel optionsMenu;
    private JButtonTraspUPTC logout;
    private JLabel name;
    private JTextPaneUPTC subTitle;
    private JPanel panelCourse;
    private JPanelCoursePage coursePage;

    public JPanelCourse(ActionListener listener) {
        super(listener);
        initComponents2(listener);
        this.setVisible(false);
    }

    private void initComponents2(ActionListener listener) {
        GridBagConstraints gbc = new GridBagConstraints();
        getDimensionPanelLeft(listener, gbc);
        firstLine(gbc, listener);
        secondLine(gbc);
        thirdLine(gbc);
        fourLine(gbc);
    }

    private void getDimensionPanelLeft(ActionListener listener, GridBagConstraints gbc) {
        panelLeft(gbc);
        panelRight(gbc);
        addNewComponents(listener);
    }

    private void panelRight(GridBagConstraints gbc) {
        getInfoPanel().setLayout(new GridBagLayout());
        gbc.gridx = 1;
        gbc.weightx = 1;
        add(getInfoPanel(), gbc);
    }

    private void panelLeft(GridBagConstraints gbc) {
        getImgUser().remove(getImgUser().getImgUserGrey());
        getImgUser().remove(getImgUser().getImgUPTC());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add(getImgUser(), gbc);
    }

    private void addNewComponents(ActionListener listener) {
        getImgUser().firstLineUser(96, 88);
        getImgUser().setInfo("Ayuda");
        revalidate();
        repaint();
    }

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

    private ImageIcon modiImage() {
        ImageIcon imageIcon = new ImageIcon("img/logout.png");
        Image originalImage = imageIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(52, 65, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    private void secondLine(GridBagConstraints gbc) {
        this.name = new JLabel();
    }

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

    private void addTextPane() {
        String paragraph = "Este es el curso de acuerdo al estilo de aprendizaje que m\u00E1s se acomoda a ti. Gracias por estar aqu\u00ED. </p></html>";
        this.subTitle.setText(paragraph);
    }

    private void fourLine(GridBagConstraints gbc) {
        this.panelCourse = new JPanel();
        panelCourse = new JPanel(new BorderLayout());
        this.coursePage = new JPanelCoursePage();
        this.panelCourse.add(coursePage, BorderLayout.CENTER);
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(216, 76, 0, 76);
        getInfoPanel().add(panelCourse, gbc);

    }

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

    public void setPathCourse(String pathCouse) {
        this.coursePage.loadPage(pathCouse);
    }

    public JPanelCoursePage getWebCourse() {
        return coursePage;
    }

}
