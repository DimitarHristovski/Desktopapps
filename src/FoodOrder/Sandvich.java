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

public class Sandvich {

	private JFrame frmSandvich;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sandvich window = new Sandvich();
					window.frmSandvich.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sandvich() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSandvich = new JFrame();
		frmSandvich.setResizable(false);
		frmSandvich.setTitle("Sandvich");
		frmSandvich.setBounds(100, 100, 603, 529);
		frmSandvich.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSandvich.getContentPane().setLayout(null);
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Drinks t=new Drinks();
				frmSandvich.dispose();
			}
		});
		button.setBounds(10, 472, 89, 23);
		frmSandvich.getContentPane().add(button);
		
		JButton button_1 = new JButton("NEXT");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fries f=new Fries();
				frmSandvich.dispose();
			}
		});
		button_1.setBounds(505, 472, 89, 23);
		frmSandvich.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Order");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			          
		              theQuery("insert into Orders (id_Food)values(5) " );
		          }
		          catch(Exception ex){}
		          }
			
		});
		button_2.setBounds(435, 445, 60, 50);
		frmSandvich.getContentPane().add(button_2);
		frmSandvich.setVisible(true);
		frmSandvich.setLocationRelativeTo(null);
		button_2.setIcon(new ImageIcon(this.getClass().getResource("/images/order.png")));
		
		JLabel label = new JLabel("ORDER PRODUCT");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(320, 468, 105, 28);
		frmSandvich.getContentPane().add(label);
		
		JLabel lblSandvich = new JLabel("Sandvich");
		lblSandvich.setBounds(10, 11, 584, 484);
		frmSandvich.getContentPane().add(lblSandvich);
		lblSandvich.setIcon(new ImageIcon(this.getClass().getResource("/images/sandwich.png")));
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
