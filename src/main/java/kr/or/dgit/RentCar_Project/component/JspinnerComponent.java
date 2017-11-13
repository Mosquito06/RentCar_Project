package kr.or.dgit.RentCar_Project.component;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JspinnerComponent extends JPanel {

	private JSpinner spinner;

	public JspinnerComponent(String title) {
		setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblSpinner = new JLabel(title);
		lblSpinner.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSpinner);
		
		spinner = new JSpinner();
		add(spinner);
		setDefaultValue(1, 1, 100, 1);
	}
	
	public JSpinner getComponent() {
		return spinner;
	}
	
	public void setSpinValue(int value) {
		spinner.setValue(value);
	}
	
	public int getSpinnerValue(){
		Number n = (Number) spinner.getValue();
		return n.intValue();
	}
	
	public void setDefaultValue(double value, double minimum, double maximum, double stepSize) {
		SpinnerModel model = new SpinnerNumberModel(value, minimum, maximum, stepSize);
		spinner.setModel(model);
	}
	
}
