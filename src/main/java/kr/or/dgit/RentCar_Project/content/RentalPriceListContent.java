package kr.or.dgit.RentCar_Project.content;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.RentalPrice;
import kr.or.dgit.RentCar_Project.list.RentalPriceTable;
import kr.or.dgit.RentCar_Project.service.CarDataService;

@SuppressWarnings("serial")
public class RentalPriceListContent extends JPanel 	implements ActionListener {
	
	private ComboBoxComponent<CarData> search;
	protected RentalPriceTable rpTable;
	private JButton btnAll;
	private JButton btnSearch;
	
	
	public RentalPriceListContent() {
		setBounds(100, 100, 600, 602);
		setLayout(null);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), " \uAC80\uC0C9 ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		searchPanel.setBounds(8, 7, 337, 62);
		add(searchPanel);
		searchPanel.setLayout(null);
		
		search = new ComboBoxComponent<>("차 코드");
		search.setBounds(12, 21, 244, 28);
		searchPanel.add(search);
		
		btnSearch = new JButton("검색");
		btnSearch.setBounds(257, 21, 68, 28);
		btnSearch.addActionListener(this);
		searchPanel.add(btnSearch);
		
		btnAll = new JButton("전체보기");
		btnAll.setBounds(498, 39, 97, 30);
		btnAll.addActionListener(this);
		add(btnAll);
		
		rpTable = new RentalPriceTable();
		rpTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		rpTable.setBounds(8, 77, 583, 519);
		rpTable.setFull(true);
		rpTable.loadDate();
		add(rpTable);
		
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
		if(e.getSource()==btnSearch) {
			rpTable.setFull(false);
			CarData  cd = new CarData();
			cd.setCarCode(search.getComboboxValue().getCarCode());
			RentalPrice carCode = new RentalPrice();
			carCode.setCarCode(cd);
			rpTable.setCarCode(carCode);
			rpTable.loadDate();
		}
		if(e.getSource()==btnAll) {
			rpTable.setFull(true);
			rpTable.loadDate();
		}
	}
}
