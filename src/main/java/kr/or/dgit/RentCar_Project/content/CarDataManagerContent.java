package kr.or.dgit.RentCar_Project.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.component.JspinnerComponent;
import kr.or.dgit.RentCar_Project.component.RadioComponent;
import kr.or.dgit.RentCar_Project.component.TextFieldComponent;
import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.CarModel;
import kr.or.dgit.RentCar_Project.dto.Fuel;
import kr.or.dgit.RentCar_Project.dto.IsAuto;
import kr.or.dgit.RentCar_Project.dto.Manufacturer;
import kr.or.dgit.RentCar_Project.frame.AdminMain;
import kr.or.dgit.RentCar_Project.frame.AdminMainCarManagerCarDetail;
import kr.or.dgit.RentCar_Project.frame.AdminMainCarManagerRentalPrice;
import kr.or.dgit.RentCar_Project.service.CarDataService;
import kr.or.dgit.RentCar_Project.service.CarModelService;
import kr.or.dgit.RentCar_Project.service.FuelService;
import kr.or.dgit.RentCar_Project.service.ManufacturerService;

@SuppressWarnings("serial")
public class CarDataManagerContent extends JPanel implements ActionListener {
	private String[] details = { "선택하세요", "대여단가 관리", "차종&제조회사&연료 관리" };
	protected TextFieldComponent carDataCode;
	private JButton btnDetail;
	protected ComboBoxComponent<CarModel> carModelCombo;
	protected ComboBoxComponent<Manufacturer> mfCombo;
	protected ComboBoxComponent<Fuel> fuelCombo;
	protected ComboBoxComponent<String> numCombo;
	protected TextFieldComponent carName;
	protected TextFieldComponent carOld;
	protected TextFieldComponent carSeater;
	protected JspinnerComponent carCount;
	protected RadioComponent isAuto;
	protected JLabel img;
	private JFileChooser imgChooser;
	private JLabel lblRemove;
	private JButton btnCancel;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private CarDataListManagerContent cdListManagercontent;
	
	public void setCdListManagercontent(CarDataListManagerContent cdListManagercontent) {
		this.cdListManagercontent = cdListManagercontent;
	}
	public CarDataManagerContent() {
		setBounds(100, 100, 950, 380);
		setLayout(null);
		imgChooser = new JFileChooser();
		
		JLabel lbl1 = new JLabel("+");
		lbl1.setBounds(169, 18, 27, 32);
		add(lbl1);
		lbl1.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lbl2 = new JLabel("+");
		lbl2.setBounds(353, 18, 27, 32);
		add(lbl2);
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("맑은 고딕", Font.PLAIN, 21));

		JLabel lbl3 = new JLabel("+");
		lbl3.setBounds(526, 18, 27, 32);
		add(lbl3);
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("맑은 고딕", Font.PLAIN, 21));

		JLabel lbl4 = new JLabel("=");
		lbl4.setBounds(713, 18, 27, 32);
		add(lbl4);
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setFont(new Font("맑은 고딕", Font.PLAIN, 21));

		carModelCombo = new ComboBoxComponent<>("차종 코드");
		carModelCombo.getComboBox().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				carDataCode.setTextValue(carModelCombo.getComboboxValue().getCarModelCode());
			}
		});
		carModelCombo.setBounds(10, 18, 163, 32);

		add(carModelCombo);

		mfCombo = new ComboBoxComponent<>("제조회사코드");
		mfCombo.getComboBox().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				carDataCode.setTextValue(carModelCombo.getComboboxValue().getCarModelCode() + "-"
						+ mfCombo.getComboboxValue().getManufacturerCode());
			}
		});
		mfCombo.setBounds(194, 18, 163, 32);
		add(mfCombo);

		fuelCombo = new ComboBoxComponent<>("연료코드");
		fuelCombo.getComboBox().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				carDataCode.setTextValue(carModelCombo.getComboboxValue().getCarModelCode() + "-"
						+ mfCombo.getComboboxValue().getManufacturerCode() + "-"
						+ fuelCombo.getComboboxValue().getFuelCode());

			}
		});
		fuelCombo.setBounds(364, 18, 163, 32);
		add(fuelCombo);

		numCombo = new ComboBoxComponent<>("차 고유번호");
		numCombo.getComboBox().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				carDataCode.setTextValue(carModelCombo.getComboboxValue().getCarModelCode() + "-"
						+ mfCombo.getComboboxValue().getManufacturerCode() + "-"
						+ fuelCombo.getComboboxValue().getFuelCode() + "-"
						+ numCombo.getComboboxValue());
			}
		});
		numCombo.setBounds(544, 18, 163, 32);
		add(numCombo);

		carDataCode = new TextFieldComponent("차 코드");
		carDataCode.setBounds(713, 18, 214, 32);
		add(carDataCode);
		carDataCode.setEnable(false);

		carName = new TextFieldComponent("차 이름");
		carName.setBounds(10, 86, 163, 32);
		add(carName);

		carOld = new TextFieldComponent("연식");
		carOld.setBounds(10, 145, 163, 32);
		add(carOld);

		carSeater = new TextFieldComponent("인승");
		carSeater.setBounds(10, 202, 163, 32);
		add(carSeater);

		carCount = new JspinnerComponent("차량 대수");
		carCount.setBounds(10, 261, 163, 32);
		add(carCount);

		btnDetail = new JButton("세부사항");
		btnDetail.setBounds(846, 349, 92, 23);
		btnDetail.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object selected = JOptionPane.showInputDialog(null, "세부관리 사항을 선택하세요", "세부관리",
						JOptionPane.QUESTION_MESSAGE, null, details, details[0]);
				openDetailFrame(selected);
			}
		});

		isAuto = new RadioComponent("변속기", "오토", "수동");
		isAuto.setBounds(10, 319, 163, 32);
		add(isAuto);
		
				img = new JLabel();
				img.setBorder(new LineBorder(new Color(0, 0, 0)));
				img.setBounds(194, 60, 600, 315);
				add(img);
		add(btnDetail);

		btnCancel = new JButton("취소");
		btnCancel.setBounds(872, 156, 66, 23);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int clear = JOptionPane.showConfirmDialog(null, "입력 데이터를 취소하시겠습니까?", "Message", JOptionPane.YES_NO_OPTION);
				if(clear==0) {
					setClearAll();
				}
			}
		});
		add(btnCancel);

		btnAdd = new JButton("추가");
		btnAdd.setBounds(872, 67, 66, 23);
		btnAdd.addActionListener(this);
		add(btnAdd);

		btnUpdate = new JButton("수정");
		btnUpdate.setBounds(872, 90, 66, 23);
		btnUpdate.addActionListener(this);
		add(btnUpdate);

		btnDelete = new JButton("삭제");
		btnDelete.setBounds(872, 113, 66, 23);
		btnDelete.addActionListener(this);
		add(btnDelete);
		
		JLabel lblAdd = new JLabel("");
		lblAdd.setBounds(794, 60, 45, 45);
		add(lblAdd);
		lblAdd.setIcon(new ImageIcon(System.getProperty("user.dir") +"\\images\\fileAdd.png"));
		lblAdd.setToolTipText("이미지 불러오기");
		lblAdd.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG&GIF Images", "jpg","gif");
				
				imgChooser.setDialogTitle("이미지 파일 열기");
				imgChooser.setFileFilter(filter);
				
				int ret = imgChooser.showOpenDialog(null);
				
				if(ret !=JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.","경고",JOptionPane.WARNING_MESSAGE);
					return;
				}
				String filePath = imgChooser.getSelectedFile().getPath();
				String fileName = imgChooser.getSelectedFile().getName();
			
				if(ret == JFileChooser.APPROVE_OPTION) {
					try {
						Image imgIcon = ImageIO.read(new File(filePath));
						Image resizeIcon = imgIcon.getScaledInstance(600, 315, Image.SCALE_SMOOTH);
						img.setIcon(new ImageIcon(resizeIcon));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			
		});
		
		lblRemove = new JLabel("");
		lblRemove.setBounds(794, 115, 45, 45);
		add(lblRemove);
		lblRemove.setIcon(new ImageIcon(System.getProperty("user.dir") +"\\images\\fileDelete.png"));
		lblRemove.setToolTipText("이미지 삭제");
		lblRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int imgDelete = JOptionPane.showConfirmDialog(null,"이미지를 삭제하시겠습니까?",  "Message", JOptionPane.YES_NO_OPTION);
				if(imgDelete==0) {
					img.setIcon(null);
					JOptionPane.showMessageDialog(null, "삭제되었습니다");
				}else {
					JOptionPane.showMessageDialog(null, "취소되었습니다");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRemove.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
	
		setCarModelComboModel();
		setManufacturerComboModel();
		setFuelComboModel();
		setNumComboModel();
	}
	public void setClearAll() {
		carModelCombo.setComboBoxModelClear();
		mfCombo.setComboBoxModelClear();
		fuelCombo.setComboBoxModelClear();;
		numCombo.setComboBoxModelClear();;
		carDataCode.setTextValue("");
		carName.setTextValue("");
		carOld.setTextValue("");
		carSeater.setTextValue("");
		isAuto.setSelect(true);
		img.setIcon(null);
		carCount.setSpinValue(1);
	}
	public void setCarModelComboModel() {
		CarModelService carModelService = CarModelService.getInstance();
		List<CarModel> lists = carModelService.selectCarModelByAll();
		Vector<CarModel> carModel = new Vector<>();
		for (CarModel cm : lists) {
			cm.setComboType(0);
			carModel.add(cm);
		}
		carModelCombo.setComboBoxModel(carModel);
	}

	public void setManufacturerComboModel() {
		ManufacturerService manufacturerService = ManufacturerService.getInstance();
		List<Manufacturer> lists = manufacturerService.selectManufacturerByAll();
		Vector<Manufacturer> manufacturer = new Vector<>();
		for (Manufacturer mf : lists) {
			mf.setComboType(1);
			manufacturer.add(mf);
		}
		mfCombo.setComboBoxModel(manufacturer);
	}

	public void setFuelComboModel() {
		FuelService fuelService = FuelService.getInstance();
		List<Fuel> lists = fuelService.selectFuelByAll();
		Vector<Fuel> fuelCode = new Vector<>();
		for (Fuel f : lists) {
			f.setComboType(1);
			fuelCode.add(f);
		}
		fuelCombo.setComboBoxModel(fuelCode);
	}

	public void setNumComboModel() {
		String[] numArr = { "001", "002", "003", "004", "005", "006", "007", "008", "009", "010", "011", "012", "013",
				"014", "015", "016", "017", "018", "019", "020" };
		Vector<String> num = new Vector<>();
		for (int i = 0; i < numArr.length; i++) {
			num.add(numArr[i]);
		}
		numCombo.setComboBoxModel(num);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		CarDataService cdService = CarDataService.getInstance();
		String carCode = carDataCode.getTextValue();
		String cName = carName.getTextValue();
		int cOld = Integer.parseInt(carOld.getTextValue());
		int carNumber = carCount.getSpinnerValue();
		IsAuto auto = getSelectedIsAuto(isAuto.getSelectText());
		String cSeater = carSeater.getTextValue();
		CarModel carModelCode = carModelCombo.getComboboxValue();
		Manufacturer manufacturerCode = mfCombo.getComboboxValue();
		Fuel fuelCode = fuelCombo.getComboboxValue();
		
		if(e.getSource()==btnAdd) {
			int insert = JOptionPane.showConfirmDialog(null,"입력 데이터를 추가하시겠습니까?", "Message", JOptionPane.YES_NO_OPTION);
			if (insert == 0) {
				String	filePath ="";
				String fileName ="";
				
				try {
					filePath = imgChooser.getSelectedFile().getPath();
				 fileName = imgChooser.getSelectedFile().getName();
				}catch(Exception e2) {	
					e2.getStackTrace();
					JOptionPane.showMessageDialog(null, "추후에 이미지를 등록해주세요");
				}
				
				cdService.insertCarData(new CarData(carCode, cName, fileName, cOld, carNumber, auto, cSeater, carModelCode, manufacturerCode, fuelCode));
				storeImg(filePath,fileName);
				cdListManagercontent.listCarData.loadDate();
				cdListManagercontent.setSearchCarCodeComboModel();
				
				addInsertInformation(insert);
			
			}else {
				JOptionPane.showMessageDialog(null, "취소되었습니다");
			}
		}
		
		if(e.getSource()==btnUpdate) {
			
			int update = JOptionPane.showConfirmDialog(null, "입력 데이터를 수정하시겠습니까?", "Message", JOptionPane.YES_NO_OPTION);
			
			String filePath="";
			String fileName="";
			
			if(update==0) {
				try{
					filePath = imgChooser.getSelectedFile().getPath();
					fileName = imgChooser.getSelectedFile().getName();
				}catch(Exception e1){
					e1.getStackTrace();
					fileName = cdListManagercontent.getSearch().getComboboxValue().getCarImage();
					filePath = System.getProperty("user.dir") + "\\images\\car\\"+fileName;
				}
				
				cdService.updateCarData(new CarData(carCode, cName, fileName, cOld, carNumber, auto, cSeater, carModelCode, manufacturerCode, fuelCode));
				
				storeImg(filePath,fileName);
				cdListManagercontent.listCarData.loadDate();
				cdListManagercontent.setSearchCarCodeComboModel();
				
			}else {
				JOptionPane.showMessageDialog(null, "취소되었습니다");
			}
		}
		
		if(e.getSource()==btnDelete) {
			
			int delete = JOptionPane.showConfirmDialog(null, "입력 데이터를 삭제하시겠습니까?", "Message", JOptionPane.YES_NO_OPTION);
			if (delete == 0) {
				
				cdService.deleteCarData(new CarData(carCode));
				cdListManagercontent.listCarData.loadDate();
				cdListManagercontent.setSearchCarCodeComboModel();
			}
			else {
				JOptionPane.showMessageDialog(null, "취소되었습니다");
			}
			}
		setClearAll();
		
	}

	public IsAuto getSelectedIsAuto(String selectText) {
		if(selectText.equals("AUTO")) {
			return IsAuto.AUTO;
		}
		return IsAuto.MANUAL;
	}

	private void storeImg(String filePath, String fileName) {
		try {
			Image originalImage = ImageIO.read(new File(filePath));
			Image resizeImage = originalImage.getScaledInstance(600, 340, Image.SCALE_SMOOTH);
			int width=resizeImage.getWidth(imgChooser);
			int height = resizeImage.getHeight(imgChooser);
			BufferedImage bufferedImage =  new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = bufferedImage.getGraphics();
			g.drawImage(resizeImage, 0, 0, this);
			g.dispose();
			ImageIO.write(bufferedImage, "jpg", new File(System.getProperty("user.dir") + "\\images\\car\\"+fileName));
			
			Image resizeSmall = originalImage.getScaledInstance(300, 170, Image.SCALE_SMOOTH);
			int smallWidth = resizeSmall.getWidth(imgChooser);
			int smallHeight = resizeSmall.getHeight(imgChooser);
			BufferedImage bufferSamllImage = new BufferedImage(smallWidth, smallHeight, BufferedImage.TYPE_INT_RGB);
			Graphics s = bufferSamllImage.getGraphics();
			s.drawImage(resizeSmall, 0, 0, this);
			s.dispose();
			ImageIO.write(bufferSamllImage, "jpg", new File(System.getProperty("user.dir") + "\\images\\carS\\"+fileName));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	private void openDetailFrame(Object selected) {
		if(selected==null) {
			JOptionPane.showMessageDialog(null, "취소하셨습니다");
		}else if (selected == details[0]) {
			JOptionPane.showMessageDialog(null, "세부사향을 선택하세요");
		} else if (selected == details[1]) {
			JFrame frame = AdminMain.getInstance();
			frame.getContentPane().removeAll();
			frame.getContentPane().add(new AdminMainCarManagerRentalPrice(), BorderLayout.CENTER);
			frame.setVisible(true);
		} else if (selected == details[2]) {
			JFrame frame = AdminMain.getInstance();
			frame.getContentPane().removeAll();
			frame.getContentPane().add(new AdminMainCarManagerCarDetail(), BorderLayout.CENTER);
			frame.setVisible(true);
		}

	}
	
	private void addInsertInformation(int insert) {
		if(insert==0) {
			int ok = JOptionPane.showConfirmDialog(null, "추가된 차량의 대여단가 정보를 지금 등록하시겠습니까?", "Message", JOptionPane.YES_NO_OPTION);
			if(ok==0) {
				JFrame frame = AdminMain.getInstance();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new AdminMainCarManagerRentalPrice(), BorderLayout.CENTER);
				frame.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null,"대여단가정보를 추후에 등록하세요");
			}
		}
		
	}
}
