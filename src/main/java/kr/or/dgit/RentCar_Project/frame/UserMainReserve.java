package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
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

	public void setComfirmUser(User comfirmUser) {
		this.comfirmUser = comfirmUser;
	}

	public UserMainReserve() {
		isInsurance = true;
		setBounds(new Rectangle(0, 0, 500, 500));
		setLayout(null);

		leftPanel = new ReserveLeftContent();
		leftPanel.setBackground(Color.WHITE);
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
			String carModel = carModelLists.get(i).getCarModel();
			String carModelCode = carModelLists.get(i).getCarModelCode();
			JButton btn = new JButton(carModel);
			btnsPanel.add(btn);
			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					lists = carDataService.selectCarDataByCarModelCode(carModelCode);
					setScrollPaneAddList(scrollPane, header, isInsurance);
					setComboBaxEnabled(true);
					resetSelectComdo();
					comboBoxCarName.getComboBox().setSelectedIndex(0);
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
				

			}
		});

		leftPanel.getChckbxAuto().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (leftPanel.getChckbxAuto().isSelected()) {
					auto = IsAuto.AUTO;
					for (int i = lists.size() - 1; i >= 0; i--) {
						if (!lists.get(i).getIsAuto().equals(auto)) {
							lists.remove(i);
						}
					}
					if (lists.size() == 0) {
						lists = newLists;
						JOptionPane.showMessageDialog(null, auto.toString() + " 의 렌트카가 존재하지 않습니다.");
						leftPanel.getChckbxAuto().setSelected(false);
						return;
					}
				} 
				setScrollPaneAddList(scrollPane, header, isInsurance);
				leftPanel.getChckbxAuto().setEnabled(false);
			}

		});

		comboBoxCarName.getComboBox().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBoxCarName.getComboboxValue() == comboBoxCarName.getComboBox().getItemAt(0)) {
					return;
				}
				CarData carData = comboBoxCarName.getComboboxValue();
				lists = carDataService.selectCarDataByCarDataCodeList(carData);
				setComboBaxEnabled(false);
				setScrollPaneAddList(scrollPane, header, isInsurance);
				resetSelectComdo();

			}
		});

		leftPanel.getComboBoxFuel().getComboBox().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				comboAction();
			}
			/*	if (leftPanel.getComboBoxFuel().getComboboxValue() == leftPanel.getComboBoxFuel().getComboBox()
						.getItemAt(0)) {
					return;
				}
				newListAdd();
				Fuel fuel = leftPanel.getComboBoxFuel().getComboboxValue();
				for (int i = lists.size() - 1; i >= 0; i--) {
					if (!lists.get(i).getFuelCode().getFuelCode().equals(fuel.getFuelCode())) {
						lists.remove(i);
					}
				}

				if (lists.size() == 0) {
					lists = newLists;
					JOptionPane.showMessageDialog(null, fuel.getFuelType() + "type 렌트카가 존재하지 않습니다.");
					leftPanel.getComboBoxFuel().getComboBox().setSelectedIndex(0);
					return;
				}
				setScrollPaneAddList(scrollPane, header, isInsurance);
				leftPanel.getComboBoxFuel().getComboBox().setEnabled(false);
			}*/

		});

		leftPanel.getComboBoxManufacturer().getComboBox().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				comboAction();
			}
			/*	if (leftPanel.getComboBoxManufacturer().getComboboxValue() == leftPanel.getComboBoxManufacturer()
						.getComboBox().getItemAt(0)) {
					return;
				}
				newListAdd();
				Manufacturer manufacturer = leftPanel.getComboBoxManufacturer().getComboboxValue();
				for (int i = lists.size() - 1; i >= 0; i--) {
					if (!lists.get(i).getManufacturerCode().getManufacturerCode()
							.equals(manufacturer.getManufacturerCode())) {
						lists.remove(i);
					}
				}

				if (lists.size() == 0) {
					lists = newLists;
					JOptionPane.showMessageDialog(null, manufacturer.getManufacturerName() + " 의 렌트카가 존재하지 않습니다.");
					leftPanel.getComboBoxManufacturer().getComboBox().setSelectedIndex(0);
					return;
				}
				setScrollPaneAddList(scrollPane, header, isInsurance);
				leftPanel.getComboBoxManufacturer().getComboBox().setEnabled(false);
			}*/
		});

		leftPanel.getComboBoxSeater().getComboBox().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				comboAction();
			}
				/*if (leftPanel.getComboBoxSeater().getComboboxValue() == leftPanel.getComboBoxSeater().getComboBox()
						.getItemAt(0)) {
					return;
				}
				newListAdd();
				CarData seater = leftPanel.getComboBoxSeater().getComboboxValue();
				for (int i = lists.size() - 1; i >= 0; i--) {
					if (!lists.get(i).getCarSeater().equals(seater.getCarSeater())) {
						lists.remove(i);
					}
				}

				if (lists.size() == 0) {
					lists = newLists;
					JOptionPane.showMessageDialog(null, seater.getCarSeater() + " 인승 렌트카가 존재하지 않습니다.");
					leftPanel.getComboBoxSeater().getComboBox().setSelectedIndex(0);
					return;
				}
				setScrollPaneAddList(scrollPane, header, isInsurance);
				leftPanel.getComboBoxSeater().getComboBox().setEnabled(false);
			}*/
		});

		leftPanel.getComboBoxOld().getComboBox().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				comboAction();
			}
				/*if (leftPanel.getComboBoxOld().getComboboxValue() == leftPanel.getComboBoxOld().getComboBox()
						.getItemAt(0)) {
					return;
				}
				newListAdd();
				CarData old = leftPanel.getComboBoxOld().getComboboxValue();
				for (int i = lists.size() - 1; i >= 0; i--) {
					if (lists.get(i).getCarOld() != old.getCarOld()) {
						lists.remove(i);
					}
				}

				if (lists.size() == 0) {
					lists = newLists;
					JOptionPane.showMessageDialog(null, old.getCarOld() + " 연식 렌트카가 존재하지 않습니다.");
					leftPanel.getComboBoxOld().getComboBox().setSelectedIndex(0);
					return;
				}
				setScrollPaneAddList(scrollPane, header, isInsurance);
				leftPanel.getComboBoxOld().getComboBox().setEnabled(false);
			}*/
		});

		leftPanel.getBtnReset().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lists = carDataService.selectCarDataByAll();
				setScrollPaneAddList(scrollPane, header, isInsurance);
				setComboBaxEnabled(true);
				resetSelectComdo();
				comboBoxCarName.getComboBox().setSelectedIndex(0);
			}
		});

		setComboBaxEnabled(false);
		leftPanel.getBtnReset().setEnabled(false);
		leftPanel.getIsInsurance().setAllEnable(false);
	}

	private void resetSelectComdo() {
		leftPanel.getComboBoxOld().getComboBox().setSelectedIndex(0);
		leftPanel.getComboBoxSeater().getComboBox().setSelectedIndex(0);
		leftPanel.getComboBoxSeater().getComboBox().setSelectedIndex(0);
		leftPanel.getComboBoxManufacturer().getComboBox().setSelectedIndex(0);
		leftPanel.getComboBoxFuel().getComboBox().setSelectedIndex(0);
		leftPanel.getChckbxAuto().setSelected(false);

	}

	private List<CarData> newListAdd() {
		newLists = new ArrayList<>();
		for (int i = 0; i < lists.size(); i++) {
			newLists.add(lists.get(i));
		}
		return newLists;
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
		JOptionPane.showMessageDialog(null, "Asdf");
		CarData car = new CarData();
		if(leftPanel.getComboBoxManufacturer().getComboBox().getSelectedIndex()!=0) {
			Manufacturer manufacturer = leftPanel.getComboBoxManufacturer().getComboboxValue();
			car.setManufacturerCode(manufacturer);
		}
		if(leftPanel.getComboBoxFuel().getComboBox().getSelectedIndex()!=0) {
			Fuel fuel = leftPanel.getComboBoxFuel().getComboboxValue();
			car.setFuelCode(fuel);
		}
		if(leftPanel.getComboBoxOld().getComboBox().getSelectedIndex()!=0) {
			Object carOld = leftPanel.getComboBoxOld().getComboboxValue();
			car.setCarOld((int)carOld);
		}
		if(leftPanel.getComboBoxSeater().getComboBox().getSelectedIndex()!=0) {
			Object seater = leftPanel.getComboBoxSeater().getComboboxValue();
			car.setCarSeater((String)seater);
		}
		if(car.getManufacturerCode()==null&&car.getFuelCode()==null&&car.getCarOld()==0&&car.getCarSeater()==null) {
			return;
		}
		lists=carDataService.selectCarDataByCarValue(car);
		setScrollPaneAddList(scrollPane, header, isInsurance);
	}
}
