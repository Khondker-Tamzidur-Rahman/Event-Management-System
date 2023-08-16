package EventManagementSystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;

public class Cost {

	protected static final String Calender = null;
	private JFrame frame;
	private JTable table;
	private JTextField jtxtFirstName;
	private JTextField jtxtLastName;
	private JTextField jtxtAddress;
	private JTextField jtxtMobile;
	private JTextField jtxtEmail;
	private JTextField jtxtTax;
	private JTextField jtxtSubTotal;
	private JTextField jtxtTotal;
	private JTextField jtxtDisplay;
	private JTextField jtxtChange;
	private JTextField jtxtRefer;
	private JTextArea jtxtReceipt1;
	
	String iTax, iSubTotal, iTotal;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Cost window = new Cost();
					window.frame.setVisible(true);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cost() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	//-------------------------------------------------------------Functions----------------------------------------------------
	public void ServiceCost()
	{
		double sum = 0;
		double tax = 15.5;
		
		for(int i = 0; i < table.getRowCount(); i++)
		{
			sum = sum + Double.parseDouble(table.getValueAt(i, 2).toString());
		}
		
		jtxtSubTotal.setText(Double.toString(sum));
		double cTotal = Double.parseDouble(jtxtSubTotal.getText());
		
		double cTax = (tax * cTotal)/100;
		iTax = String.format("TK %.2f", cTax);
		jtxtTax.setText(iTax);
		
		 iSubTotal = String.format("TK %.2f", cTotal);
		jtxtSubTotal.setText(iSubTotal);
		
		 iTotal = String.format("TK %.2f", cTotal + cTax);
		jtxtTotal.setText(iTotal);
		
	}
	
	//-------------------------------------------------------------Functions----------------------------------------------------
	
	
	public void Change()
	{
		double sum = 0;
		double tax = 15.5;
		double cash = Double.parseDouble(jtxtDisplay.getText());
		
		for(int i = 0; i < table.getRowCount(); i++)
		{
			sum = sum + Double.parseDouble(table.getValueAt(i, 2).toString());
		}
		
		double cTax = (tax * sum)/100;
		double cChange = (cash - (sum + cTax));
		String ChangeGiven = String.format("TK %.2f", cChange);
		jtxtChange.setText(ChangeGiven);
	}
	
	//-------------------------------------------------------------Functions----------------------------------------------------
	private void initialize() {  
		frame = new JFrame();
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {

				jtxtRefer.setText(null);
				jtxtRefer.setEnabled(false);
				int refs = 5015 + (int) (Math.random()*17238);
				String cRef = "";
				cRef += refs + 1560;
				
				jtxtRefer.setText(cRef);
				
			}
		});
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 138, 138));
		panel.setBorder(new MatteBorder(8, 8, 8, 8, (Color) new Color(209, 209, 209)));
		panel.setBounds(0, 11, 284, 312);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblReferId = new JLabel("Refer ID");
		lblReferId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblReferId.setBounds(10, 15, 111, 14);
		panel.add(lblReferId);
		
		jtxtRefer = new JTextField();
		jtxtRefer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtxtRefer.setColumns(10);
		jtxtRefer.setBounds(120, 12, 154, 20);
		panel.add(jtxtRefer);
		
		jtxtFirstName = new JTextField();
		jtxtFirstName.setBounds(120, 40, 154, 20);
		jtxtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtxtFirstName.setColumns(10);
		panel.add(jtxtFirstName);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 43, 111, 14);
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(lblFirstName);
		
		jtxtLastName = new JTextField();
		jtxtLastName.setBounds(120, 71, 154, 20);
		jtxtLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtxtLastName.setColumns(10);
		panel.add(jtxtLastName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 74, 111, 14);
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(lblLastName);
		
		jtxtAddress = new JTextField();
		jtxtAddress.setBounds(120, 102, 154, 17);
		jtxtAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtxtAddress.setColumns(10);
		panel.add(jtxtAddress);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 105, 111, 14);
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(lblAddress);
		
		jtxtMobile = new JTextField();
		jtxtMobile.setBounds(120, 130, 154, 20);
		jtxtMobile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtxtMobile.setColumns(10);
		panel.add(jtxtMobile);
		
		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setBounds(10, 133, 111, 14);
		lblMobileNo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(lblMobileNo);
		
		jtxtEmail = new JTextField();
		jtxtEmail.setBounds(120, 161, 154, 20);
		jtxtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtxtEmail.setColumns(10);
		panel.add(jtxtEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 164, 111, 14);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(lblEmail);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setBounds(10, 195, 111, 14);
		lblDateOfBirth.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(lblDateOfBirth);
		
		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setBounds(10, 226, 111, 14);
		lblNationality.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(lblNationality);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(10, 257, 111, 14);
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(lblGender);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(10, 284, 111, 14);
		lblStatus.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(lblStatus);
		
		JComboBox jcboNationality = new JComboBox();
		jcboNationality.setBounds(119, 223, 155, 22);
		jcboNationality.setModel(new DefaultComboBoxModel(new String[] {"", "American", "Afghan\t", "Australian", "Bangladeshi", "Brazilian", "British", "Cambodian", "Canadian", "Chinese", "Danish", "Dutch", "Egyptian", "Emirati", "Filipino", "French", "Georgian", "German", "Hungarian", "Indian\t", "Indonesian", "Italian", "Japanese", "Kenyan", "Lebanese", "Liberian", "Malaysian", "Mexican", "Nepalese", "New Zealander", "Pakistani", "Polish", "Portuguese", "Russian", "Saudi Arabian", "Scottish", "Singaporean", "Spanish", "Thai", "Turkish", "Ugandan", "Ukrainian", "Vietnamese", "Zimbabwean", "", ""}));
		jcboNationality.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(jcboNationality);
		
		JComboBox jcboGender = new JComboBox();
		jcboGender.setBounds(119, 252, 155, 22);
		jcboGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		jcboGender.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(jcboGender);
		
		JComboBox jcboStatus = new JComboBox();
		jcboStatus.setBounds(120, 281, 155, 22);
		jcboStatus.setModel(new DefaultComboBoxModel(new String[] {"Unmarried", "Married"}));
		jcboStatus.setBackground(new Color(255, 255, 255));
		jcboStatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(jcboStatus);
		
		JComboBox jcboDOB1 = new JComboBox();
		jcboDOB1.setBounds(120, 192, 44, 22);
		jcboDOB1.setModel(new DefaultComboBoxModel(new String[] {"...", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		jcboDOB1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(jcboDOB1);
		
		JComboBox jcboDOB2 = new JComboBox();
		jcboDOB2.setBounds(168, 192, 44, 22);
		jcboDOB2.setModel(new DefaultComboBoxModel(new String[] {"...", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}));
		jcboDOB2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(jcboDOB2);
		
		JComboBox jcboDOB3 = new JComboBox();
		jcboDOB3.setBounds(218, 192, 56, 22);
		jcboDOB3.setModel(new DefaultComboBoxModel(new String[] {"...", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980"}));
		jcboDOB3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(jcboDOB3);
		
		JTextArea jtxtReceipt1 = new JTextArea();
		jtxtReceipt1.setBounds(1084, 254, 286, 233);
		frame.getContentPane().add(jtxtReceipt1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 138, 138));
		panel_1.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(187, 187, 187)));
		panel_1.setBounds(284, 11, 800, 476);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton jbtnCultural = new JButton("Cultural");
		jbtnCultural.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double Price = 1200;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Cultural", "1", Price});
				ServiceCost();
			}
		});
		jbtnCultural.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnCultural.setBounds(10, 11, 79, 109);
		panel_1.add(jbtnCultural);
		
		JButton jbtnIndoor = new JButton("Indoor");
		jbtnIndoor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double Price = 2050;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Indoor", "1", Price});
				ServiceCost();
			}
		});
		jbtnIndoor.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnIndoor.setBounds(88, 11, 79, 109);
		panel_1.add(jbtnIndoor);
		
		JButton jbtnRetro = new JButton("Retro");
		jbtnRetro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 1500;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Retro", "1", Price});
				ServiceCost();
			}
		});
		jbtnRetro.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnRetro.setBounds(166, 11, 79, 109);
		panel_1.add(jbtnRetro);
		
		JButton jbtnBollywood = new JButton("Bolly");
		jbtnBollywood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double Price = 2350;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Bollywood", "1", Price});
				ServiceCost();
			}
		});
		jbtnBollywood.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnBollywood.setBounds(244, 11, 79, 109);
		panel_1.add(jbtnBollywood);
		
		JButton jbtnReligious = new JButton("Religious");
		jbtnReligious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 1800;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Religious", "1", Price});
				ServiceCost();
			}
		});
		jbtnReligious.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnReligious.setBounds(322, 11, 79, 109);
		panel_1.add(jbtnReligious);
		
		JButton jbtnOutdoor = new JButton("Outdoor");
		jbtnOutdoor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 3450;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Outdoor", "1", Price});
				ServiceCost();
			}
		});
		jbtnOutdoor.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnOutdoor.setBounds(400, 11, 79, 109);
		panel_1.add(jbtnOutdoor);
		
		JButton jbtnDisco = new JButton("Disco");
		jbtnDisco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 2500;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Disco", "1", Price});
				ServiceCost();
			}
		});
		jbtnDisco.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnDisco.setBounds(478, 11, 79, 109);
		panel_1.add(jbtnDisco);
		
		JButton jbtnTraditional = new JButton("Traditional");
		jbtnTraditional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 3100;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Traditional", "1", Price});
				ServiceCost();
			}
		});
		jbtnTraditional.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnTraditional.setBounds(10, 123, 79, 109);
		panel_1.add(jbtnTraditional);
		
		JButton jbtnICCB = new JButton("ICCB");
		jbtnICCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 5500;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"ICCB", "1", Price});
				ServiceCost();
			}
		});
		jbtnICCB.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnICCB.setBounds(10, 243, 79, 109);
		panel_1.add(jbtnICCB);
		
		JButton jbtnPhoto = new JButton("Photo");
		jbtnPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double Price = 2400;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Photography", "1", Price});
				ServiceCost();
			}
		});
		jbtnPhoto.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnPhoto.setBounds(556, 11, 79, 109);
		panel_1.add(jbtnPhoto);
		
		JButton jbtnVideo = new JButton("Video");
		jbtnVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double Price = 4300;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Videography", "1", Price});
				ServiceCost();
			}
		});
		jbtnVideo.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnVideo.setBounds(634, 11, 79, 109);
		panel_1.add(jbtnVideo);
		
		JButton jbtnCinemato = new JButton("Cinemato");
		jbtnCinemato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 7100;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Cinematography", "1", Price});
				ServiceCost();
			}
		});
		jbtnCinemato.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnCinemato.setBounds(711, 11, 79, 109);
		panel_1.add(jbtnCinemato);
		
		JButton jbtnWCH = new JButton("WCH");
		jbtnWCH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 3000;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"The WaterFront Convention Hall", "1", Price});
				ServiceCost();
			}
		});
		jbtnWCH.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnWCH.setBounds(10, 356, 79, 109);
		panel_1.add(jbtnWCH);
		
		JButton jbtnCraft = new JButton("Crafting");
		jbtnCraft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 1900;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Crafting", "1", Price});
				ServiceCost();
			}
		});
		jbtnCraft.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnCraft.setBounds(711, 123, 79, 109);
		panel_1.add(jbtnCraft);
		
		JButton jbtnLight = new JButton("Lighting");
		jbtnLight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 5500;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Lightings", "1", Price});
				ServiceCost();
			}
		});
		jbtnLight.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnLight.setBounds(634, 123, 79, 109);
		panel_1.add(jbtnLight);
		
		JButton jbtnBalloon = new JButton("Balloons");
		jbtnBalloon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 2100;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Balloons", "1", Price});
				ServiceCost();
			}
		});
		jbtnBalloon.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnBalloon.setBounds(556, 123, 79, 109);
		panel_1.add(jbtnBalloon);
		
		JButton jbtnFloral = new JButton("Floral");
		jbtnFloral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 6730;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Floral", "1", Price});
				ServiceCost();
			}
		});
		jbtnFloral.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnFloral.setBounds(478, 123, 79, 109);
		panel_1.add(jbtnFloral);
		
		JButton jbtnModern = new JButton("Modern");
		jbtnModern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 3800;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Modern", "1", Price});
				ServiceCost();
			}
		});
		jbtnModern.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnModern.setBounds(400, 123, 79, 109);
		panel_1.add(jbtnModern);
		
		JButton jbtnPrincess = new JButton("Princess");
		jbtnPrincess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 8900;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Princess", "1", Price});
				ServiceCost();
			}
		});
		jbtnPrincess.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnPrincess.setBounds(322, 123, 79, 109);
		panel_1.add(jbtnPrincess);
		
		JButton jbtnMarvel = new JButton("Marvel");
		jbtnMarvel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 1600;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Marvel", "1", Price});
				ServiceCost();
			}
		});
		jbtnMarvel.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnMarvel.setBounds(244, 123, 79, 109);
		panel_1.add(jbtnMarvel);
		
		JButton jbtnFairytale = new JButton("FairyTale");
		jbtnFairytale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 1300;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"FairyTale", "1", Price});
				ServiceCost();
			}
		});
		jbtnFairytale.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnFairytale.setBounds(166, 123, 79, 109);
		panel_1.add(jbtnFairytale);
		
		JButton jbtnDisney = new JButton("Disney");
		jbtnDisney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 1990;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"DisneyLand", "1", Price});
				ServiceCost();
			}
		});
		jbtnDisney.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnDisney.setBounds(88, 123, 79, 109);
		panel_1.add(jbtnDisney);
		
		JButton jbtnStage = new JButton("Stage");
		jbtnStage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 3610;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Stage", "1", Price});
				ServiceCost();
			}
		});
		jbtnStage.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnStage.setBounds(711, 243, 79, 109);
		panel_1.add(jbtnStage);
		
		JButton jbtnSolo = new JButton("Solo");
		jbtnSolo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 2500;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Solo Singer", "1", Price});
				ServiceCost();
			}
		});
		jbtnSolo.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnSolo.setBounds(634, 243, 79, 109);
		panel_1.add(jbtnSolo);
		
		JButton jbtnBand = new JButton("Band");
		jbtnBand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 6000;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Band", "1", Price});
				ServiceCost();
			}
		});
		jbtnBand.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnBand.setBounds(556, 243, 79, 109);
		panel_1.add(jbtnBand);
		
		JButton jbtnDJ = new JButton("DJ");
		jbtnDJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 2900;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"DJ", "1", Price});
				ServiceCost();
			}
		});
		jbtnDJ.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnDJ.setBounds(478, 243, 79, 109);
		panel_1.add(jbtnDJ);
		
		JButton jbtnSM = new JButton("SenaM");
		jbtnSM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 2600;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Sena Malancha", "1", Price});
				ServiceCost();
			}
		});
		jbtnSM.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnSM.setBounds(400, 243, 79, 109);
		panel_1.add(jbtnSM);
		
		JButton jbtnSG = new JButton("SecretG");
		jbtnSG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 2340;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Secret Garden", "1", Price});
				ServiceCost();
			}
		});
		jbtnSG.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnSG.setBounds(322, 243, 79, 109);
		panel_1.add(jbtnSG);
		
		JButton jbtnAM = new JButton("AzizM");
		jbtnAM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 1950;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Aziz Manzil", "1", Price});
				ServiceCost();
			}
		});
		jbtnAM.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnAM.setBounds(244, 243, 79, 109);
		panel_1.add(jbtnAM);
		
		JButton jbtnSSB = new JButton("SSB");
		jbtnSSB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 3470;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Six Seasons Banquet", "1", Price});
				ServiceCost();
			}
		});
		jbtnSSB.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnSSB.setBounds(166, 243, 79, 109);
		panel_1.add(jbtnSSB);
		
		JButton jbtnRH = new JButton("RH&R");
		jbtnRH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 3500;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Regency Hotel & Resort", "1", Price});
				ServiceCost();
			}
		});
		jbtnRH.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnRH.setBounds(88, 243, 79, 109);
		panel_1.add(jbtnRH);
		
		JButton jbtnTurkish = new JButton("Turkish");
		jbtnTurkish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 5600;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Turkish", "1", Price});
				ServiceCost();
			}
		});
		jbtnTurkish.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnTurkish.setBounds(711, 356, 79, 109);
		panel_1.add(jbtnTurkish);
		
		JButton jbtnItalian = new JButton("Italian");
		jbtnItalian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 4900;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Italian", "1", Price});
				ServiceCost();
			}
		});
		jbtnItalian.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnItalian.setBounds(634, 356, 79, 109);
		panel_1.add(jbtnItalian);
		
		JButton jbtnChinese = new JButton("Chinese");
		jbtnChinese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 3850;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Chinese", "1", Price});
				ServiceCost();
			}
		});
		jbtnChinese.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnChinese.setBounds(556, 356, 79, 109);
		panel_1.add(jbtnChinese);
		
		JButton jbtnIndian = new JButton("Indian");
		jbtnIndian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 3550;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Indian", "1", Price});
				ServiceCost();
			}
		});
		jbtnIndian.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnIndian.setBounds(478, 356, 79, 109);
		panel_1.add(jbtnIndian);
		
		JButton jbtnPakistani = new JButton("Pakistani");
		jbtnPakistani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 3650;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Pakistani", "1", Price});
				ServiceCost();
			}
		});
		jbtnPakistani.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnPakistani.setBounds(400, 356, 79, 109);
		panel_1.add(jbtnPakistani);
		
		JButton jbtnBengali = new JButton("Bengali");
		jbtnBengali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 3550;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Bengali", "1", Price});
				ServiceCost();
			}
		});
		jbtnBengali.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnBengali.setBounds(322, 356, 79, 109);
		panel_1.add(jbtnBengali);
		
		JButton jbtnBGB = new JButton("BGB-Hall");
		jbtnBGB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 2100;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"BGB Banquet Hall", "1", Price});
				ServiceCost();
			}
		});
		jbtnBGB.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnBGB.setBounds(244, 356, 79, 109);
		panel_1.add(jbtnBGB);
		
		JButton jbtnEPC = new JButton("EPC");
		jbtnEPC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 3700;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Emmanuelle's Party Center", "1", Price});
				ServiceCost();
			}
		});
		jbtnEPC.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnEPC.setBounds(166, 356, 79, 109);
		panel_1.add(jbtnEPC);
		
		JButton jbtnBAF = new JButton("BAF-Hall");
		jbtnBAF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Price = 2090;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"BAF Falcon Hall", "1", Price});
				ServiceCost();
			}
		});
		jbtnBAF.setFont(new Font("Tahoma", Font.ITALIC, 12));
		jbtnBAF.setBounds(88, 356, 79, 109);
		panel_1.add(jbtnBAF);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 111, 111));
		panel_2.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(127, 127, 127)));
		panel_2.setBounds(0, 487, 1370, 254);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBounds(917, 11, 405, 225);
		panel_3_2.setBorder(new MatteBorder(8, 8, 8, 8, (Color) new Color(209, 209, 209)));
		panel_3_2.setBackground(new Color(255, 138, 138));
		panel_2.add(panel_3_2);
		panel_3_2.setLayout(null);
		
		JPanel panel_3_2_1 = new JPanel();
		panel_3_2_1.setBounds(475, 11, 405, 225);
		panel_3_2_1.setBorder(new MatteBorder(8, 8, 8, 8, (Color) new Color(209, 209, 209)));
		panel_3_2_1.setBackground(new Color(255, 138, 138));
		panel_3_2_1.setLayout(null);
		panel_2.add(panel_3_2_1);
		
		jtxtDisplay = new JTextField();
		jtxtDisplay.setBackground(new Color(255, 235, 225));
		jtxtDisplay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtxtDisplay.setColumns(10);
		jtxtDisplay.setBounds(196, 103, 187, 28);
		panel_3_2_1.add(jtxtDisplay);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Amount Paid");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(31, 103, 155, 20);
		panel_3_2_1.add(lblNewLabel_1_1_1);
		
		jtxtChange = new JTextField();
		jtxtChange.setBackground(new Color(255, 235, 225));
		jtxtChange.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtxtChange.setColumns(10);
		jtxtChange.setBounds(196, 156, 187, 28);
		panel_3_2_1.add(jtxtChange);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Changes");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_2.setBounds(31, 156, 155, 20);
		panel_3_2_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Payment Method");
		lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_3.setBounds(31, 48, 155, 20);
		panel_3_2_1.add(lblNewLabel_1_1_3);
		
		JComboBox jcboPayment = new JComboBox();
		jcboPayment.setBackground(new Color(255, 235, 225));
		jcboPayment.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Bkash", "Visa Card", "MasterCard"}));
		jcboPayment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jcboPayment.setBounds(196, 46, 187, 28);
		panel_3_2_1.add(jcboPayment);
		
		JButton jbtnPay = new JButton("Pay");
		jbtnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(jcboPayment.getSelectedItem().equals("Cash"))
				{
					Change();
				}
				else
				{
					jtxtChange.setText("");
					jtxtDisplay.setText("");
				}
			}
		});
		jbtnPay.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jbtnPay.setBounds(32, 21, 175, 51);
		panel_3_2.add(jbtnPay);
		
		JButton jbtnReset = new JButton("Reset");
		jbtnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jtxtFirstName.setText("");
				jtxtLastName.setText("");
				jtxtAddress.setText("");
				jtxtEmail.setText("");
				
				jtxtRefer.setText(null);
				jtxtRefer.setEnabled(false);
				int refs = 5015 + (int) (Math.random()*17238);
				String cRef = "";
				cRef += refs + 1560;
				
				jtxtDisplay.setText(null);
				jtxtChange.setText(null);
				jtxtTax.setText(null);
				jtxtSubTotal.setText(null);
				jtxtTotal.setText(null);
				jtxtReceipt1.setText(null);
				
				DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
				RecordTable.setRowCount(0);
			}
		});
		jbtnReset.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jbtnReset.setBounds(32, 150, 175, 51);
		panel_3_2.add(jbtnReset);
		
		JButton jbtnRemove = new JButton("Remove");
		jbtnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				int RemoveItem = table.getSelectedRow();
				if(RemoveItem >= 0)
				{
					model.removeRow(RemoveItem);
				}
				
				ServiceCost();
				
				if(jcboPayment.getSelectedItem().equals("Cash"))
				{
					Change();
				}
				else
				{
					jtxtChange.setText("");
					jtxtDisplay.setText("");
				}
			}
		});
		jbtnRemove.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jbtnRemove.setBounds(32, 83, 175, 51);
		panel_3_2.add(jbtnRemove);
		
		JButton jbtnExit = new JButton("Exit");
		jbtnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame = new JFrame("Exit");
				
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Costing site", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		jbtnExit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jbtnExit.setBounds(217, 129, 159, 51);
		panel_3_2.add(jbtnExit);
		
		JButton jbtnTotal = new JButton("Total");
		jbtnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jtxtReceipt1.setEnabled(true);
				int refs = 1325 + (int) (Math.random()*4238);
				
				Calendar timer = Calendar.getInstance();
				timer.getTime();
				SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
				tTime.format(timer.getTime());
				SimpleDateFormat Tdate = new SimpleDateFormat("dd:MMM:yyyy");
				Tdate.format(timer.getTime());
				
				jtxtReceipt1.append("\t Billing\n" + 
				"Reference:\t\t" +refs+ 
				"\n=================================================================\t " +
				
						"\n=================================================================\t " +
						"\nRefer ID:\t\t" + jtxtRefer.getText() +
						"\nFirst Name:\t\t" + jtxtFirstName.getText() +
						"\nLast Name:\t\t" + jtxtLastName.getText() +
						"\n=================================================================\t " +
						
						"\nTax:\t\t" +iTax+
						"\nSub Total:\t\t" +iSubTotal+
						"\nTotal:\t\t" +iTotal+ 
						
						"\n================================================================\t " +
						"\nDate: " +Tdate.format(timer.getTime())+ "\tTime: " +tTime.format(timer.getTime())+
						"\nThank you contacting us.\n");
				
				
			}
		});
		jbtnTotal.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jbtnTotal.setBounds(217, 53, 159, 51);
		panel_3_2.add(jbtnTotal);
		
		JPanel panel_3_2_2 = new JPanel();
		panel_3_2_2.setBounds(32, 11, 405, 225);
		panel_3_2_2.setBackground(new Color(255, 138, 138));
		panel_3_2_2.setBorder(new MatteBorder(8, 8, 8, 8, (Color) new Color(209, 209, 209)));
		panel_3_2_2.setLayout(null);
		panel_2.add(panel_3_2_2);
		
		JLabel lblNewLabel_1 = new JLabel("Tax");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(20, 48, 155, 20);
		panel_3_2_2.add(lblNewLabel_1);
		
		jtxtTax = new JTextField();
		jtxtTax.setBackground(new Color(255, 235, 225));
		jtxtTax.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtxtTax.setBounds(185, 40, 187, 28);
		panel_3_2_2.add(jtxtTax);
		jtxtTax.setColumns(10);
		
		jtxtSubTotal = new JTextField();
		jtxtSubTotal.setBackground(new Color(255, 235, 225));
		jtxtSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtxtSubTotal.setColumns(10);
		jtxtSubTotal.setBounds(185, 100, 187, 28);
		panel_3_2_2.add(jtxtSubTotal);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sub Total");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(20, 100, 155, 20);
		panel_3_2_2.add(lblNewLabel_1_1);
		
		jtxtTotal = new JTextField();
		jtxtTotal.setBackground(new Color(255, 235, 225));
		jtxtTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtxtTotal.setColumns(10);
		jtxtTotal.setBounds(185, 152, 187, 28);
		panel_3_2_2.add(jtxtTotal);
		
		JLabel lblNewLabel_1_2 = new JLabel("Total Amount");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(20, 152, 155, 20);
		panel_3_2_2.add(lblNewLabel_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1084, 11, 286, 244);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Services", "Items Selected", "Amount"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(125);
		table.getColumnModel().getColumn(1).setPreferredWidth(81);
		table.getColumnModel().getColumn(2).setPreferredWidth(95);
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(232, 232, 232));
		panel_3.setBounds(0, 324, 284, 162);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton jbtn9 = new JButton("9");
		jbtn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = jtxtDisplay.getText();
				
				if(Enternumber == "")
				{
					jtxtDisplay.setText(jbtn9.getText());
				}
				else
				{
					Enternumber = jtxtDisplay.getText() + jbtn9.getText();
					jtxtDisplay.setText(Enternumber);
				}
			}
		});
		jbtn9.setFont(new Font("Tahoma", Font.BOLD, 15));
		jbtn9.setBounds(10, 0, 66, 54);
		panel_3.add(jbtn9);
		
		JButton jbtn6 = new JButton("6");
		jbtn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = jtxtDisplay.getText();
				
				if(Enternumber == "")
				{
					jtxtDisplay.setText(jbtn6.getText());
				}
				else
				{
					Enternumber = jtxtDisplay.getText() + jbtn6.getText();
					jtxtDisplay.setText(Enternumber);
				}
			}
		});
		jbtn6.setFont(new Font("Tahoma", Font.BOLD, 15));
		jbtn6.setBounds(76, 0, 66, 54);
		panel_3.add(jbtn6);
		
		JButton jbtn3 = new JButton("3");
		jbtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = jtxtDisplay.getText();
				
				if(Enternumber == "")
				{
					jtxtDisplay.setText(jbtn3.getText());
				}
				else
				{
					Enternumber = jtxtDisplay.getText() + jbtn3.getText();
					jtxtDisplay.setText(Enternumber);
				}
			}
		});
		jbtn3.setFont(new Font("Tahoma", Font.BOLD, 15));
		jbtn3.setBounds(142, 0, 66, 54);
		panel_3.add(jbtn3);
		
		JButton jbtnC = new JButton("C");
		jbtnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					jtxtDisplay.setText(null);
					jtxtChange.setText(null);
			}
		});
		jbtnC.setFont(new Font("Tahoma", Font.BOLD, 15));
		jbtnC.setBounds(208, 0, 66, 54);
		panel_3.add(jbtnC);
		
		JButton jbtnDot = new JButton(".");
		jbtnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = jtxtDisplay.getText();
				
				if(! jtxtDisplay.getText().contains("."))
				{
					jtxtDisplay.setText(jtxtDisplay.getText() + jbtnDot.getText());
				}		
				
			}
		});
		jbtnDot.setFont(new Font("Tahoma", Font.BOLD, 15));
		jbtnDot.setBounds(208, 54, 66, 54);
		panel_3.add(jbtnDot);
		
		JButton jbtn2 = new JButton("2");
		jbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Enternumber = jtxtDisplay.getText();
				
				if(Enternumber == "")
				{
					jtxtDisplay.setText(jbtn2.getText());
				}
				else
				{
					Enternumber = jtxtDisplay.getText() + jbtn2.getText();
					jtxtDisplay.setText(Enternumber);
				}
			}
		});
		jbtn2.setFont(new Font("Tahoma", Font.BOLD, 15));
		jbtn2.setBounds(142, 54, 66, 54);
		panel_3.add(jbtn2);
		
		JButton jbtn5 = new JButton("5");
		jbtn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = jtxtDisplay.getText();
				
				if(Enternumber == "")
				{
					jtxtDisplay.setText(jbtn5.getText());
				}
				else
				{
					Enternumber = jtxtDisplay.getText() + jbtn5.getText();
					jtxtDisplay.setText(Enternumber);
				}
			}
		});
		jbtn5.setFont(new Font("Tahoma", Font.BOLD, 15));
		jbtn5.setBounds(76, 54, 66, 54);
		panel_3.add(jbtn5);
		
		JButton jbtn8 = new JButton("8");
		jbtn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = jtxtDisplay.getText();
				
				if(Enternumber == "")
				{
					jtxtDisplay.setText(jbtn8.getText());
				}
				else
				{
					Enternumber = jtxtDisplay.getText() + jbtn8.getText();
					jtxtDisplay.setText(Enternumber);
				}
			}
		});
		jbtn8.setFont(new Font("Tahoma", Font.BOLD, 15));
		jbtn8.setBounds(10, 54, 66, 54);
		panel_3.add(jbtn8);
		
		JButton jbtn0 = new JButton("0");
		jbtn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = jtxtDisplay.getText();
				
				if(Enternumber == "")
				{
					jtxtDisplay.setText(jbtn0.getText());
				}
				else
				{
					Enternumber = jtxtDisplay.getText() + jbtn0.getText();
					jtxtDisplay.setText(Enternumber);
				}
			}
		});
		jbtn0.setFont(new Font("Tahoma", Font.BOLD, 15));
		jbtn0.setBounds(208, 108, 66, 54);
		panel_3.add(jbtn0);
		
		JButton jbtn1 = new JButton("1");
		jbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = jtxtDisplay.getText();
				
				if(Enternumber == "")
				{
					jtxtDisplay.setText(jbtn1.getText());
				}
				else
				{
					Enternumber = jtxtDisplay.getText() + jbtn1.getText();
					jtxtDisplay.setText(Enternumber);
				}
			}
		});
		jbtn1.setFont(new Font("Tahoma", Font.BOLD, 15));
		jbtn1.setBounds(142, 108, 66, 54);
		panel_3.add(jbtn1);
		
		JButton jbtn4 = new JButton("4");
		jbtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = jtxtDisplay.getText();
				
				if(Enternumber == "")
				{
					jtxtDisplay.setText(jbtn4.getText());
				}
				else
				{
					Enternumber = jtxtDisplay.getText() + jbtn4.getText();
					jtxtDisplay.setText(Enternumber);
				}
			}
		});
		jbtn4.setFont(new Font("Tahoma", Font.BOLD, 15));
		jbtn4.setBounds(76, 108, 66, 54);
		panel_3.add(jbtn4);
		
		JButton jbtn7 = new JButton("7");
		jbtn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Enternumber = jtxtDisplay.getText();
				
				if(Enternumber == "")
				{
					jtxtDisplay.setText(jbtn7.getText());
				}
				else
				{
					Enternumber = jtxtDisplay.getText() + jbtn7.getText();
					jtxtDisplay.setText(Enternumber);
				}
			}
		});
		jbtn7.setFont(new Font("Tahoma", Font.BOLD, 15));
		jbtn7.setBounds(10, 108, 66, 54);
		panel_3.add(jbtn7);
		
	}
}
