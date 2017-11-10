package kr.or.dgit.RentCar_Project.component;

import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import kr.or.dgit.RentCar_Project.dto.Manufacturer;
import kr.or.dgit.RentCar_Project.service.ManufacturerService;

@SuppressWarnings("serial")
public class ComboBoxComponent<T> extends JPanel {
	private JComboBox<T> comboBox;

	
	public ComboBoxComponent(String title) {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lbl = new JLabel(title);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl);
		
		comboBox = new JComboBox<>();
		add(comboBox);

	}


	public JComboBox<T> getComboBox() {
		return comboBox;
	}


	public void setComboBox(JComboBox<T> comboBox) {
		this.comboBox = comboBox;
	}
	
	public void setComboBoxModel(Vector<T> lists) {
		ComboBoxModel<T> model = new DefaultComboBoxModel<>(lists);
		comboBox.setModel(model);
	}


	
	public T getComboboxValue() {
		return (T) comboBox.getSelectedItem();
	}
	
	
	
	
}


