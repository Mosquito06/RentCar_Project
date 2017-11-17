package kr.or.dgit.RentCar_Project.chart;

import java.util.List;

import com.bitagentur.chart.JChartLibBarchart;
import com.bitagentur.data.JChartLibDataSet;
import com.bitagentur.data.JChartLibSerie;
import com.bitagentur.renderer.JChartLibPanel;

public abstract class AbstractBarChart<T>{
	private JChartLibSerie values;
	private JChartLibDataSet dataset;
	private JChartLibBarchart chart;
	private JChartLibPanel chartPanel;
	
	public AbstractBarChart(String setTitle, String xName, String yName, List<T> items) {
		values = new JChartLibSerie(setTitle);
		dataset = new JChartLibDataSet();
		chart = new  JChartLibBarchart(setTitle, xName, yName, setDataset(values, dataset, items));
		chartPanel = new JChartLibPanel(chart);
	}

	protected abstract JChartLibDataSet setDataset(JChartLibSerie values, JChartLibDataSet dataset, List<T> items);
	 
	public JChartLibPanel getBarChart() {
		return chartPanel;
	}
}
