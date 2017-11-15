package kr.or.dgit.RentCar_Project.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

import kr.or.dgit.RentCar_Project.content.ReserveAddCarContent;
import kr.or.dgit.RentCar_Project.content.ReserveHeaderContent;
import kr.or.dgit.RentCar_Project.content.ReserveLeftContent;
import kr.or.dgit.RentCar_Project.dto.CarData;
import kr.or.dgit.RentCar_Project.dto.CarModel;
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


	public void setComfirmUser(User comfirmUser) {
		this.comfirmUser = comfirmUser;
	}

	public UserMainReserve() {

		setBounds(new Rectangle(0, 0, 500, 500));
		setLayout(null);

		ReserveLeftContent leftPanel = new ReserveLeftContent();
		leftPanel.setBorder(new TitledBorder(
				new CompoundBorder(new LineBorder(new Color(0, 0, 0)),
						new EtchedBorder(EtchedBorder.LOWERED, null, null)),
				"\uC0C1\uC138\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		leftPanel.setBounds(0, 79, 302, 672);
		add(leftPanel);
		leftPanel.setLayout(null);

		JPanel rightPanel = new JPanel();
		rightPanel.setBounds(310, 112, 664, 639);
		add(rightPanel);
		rightPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		rightPanel.add(scrollPane);

		JPanel carList = new JPanel();
		scrollPane.setViewportView(carList);
		carList.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\DGIT3-10\\Desktop\\if_BT_c3angle_905667.png"));
		lblNewLabel_1.setBounds(65, 0, 522, 590);
		carList.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("날짜를 입력하세요");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(24, 40, 210, 101);
		carList.add(lblNewLabel);

		ReserveHeaderContent header = new ReserveHeaderContent();
		header.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)),
				new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		header.setBounds(3, 3, 968, 72);
		add(header);
		sDay = header.getStartPanel().getTextValue();
		fDay = header.getFinalPanel().getTextValue();
		header.getBtnSearch().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (header.getTotalTimePanel().getTextValue().equals("0")) {
					JOptionPane.showMessageDialog(null, "날짜를 정확하게 입력하세요");
					return;
				}
				
				lists = carDataService.selectCarDataByAll();
				setScrollPaneAddList(scrollPane, header);
			}
		});

		JPanel btnsPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) btnsPanel.getLayout();
		flowLayout.setHgap(10);
		btnsPanel.setBounds(303, 76, 671, 35);
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
					setScrollPaneAddList(scrollPane, header);
				}
			});
		}
		add(btnsPanel);

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
	}

	private void setScrollPaneAddList(JScrollPane scrollPane, ReserveHeaderContent header) {
		int totalTime = Integer.parseInt(header.getTotalTimePanel().getTextValue());
		if (totalTime == 0) {
			JOptionPane.showMessageDialog(null, "날짜를 입력하세요");
			return;
		}
		scrollPane.getViewport().removeAll();
		ReserveAddCarContent addCar = new ReserveAddCarContent(totalTime, comfirmUser, lists,
				sDay,fDay);
		scrollPane.setViewportView(addCar);
		addCar.setLayout(new GridLayout(0, 1, 0, 0));
	}
}
