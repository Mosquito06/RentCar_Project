package kr.or.dgit.RentCar_Project.content;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import kr.or.dgit.RentCar_Project.dto.Manufacturer;
import kr.or.dgit.RentCar_Project.service.ManufacturerService;

@SuppressWarnings("serial")
public class ManufacturerManagerContent extends JPanel 	implements ActionListener{
	
	private TextFieldComponent mfCode;
	private TextFieldComponent mfName;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private ManufacturerListContent mfList;
	
	
	public void setMfList(ManufacturerListContent mfList) {
		this.mfList = mfList;
	}
	public ManufacturerManagerContent() {
		setBounds(100, 100, 333, 171);
		setLayout(null);
		
		mfCode = new TextFieldComponent("제조회사 코드");
		mfCode.setBounds(3, 25, 276, 30);
		add(mfCode);
		
		mfName = new TextFieldComponent("제조사 이름");
		mfName.setBounds(3, 65, 276, 30);
		add(mfName);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(253, 117, 66, 23);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int clear = JOptionPane.showConfirmDialog(null, "입력 데이터를 취소하시겠습니까?", "Message", JOptionPane.YES_NO_OPTION);
				if(clear==0) {
					setManufacturerTextValueClear();
					setActive(false);
				}
				
			}
		});
		add(btnCancel);

		btnAdd = new JButton("추가");
		btnAdd.setBounds(33, 117, 66, 23);
		btnAdd.addActionListener(this);
		add(btnAdd);
		
		btnUpdate = new JButton("수정");
		btnUpdate.setBounds(98, 117, 66, 23);
		btnUpdate.addActionListener(this);
		add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(this);
		btnDelete.setBounds(163, 117, 66, 23);
		add(btnDelete);
		
		setActive(false);
	}
	public TextFieldComponent getMfCode() {
		return mfCode;
	}
	public TextFieldComponent getMfName() {
		return mfName;
	}

	public void setManufacturerTextValueClear() {
		mfCode.setTextValue("");
		mfName.setTextValue("");
	}
	public void setActive(boolean active) {
		btnUpdate.setEnabled(active);
		btnDelete.setEnabled(active);
	}
	public boolean isEmptyCheck(){
		if(mfCode.isEmptyCheck()&&mfName.isEmptyCheck()) {
			return false;
		}else {
			return true;
		}
	}
	public boolean codeEmptyCheck() {
		if(mfCode.isEmptyCheck()) {
			return false;
		}else {
			return true;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String manufacturerCode = mfCode.getTextValue();
		String manufacturerName = mfName.getTextValue();
		ManufacturerService manufacturerService = ManufacturerService.getInstance();
		
		
		if(e.getSource()==btnAdd) {
			if(!isEmptyCheck()) {
				int insert = JOptionPane.showConfirmDialog(null, "입력 데이터를 추가하시겠습니까?", "Message", JOptionPane.YES_NO_OPTION);
				if(insert ==0) {
					manufacturerService.insertManufacturer(new Manufacturer(manufacturerCode, manufacturerName));
					mfList.mfTable.loadDate();
					mfList.setManufacturerComboBoxModel();
					setManufacturerTextValueClear();
					setActive(false);
				}else {
					JOptionPane.showMessageDialog(null, "취소되었습니다");
					return;
				}
			}else {
				JOptionPane.showMessageDialog(null, "공백이 존재합니다");
				if(manufacturerCode.equals("")) {
					mfCode.getTextField().requestFocus();
				}else {
					mfName.getTextField().requestFocus();
				}
				return;
			}
		}
		if(e.getSource()==btnUpdate) {
			
			if(!isEmptyCheck()) {
				int update = JOptionPane.showConfirmDialog(null, "입력 데이터를 수정하시겠습니까?", "Message", JOptionPane.YES_NO_OPTION);
				if(update==0) {
					manufacturerService.updateManufacturer(new Manufacturer(manufacturerCode, manufacturerName));
					mfList.mfTable.loadDate();
					mfList.setManufacturerComboBoxModel();
					setManufacturerTextValueClear();
					setActive(false);
				}else {
					JOptionPane.showMessageDialog(null, "취소되었습니다");
					return;
				}
			}else {
				JOptionPane.showMessageDialog(null, "공백이 존재합니다");
				if(manufacturerCode.equals("")) {
					mfCode.getTextField().requestFocus();
				}else {
					mfName.getTextField().requestFocus();
				}
				return;
			}
			
		}
		if(e.getSource()==btnDelete) {
			if(!codeEmptyCheck()) {
				int delete = JOptionPane.showConfirmDialog(null, "입력 데이터를 삭제하시겠습니까?", "Message", JOptionPane.YES_NO_OPTION);
				if(delete==0) {
					manufacturerService.deleteManufacturer(new Manufacturer(manufacturerCode, manufacturerName));
					mfList.mfTable.loadDate();
					mfList.setManufacturerComboBoxModel();
					setManufacturerTextValueClear();
					setActive(false);
				}else {
					JOptionPane.showMessageDialog(null, "취소되었습니다");
					return;
				}
			}else {
				JOptionPane.showMessageDialog(null, "코드를 입력하세요");
				mfCode.getTextField().requestFocus();
				return;
			}
			
		}
		
	}
}
