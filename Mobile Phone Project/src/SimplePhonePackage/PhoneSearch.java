package SimplePhonePackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;

public class PhoneSearch extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 * Documentation
	 * PhoneSearch.java(SimplePhonePackage)
	 * Mr.Fone Mobile Phone Sale Company of Search Form
	 * 
	 * Set the search box and search button 
	 * Search by Color
	 * Search by Brand
	 * Search by OS
	 * Search by Price
	 * Set the Advanced Search button and link to TripleSearch.java
	 * Set the Back button and link to MainForm.java
	 * Set the exit button
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhoneSearch frame = new PhoneSearch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PhoneSearch() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Computer System\\1.png"));

		// create the object**********************************************************
		MainForm pf = new MainForm();
		Phoneinfo[] pharray = pf.getpharray();
		// return function*************************************************************

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSearchPhonetabletInfromation = new JLabel("Search Phone/Tablet Infromation");
		lblSearchPhonetabletInfromation.setForeground(Color.BLUE);
		lblSearchPhonetabletInfromation.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 20));
		lblSearchPhonetabletInfromation.setBounds(170, 11, 329, 24);
		contentPane.add(lblSearchPhonetabletInfromation);

		JRadioButton rdbtnSearchByBrand = new JRadioButton("Search By Brand");
		rdbtnSearchByBrand.setBounds(137, 42, 129, 23);
		contentPane.add(rdbtnSearchByBrand);

		JRadioButton rdbtnSearchByOs = new JRadioButton("Search By OS");
		rdbtnSearchByOs.setBounds(6, 78, 129, 23);
		contentPane.add(rdbtnSearchByOs);

		JRadioButton rdbtnSearchByColor = new JRadioButton("Search By Color");
		rdbtnSearchByColor.setBounds(6, 42, 129, 23);
		contentPane.add(rdbtnSearchByColor);

		JRadioButton rdbtnSearchByPrice = new JRadioButton("Search By Price");
		rdbtnSearchByPrice.setBounds(135, 78, 129, 23);
		contentPane.add(rdbtnSearchByPrice);

		// create the button
		// group***************************************************************
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnSearchByBrand);
		bg.add(rdbtnSearchByOs);
		bg.add(rdbtnSearchByColor);
		bg.add(rdbtnSearchByPrice);
		// create the button
		// group***************************************************************

		JLabel lblEnterSearchData = new JLabel("Enter Search Data");
		lblEnterSearchData.setBounds(385, 51, 114, 14);
		contentPane.add(lblEnterSearchData);

		textField = new JTextField();
		textField.setBounds(385, 79, 116, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				if (rdbtnSearchByBrand.isSelected()) {
					((DefaultTableModel) table.getModel()).setNumRows(0);
					String searchbrand = textField.getText();
					Linearsearch(pharray, searchbrand);
				}
				
				else if (rdbtnSearchByPrice.isSelected()) {
					((DefaultTableModel) table.getModel()).setNumRows(0);
					int searchprice = Integer.parseInt(textField.getText());
					Linearsearch(pharray, searchprice);
				}

				else if (rdbtnSearchByOs.isSelected()) {
					((DefaultTableModel) table.getModel()).setNumRows(0);
					String searchos = textField.getText();
					Linearsearchos(pharray, searchos);
				}

				else if (rdbtnSearchByColor.isSelected()) {
					((DefaultTableModel) table.getModel()).setNumRows(0);
					String searchcolor = textField.getText();
					Linearsearchcolor(pharray, searchcolor);
				} 
				
				
			}
		});
		btnSearch.setBounds(511, 78, 89, 23);
		contentPane.add(btnSearch);

		JPanel panel = new JPanel();
		panel.setBounds(6, 105, 609, 152);
		contentPane.add(panel);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "New column", "New column", "New column",
				"New column", "New column", "New column", "New column", "New column" }));
		panel.add(table);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				new MainForm().setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(410, 502, 89, 23);
		contentPane.add(btnBack);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(511, 502, 89, 23);
		contentPane.add(btnExit);

		JButton btnDoubleSearch = new JButton("Advanced Search");
		btnDoubleSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TripleSearch triple = new TripleSearch();
				triple.setVisible(true);
				dispose();

			}
		});
		btnDoubleSearch.setBounds(429, 461, 171, 23);
		contentPane.add(btnDoubleSearch);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				"D:\\app\\Presentatioin Layer\\14-58-25-samsung-mobile-phone-clipart-iphone-cell-phone-748789-1302200.png"));
		lblNewLabel.setBounds(0, 257, 621, 279);
		contentPane.add(lblNewLabel);

	}

	// *********Linear Search For Price*******************************************************
	public void Linearsearch(Phoneinfo[] pharray, int totamount) {

		int count = 0;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String column[] = new String[] { "List", "Brand", "Amount", "Model", "OS", "RAM", "Color", "Sale Amount" };
		model.addRow(column);
		for (int i = 0; i < pharray.length; i++) {
			if (pharray[i].getTotamount() == totamount) {
				String list = " " + pharray[i].getList();
				String totamount1 = " " + pharray[i].getTotamount();
				String amount = " " + pharray[i].getamount();
				String data[] = new String[] { list, pharray[i].getBrand(), amount, pharray[i].getModel(),
						pharray[i].getOs(), pharray[i].getRam(), pharray[i].getColor(), totamount1 };
				model.addRow(data);
				count++;
			}
		}
		if (count == 0) {
			JOptionPane.showMessageDialog(null, "No Data for this");
		}
	}
	// *********Linear Search For Price*******************************************************

	// *********Linear Search For Brand*******************************************************
	public void Linearsearch(Phoneinfo[] pharray, String brand) {

		int count = 0;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String column[] = new String[] { "List", "Brand", "Amount", "Model", "OS", "RAM", "Color", "Sale Amount" };
		model.addRow(column);
		for (int i = 0; i < pharray.length; i++) {
			if ((pharray[i].getBrand()).equals(brand)) {
				String list = " " + pharray[i].getList();
				String totamount1 = " " + pharray[i].getTotamount();
				String amount = " " + pharray[i].getamount();
				String data[] = new String[] { list, pharray[i].getBrand(), amount, pharray[i].getModel(),
						pharray[i].getOs(), pharray[i].getRam(), pharray[i].getColor(), totamount1 };
				model.addRow(data);
				count++;
			}
		}
		if (count == 0) {
			JOptionPane.showMessageDialog(null, "No Data for this");
		}
	}
	// *********Linear Search For Brand*******************************************************

	// *********Linear Search For
	// OS*******************************************************
	public void Linearsearchos(Phoneinfo[] pharray, String OS) {

		int count = 0;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String column[] = new String[] { "List", "Brand", "Amount", "Model", "OS", "RAM", "Color", "Sale Amount" };
		model.addRow(column);
		for (int i = 0; i < pharray.length; i++) {
			if ((pharray[i].getOs()).equals(OS)) {
				String list = " " + pharray[i].getList();
				String totamount1 = " " + pharray[i].getTotamount();
				String amount = " " + pharray[i].getamount();
				String data[] = new String[] { list, pharray[i].getBrand(), amount, pharray[i].getModel(),
						pharray[i].getOs(), pharray[i].getRam(), pharray[i].getColor(), totamount1 };
				model.addRow(data);
				count++;
			}
		}
		if (count == 0) {
			JOptionPane.showMessageDialog(null, "No Data for this");
		}
	}
	// *********Linear Search For
	// OS*******************************************************

	// *********Linear Search For
	// Color*******************************************************
	public void Linearsearchcolor(Phoneinfo[] pharray, String color) {

		int count = 0;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String column[] = new String[] { "List", "Brand", "Amount", "Model", "OS", "RAM", "Color", "Sale Amount" };
		model.addRow(column);
		for (int i = 0; i < pharray.length; i++) {
			if ((pharray[i].getColor()).equals(color)) {
				String list = " " + pharray[i].getList();
				String totamount1 = " " + pharray[i].getTotamount();
				String amount = " " + pharray[i].getamount();
				String data[] = new String[] { list, pharray[i].getBrand(), amount, pharray[i].getModel(),
						pharray[i].getOs(), pharray[i].getRam(), pharray[i].getColor(), totamount1 };
				model.addRow(data);
				count++;
			}
		}
		if (count == 0) {
			JOptionPane.showMessageDialog(null, "No Data for this");
		}
	}

	public Phoneinfo[] getpharray() {
		// TODO Auto-generated method stub
		return null;
	}
}
