package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.bitagentur.renderer.JChartLibPanel;

import kr.or.dgit.RentCar_Project.chart.AbstractPieChart;
import kr.or.dgit.RentCar_Project.chart.PerformenceTotalPieChart;
import kr.or.dgit.RentCar_Project.content.PerformenceContent;
import kr.or.dgit.RentCar_Project.dto.Rent;
import kr.or.dgit.RentCar_Project.list.AdminPerformenceTable;
import kr.or.dgit.RentCar_Project.service.RentService;

@SuppressWarnings("serial")
public class AdminMainPerformence extends JPanel {
	private AdminMainPerformenceChart chartFrame;
	
	
	public AdminMainPerformence() {
		setLayout(null);
		
		AdminPerformenceTable adminTable = new AdminPerformenceTable();
		adminTable.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		adminTable.setBounds(8, 80, 587, 664);
		adminTable.loadDate();
		add(adminTable);
		
		JLabel personImg = new JLabel("");
		personImg.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\chart1.png"));
		personImg.setBounds(209, 6, 158, 71);
		add(personImg);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.LOWERED, null, null)), "\uAC80\uC0C9\uC870\uAC74 \uC120\uD0DD", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		searchPanel.setBounds(601, 0, 373, 375);
		searchPanel.setLayout(null);
		add(searchPanel);
		
		
		// 검색조건 선택 패널 리스너
		PerformenceContent performenceContent = new PerformenceContent();
		performenceContent.getBtnSearch().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object item = performenceContent.selectGetComboBox().getSelectedItem();
				JOptionPane.showMessageDialog(null, item);
				chartFrame = null;
			}
		});
		performenceContent.setBounds(12, 22, 349, 354);
		searchPanel.add(performenceContent);
		
		// 결과요약 파이패널 출력
		List<Rent> items = RentService.getInstance().selectPerformenceTotal();
		AbstractPieChart<Rent> abstractPieChahrt = new PerformenceTotalPieChart("성과분석", "", "", items, false);
		JChartLibPanel jChart = abstractPieChahrt.getPieChart();
						
		JPanel chartPanel = new JPanel();
		chartPanel.setLayout(new BorderLayout(0, 0));
		chartPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.LOWERED, null, null)), "\uACB0\uACFC\uC694\uC57D", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		chartPanel.setBounds(601, 374, 373, 333);
		chartPanel.add(jChart, BorderLayout.CENTER);
		add(chartPanel);
		
		JPanel chartBtnPanel = new JPanel();
		chartBtnPanel.setBounds(607, 705, 357, 48);
		add(chartBtnPanel);
		chartBtnPanel.setLayout(null);
		
		JButton btnSpecific = new JButton("자세히 보기");
		btnSpecific.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chartFrame == null) {
					chartFrame = new AdminMainPerformenceChart();
					chartFrame.setVisible(true);
				}else {
					chartFrame.setVisible(true);
				}
			}
		});
		btnSpecific.setBounds(9, 7, 163, 37);
		chartBtnPanel.add(btnSpecific);
		
		JButton btnExit = new JButton("나가기");
		btnExit.setBounds(185, 7, 163, 37);
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = AdminMain.getInstance();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new AdminMainHome(), BorderLayout.CENTER);
				frame.setVisible(true);
				
			}
		});
		chartBtnPanel.add(btnExit);
		
	}
}
