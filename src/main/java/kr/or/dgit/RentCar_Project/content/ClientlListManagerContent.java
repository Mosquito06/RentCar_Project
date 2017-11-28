package kr.or.dgit.RentCar_Project.content;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import kr.or.dgit.RentCar_Project.list.ClientListTable;

@SuppressWarnings("serial")
public class ClientlListManagerContent extends JPanel implements ActionListener {
	
	protected ClientListTable listClient;
	private JButton btnAll;
	private ClientManagerContent clientManager;
	
	
	public void setClientManager(ClientManagerContent clientManager) {
		this.clientManager = clientManager;
	}

	public ClientlListManagerContent(){
		setBounds(100, 100, 954, 362);
		setLayout(null);
		
		btnAll = new JButton("전체보기");
		btnAll.setBounds(845, 22, 97, 25);
		btnAll.addActionListener(this);
		add(btnAll);
		
		listClient = new ClientListTable();
		listClient.setBorder(new LineBorder(new Color(0, 0, 0)));
		listClient.setBounds(12, 55, 930, 251);
		listClient.setFull(true);
		listClient.loadDate();
		add(listClient);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnAll) {
			listClient.setFull(true);
			listClient.loadDate();
			clientManager.setClearAll();
			clientManager.setActive(false);
		}
		
	}
}

