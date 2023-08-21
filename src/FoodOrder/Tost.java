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

public class Tost {

	private JFrame frmTost;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tost window = new Tost();
					window.frmTost.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tost() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTost = new JFrame();
		frmTost.setResizable(false);
		frmTost.setTitle("Tost");
		frmTost.setBounds(100, 100, 600, 525);
		frmTost.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTost.getContentPane().setLayout(null);
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cheeseburger c=new Cheeseburger();
				frmTost.dispose();
			}
		});
		button.setBounds(10, 472, 89, 23);
		frmTost.getContentPane().add(button);
		
		JButton button_1 = new JButton("NEXT");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Drinks t=new Drinks();
				frmTost.dispose();
			}
		});
		button_1.setBounds(505, 472, 89, 23);
		frmTost.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Order");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{

		              theQuery(" insert into Orders (id_Food)values(3)" );
		          }
		          catch(Exception ex){}
		          }
			
		});
		button_2.setBounds(438, 445, 60, 50);
		frmTost.getContentPane().add(button_2);
		frmTost.setVisible(true);
		frmTost.setLocationRelativeTo(null);
		button_2.setIcon(new ImageIcon(this.getClass().getResource("/images/order.png")));
		
		JLabel label = new JLabel("ORDER PRODUCT");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(332, 455, 105, 28);
		frmTost.getContentPane().add(label);
		
		JLabel lblTost = new JLabel("tost");
		lblTost.setBounds(10, 11, 584, 484);
		frmTost.getContentPane().add(lblTost);
		lblTost.setIcon(new ImageIcon(this.getClass().getResource("/images/Tost.png")));
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
