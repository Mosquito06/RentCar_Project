package kr.or.dgit.RentCar_Project.chart;

import java.util.List;

import com.bitagentur.data.JChartLibDataSet;
import com.bitagentur.data.JChartLibSerie;

import kr.or.dgit.RentCar_Project.dto.Rent;

public class PerformenceTotalBarChart extends AbstractBarChart<Rent> {

	public PerformenceTotalBarChart(String setTitle, String xName, String yName, List<Rent> items) {
		super(setTitle, xName, yName, items);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	protected JChartLibDataSet setDataset(JChartLibDataSet dataset, List<Rent> items) {
		for(int i = 0; i < items.size(); i++) {
			JChartLibSerie values = new JChartLibSerie(items.get(i).getCarCode().getCarModelCode().getCarModel());
			values.addValue(items.get(i).getFinalPrice());
			dataset.addDataSerie(values);
		}
		
		return dataset;
	}

}
