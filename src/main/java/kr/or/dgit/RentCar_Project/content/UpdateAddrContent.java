package kr.or.dgit.RentCar_Project.content;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import kr.or.dgit.RentCar_Project.dto.User;

public class UpdateAddrContent extends JPanel {
	private JTextField TfFirstAddr;
	private JTextField TfLastAddr;
	private JButton btnAddrSearch;
	private JButton btnAddrUpdate;

	public JTextField getTfFirstAddr() {
		return TfFirstAddr;
	}

	public JButton getBtnNewButton() {
		return btnAddrSearch;
	}

	public JButton getBtnAddrUpdate() {
		return btnAddrUpdate;
	}

	public UpdateAddrContent() {
		setLayout(null);

		JLabel lblName = new JLabel("주소");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(4, 4, 99, 100);
		add(lblName);

		TfFirstAddr = new JTextField();
		TfFirstAddr.setBounds(115, 14, 248, 35);
		add(TfFirstAddr);
		TfFirstAddr.setColumns(10);

		TfLastAddr = new JTextField();
		TfLastAddr.setColumns(10);
		TfLastAddr.setBounds(115, 59, 365, 35);
		add(TfLastAddr);

		btnAddrSearch = new JButton("주소검색");
		btnAddrSearch.setBounds(375, 14, 105, 35);
		add(btnAddrSearch);

		btnAddrUpdate = new JButton("수정하기");
		btnAddrUpdate.setBounds(192, 104, 122, 25);
		add(btnAddrUpdate);

	}

	public String getAddr() {
		return TfFirstAddr.getText() + "/" + TfLastAddr.getText();
	}
	
	public void setAddrText(User ComfirmUser) {
		String[] Addr = ComfirmUser.getAddr().split("/");
		TfFirstAddr.setText(Addr[0]);
		TfLastAddr.setText(Addr[1]);
	}
	
	public boolean isEmptyCheck() {
		if(TfFirstAddr.getText().equals("")){
			TfFirstAddr.requestFocus();
			return false;
		}else if(TfLastAddr.getText().equals("")) {
			TfLastAddr.requestFocus();
			return false;
		}else {
			return true;
		}
	}
}
