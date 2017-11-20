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
import kr.or.dgit.RentCar_Project.dto.CarModel;
import kr.or.dgit.RentCar_Project.list.CarModelTable;
import kr.or.dgit.RentCar_Project.service.CarModelService;

@SuppressWarnings("serial")
public class CarModellListManagerContent extends JPanel implements ActionListener {
	private ComboBoxComponent<CarModel> carModel;
	private JButton btnSearch;
	private JButton btnAll;
	protected CarModelTable cmTable;
	private CarModelContent cmContent;
	
	
	public void setCmContent(CarModelContent cmContent) {
		this.cmContent = cmContent;
	}

	public CarModellListManagerContent() {
		setBounds(100, 100, 431, 243);
		setLayout(null);
		
		carModel = new ComboBoxComponent<>("차종 코드");
		carModel.setBounds(5, 10, 211, 37);
		add(carModel);
		
		btnSearch = new JButton("검색");
		btnSearch.setBounds(218, 10, 67, 39);
		btnSearch.addActionListener(this);
		add(btnSearch);
		
		btnAll = new JButton("전체보기");
		btnAll.setBounds(327, 10, 97, 37);
		btnAll.addActionListener(this);
		add(btnAll);
		
		cmTable = new CarModelTable();
		cmTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		cmTable.setBounds(5, 57, 420, 166);
		cmTable.setFull(true);
		cmTable.loadDate();
		add(cmTable);
		setCarModelComboBoxModel();
	}
	
	public void setCarModelComboBoxModel() {
		List<CarModel> lists = CarModelService.getInstance().selectCarModelByAll();
		Vector<CarModel> cmCode = new Vector<>();
		for(CarModel cm:lists) {
			cm.setComboType(0);
			cmCode.add(cm);
		}
		carModel.setComboBoxModel(cmCode);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSearch) {
			cmTable.setFull(false);
			CarModel cmCode = carModel.getComboboxValue();
			cmTable.setCmCode(cmCode);
			cmTable.loadDate();
			cmContent.getCmCode().setTextValue(cmCode.getCarModelCode());
			cmContent.getCarModel().setTextValue(cmCode.getCarModel());
		}
		if(e.getSource()==btnAll) {
			cmTable.setFull(true);
			cmTable.loadDate();
		}
	}
	
	
}
