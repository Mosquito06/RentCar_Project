package kr.or.dgit.RentCar_Project.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.Rent;
import kr.or.dgit.RentCar_Project.list.RentTable;
import kr.or.dgit.RentCar_Project.service.CarDataService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;

@SuppressWarnings("serial")
public class AdminMainRentListManager extends JFrame implements ActionListener{

	private JPanel contentPane;
	private RentTable rentTable;
	private JButton btnOk;
	
	public AdminMainRentListManager(Rent rent) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage(System.getProperty("user.dir") + "\\images\\Instapaper icon.png");
		setIconImage(img);
		
		setResizable(false);
		CarData carCode = CarDataService.getInstance().selectCarDataByCarDataCode(rent.getCarCode());

		setTitle(rent.getCarCode() + " ("+carCode.getCarName()+") "+"대여 기록");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 949, 580);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rentTable = new RentTable();
		rentTable.setBounds(12, 91, 919, 417);
		rentTable.setKey("carCode");
		rentTable.setValue(carCode);
		rentTable.loadDate();
		contentPane.add(rentTable);
		
		btnOk = new JButton("확인");
		btnOk.setBounds(846, 518, 85, 23);
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.add(btnOk);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(590, 58, 85, 23);
		contentPane.add(btnSearch);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), " \uC120\uD0DD \uC0AC\uD56D ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(666, 10, 310, 55);
		contentPane.add(panel);
		
		JRadioButton radioReservation = new JRadioButton("예약기록");
		radioReservation.setBounds(26, 38, 121, 23);
		contentPane.add(radioReservation);
		
		JRadioButton radioButton_1 = new JRadioButton("취소기록");
		radioButton_1.setBounds(207, 38, 121, 23);
		contentPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("완료기록");
		radioButton_2.setBounds(354, 38, 121, 23);
		contentPane.add(radioButton_2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
