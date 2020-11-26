package SimplePhonePackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * Documentation
	 * Menu.java(SimplePhonePackage)
	 * 
	 * Display the "Welcome To Mr.Fone Mobile Phone Centre"
	 * Set the Click Button
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoYouNeed = new JLabel("Do You Need A Good Mobile Phone?");
		lblDoYouNeed.setForeground(Color.BLACK);
		lblDoYouNeed.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 25));
		lblDoYouNeed.setBounds(42, 113, 425, 37);
		contentPane.add(lblDoYouNeed);
		
		JLabel lblWelcomeToMrfone = new JLabel("Welcome To Mr.Fone Mobile Phone Centre");
		lblWelcomeToMrfone.setForeground(Color.BLACK);
		lblWelcomeToMrfone.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 25));
		lblWelcomeToMrfone.setBounds(10, 29, 481, 46);
		contentPane.add(lblWelcomeToMrfone);
		
		JButton btnClickMe = new JButton("Click Me !");
		btnClickMe.setForeground(Color.WHITE);
		btnClickMe.setBackground(Color.BLUE);
		btnClickMe.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 16));
		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainForm mf=new MainForm();
				mf.setVisible(true);
				dispose();
				
			}
		});
		btnClickMe.setBounds(216, 181, 135, 37);
		contentPane.add(btnClickMe);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\app\\Presentatioin Layer\\photo-1511707171634-5f897ff02aa9.jpg"));
		lblNewLabel.setBounds(0, 0, 520, 328);
		contentPane.add(lblNewLabel);
	}
}
