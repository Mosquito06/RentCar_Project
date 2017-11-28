package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.content.RentalPriceListManagerContent;
import kr.or.dgit.RentCar_Project.content.RentalPriceManagerContent;

@SuppressWarnings("serial")
public class AdminMainCarManagerRentalPrice extends JPanel{
	private String[] details = {"선택하세요","차종&제조회사&연료 관리","차량제원 관리"};
	private RentalPriceListManagerContent listRentalPrice;
	private RentalPriceManagerContent inputPanel;
	
	public AdminMainCarManagerRentalPrice() {
		setBounds(100, 100, 974, 751);
		setLayout(null);
		
		JPanel totalPanel = new JPanel();
		totalPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uB300\uC5EC\uB2E8\uAC00 \uAD00\uB9AC ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		totalPanel.setBounds(12, 10, 957, 698);
		add(totalPanel);
		totalPanel.setLayout(null);
		
		inputPanel = new RentalPriceManagerContent();
		inputPanel.setBounds(12, 27, 286, 650);
		totalPanel.add(inputPanel);
		
		JPanel listPanel = new JPanel();
		listPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), " \uCC28\uB7C9 \uAC00\uACA9 \uB9AC\uC2A4\uD2B8 ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		listPanel.setBounds(310, 43, 624, 634);
		totalPanel.add(listPanel);
		listPanel.setLayout(null);
		
		listRentalPrice = new RentalPriceListManagerContent();
		listRentalPrice.setBounds(12, 22, 600, 602);
		listPanel.add(listRentalPrice);
		
		inputPanel.setRpListManagerContent(listRentalPrice);
		listRentalPrice.setRpManagerContent(inputPanel);
		
		JButton btnDetail = new JButton("세부사항 관리");
		btnDetail.setBounds(819, 20, 115, 23);
		btnDetail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object selected = JOptionPane.showInputDialog(null, "세부관리 사항을 선택하세요", "세부관리", JOptionPane.QUESTION_MESSAGE, null, details, details[0]);
				openDetailFrame(selected);
			}
		});
		totalPanel.add(btnDetail);
		
		JButton btnBack = new JButton("나가기");
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = AdminMain.getInstance();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new AdminMainHome(), BorderLayout.CENTER);
				frame.setVisible(true);
				
			}
		});
		btnBack.setBounds(872, 718, 97, 23);
		add(btnBack);
	
	}
	
	private void openDetailFrame(Object selected) {
		if(selected==null) {
			JOptionPane.showMessageDialog(null, "취소하셨습니다");
		}else if(selected==details[0]){
			JOptionPane.showMessageDialog(null, "세부사향을 선택하세요");
		}else if(selected==details[1]) {
			JFrame frame = AdminMain.getInstance();
			frame.getContentPane().removeAll();
			frame.getContentPane().add(new AdminMainCarManagerCarDetail(), BorderLayout.CENTER);
			frame.setVisible(true);
		}else if(selected==details[2]) {
			JFrame frame = AdminMain.getInstance();
			frame.getContentPane().removeAll();
			frame.getContentPane().add(new AdminMainCarManager(), BorderLayout.CENTER);
			frame.setVisible(true);
		}
		
	}
}
