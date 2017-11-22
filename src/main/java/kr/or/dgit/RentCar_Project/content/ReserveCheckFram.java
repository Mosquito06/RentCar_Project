package kr.or.dgit.RentCar_Project.content;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class ReserveCheckFram extends JFrame {

	private JPanel contentPane;
	private TextFieldComponent tfInsurance;
	private JButton btnReserve;
	private TextFieldComponent tfPrice;

	public TextFieldComponent getTfPrice() {
		return tfPrice;
	}

	public JButton getBtnReserve() {
		return btnReserve;
	}

	public TextFieldComponent getTfInsurance() {
		return tfInsurance;
	}

	public ReserveCheckFram(String name, String img,String old, String seater, String auto, String fuel,String sDay,String fDay) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 854, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		btnReserve = new JButton("예약");
		btnReserve.setBounds(125, 466, 127, 37);
		contentPane.add(btnReserve);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(368, 466, 127, 37);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 0, 5, 0));
		panel.setBounds(0, 0, 603, 53);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		TextFieldComponent tfSDay = new TextFieldComponent("대여일");
		tfSDay.setFont(new Font("굴림", Font.BOLD, 13));
		tfSDay.getTextField().setFont(new Font("굴림", Font.BOLD, 13));
		panel.add(tfSDay);
		tfSDay.setTextValue(sDay);
		tfSDay.getTextField().setFocusable(false);
		TextFieldComponent tfEDay = new TextFieldComponent("반납일");
		tfEDay.setFont(new Font("굴림", Font.BOLD, 13));
		tfEDay.getTextField().setFont(new Font("굴림", Font.BOLD, 13));
		panel.add(tfEDay);
		tfEDay.setTextValue(fDay);
		tfEDay.getTextField().setFocusable(false);
		tfPrice = new TextFieldComponent("결제금액");
		tfPrice.getTextField().setFont(new Font("굴림", Font.BOLD, 13));
		panel.add(tfPrice);
		tfPrice.getTextField().setFocusable(false);
		tfInsurance = new TextFieldComponent("자차보험");
		tfInsurance.setTextValue("O");
		tfInsurance.setBounds(463, 54, 140, 23);
		contentPane.add(tfInsurance);
		tfInsurance.getTextField().setFocusable(false);
		ReserveCarValue carValue = new ReserveCarValue(name, img, old, seater, auto, fuel);
		carValue.setBounds(0, 52, 620, 404);
		contentPane.add(carValue);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u203B\uC8FC\uC758\uC0AC\uD56D\u203B", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1.setBounds(617, 21, 219, 482);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("대여당일 예약취소는 불가합니다.");
		lblNewLabel.setBounds(12, 352, 195, 15);
		panel_1.add(lblNewLabel);
		
		JLabel label = new JLabel("●환불규정");
		label.setBounds(12, 328, 195, 21);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("예약 후 24시간 이내에 예약을 취소");
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setBounds(12, 370, 195, 15);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("할 경우 예약금 전액을 환급받으실");
		label_2.setVerticalAlignment(SwingConstants.TOP);
		label_2.setBounds(12, 387, 195, 15);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("수있습니다.");
		label_3.setVerticalAlignment(SwingConstants.TOP);
		label_3.setBounds(12, 404, 195, 15);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("●운전시");
		label_4.setBounds(12, 30, 195, 21);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("예약자의 이름으로 보험처리가 이루");
		label_5.setBounds(12, 54, 195, 15);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("러지기 때문에 예약자외 렌트카 운");
		label_6.setVerticalAlignment(SwingConstants.TOP);
		label_6.setBounds(12, 72, 195, 15);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("행시 불이익을 가져올 수 있습니다.");
		label_7.setVerticalAlignment(SwingConstants.TOP);
		label_7.setBounds(12, 89, 195, 15);
		panel_1.add(label_7);
		
		JLabel label_9 = new JLabel("●반납시");
		label_9.setBounds(12, 114, 195, 21);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("대여 전에 미리 렌트카의 상태를 확");
		label_10.setBounds(12, 138, 195, 15);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("인후 대여가 이루어 집니다.");
		label_11.setVerticalAlignment(SwingConstants.TOP);
		label_11.setBounds(12, 156, 195, 15);
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel("렌트카를 운행전 연료량,파손등을");
		label_12.setVerticalAlignment(SwingConstants.TOP);
		label_12.setBounds(12, 173, 195, 15);
		panel_1.add(label_12);
		
		JLabel label_13 = new JLabel("미리확인 하시고 연료는 대여 전 ");
		label_13.setVerticalAlignment(SwingConstants.TOP);
		label_13.setBounds(12, 190, 195, 15);
		panel_1.add(label_13);
		
		JLabel label_8 = new JLabel("과 동일한 양으로 반납하시면 됩니");
		label_8.setVerticalAlignment(SwingConstants.TOP);
		label_8.setBounds(12, 206, 195, 15);
		panel_1.add(label_8);
		
		JLabel label_14 = new JLabel("다. ");
		label_14.setVerticalAlignment(SwingConstants.TOP);
		label_14.setBounds(12, 221, 195, 15);
		panel_1.add(label_14);
		
		JLabel label_15 = new JLabel("●사고시");
		label_15.setBounds(12, 244, 195, 21);
		panel_1.add(label_15);
		
		JLabel label_16 = new JLabel("당황하지마시고 저희 렌트카로 연락");
		label_16.setBounds(12, 268, 195, 15);
		panel_1.add(label_16);
		
		JLabel label_17 = new JLabel("주시면 신속하게 처리를 도와 드리");
		label_17.setVerticalAlignment(SwingConstants.TOP);
		label_17.setBounds(12, 286, 195, 15);
		panel_1.add(label_17);
		
		JLabel label_18 = new JLabel("겠습니다. ");
		label_18.setVerticalAlignment(SwingConstants.TOP);
		label_18.setBounds(12, 303, 195, 15);
		panel_1.add(label_18);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(2, 439, 215, 39);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("010-1234-1234");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1, BorderLayout.CENTER);
	}
}
