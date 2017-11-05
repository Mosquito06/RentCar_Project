package kr.or.dgit.RentCar_Project.content;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.component.ImgRadioComponent;
import javax.swing.JButton;

public class UpdateProfileContent extends JPanel {

	private JButton btnUpdate;
	private ButtonGroup group;

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public ButtonGroup getGroup() {
		return group;
	}

	public UpdateProfileContent() {
		setLayout(null);

		ImgRadioComponent img = new ImgRadioComponent("user1");
		img.setBounds(23, 52, 104, 117);
		add(img);

		ImgRadioComponent img1 = new ImgRadioComponent("user2");
		img1.setBounds(152, 52, 104, 117);
		add(img1);

		ImgRadioComponent img2 = new ImgRadioComponent("user3");
		img2.setBounds(284, 52, 104, 117);
		add(img2);

		ImgRadioComponent img3 = new ImgRadioComponent("user4");
		img3.setBounds(413, 52, 104, 117);
		add(img3);

		ImgRadioComponent img4 = new ImgRadioComponent("user5");
		img4.setBounds(23, 179, 104, 117);
		add(img4);

		ImgRadioComponent img5 = new ImgRadioComponent("user6");
		img5.setBounds(152, 179, 104, 117);
		add(img5);

		ImgRadioComponent img6 = new ImgRadioComponent("user7");
		img6.setBounds(284, 179, 104, 117);
		add(img6);

		ImgRadioComponent img7 = new ImgRadioComponent("user8");
		img7.setBounds(413, 179, 104, 117);
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
		btnUpdate.setBounds(209, 306, 126, 23);
		add(btnUpdate);
	}

}
