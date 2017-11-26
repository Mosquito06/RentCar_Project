package kr.or.dgit.RentCar_Project.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import kr.or.dgit.RentCar_Project.dto.Rent;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.list.UserHistoryTable;
import kr.or.dgit.RentCar_Project.service.RentService;

@SuppressWarnings("serial")
public class AdminMainClientManagerUserList extends JFrame {

	private JPanel contentPane;
	private TextFieldComponent clientCode;
	private TextFieldComponent clientName;
	private UserHistoryTable UserHistoryTable;
	private Rent rent;
	private String[] firstDate;
	private String[] lastDate;
	private List<Rent> findCode;

	public AdminMainClientManagerUserList(User userCode) {
		
		setResizable(false);
		setTitle(userCode.getUserName()+"님의 이용내역");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 963, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		clientCode = new TextFieldComponent("고객코드");
		clientCode.setBounds(130, 10, 300, 35);
		clientCode.setTextValue(String.valueOf(userCode.getUserCode()));
		clientCode.setEnable(false);
		contentPane.add(clientCode);
		
		clientName = new TextFieldComponent("고객명");
		clientName.setBounds(472, 10, 300, 35);
		clientName.setTextValue(userCode.getUserName());
		clientName.setEnable(false);
		contentPane.add(clientName);
		
		rent = new Rent();
		rent.setUserCode(userCode);
		
		findCode = RentService.getInstance().selectRentByUserCode(rent);
		
		SimpleDateFormat dateFirstFormat = new SimpleDateFormat("yyyy/MM/01");
		SimpleDateFormat dateLastFormat = new SimpleDateFormat("yyyy/MM/31");
		Date Fdate = new Date();
		Date Ldate = new Date();
		
		firstDate = dateFirstFormat.format(Fdate).split("/");
		lastDate = dateLastFormat.format(Ldate).split("/");
		
		UserHistoryTable = new UserHistoryTable();
		UserHistoryTable.setBounds(6, 55, 944, 290);
		UserHistoryTable.setRent(setDate(firstDate, lastDate));
		UserHistoryTable.loadDate();
		contentPane.add(UserHistoryTable);
		
		JButton btnOk = new JButton("확인");
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnOk.setBounds(879, 385, 71, 23);
		contentPane.add(btnOk);
		
		JLabel lblTotal = new JLabel("");
		lblTotal.setFont(new Font("나눔고딕", Font.BOLD, 16));
		lblTotal.setBounds(879, 355, 71, 15);
		lblTotal.setText("총 : "+totalCount(rent)+"건");
		contentPane.add(lblTotal);
	}
	
	private Rent setDate(String[] FirstDate, String[] LastDate) {
		Calendar dayStart = GregorianCalendar.getInstance();
		dayStart.set(Integer.parseInt(FirstDate[0]), Integer.parseInt(FirstDate[1])-1, Integer.parseInt(FirstDate[2]));
		
		Calendar dayEnd = GregorianCalendar.getInstance();
		dayEnd.set(Integer.parseInt(LastDate[0]), Integer.parseInt(LastDate[1])-1, Integer.parseInt(LastDate[2]));
		
		findCode.get(0).setDayStart(dayStart.getTime());
		findCode.get(0).setDayEnd(dayEnd.getTime());
		return findCode.get(0);
	}
	
	private int totalCount(Rent rent) {
		List<Rent> lists = RentService.getInstance().selectRentByUserCode(rent);
		return lists.size();
	}
}
