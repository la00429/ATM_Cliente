package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

// TODO: Auto-generated Javadoc
/**
 * The Class JComboCell.
 */
public class JComboCell extends DefaultListCellRenderer{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Gets the list cell renderer component.
	 *
	 * @param list the list
	 * @param value the value
	 * @param index the index
	 * @param isSelected the is selected
	 * @param cellHasFocus the cell has focus
	 * @return the list cell renderer component
	 */
	@Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel cell = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        // Personaliza la apariencia de cada item aquí
        cell.setFont(new Font("Arial", Font.PLAIN, 20));
        cell.setForeground(Color.DARK_GRAY);
        cell.setPreferredSize(new Dimension(420, 50));
        return cell;
    }

}
