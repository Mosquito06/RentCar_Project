package kr.or.dgit.RentCar_Project.chart;

import java.util.List;

import com.bitagentur.data.JChartLibDataSet;
import com.bitagentur.data.JChartLibSerie;

import kr.or.dgit.RentCar_Project.dto.Rent;

public class PerformenceCarModelPieChart extends AbstractPieChart<Rent> {
	public PerformenceCarModelPieChart(String setTitle, String xName, String yName, List<Rent> items, boolean UseName) {
		super(setTitle, xName, yName, items, UseName);
	}

	@Override
	protected JChartLibDataSet setDataset(JChartLibSerie values, JChartLibDataSet dataset, List<Rent> items,
			boolean UseName) {
		if (!UseName) {
			for (int i = 0; i < items.size() - 1; i++) {
				values.addValue("", items.get(i).getFinalPrice());
			}
			dataset.addDataSerie(values);
		} else {
			for (int i = 0; i < items.size() - 1; i++) {
				values.addValue(items.get(i).getCarCode().getCarName(), items.get(i).getFinalPrice());
			}
			dataset.addDataSerie(values);
		}
		return dataset;
	}

}
