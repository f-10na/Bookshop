package coursework;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

public class Bookshop extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bookshop frame = new Bookshop();
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
	public Bookshop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton toAdmin = new JButton("ADMIN");
		toAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AdminGUI Frame = new AdminGUI();
					Frame.setVisible(true);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		toAdmin.setForeground(new Color(147, 112, 219));
		toAdmin.setBounds(137, 67, 117, 29);
		contentPane.add(toAdmin);
		
		JButton toCustomer = new JButton("CUSTOMER");
		toCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CustomerGUI Frame = new CustomerGUI();
					Frame.setVisible(true);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		toCustomer.setForeground(new Color(147, 112, 219));
		toCustomer.setBounds(137, 128, 117, 29);
		contentPane.add(toCustomer);
	}
}
