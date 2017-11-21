package kr.or.dgit.RentCar_Project.chart;

import java.util.List;

import com.bitagentur.data.JChartLibDataSet;
import com.bitagentur.data.JChartLibSerie;

import kr.or.dgit.RentCar_Project.dto.Rent;

public class PerformenceCarModelBarChart extends AbstractBarChart<Rent> {

	public PerformenceCarModelBarChart(String setTitle, String xName, String yName, List<Rent> items) {
		super(setTitle, xName, yName, items);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	protected JChartLibDataSet setDataset(JChartLibDataSet dataset, List<Rent> items) {
		for(int i = 0; i < items.size()-1; i++) {
			JChartLibSerie values = new JChartLibSerie(items.get(i).getCarCode().getCarName());
			values.addValue(items.get(i).getFinalPrice());
			dataset.addDataSerie(values);
		}
		
		return dataset;
	}

}
