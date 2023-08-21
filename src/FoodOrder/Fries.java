package FoodOrder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Fries {

	private JFrame frmFries;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fries window = new Fries();
					window.frmFries.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Fries() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFries = new JFrame();
		frmFries.setResizable(false);
		frmFries.getContentPane().setBackground(Color.WHITE);
		frmFries.setTitle("Fries");
		frmFries.setBounds(100, 100, 592, 525);
		frmFries.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFries.getContentPane().setLayout(null);
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sandvich s=new Sandvich();
				frmFries.dispose();
			}
		});
		button.setBounds(10, 472, 89, 23);
		frmFries.getContentPane().add(button);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cake c=new Cake();
				frmFries.dispose();
			}
		});
		btnNext.setBounds(497, 472, 89, 23);
		frmFries.getContentPane().add(btnNext);
		
		JButton button_1 = new JButton("Order");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			          
		              theQuery(" insert into Orders (id_Food)values(4)" );
		          }
		          catch(Exception ex){}
		          }
			
		});
		button_1.setBounds(422, 445, 60, 50);
		frmFries.getContentPane().add(button_1);
		frmFries.setVisible(true);
		frmFries.setLocationRelativeTo(null);
		button_1.setIcon(new ImageIcon(this.getClass().getResource("/images/order.png")));
		
		JLabel label = new JLabel("ORDER PRODUCT");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(310, 468, 105, 28);
		frmFries.getContentPane().add(label);
		
		JLabel FRIES = new JLabel("New label");
		FRIES.setBounds(0, 11, 586, 484);
		frmFries.getContentPane().add(FRIES);
		FRIES.setIcon(new ImageIcon(this.getClass().getResource("/images/Fries.png")));

	}
	public void theQuery(String query){
	       Connection con = null;
	       Statement st = null;
	       try{
	           con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Test","dimi","postgres");
	           st = con.createStatement();
	           st.executeUpdate(query);
	           JOptionPane.showMessageDialog(null,"Query Executed");
	       }catch(Exception ex){
	           JOptionPane.showMessageDialog(null,ex.getMessage());
	       }
	   }
}
