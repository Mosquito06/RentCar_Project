package kr.or.dgit.RentCar_Project.chart;

import java.util.List;

import com.bitagentur.chart.JChartLibPiechart;
import com.bitagentur.data.JChartLibDataSet;
import com.bitagentur.data.JChartLibSerie;
import com.bitagentur.renderer.JChartLibPanel;

public abstract class AbstractPieChart<T>{
	private JChartLibSerie values;
	private JChartLibDataSet dataset;
	private JChartLibPiechart chart;
	private JChartLibPanel chartPanel;
	
	public AbstractPieChart(String setTitle, String xName, String yName, List<T> items, boolean UseName) {
		values = new JChartLibSerie(setTitle);
		dataset = new JChartLibDataSet();
		chart = new JChartLibPiechart(setTitle, xName, yName, setDataset(values, dataset, items, UseName));
		chartPanel = new JChartLibPanel(chart);
	}

	protected abstract JChartLibDataSet setDataset(JChartLibSerie values, JChartLibDataSet dataset, List<T> items, boolean UseName);
	 
	public JChartLibPanel getPieChart() {
		return chartPanel;
	}
}
