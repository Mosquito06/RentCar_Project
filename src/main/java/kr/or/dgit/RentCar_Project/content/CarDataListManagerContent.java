package kr.or.dgit.RentCar_Project.content;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.list.CarDataTable;
import kr.or.dgit.RentCar_Project.service.CarDataService;

@SuppressWarnings("serial")
public class CarDataListManagerContent extends JPanel implements ActionListener {
	
	private ComboBoxComponent<CarData> search;
	private CarDataTable listCarData;
	private JButton btnAll;
	private JButton btnSearch;
	
	public CarDataListManagerContent() {
		setBounds(100, 100, 950, 322);
		setLayout(null);
		
		JButton btnChart = new JButton("차트보기");
		btnChart.setBounds(841, 23, 97, 35);
		add(btnChart);
		
		btnAll = new JButton("전체보기");
		btnAll.setBounds(744, 23, 97, 35);
		btnAll.addActionListener(this);
		add(btnAll);
		
		search = new ComboBoxComponent<>("차 코드");
		search.setBounds(258, 23, 296, 35);
		add(search);
		
		listCarData = new CarDataTable();
		listCarData.setBorder(new LineBorder(new Color(0, 0, 0)));
		listCarData.setBounds(12, 68, 926, 244);
		listCarData.setFull(true);
		listCarData.loadDate();
		add(listCarData);
		
		btnSearch = new JButton("검색");
		btnSearch.setBounds(554, 23, 66, 35);
		btnSearch.addActionListener(this);
		add(btnSearch);
		
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
		
		search.setComboBoxModel(carData);
	}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==btnAll) {
				listCarData.setFull(true);
				listCarData.loadDate();
			}
			if(e.getSource()==btnSearch) {
				CarData carDataCode = search.getComboboxValue();
				listCarData.setFull(false);
				listCarData.setCarDataCode(carDataCode);
				listCarData.loadDate();
			}
			
		}
	

}
