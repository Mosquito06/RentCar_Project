package kr.or.dgit.RentCar_Project.content;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import kr.or.dgit.RentCar_Project.list.ClientListTable;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ClientlListManagerContent extends JPanel implements ActionListener {
	
	protected ClientListTable listClient;
	private JButton btnAll;
	private JLabel lblNum;
	
	public ClientlListManagerContent(){
		setBounds(100, 100, 921, 362);
		setLayout(null);
		
		btnAll = new JButton("전체보기");
		btnAll.setBounds(812, 23, 97, 25);
		btnAll.addActionListener(this);
		add(btnAll);
		
		listClient = new ClientListTable();
		listClient.setBorder(new LineBorder(new Color(0, 0, 0)));
		listClient.setBounds(12, 58, 897, 267);
		listClient.setFull(true);
		listClient.loadDate();
		add(listClient);
		
		lblNum = new JLabel("New label");
		lblNum.setBounds(852, 330, 57, 15);
		add(lblNum);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnAll) {
			listClient.setFull(true);
			listClient.loadDate();
		}
		
	}
}
