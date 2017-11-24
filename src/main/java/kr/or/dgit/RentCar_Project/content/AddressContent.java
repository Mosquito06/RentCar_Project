package kr.or.dgit.RentCar_Project.content;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AddressContent extends JPanel {

	private JButton btnSelect;
	private JLabel lblNewLabel;
	private JPanel panel_2;

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public JButton getBtnSelect() {
		return btnSelect;
	}

	public AddressContent(String addr) {
		setBorder(new EmptyBorder(7, 0, 5, 0));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.EAST);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnSelect = new JButton("선택");
		btnSelect.setHorizontalAlignment(SwingConstants.LEADING);
		panel.add(btnSelect);
		
		panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
				panel_2.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
				lblNewLabel = new JLabel(addr);
				panel_2.add(lblNewLabel);

	}

}
