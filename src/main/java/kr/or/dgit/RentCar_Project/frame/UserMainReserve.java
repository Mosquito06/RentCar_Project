package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.border.EmptyBorder;

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
	
	public void setComfirmUser(User comfirmUser) {
		this.comfirmUser = comfirmUser;
	}

	public UserMainReserve() {
		isInsurance=true;
		setBounds(new Rectangle(0, 0, 500, 500));
		setLayout(null);

		leftPanel = new ReserveLeftContent();
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		rightPanel.add(scrollPane);


		
		
		ReserveHeaderContent header = new ReserveHeaderContent();
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
				setScrollPaneAddList(scrollPane, header,isInsurance);
				setComboBaxEnabled(true);
				btnsPanel.setVisible(true);
				comboBoxCarName.setVisible(true);
				leftPanel.getIsInsurance().setAllEnable(true);
				leftPanel.getBtnReset().setEnabled(true);
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
					setScrollPaneAddList(scrollPane, header,isInsurance);
					setComboBaxEnabled(true);
					
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
				if(e.getStateChange()==1) {
					isInsurance=true;
					setScrollPaneAddList(scrollPane, header,isInsurance);
				}else {
					isInsurance=false;
					setScrollPaneAddList(scrollPane, header,isInsurance);
				}

			}
		});
		
		
		
		
		
		
/*		leftPanel.getIsAuto().getGroup().getSelection().addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent e) {
				int num = e.getStateChange();
				JOptionPane.showMessageDialog(null, num);
				newListAdd();
				if (num == 1) {
					auto = IsAuto.AUTO;
					for (int i = lists.size() - 1; i >= 0; i--) {
						if (!lists.get(i).getIsAuto().equals(auto)) {
							lists.remove(i);
						}
					}
					if (lists.size() == 0) {
						lists = newLists;
						JOptionPane.showMessageDialog(null, auto.toString() + " 의 렌트카가 존재하지 않습니다.");
						leftPanel.getIsAuto().getRdbtnRight().setSelected(true);
						return;
					}
				} else {
					auto = IsAuto.MANUAL;
					for (int i = lists.size() - 1; i >= 0; i--) {
						if (!lists.get(i).getIsAuto().equals(auto)) {
							lists.remove(i);
						}
					}
					if (lists.size() == 0) {
						lists = newLists;
						JOptionPane.showMessageDialog(null, auto.toString() + " 의 렌트카가 존재하지 않습니다.");
						leftPanel.getIsAuto().getRdbtnLeft().setSelected(true);
						return;
					}
				}
				setScrollPaneAddList(scrollPane, header, isInsurance);
			}
		});
		
		
		*/
		

		comboBoxCarName.getComboBox().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				CarData carData = comboBoxCarName.getComboboxValue();
				lists=carDataService.selectCarDataByCarDataCodeList(carData);
				setComboBaxEnabled(false);
				setScrollPaneAddList(scrollPane, header, isInsurance);
				
			}
		});
		
		leftPanel.getComboBoxFuel().getComboBox().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
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
					return;
				}
				setScrollPaneAddList(scrollPane, header, isInsurance);
				leftPanel.getComboBoxFuel().getComboBox().setEnabled(false);
			}

			
		});
		
		leftPanel.getComboBoxManufacturer().getComboBox().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				newListAdd();
				Manufacturer manufacturer = leftPanel.getComboBoxManufacturer().getComboboxValue();
				for (int i = lists.size() - 1; i >= 0; i--) {
					if (!lists.get(i).getManufacturerCode().getManufacturerCode().equals(manufacturer.getManufacturerCode())) {
						lists.remove(i);
					}
				}

				if (lists.size() == 0) {
					lists = newLists;
					JOptionPane.showMessageDialog(null, manufacturer.getManufacturerName() + " 의 렌트카가 존재하지 않습니다.");
					return;
				}
				setScrollPaneAddList(scrollPane, header, isInsurance);
				leftPanel.getComboBoxManufacturer().getComboBox().setEnabled(false);
			}
		});
		
		
		leftPanel.getComboBoxSeater().getComboBox().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				newListAdd();
				CarData seater = leftPanel.getComboBoxSeater().getComboboxValue();
				for (int i = lists.size() - 1; i >= 0; i--) {
					if (!lists.get(i).getCarSeater().equals(seater.getCarSeater())) {
						lists.remove(i);
					}
				}

				if (lists.size() == 0) {
					lists = newLists;
					JOptionPane.showMessageDialog(null, seater.getCarSeater() + " 의 렌트카가 존재하지 않습니다.");
					return;
				}
				setScrollPaneAddList(scrollPane, header, isInsurance);
				leftPanel.getComboBoxSeater().getComboBox().setEnabled(false);
			}
		});
		
		leftPanel.getComboBoxOld().getComboBox().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				newListAdd();
				CarData old = leftPanel.getComboBoxOld().getComboboxValue();
				for (int i = lists.size() - 1; i >= 0; i--) {
					if (lists.get(i).getCarOld()!=old.getCarOld()) {
						lists.remove(i);
					}
				}

				if (lists.size() == 0) {
					lists = newLists;
					JOptionPane.showMessageDialog(null, old.getCarOld() + " 의 렌트카가 존재하지 않습니다.");
					return;
				}
				setScrollPaneAddList(scrollPane, header, isInsurance);
				leftPanel.getComboBoxOld().getComboBox().setEnabled(false);
			}
		});
		
		
		
		
		leftPanel.getBtnReset().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lists = carDataService.selectCarDataByAll();
				setScrollPaneAddList(scrollPane, header,isInsurance);
				setComboBaxEnabled(true);
			}
		});
		
		setComboBaxEnabled(false);
		leftPanel.getBtnReset().setEnabled(false);
		leftPanel.getIsInsurance().setAllEnable(false);
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
		leftPanel.getIsAuto().setAllEnable(yes);
	}
	
	
	private void setScrollPaneAddList(JScrollPane scrollPane, ReserveHeaderContent header,Boolean isInsurance) {
		int totalTime = Integer.parseInt(header.getTotalTimePanel().getTextValue());
		if (totalTime == 0) {
			JOptionPane.showMessageDialog(null, "날짜를 입력하세요");
			return;
		}
		scrollPane.getViewport().removeAll();
		sDay = header.getStartPanel().getTextValue();
		fDay = header.getFinalPanel().getTextValue();
		addCar = new ReserveAddCarContent(totalTime, comfirmUser, lists,
				sDay,fDay,isInsurance);
		scrollPane.setViewportView(addCar);
		addCar.setLayout(new GridLayout(0, 1, 0, 0));
	}
	
	
	public void setCarDataNameBoxModel() {
		CarDataService carDataService = CarDataService.getInstance();
		List<CarData> lists = carDataService.selectCarDataByAll();
		Vector<CarData> carData = new Vector<>(lists);
		for (CarData c : lists) {
			c.setComboType(1);
			carData.add(c);
		}
		comboBoxCarName.setComboBoxModel(carData);
	}
}
