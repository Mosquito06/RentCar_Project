package kr.or.dgit.RentCar_Project.component;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class RadioComboBoxComponent<T> extends JPanel {
	private JComboBox comboBox;
	private JRadioButton radioButton;

	public JComboBox getComboBox() {
		return comboBox;
	}
	
	public RadioComboBoxComponent(String title) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{88, 100, 149, 0};
		gridBagLayout.rowHeights = new int[]{35, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		radioButton = new JRadioButton("");
		radioButton.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.fill = GridBagConstraints.BOTH;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnNewRadioButton.gridx = 0;
		gbc_rdbtnNewRadioButton.gridy = 0;
		add(radioButton, gbc_rdbtnNewRadioButton);
		
		JLabel lbl = new JLabel(title);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lbl = new GridBagConstraints();
		gbc_lbl.fill = GridBagConstraints.BOTH;
		gbc_lbl.insets = new Insets(0, 0, 0, 5);
		gbc_lbl.gridx = 1;
		gbc_lbl.gridy = 0;
		add(lbl, gbc_lbl);
		
		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 0;
		add(comboBox, gbc_comboBox);

	}

	public void setComboBoxModel(Vector<T> list) {
		ComboBoxModel<T> model = new DefaultComboBoxModel<>(list);
		comboBox.setModel(model);
	}
	
	public AbstractButton getRadioButton() {
		return radioButton;
	}

	public JComboBox selectGetComboBox() {
		if(radioButton.isSelected()) {
			return comboBox;
		}
		return null;
	}
}
