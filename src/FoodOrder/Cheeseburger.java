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
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;

public class Cheeseburger {

	private JFrame frmCheeseburger;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cheeseburger window = new Cheeseburger();
					window.frmCheeseburger.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cheeseburger() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCheeseburger = new JFrame();
		frmCheeseburger.setResizable(false);
		frmCheeseburger.setTitle("Cheeseburger");
		frmCheeseburger.setBounds(100, 100, 604, 525);
		frmCheeseburger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCheeseburger.getContentPane().setLayout(null);
		JButton button_1 = new JButton("NEXT");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tost t=new Tost();
				frmCheeseburger.dispose();
			}
		});
		button_1.setBounds(505, 472, 89, 23);
		frmCheeseburger.getContentPane().add(button_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hamburger H=new Hamburger();
				frmCheeseburger.dispose();
			}
		});
		btnBack.setBounds(10, 472, 89, 23);
		frmCheeseburger.getContentPane().add(btnBack);
		
		JButton button = new JButton("Order");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			          
		              theQuery("insert into Orders (id_Food)values(2)" );
		          }
		          catch(Exception ex){}
		          }
			
		});
		button.setBounds(435, 445, 60, 50);
		frmCheeseburger.getContentPane().add(button);
		frmCheeseburger.setVisible(true);
		frmCheeseburger.setLocationRelativeTo(null);
		button.setIcon(new ImageIcon(this.getClass().getResource("/images/order.png")));
		
		JLabel lblOrder = new JLabel("ORDER PRODUCT");
		lblOrder.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOrder.setBounds(320, 468, 105, 28);
		frmCheeseburger.getContentPane().add(lblOrder);
		
		JLabel lblCheeseburger = new JLabel("Cheeseburger");
		lblCheeseburger.setBounds(10, 11, 584, 484);
		frmCheeseburger.getContentPane().add(lblCheeseburger);
		lblCheeseburger.setIcon(new ImageIcon(this.getClass().getResource("/images/Cheeseburger.png")));
		

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
