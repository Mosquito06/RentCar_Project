package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.RentCar_Project.component.ComboBoxComponent;
import kr.or.dgit.RentCar_Project.content.ReserveAddCarContent;
import kr.or.dgit.RentCar_Project.content.ReserveHeaderContent;
import kr.or.dgit.RentCar_Project.content.ReserveLeftContent;
import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.CarModel;
import kr.or.dgit.RentCar_Project.dto.Fuel;
import kr.or.dgit.RentCar_Project.dto.IsAuto;
import kr.or.dgit.RentCar_Project.dto.Manufacturer;
import kr.or.dgit.RentCar_Project.dto.User;
import kr.or.dgit.RentCar_Project.service.CarDataService;
import kr.or.dgit.RentCar_Project.service.CarModelService;

@SuppressWarnings("serial")
public class UserMainReserve extends JPanel {
	private User comfirmUser;
	private CarDataService carDataService = CarDataService.getInstance();
	CarModelService carModelService = CarModelService.getInstance();
	private List<CarData> lists;
	private String sDay;
	private String fDay;
	private ReserveAddCarContent addCar;
	private Boolean isInsurance;
	private List<CarData> newLists;
	private IsAuto auto;
	private ReserveLeftContent leftPanel;
	private JPanel btnsPanel;
	private ComboBoxComponent<CarData> comboBoxCarName;
	private JScrollPane scrollPane;
	private ReserveHeaderContent header;
	private JLabel lblCarModel;
	private CarModel carModel;

	public void setComfirmUser(User comfirmUser) {
		this.comfirmUser = comfirmUser;
	}

	public UserMainReserve() {
		isInsurance = true;
		setBounds(new Rectangle(0, 0, 500, 500));
		setLayout(null);

		leftPanel = new ReserveLeftContent();
		leftPanel.getChckbxAuto().setLocation(137, 449);
		leftPanel.getComboBoxSeater().setLocation(26, 364);
		leftPanel.getComboBoxOld().setLocation(26, 275);
		leftPanel.getComboBoxFuel().setLocation(26, 184);
		leftPanel.getComboBoxManufacturer().setLocation(26, 93);
		leftPanel.setBorder(new TitledBorder(
				new CompoundBorder(new LineBorder(new Color(0, 0, 0)),
						new EtchedBorder(EtchedBorder.LOWERED, null, null)),
				"\uC0C1\uC138\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		leftPanel.setBounds(0, 79, 259, 672);
		add(leftPanel);
		leftPanel.setLayout(null);

		JPanel rightPanel = new JPanel();
		rightPanel.setBounds(271, 112, 703, 639);
		add(rightPanel);
		rightPanel.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(5);
		rightPanel.add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);

		JLabel backImg = new JLabel("");
		backImg.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\images\\reserve.jpg"));
		panel.add(backImg);

		header = new ReserveHeaderContent();
		header.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)),
				new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		header.setBounds(3, 3, 968, 72);
		add(header);

		header.getBtnSearch().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (header.getTotalTimePanel().getTextValue().equals("0")) {
					JOptionPane.showMessageDialog(null, "날짜를 정확하게 입력하세요");
					return;
				}
				resetSelectComdo();
				lists = carDataService.selectCarDataByAll();
				setScrollPaneAddList(scrollPane, header, isInsurance);
				setComboBaxEnabled(true);
				btnsPanel.setVisible(true);
				comboBoxCarName.setVisible(true);
				leftPanel.getIsInsurance().setAllEnable(true);
				leftPanel.getBtnReset().setEnabled(true);
				comboBoxCarName.getComboBox().setSelectedIndex(0);
			}
		});

		btnsPanel = new JPanel();
		btnsPanel.setBorder(new EmptyBorder(2, 2, 2, 2));
		btnsPanel.setBounds(271, 76, 565, 35);
		List<CarModel> carModelLists = carModelService.selectCarModelByAll();
		for (int i = 0; i < carModelLists.size(); i++) {
			CarModel carM = carModelLists.get(i);
			String carModelName = carModelLists.get(i).getCarModel();
			JButton btn = new JButton(carModelName);
			btnsPanel.add(btn);
			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					carModel = carM;
					setComboBaxEnabled(true);
					resetSelectComdo();
					comboBoxCarName.getComboBox().setSelectedIndex(0);
					lblCarModel.setText(carModelName);
					comboAction();
					setScrollPaneAddList(scrollPane, header, isInsurance);
				}

			});

		}
		btnsPanel.setLayout(new GridLayout(1, 1, 0, 0));
		add(btnsPanel);
		comboBoxCarName = new ComboBoxComponent<>("검색   ");
		comboBoxCarName.setBorder(new EmptyBorder(3, 0, 3, 0));
		comboBoxCarName.getLbl().setHorizontalAlignment(SwingConstants.RIGHT);
		setCarDataNameBoxModel();
		comboBoxCarName.setBounds(794, 76, 177, 35);
		add(comboBoxCarName);
		comboBoxCarName.setVisible(false);
		btnsPanel.setVisible(false);
		leftPanel.getBtnExit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = UserMain.getInstance();
				frame.getContentPane().removeAll();
				UserMainHome userMainHome = new UserMainHome();
				userMainHome.setComfirmUser(comfirmUser);
				frame.getContentPane().add(userMainHome, BorderLayout.CENTER);
				frame.setVisible(true);
			}
		});

		leftPanel.getIsInsurance().getRdbtnLeft().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					isInsurance = true;
					setScrollPaneAddList(scrollPane, header, isInsurance);
				} else {
					isInsurance = false;
					setScrollPaneAddList(scrollPane, header, isInsurance);
				}
			}
		});

		leftPanel.getChckbxAuto().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				comboAction();
				setScrollPaneAddList(scrollPane, header, isInsurance);
			}

		});

		comboBoxCarName.getComboBox().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (comboBoxCarName.getComboboxValue() == comboBoxCarName.getComboBox().getItemAt(0)) {
					return;
				}
				resetSelectComdo();
				CarData carData = comboBoxCarName.getComboboxValue();
				lists = carDataService.selectCarDataByCarDataCodeList(carData);
				setComboBaxEnabled(false);
				setScrollPaneAddList(scrollPane, header, isInsurance);

			}
		});

		leftPanel.getComboBoxFuel().getComboBox().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				comboAction();
				setScrollPaneAddList(scrollPane, header, isInsurance);
			}

		});

		leftPanel.getComboBoxManufacturer().getComboBox().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				comboAction();
				setScrollPaneAddList(scrollPane, header, isInsurance);
			}

		});

		leftPanel.getComboBoxSeater().getComboBox().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				comboAction();
				setScrollPaneAddList(scrollPane, header, isInsurance);
			}

		});

		leftPanel.getComboBoxOld().getComboBox().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				comboAction();
				setScrollPaneAddList(scrollPane, header, isInsurance);
			}

		});

		leftPanel.getBtnReset().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resetSelectComdo();
				lists = carDataService.selectCarDataByAll();
				setScrollPaneAddList(scrollPane, header, isInsurance);
				setComboBaxEnabled(true);
				comboBoxCarName.getComboBox().setSelectedIndex(0);
			}
		});

		setComboBaxEnabled(false);
		leftPanel.getBtnReset().setEnabled(false);
		leftPanel.getIsInsurance().setAllEnable(false);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(72, 23, 113, 36);
		leftPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		lblCarModel = new JLabel("전체차량");
		lblCarModel.setFont(new Font("굴림", Font.PLAIN, 13));
		lblCarModel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblCarModel, BorderLayout.CENTER);
	}

	private void resetSelectComdo() {
		leftPanel.getComboBoxOld().getComboBox().setSelectedIndex(0);
		leftPanel.getComboBoxSeater().getComboBox().setSelectedIndex(0);
		leftPanel.getComboBoxSeater().getComboBox().setSelectedIndex(0);
		leftPanel.getComboBoxManufacturer().getComboBox().setSelectedIndex(0);
		leftPanel.getComboBoxFuel().getComboBox().setSelectedIndex(0);
		leftPanel.getChckbxAuto().setSelected(false);
		lblCarModel.setText("전체차량");
	}

	private void setComboBaxEnabled(Boolean yes) {
		leftPanel.getComboBoxOld().getComboBox().setEnabled(yes);
		leftPanel.getComboBoxSeater().getComboBox().setEnabled(yes);
		leftPanel.getComboBoxManufacturer().getComboBox().setEnabled(yes);
		leftPanel.getComboBoxFuel().getComboBox().setEnabled(yes);
		leftPanel.getChckbxAuto().setEnabled(yes);
	}

	private void setScrollPaneAddList(JScrollPane scrollPane, ReserveHeaderContent header, Boolean isInsurance) {
		int totalTime = Integer.parseInt(header.getTotalTimePanel().getTextValue());
		if (totalTime == 0) {
			JOptionPane.showMessageDialog(null, "날짜를 입력하세요");
			return;
		}
		scrollPane.getViewport().removeAll();
		sDay = header.getStartPanel().getTextValue();
		fDay = header.getFinalPanel().getTextValue();
		addCar = new ReserveAddCarContent(totalTime, comfirmUser, lists, sDay, fDay, isInsurance);
		scrollPane.setViewportView(addCar);
		addCar.setLayout(new GridLayout(0, 1, 0, 0));
	}

	public void setCarDataNameBoxModel() {
		CarDataService carDataService = CarDataService.getInstance();
		List<CarData> lists = carDataService.selectCarDataByAll();
		CarData car = new CarData();
		car.setCarName("선택");
		lists.add(0, car);
		Vector<CarData> carData = new Vector<>();
		for (CarData c : lists) {
			c.setComboType(1);
			carData.add(c);
		}
		comboBoxCarName.setComboBoxModel(carData);
	}

	private void comboAction() {
		HashMap<String, Object> map = new HashMap<>();

		if (!lblCarModel.getText().equals("전체차량")) {
			map.put("carModelCode", carModel);
		}

		if (leftPanel.getChckbxAuto().isSelected()) {
			auto = IsAuto.AUTO;
			map.put("isAuto", auto);
		}

		if (leftPanel.getComboBoxManufacturer().getComboBox().getSelectedIndex() != 0) {
			Manufacturer manufacturer = leftPanel.getComboBoxManufacturer().getComboboxValue();
			map.put("manufacturerCode", manufacturer);
		}

		if (leftPanel.getComboBoxFuel().getComboBox().getSelectedIndex() != 0) {
			Fuel fuel = leftPanel.getComboBoxFuel().getComboboxValue();
			map.put("fuelCode", fuel);
		}
		if (leftPanel.getComboBoxOld().getComboBox().getSelectedIndex() != 0) {
			CarData carOld = leftPanel.getComboBoxOld().getComboboxValue();
			map.put("carOld", carOld.getCarOld());
		}

		if (leftPanel.getComboBoxSeater().getComboBox().getSelectedIndex() != 0) {
			CarData seater = leftPanel.getComboBoxSeater().getComboboxValue();
			map.put("carSeater", seater.getCarSeater());
		}
	
		lists = carDataService.selectCarDataByCarValue(map);
	
	}
}
