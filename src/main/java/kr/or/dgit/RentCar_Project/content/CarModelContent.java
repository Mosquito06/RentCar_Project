package kr.or.dgit.RentCar_Project.content;

import javax.swing.JPanel;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CarModelContent extends JPanel {
	private JTextField textField;

	public CarModelContent() {
		setLayout(null);
		
		TextFieldComponent carModelCodePanel = new TextFieldComponent("차종 코드");
		carModelCodePanel.setBounds(5, 31, 230, 30);
		add(carModelCodePanel);
		
		TextFieldComponent carModelPanel = new TextFieldComponent("차종");
		carModelPanel.setBounds(5, 73, 230, 30);
		add(carModelPanel);
		
		JPanel imgPanel = new JPanel();
		imgPanel.setLayout(null);
		imgPanel.setBounds(244, 21, 224, 82);
		add(imgPanel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(55, 10, 169, 29);
		imgPanel.add(textField);
		
		JButton btnImgDelete = new JButton("이미지 삭제");
		btnImgDelete.setBounds(112, 49, 112, 29);
		imgPanel.add(btnImgDelete);
		
		JButton btnImgAdd = new JButton("이미지 추가");
		btnImgAdd.setBounds(0, 49, 112, 29);
		imgPanel.add(btnImgAdd);
		
		JLabel label = new JLabel("경로");
		label.setBounds(0, 10, 47, 29);
		imgPanel.add(label);
		
		JButton btnAdd = new JButton("추가");
		btnAdd.setBounds(498, 15, 66, 23);
		add(btnAdd);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.setBounds(498, 40, 66, 23);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(498, 65, 66, 23);
		add(btnDelete);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(498, 105, 66, 23);
		add(btnCancel);

	}
}
