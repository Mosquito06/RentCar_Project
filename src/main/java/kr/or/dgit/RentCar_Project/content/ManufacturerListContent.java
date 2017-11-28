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
import kr.or.dgit.RentCar_Project.dto.Manufacturer;
import kr.or.dgit.RentCar_Project.list.ManufacturerTable;
import kr.or.dgit.RentCar_Project.service.ManufacturerService;

@SuppressWarnings("serial")
public class ManufacturerListContent extends JPanel implements ActionListener{
	private ComboBoxComponent<Manufacturer> manufacturer;
	private JButton btnSearch;
	private JButton btnAll;
	protected ManufacturerTable mfTable;
	private ManufacturerManagerContent mfManagerContent;
	
	public void setMfManagerContent(ManufacturerManagerContent mfManagerContent) {
		this.mfManagerContent = mfManagerContent;
	}

	public ManufacturerListContent() {
		setBounds(100, 100, 431, 243);
		setLayout(null);
	
		manufacturer = new ComboBoxComponent<>("제조회사 코드");
		manufacturer.setBounds(5, 10, 211, 37);
		add(manufacturer);
		
		btnSearch = new JButton("검색");
		btnSearch.setBounds(218, 10, 67, 39);
		btnSearch.addActionListener(this);
		add(btnSearch);
		
		btnAll = new JButton("전체보기");
		btnAll.setBounds(327, 10, 97, 37);
		btnAll.addActionListener(this);
		add(btnAll);
		
		mfTable = new ManufacturerTable();
		mfTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		mfTable.setBounds(5, 57, 420, 166);
		mfTable.setFull(true);
		mfTable.loadDate();
		add(mfTable);
		
		setManufacturerComboBoxModel();
	}
	
	public void setManufacturerComboBoxModel(){
		List<Manufacturer> lists = ManufacturerService.getInstance().selectManufacturerByAll();
		Vector<Manufacturer> mfCode = new Vector<>();
		for(Manufacturer mf : lists) {
			mf.setComboType(1);
			mfCode.add(mf);
		}
		manufacturer.setComboBoxModel(mfCode);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSearch) {
			Manufacturer mf = manufacturer.getComboboxValue();
			mfTable.setFull(false);
			mfTable.setMfCode(mf);
			mfTable.loadDate();
			mfManagerContent.getMfCode().setTextValue(mf.getManufacturerCode());
			mfManagerContent.getMfName().setTextValue(mf.getManufacturerName());
			mfManagerContent.setActive(true);
		}
		if(e.getSource()==btnAll) {
			mfTable.setFull(true);
			mfTable.loadDate();
			mfManagerContent.setManufacturerTextValueClear();
			manufacturer.getComboBox().setSelectedIndex(0);
			mfManagerContent.setActive(false);
		}
	}

}
