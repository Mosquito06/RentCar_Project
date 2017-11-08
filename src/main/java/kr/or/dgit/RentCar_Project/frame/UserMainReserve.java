package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.content.ReserveAddCarContent;
import kr.or.dgit.RentCar_Project.content.ReserveHeaderContent;
import kr.or.dgit.RentCar_Project.content.ReserveLeftContent;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class UserMainReserve extends JPanel {
	

	public UserMainReserve() {

		setBounds(new Rectangle(0, 0, 500, 500));
		setLayout(null);
		
		ReserveLeftContent leftPanel = new ReserveLeftContent();
		leftPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.LOWERED, null, null)), "\uC0C1\uC138\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		leftPanel.setBounds(0, 79, 302, 672);
		add(leftPanel);
		leftPanel.setLayout(null);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBounds(310, 112, 664, 639);
		add(rightPanel);
		rightPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		rightPanel.add(scrollPane);
		
		JPanel carList = new JPanel();
		scrollPane.setViewportView(carList);
		carList.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\DGIT3-10\\Desktop\\if_BT_c3angle_905667.png"));
		lblNewLabel_1.setBounds(65, 0, 522, 590);
		carList.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("날짜를 입력하세요");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(24, 40, 210, 101);
		carList.add(lblNewLabel);
		
		ReserveHeaderContent header = new ReserveHeaderContent();
		header.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		header.setBounds(3, 3, 968, 72);
		add(header);
		
		header.getBtnSearch().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(header.getTotalTimePanel().getTextValue().equals("0")) {
					JOptionPane.showMessageDialog(null, "날짜를 정확하게 입력하세요");
					return;
				}
				ReserveAddCarContent addCar = new ReserveAddCarContent();
				scrollPane.setViewportView(addCar);
				addCar.setLayout(new GridLayout(0, 1, 0, 0));
				
			}
		});
		
		
		JButton btnB = new JButton("소형");
		btnB.setBounds(402, 79, 74, 29);
		add(btnB);
		
		JButton btnC = new JButton("중형");
		btnC.setBounds(490, 79, 74, 29);
		add(btnC);
		
		JButton btnD = new JButton("고급");
		btnD.setBounds(583, 79, 74, 29);
		add(btnD);
		
		JButton btnA = new JButton("경차");
		btnA.setBounds(310, 79, 74, 29);
		add(btnA);
		
		JButton btnE = new JButton("RV/SUV");
		btnE.setBounds(680, 79, 86, 29);
		add(btnE);
		
		JButton btnF = new JButton("수입차");
		btnF.setBounds(792, 79, 74, 29);
		add(btnF);
		
		JButton btnG = new JButton("승합차");
		btnG.setBounds(888, 79, 74, 29);
		add(btnG);
	}
}
