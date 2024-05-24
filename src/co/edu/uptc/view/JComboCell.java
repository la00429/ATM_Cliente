package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

public class JComboCell extends DefaultListCellRenderer {
    private static final long serialVersionUID = 1L;

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel cell = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        cell.setFont(new Font("Arial", Font.PLAIN, 20));
        cell.setForeground(Color.DARK_GRAY);
        cell.setPreferredSize(new Dimension(420, 50));
        return cell;
    }

}
