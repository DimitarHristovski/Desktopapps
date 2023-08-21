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

public class Cake {

	private JFrame frmCake;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cake window = new Cake();
					window.frmCake.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cake() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCake = new JFrame();
		frmCake.setResizable(false);
		frmCake.setTitle("Cake");
		frmCake.setBounds(100, 100, 606, 533);
		frmCake.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCake.getContentPane().setLayout(null);
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fries f=new Fries();
				frmCake.dispose();
			}
		});
		button.setBounds(10, 472, 89, 23);
		frmCake.getContentPane().add(button);
		
		JButton button_1 = new JButton("Order");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			          
		              theQuery(" insert into Orders (id_Food)values(9)" );
		          }
		          catch(Exception ex){}
		          }
			
		});
		button_1.setBounds(430, 445, 60, 50);
		frmCake.getContentPane().add(button_1);
		frmCake.setVisible(true);
		frmCake.setLocationRelativeTo(null);
		button_1.setIcon(new ImageIcon(this.getClass().getResource("/images/order.png")));
		JLabel label = new JLabel("ORDER PRODUCT");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(315, 468, 105, 28);
		frmCake.getContentPane().add(label);
		
		JLabel lblCake = new JLabel("Cake");
		lblCake.setBounds(10, 11, 584, 484);
		frmCake.getContentPane().add(lblCake);
		lblCake.setIcon(new ImageIcon(this.getClass().getResource("/images/cake.png")));
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
