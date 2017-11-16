package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.content.RentalPriceManagerContent;
import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.list.RentalPriceTable;
import kr.or.dgit.RentCar_Project.service.CarDataService;

@SuppressWarnings("serial")
public class AdminMainCarManagerRentalPrice extends JPanel {
	private ComboBoxComponent<CarData> searchCode;
	private RentalPriceTable rentalPriceTable;
	private String[] details = {"선택하세요","차종&제조회사 관리","연료&고객등급 관리","초기화면"};
	
	public AdminMainCarManagerRentalPrice() {
		setBounds(100, 100, 974, 751);
		setLayout(null);
		
		JPanel totalPanel = new JPanel();
		totalPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uB300\uC5EC\uB2E8\uAC00 \uAD00\uB9AC ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		totalPanel.setBounds(12, 10, 957, 698);
		add(totalPanel);
		totalPanel.setLayout(null);
		
		RentalPriceManagerContent inputPanel = new RentalPriceManagerContent();
		inputPanel.setBounds(12, 27, 286, 650);
		totalPanel.add(inputPanel);
		
		JPanel listPanel = new JPanel();
		listPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), " \uC804\uCCB4 \uBCF4\uAE30 ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		listPanel.setBounds(310, 43, 624, 634);
		totalPanel.add(listPanel);
		listPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 75, 600, 561);
		listPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		rentalPriceTable = new RentalPriceTable();
		rentalPriceTable.loadDate();
		panel.add(rentalPriceTable,BorderLayout.CENTER);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), " \uAC80\uC0C9 ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		searchPanel.setBounds(95, 10, 440, 55);
		listPanel.add(searchPanel);
		searchPanel.setLayout(null);
		
		searchCode = new ComboBoxComponent<>("차 코드");
		searchCode.setBounds(74, 15, 244, 28);
		searchPanel.add(searchCode);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(331, 15, 97, 28);
		searchPanel.add(btnSearch);
		
		JButton button = new JButton("세부사항 관리");
		button.setBounds(819, 20, 115, 23);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object selected = JOptionPane.showInputDialog(null, "세부관리 사항을 선택하세요", "세부관리", JOptionPane.QUESTION_MESSAGE, null, details, details[0]);
				openDetailFrame(selected);
			}
		});
		totalPanel.add(button);
		
		JButton btnBack = new JButton("나가기");
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = AdminMain.getInstance();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new AdminMainCarManager(), BorderLayout.CENTER);
				frame.setVisible(true);
				
			}
		});
		btnBack.setBounds(872, 718, 97, 23);
		add(btnBack);
		setSearchCarCodeComboModel();
	}
	
	public void setSearchCarCodeComboModel() {
		CarDataService carDataService = CarDataService.getInstance();
		List<CarData> lists = carDataService.selectCarDataByAll();
		Vector<CarData> carData = new Vector<>();
		for(CarData cd : lists) {
			cd.setComboType(0);
			carData.add(cd);
		}
		searchCode.setComboBoxModel(carData);
	}
	
	private void openDetailFrame(Object selected) {
		if(selected==details[0]){
			JOptionPane.showMessageDialog(null, "세부사향을 선택하세요");
			return;
			
		}else if(selected==details[1]) {
			JFrame frame = AdminMain.getInstance();
			frame.getContentPane().removeAll();
			frame.getContentPane().add(new AdminMainCarManagerCarModel_Manufacturer(), BorderLayout.CENTER);
			frame.setVisible(true);
		}else if(selected==details[2]) {
			JFrame frame = AdminMain.getInstance();
			frame.getContentPane().removeAll();
			frame.getContentPane().add(new AdminMainCarManagerFuel_UserGrade(), BorderLayout.CENTER);
			frame.setVisible(true);
		}else if(selected==details[3]) {
			JFrame frame = AdminMain.getInstance();
			frame.getContentPane().removeAll();
			frame.getContentPane().add(new AdminMainCarManager(), BorderLayout.CENTER);
			frame.setVisible(true);
		}else {
			return;
		}
	}
}
