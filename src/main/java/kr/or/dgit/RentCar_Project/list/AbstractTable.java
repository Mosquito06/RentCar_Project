package kr.or.dgit.RentCar_Project.list;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;




public abstract class AbstractTable extends JPanel {
	protected JTable table;
		
	public AbstractTable() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		// 테이블 열 이동 불가
		table.getTableHeader().setReorderingAllowed(false);
		// 테이블 사이즈 변경 불가
		table.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(table);

	}
	
	public void loadDate() {
		// 내용 수정 불가, isCellEditable overriding
		DefaultTableModel model = new DefaultTableModel(getData(), getcolumnNames()) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(model);
		
		setAlignWidth();
	
	}

	protected void setCellwidth(int...width) {
		TableColumnModel cModel = table.getColumnModel();
		
		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
		
	}

	protected void setAlign(int align, int...idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		TableColumnModel cModel = table.getColumnModel();
		
		for(int i = 0; i < idx.length; i++) {
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}
		
	}

	protected abstract void setAlignWidth();
	
	protected abstract Object[][] getData();
	
	protected abstract Object[] getcolumnNames();
	
	public abstract Object getSelectedItem();
}
