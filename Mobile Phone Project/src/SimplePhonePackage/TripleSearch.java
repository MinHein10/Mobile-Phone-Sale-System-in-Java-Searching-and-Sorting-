package SimplePhonePackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

public class TripleSearch extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldBrand;
	private JTextField textFieldPrice;
	private JTextField textFieldColor;
	private JTable table;
	private JButton btnBack;
	private JButton btnExit;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 * Set the Search Box for brand, price, color
	 * Set the search button and search for brand, price, color
	 * Set the Back Button and link to PhoneSearch.java
	 * Set the Exit Button
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TripleSearch frame = new TripleSearch();
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
	public TripleSearch() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Computer System\\1.png"));
		// create the object**********************************************************

		MainForm pf = new MainForm();
		Phoneinfo[] pharray = pf.getpharray();

		// return function*************************************************************
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 20));
		lblBrand.setBounds(205, 11, 86, 23);
		contentPane.add(lblBrand);

		textFieldBrand = new JTextField();
		textFieldBrand.setBounds(205, 36, 86, 20);
		contentPane.add(textFieldBrand);
		textFieldBrand.setColumns(10);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 20));
		lblPrice.setBounds(311, 11, 86, 23);
		contentPane.add(lblPrice);

		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(311, 36, 86, 20);
		contentPane.add(textFieldPrice);
		textFieldPrice.setColumns(10);

		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 20));
		lblColor.setBounds(413, 11, 86, 23);
		contentPane.add(lblColor);

		textFieldColor = new JTextField();
		textFieldColor.setBounds(413, 36, 86, 20);
		contentPane.add(textFieldColor);
		textFieldColor.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				((DefaultTableModel) table.getModel()).setNumRows(0);
				String searchbrand = textFieldBrand.getText();
				// Linearsearch(pharray,searchbrand);

				// ((DefaultTableModel) table.getModel()).setNumRows(0);
				String searchcolor = textFieldColor.getText();
				// Linearsearchcolor(pharray,searchcolor);

				// ((DefaultTableModel) table.getModel()).setNumRows(0);
				int searchprice = Integer.parseInt(textFieldPrice.getText());
				// Linearsearch(pharray,searchprice);

				Linearsearchaddition(pharray, searchbrand, searchprice, searchcolor);

			}
		});
		btnSearch.setBounds(542, 35, 89, 23);
		contentPane.add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 621, 207);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "List", "Brand", "Amount", "Model", "OS", "RAM", "Color", "Sale Amount" }));
		scrollPane.setViewportView(table);

		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				new PhoneSearch().setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(10, 338, 89, 23);
		contentPane.add(btnBack);

		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);

			}
		});
		btnExit.setBounds(542, 338, 89, 23);
		contentPane.add(btnExit);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\gaming photo\\Prepare\\Words-Bible-PPT-Backgrounds-968x726.jpg"));
		lblNewLabel.setBounds(0, 0, 641, 384);
		contentPane.add(lblNewLabel);
	}

	// *********Linear Search For
	// Brand,price,color*******************************************************
	public void Linearsearchaddition(Phoneinfo[] pharray, String brand, int price, String color) {
		int count = 0;
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		for (int i = 0; i < pharray.length; i++) {
			if ((pharray[i].getBrand()).equals(brand) && pharray[i].getTotamount() == price
					&& (pharray[i].getColor()).equals(color)) {
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
	// Brand,price,color*******************************************************

}
