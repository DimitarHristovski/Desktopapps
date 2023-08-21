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
import java.awt.Font;

public class Hamburger {

	private JFrame frmHamburger;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hamburger window = new Hamburger();
					window.frmHamburger.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Hamburger() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHamburger = new JFrame();
		frmHamburger.setResizable(false);
		frmHamburger.setTitle("Hamburger");
		frmHamburger.setBounds(100, 100, 605, 525);
		frmHamburger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHamburger.getContentPane().setLayout(null);
		frmHamburger.setVisible(true);
		
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cheeseburger t=new Cheeseburger();
				frmHamburger.dispose();
			}
		});
		btnNext.setBounds(505, 460, 89, 23);
		frmHamburger.getContentPane().add(btnNext);
		frmHamburger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHamburger.setLocationRelativeTo(null);
		frmHamburger.getContentPane().setLayout(null);
		
		JButton button = new JButton("Order");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			          
		              theQuery("    insert into Orders (id_Food)values(1)" );
		          }
		          catch(Exception ex){}
		          }
			
		});
		button.setBounds(435, 446, 60, 50);
		frmHamburger.getContentPane().add(button);
		button.setIcon(new ImageIcon(this.getClass().getResource("/images/order.png")));
		
		JLabel label = new JLabel("ORDER PRODUCT");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(320, 468, 105, 28);
		frmHamburger.getContentPane().add(label);
		
		JLabel Hamburger = new JLabel("hamburger");
		Hamburger.setBounds(10, 11, 594, 484);
		frmHamburger.getContentPane().add(Hamburger);
		Hamburger.setIcon(new ImageIcon(this.getClass().getResource("/images/hamburger.png")));

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
