package kr.or.dgit.RentCar_Project.content;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.dto.UserGrade;
import kr.or.dgit.RentCar_Project.list.UserGradeTable;
import kr.or.dgit.RentCar_Project.service.UserGradeService;
import kr.or.dgit.RentCar_Project.service.UserService;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class UserGradeListContent extends JPanel implements ActionListener{
	private ComboBoxComponent<UserGrade> grade;
	protected UserGradeTable userGradeTable;
	private JButton btnAll;
	private JButton btnSearch;
	private UserGradeContent userGradeContnet;
	
	public void setUserGradeContnet(UserGradeContent userGradeContnet) {
		this.userGradeContnet = userGradeContnet;
	}
	public UserGradeListContent() {
		setBounds(100, 100, 345, 177);
		setLayout(null);
		
		grade = new ComboBoxComponent<>("고객등급");
		grade.setBounds(5, 10, 166, 25);
		add(grade);
		
		btnSearch = new JButton("검색");
		btnSearch.setBounds(175, 8, 65, 27);
		btnSearch.addActionListener(this);
		add(btnSearch);
		
		btnAll = new JButton("전체보기");
		btnAll.addActionListener(this);
		btnAll.setBounds(254, 8, 91, 27);
		add(btnAll);
		
		userGradeTable = new UserGradeTable();
		userGradeTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		userGradeTable.setBounds(5, 45, 340, 122);
		userGradeTable.setFull(true);
		userGradeTable.loadDate();
		add(userGradeTable);
		
		setGradeComboModel();
	}
	public void setGradeComboModel() {
		List<UserGrade> lists = UserGradeService.getInstance().selectUserGradeByAll();
		Vector<UserGrade> userGrade = new Vector<>();
		for(UserGrade ug : lists) {
			ug.setComboType(1);
			userGrade.add(ug);
		}
		grade.setComboBoxModel(userGrade);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAll) {
			userGradeTable.setFull(true);
			userGradeTable.loadDate();
			userGradeContnet.setUserGradeTextValueClear();
			userGradeContnet.setActive(false);
		}
		if(e.getSource()==btnSearch) {
			UserGrade ugkey = grade.getComboboxValue();
			userGradeTable.setFull(false);
			userGradeTable.setUserGarde(ugkey);
			userGradeTable.loadDate();
			userGradeContnet.getUserGrade().setTextValue(ugkey.getGrade());
			userGradeContnet.getDiscount().setTextValue(String.valueOf(ugkey.getDiscount()));
			userGradeContnet.setActive(true);
		}
	}

}
