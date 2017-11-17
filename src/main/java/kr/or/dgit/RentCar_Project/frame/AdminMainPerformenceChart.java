package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.bitagentur.renderer.JChartLibPanel;

import kr.or.dgit.RentCar_Project.chart.AbstractBarChart;
import kr.or.dgit.RentCar_Project.chart.AbstractPieChart;
import kr.or.dgit.RentCar_Project.chart.PerformenceTotalBarChart;
import kr.or.dgit.RentCar_Project.chart.PerformenceTotalPieChart;
import kr.or.dgit.RentCar_Project.dto.Rent;
import kr.or.dgit.RentCar_Project.service.RentService;

public class AdminMainPerformenceChart extends JFrame {

	private JPanel contentPane;

	public AdminMainPerformenceChart() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel chartPanel = new JPanel();
		chartPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.LOWERED, null, null)), "\uCC28\uD2B8", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		chartPanel.setBounds(0, 0, 834, 450);
		contentPane.add(chartPanel);
		chartPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel btnPanel = new JPanel();
		btnPanel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EtchedBorder(EtchedBorder.LOWERED, null, null)), "\uCC28\uD2B8\uC120\uD0DD", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnPanel.setBounds(0, 449, 834, 62);
		contentPane.add(btnPanel);
		btnPanel.setLayout(null);
		
		JButton btnBarChart = new JButton("막대차트");
		btnBarChart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chartPanel.removeAll();
				List<Rent> items = RentService.getInstance().selectPerformenceTotal();
				AbstractBarChart<Rent> abstractBarChahrt = new  PerformenceTotalBarChart("성과분석", "차종별", "최종요금", items);
				JChartLibPanel jChart = abstractBarChahrt.getBarChart();
				chartPanel.add(jChart);
				chartPanel.revalidate();
				chartPanel.repaint();
			}
		});
		btnBarChart.setBounds(175, 16, 158, 34);
		btnPanel.add(btnBarChart);
		
		JButton btnPieChart = new JButton("파이차트");
		btnPieChart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chartPanel.removeAll();
				List<Rent> items = RentService.getInstance().selectPerformenceTotal();
				AbstractPieChart<Rent> abstractPieChahrt = new PerformenceTotalPieChart("성과분석", "", "", items, true);
				JChartLibPanel jChart = abstractPieChahrt.getPieChart();
				chartPanel.add(jChart);
				chartPanel.revalidate();
				chartPanel.repaint();
			}
		});
		btnPieChart.setBounds(345, 16, 158, 34);
		btnPanel.add(btnPieChart);
		
		// 나가기 버튼 리스너
		JButton btnExit = new JButton("나가기");
		btnExit.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnExit.setBounds(515, 16, 158, 34);
		btnPanel.add(btnExit);
	}
}
