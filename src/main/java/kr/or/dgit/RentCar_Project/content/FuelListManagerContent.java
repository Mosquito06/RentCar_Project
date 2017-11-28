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
import kr.or.dgit.RentCar_Project.dto.Fuel;
import kr.or.dgit.RentCar_Project.list.FuelTable;
import kr.or.dgit.RentCar_Project.service.FuelService;

@SuppressWarnings("serial")
public class FuelListManagerContent extends JPanel implements ActionListener{
	private ComboBoxComponent<Fuel> fuel;
	private JButton btnSearch;
	private JButton btnAll;
	protected FuelTable fuelTable;
	private FuelManagerContent fmContent;
	
	
	public void setFMContent(FuelManagerContent fmContent) {
		this.fmContent = fmContent;
	}
	public FuelListManagerContent() {
		setBounds(100, 100, 431, 243);
		setLayout(null);
		
		fuel = new ComboBoxComponent<>("연료 코드");
		fuel.setBounds(5, 10, 211, 37);
		add(fuel);
		
		btnSearch = new JButton("검색");
		btnSearch.setBounds(218, 10, 67, 39);
		btnSearch.addActionListener(this);
		add(btnSearch);
		
		btnAll = new JButton("전체보기");
		btnAll.setBounds(327, 10, 97, 37);
		btnAll.addActionListener(this);
		add(btnAll);
		
		fuelTable = new FuelTable();
		fuelTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		fuelTable.setBounds(5, 57, 420, 166);
		fuelTable.setFull(true);
		fuelTable.loadDate();
		add(fuelTable);
		
		setFuelComboBoxModel();
		
	}
	public void setFuelComboBoxModel() {
		List<Fuel> lists = FuelService.getInstance().selectFuelByAll();
		Vector<Fuel> fuelCode = new Vector<>();
		for(Fuel f : lists) {
			f.setComboType(1);
			fuelCode.add(f);
		}
		fuel.setComboBoxModel(fuelCode);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSearch) {
			Fuel fuelKey = fuel.getComboboxValue();
			fuelTable.setFull(false);
			fuelTable.setFuel(fuelKey);
			fuelTable.loadDate();
			fmContent.getFuelCode().setTextValue(fuelKey.getFuelCode());
			fmContent.getFuelType().setTextValue(fuelKey.getFuelType());
		}
		if(e.getSource()==btnAll) {
			fuelTable.setFull(true);
			fuelTable.loadDate();
			fmContent.setFuelTextValueClear();
			fuel.getComboBox().setSelectedIndex(0);
		}
	}
	
	
}
