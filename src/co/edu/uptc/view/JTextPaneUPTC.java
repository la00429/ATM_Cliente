package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JTextPane;

public class JTextPaneUPTC extends JTextPane {
    private Color colorBack;

    public JTextPaneUPTC() {
        super();
        setOpaque(false);
        setEditable(false);
        setContentType("text/html");
        setSize(new Dimension(930, 380));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getColorBack());
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 16, 16));
        super.paintComponent(g2d);

        g2d.dispose();
    }

    public void setColorBack(Color colorBack) {
        this.colorBack = colorBack;
    }

    public Color getColorBack() {
        return colorBack;
    }
}