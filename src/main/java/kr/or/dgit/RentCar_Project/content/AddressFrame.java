package kr.or.dgit.RentCar_Project.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import kr.or.dgit.RentCar_Project.dto.Post;
import kr.or.dgit.RentCar_Project.service.PostService;

@SuppressWarnings("serial")
public class AddressFrame extends JFrame {

	private JPanel contentPane;
	private ComboBoxComponent<Post> sidoPanel;
	private JScrollPane scrollPane;

	public AddressFrame(MembershipFrame mf) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 469, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "\uC8FC\uC18C\uAC80\uC0C9", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 96, 451, 276);
		panel.add(scrollPane);
		
		sidoPanel = new ComboBoxComponent<>("시,도 검색");
		
		sidoPanel.setBounds(0, 5, 214, 32);
		panel.add(sidoPanel);
		
		TextFieldComponent doroPanel = new TextFieldComponent("도로명 검색");
		doroPanel.setBounds(214, 5, 225, 32);
		panel.add(doroPanel);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object sido = sidoPanel.getComboBox().getSelectedItem();
				String doro =  doroPanel.getTextValue();
				Post post = new Post(String.valueOf(sido), doro+'%');
				AddressAddPanel addPanel = new AddressAddPanel(post,mf);
				scrollPane.setViewportView(addPanel);
				addPanel.setLayout(new GridLayout(0, 1, 0, 0));
			}
		});
		btnSearch.setBounds(338, 47, 101, 32);
		panel.add(btnSearch);
		
		setSidoPanelBoxModel();
	}
	
	
	public void setSidoPanelBoxModel() {
		PostService postService = PostService.getInstance();
		List<Post> lists = postService.selectPostSido();
		Vector<Post> sido = new Vector<>();
		
		for (Post p : lists) {
			p.setComboType(1);
			sido.add(p);
		}
		sidoPanel.setComboBoxModel(sido);
	}
}
