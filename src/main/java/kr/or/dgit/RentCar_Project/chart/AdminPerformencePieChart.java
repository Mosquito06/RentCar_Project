package kr.or.dgit.RentCar_Project.chart;

import java.util.List;

import com.bitagentur.data.JChartLibDataSet;
import com.bitagentur.data.JChartLibSerie;

import kr.or.dgit.RentCar_Project.dto.Rent;

public class AdminPerformencePieChart extends AbstractPieChart<Rent> {

	public AdminPerformencePieChart(String setTitle, String xName, String yName, List<Rent> items) {
		super(setTitle, xName, yName, items);
	}

	@Override
	protected JChartLibDataSet setDataset(JChartLibSerie values, JChartLibDataSet dataset, List<Rent> items) {
		
		for(int i = 0; i < items.size(); i++) {
			values.addValue("", items.get(i).getFinalPrice());
		}
		dataset.addDataSerie(values);
		return dataset;
	}

}
