package kr.or.dgit.RentCar_Project.content;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class AddressContent extends JPanel {

	private JButton btnSelect;
	private JLabel lblNewLabel;

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public JButton getBtnSelect() {
		return btnSelect;
	}

	public AddressContent(String addr) {
		setBorder(new EmptyBorder(7, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel(addr);
		add(lblNewLabel, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));

		btnSelect = new JButton("선택");
		panel.add(btnSelect);

	}

}
