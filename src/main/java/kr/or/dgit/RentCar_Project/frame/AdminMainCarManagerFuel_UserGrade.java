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
import kr.or.dgit.RentCar_Project.content.FuelManagerContent;
import kr.or.dgit.RentCar_Project.content.UserGradeContent;
import kr.or.dgit.RentCar_Project.dto.Fuel;
import kr.or.dgit.RentCar_Project.dto.UserGrade;
import kr.or.dgit.RentCar_Project.list.FindFuelTable;
import kr.or.dgit.RentCar_Project.list.FindUserGradeTable;
import kr.or.dgit.RentCar_Project.list.FuelTable;
import kr.or.dgit.RentCar_Project.list.UserGradeTable;
import kr.or.dgit.RentCar_Project.service.FuelService;
import kr.or.dgit.RentCar_Project.service.UserGradeService;

@SuppressWarnings("serial")
public class AdminMainCarManagerFuel_UserGrade extends JPanel implements ActionListener {
	
	private FuelTable fuelTable;
	private UserGradeTable userGradeTable;
	private String[] details = {"선택하세요","대여단가 관리","차종&제조회사 관리","초기화면"};
	private JButton btnSearchFuel;
	private JButton btnAllFuel;
	private JButton btnBack;
	private JButton button;
	private ComboBoxComponent<Fuel> searchFuel;
	private FindFuelTable findTable;
	private JPanel fuelList;
	private ComboBoxComponent<UserGrade> searchUserGrade;
	private JButton btnAllUserGrade;
	private JPanel userGradeList;
	private FuelManagerContent inputfuel;
	private FindUserGradeTable findUserGrade;
	private JButton btnSearchUG;
	private UserGradeContent inputUserGrade;
	
	public AdminMainCarManagerFuel_UserGrade() {
		setBounds(100, 100, 974, 751);
		setLayout(null);
		
		JPanel fuelPanel = new JPanel();
		fuelPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.RAISED, null, null)), " \uC5F0\uB8CC \uAD00\uB9AC ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		fuelPanel.setBounds(30, 43, 370, 669);
		add(fuelPanel);
		fuelPanel.setLayout(null);
		
		fuelList = new JPanel();
		fuelList.setBounds(12, 237, 345, 395);
		fuelPanel.add(fuelList);
		fuelList.setLayout(new BorderLayout(0, 0));
		fuelTable = new FuelTable();
		fuelTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		fuelTable.loadDate();
		fuelList.add(fuelTable);
		
		inputfuel = new FuelManagerContent();
		inputfuel.setBounds(12, 21, 345, 161);
		fuelPanel.add(inputfuel);
		
		btnSearchFuel = new JButton("검색");
		btnSearchFuel.setBounds(256, 192, 65, 35);
		btnSearchFuel.addActionListener(this);
		fuelPanel.add(btnSearchFuel);
		
		btnAllFuel = new JButton("전체보기");
		btnAllFuel.setBounds(270, 636, 87, 23);
		btnAllFuel.addActionListener(this);
		fuelPanel.add(btnAllFuel);
		
		searchFuel = new ComboBoxComponent<>("연료코드");
		searchFuel.setBounds(54, 192, 200, 35);
		fuelPanel.add(searchFuel);
		
		btnBack = new JButton("나가기");
		btnBack.addActionListener(this);
		btnBack.setBounds(865, 686, 97, 23);
		add(btnBack);
		
		JPanel userGradePanel = new JPanel();
		userGradePanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.LOWERED, null, null)), " \uACE0\uAC1D\uB4F1\uAE09 \uAD00\uB9AC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		userGradePanel.setBounds(449, 43, 370, 669);
		add(userGradePanel);
		userGradePanel.setLayout(null);
		
		inputUserGrade = new UserGradeContent();
		inputUserGrade.setBounds(12, 21, 345, 161);
		userGradePanel.add(inputUserGrade);
		
		userGradeList = new JPanel();
		userGradeList.setBounds(12, 238, 345, 395);
		userGradePanel.add(userGradeList);
		userGradeList.setLayout(new BorderLayout(0, 0));
		userGradeTable = new UserGradeTable();
		userGradeTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		userGradeTable.loadDate();
		userGradeList.add(userGradeTable);
		
		btnAllUserGrade = new JButton("전체보기");
		btnAllUserGrade.setBounds(270, 636, 87, 23);
		btnAllUserGrade.addActionListener(this);
		userGradePanel.add(btnAllUserGrade);
		
		btnSearchUG = new JButton("검색");
		btnSearchUG.setBounds(256, 192, 65, 35);
		btnSearchUG.addActionListener(this);
		userGradePanel.add(btnSearchUG);
		
		searchUserGrade = new ComboBoxComponent<>("고객등급");
		searchUserGrade.setBounds(54, 192, 200, 35);
		userGradePanel.add(searchUserGrade);
		
		button = new JButton("세부사항 관리");
		button.setBounds(847, 53, 115, 23);
		button.addActionListener(this);
		add(button);
		setFuelComboBoxModel();
		setUserGradeComboBoxModel();
		findTable = new FindFuelTable();
		findUserGrade = new FindUserGradeTable();
	
		
	}
	public ComboBoxComponent<Fuel> getSearch() {
		return searchFuel;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSearchFuel) {
			fuelList.validate();
			Fuel fuelCode  = searchFuel.getComboboxValue();
			findTable.setFuel(fuelCode);
			findTable.loadDate();
			fuelList.add(findTable);
			 inputfuel.getFuelCode().setTextValue(fuelCode.getFuelCode());
			 inputfuel.getFuelType().setTextValue(fuelCode.getFuelType());
		}
		if(e.getSource()==btnBack) {
			JFrame frame = AdminMain.getInstance();
			frame.getContentPane().removeAll();
			frame.getContentPane().add(new AdminMainCarManager(), BorderLayout.CENTER);
			frame.setVisible(true);
		}
		if(e.getSource()==button) {
			Object selected = JOptionPane.showInputDialog(null, "세부관리 사항을 선택하세요", "세부관리", JOptionPane.QUESTION_MESSAGE, null, details, details[0]);
			openDetailFrame(selected);
		}
		if(e.getSource()==btnAllFuel) {
			fuelList.revalidate();
			fuelTable.loadDate();
			fuelList.add(fuelTable);
		}
		if(e.getSource()==btnSearchUG) {
			userGradeList.revalidate();
			UserGrade userGrade = searchUserGrade.getComboboxValue();
			findUserGrade.setUserGrade(userGrade);
			findUserGrade.loadDate();
			userGradeList.add(findUserGrade);
			inputUserGrade.getUserGrade().setTextValue(userGrade.getGrade());
			inputUserGrade.getDiscount().setTextValue(userGrade.getDiscount()+"");
			
		}
		if(e.getSource()==btnAllUserGrade) {
			userGradeList.revalidate();
			userGradeTable.loadDate();
			userGradeList.add(userGradeTable);
		}
	}
	public void setUserGradeComboBoxModel() {
		List<UserGrade> lists = UserGradeService.getInstance().selectUserGradeByAll();
		Vector<UserGrade> userGrade = new Vector<>();
		for(UserGrade ug:lists) {
			ug.setComboType(1);
			userGrade.add(ug);
		}
		searchUserGrade.setComboBoxModel(userGrade);
	}
	public void setFuelComboBoxModel() {
		List<Fuel> lists = FuelService.getInstance().selectFuelByAll();
		Vector<Fuel> fuelCode = new Vector<>();
		for(Fuel f : lists) {
			f.setComboType(1);
			fuelCode.add(f);
		}
		searchFuel.setComboBoxModel(fuelCode);
	}
	private void openDetailFrame(Object selected) {
		JFrame frame = AdminMain.getInstance();
		frame.getContentPane().removeAll();
		if(selected==details[0]) {
			JOptionPane.showMessageDialog(null, "세부사항을 선택하세요");
			return;
		}
		else if(selected==details[1]) {
			frame.getContentPane().add(new AdminMainCarManagerRentalPrice(), BorderLayout.CENTER);
		}else if(selected==details[2]) {
			frame.getContentPane().add(new AdminMainCarManagerCarModel_Manufacturer(), BorderLayout.CENTER);
		}else if(selected==details[3]) {
			frame.getContentPane().add(new AdminMainCarManager(), BorderLayout.CENTER);
		}else {
			return;
		}
		frame.setVisible(true);
	}
}
