package kr.or.dgit.RentCar_Project.content;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import kr.or.dgit.RentCar_Project.component.ImgRadioComponent;
import javax.swing.JButton;

public class UpdateProfileContent extends JPanel {

	private JButton btnUpdate;
	private ButtonGroup group;

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public UpdateProfileContent() {
		setLayout(null);

		ImgRadioComponent img = new ImgRadioComponent("user1");
		img.setBounds(25, 56, 104, 117);
		add(img);

		ImgRadioComponent img1 = new ImgRadioComponent("user2");
		img1.setBounds(141, 56, 104, 117);
		add(img1);

		ImgRadioComponent img2 = new ImgRadioComponent("user3");
		img2.setBounds(257, 56, 104, 117);
		add(img2);

		ImgRadioComponent img3 = new ImgRadioComponent("user4");
		img3.setBounds(373, 56, 104, 117);
		add(img3);

		ImgRadioComponent img4 = new ImgRadioComponent("user5");
		img4.setBounds(25, 183, 104, 117);
		add(img4);

		ImgRadioComponent img5 = new ImgRadioComponent("user6");
		img5.setBounds(141, 183, 104, 117);
		add(img5);

		ImgRadioComponent img6 = new ImgRadioComponent("user7");
		img6.setBounds(257, 183, 104, 117);
		add(img6);

		ImgRadioComponent img7 = new ImgRadioComponent("user8");
		img7.setBounds(373, 183, 104, 117);
		add(img7);

		group = new ButtonGroup();
		group.add(img.getRidioButton());
		group.add(img1.getRidioButton());
		group.add(img2.getRidioButton());
		group.add(img3.getRidioButton());
		group.add(img4.getRidioButton());
		group.add(img5.getRidioButton());
		group.add(img6.getRidioButton());
		group.add(img7.getRidioButton());

		btnUpdate = new JButton("수정하기");
		btnUpdate.setBounds(191, 310, 126, 23);
		add(btnUpdate);
	}
	
	// 라디오버튼 그룹에서 선택된 버튼의 텍스트 값 리턴 함수
	public String getSelectRadioText() {
		Enumeration<AbstractButton> selectObject = group.getElements();
		while(selectObject.hasMoreElements()) {
			JRadioButton jb = (JRadioButton) selectObject.nextElement();
			if(jb.isSelected()) {
				return jb.getText();
			}
		}
		return null;
	}

}
