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
import kr.or.dgit.RentCar_Project.dto.RentalPrice;
import kr.or.dgit.RentCar_Project.list.RentalPriceTable;
import kr.or.dgit.RentCar_Project.service.CarDataService;

@SuppressWarnings("serial")
public class AdminMainCarManagerRentalPrice extends JPanel implements ActionListener{
	private ComboBoxComponent<CarData> searchCode;
	private RentalPriceTable rentalPriceTable;
	private String[] details = {"선택하세요","차종&제조회사&연료 관리","초기화면"};
	private JButton btnSearch;
	private JButton btnAll;
	
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
		listPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), " \uCC28\uB7C9 \uAC00\uACA9 \uB9AC\uC2A4\uD2B8 ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		listPanel.setBounds(310, 43, 624, 634);
		totalPanel.add(listPanel);
		listPanel.setLayout(null);
		rentalPriceTable = new RentalPriceTable();
		rentalPriceTable.setBounds(12, 105, 600, 519);
		listPanel.add(rentalPriceTable);
		rentalPriceTable.setFull(true);
		rentalPriceTable.loadDate();
		inputPanel.setRentalPriceTable(rentalPriceTable);
		
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), " \uAC80\uC0C9 ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		searchPanel.setBounds(12, 30, 440, 55);
		listPanel.add(searchPanel);
		searchPanel.setLayout(null);
		
		searchCode = new ComboBoxComponent<>("차 코드");
		searchCode.setBounds(74, 15, 244, 28);
		searchPanel.add(searchCode);
		
		btnSearch = new JButton("검색");
		btnSearch.setBounds(331, 15, 97, 28);
		btnSearch.addActionListener(this);
		searchPanel.add(btnSearch);
		
		btnAll = new JButton("전체보기");
		btnAll.setBounds(515, 26, 97, 28);
		btnAll.addActionListener(this);
		listPanel.add(btnAll);
		
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
		JFrame frame = AdminMain.getInstance();
		frame.getContentPane().removeAll();
		if(selected==details[0]){
			JOptionPane.showMessageDialog(null, "세부사향을 선택하세요");
			return;
		}else if(selected==details[1]) {
			frame.getContentPane().add(new AdminMainCarManagerCarDetail(), BorderLayout.CENTER);
		}else if(selected==details[2]) {
			frame.getContentPane().add(new AdminMainCarManager(), BorderLayout.CENTER);
		}else {
			return;
		}
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnSearch) {
			CarData cd = new CarData();
			cd.setCarCode(searchCode.getComboboxValue().getCarCode());
			RentalPrice carCode = new RentalPrice();
			carCode.setCarCode(cd);
			rentalPriceTable.setFull(false);
			rentalPriceTable.setCarCode(carCode);
			rentalPriceTable.loadDate();
		}
		if(e.getSource()==btnAll) {
			rentalPriceTable.setFull(true);
			rentalPriceTable.loadDate();
		}
		
	}
}
