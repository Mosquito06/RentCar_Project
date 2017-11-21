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
import kr.or.dgit.RentCar_Project.chart.PerformenceCarModelPieChart;
import kr.or.dgit.RentCar_Project.chart.PerformenceTotalPieChart;
import kr.or.dgit.RentCar_Project.dto.Rent;

public class AdminMainPerformenceChart extends JFrame {

	private JPanel contentPane;
	private List<Rent> items;
	private AbstractBarChart<Rent> abstractBarChart;
	private AbstractPieChart<Rent> abstractPieChart;
	private String createWhatPie;
	
	public AdminMainPerformenceChart(List<Rent> lists, AbstractBarChart<Rent> BarChart, String setPie) {
		setResizable(false);
		this.items = lists;
		this.abstractBarChart = BarChart;
		this.createWhatPie = setPie;
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 841, 544);
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
		
		JChartLibPanel jChart = abstractBarChart.getBarChart();
		chartPanel.add(jChart);
						
		JButton btnBarChart = new JButton("막대차트");
		btnBarChart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chartPanel.removeAll();
				JChartLibPanel jChart = abstractBarChart.getBarChart();
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
				
				if(createWhatPie.equals("기본")) {
					abstractPieChart = new PerformenceTotalPieChart("성과분석", "", "", items, true);
				}else if(createWhatPie.equals("차종")) {
					abstractPieChart = new PerformenceCarModelPieChart("성과분석", "", "", items, true);
				}
				
				JChartLibPanel jChart = abstractPieChart.getPieChart();
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
