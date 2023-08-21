package FoodOrder;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Drinks {

	private JFrame frmDrinks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drinks window = new Drinks();
					window.frmDrinks.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Drinks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDrinks = new JFrame();
		frmDrinks.setResizable(false);
		frmDrinks.getContentPane().setBackground(Color.WHITE);
		frmDrinks.getContentPane().setForeground(Color.GRAY);
		frmDrinks.setTitle("Drinks");
		frmDrinks.setBounds(100, 100, 620, 545);
		frmDrinks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDrinks.setVisible(true);
		frmDrinks.setLocationRelativeTo(null);
		frmDrinks.getContentPane().setLayout(null);
		
		JButton btnviva = new JButton("Order");
		btnviva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			          
		              theQuery("   insert into Orders (id_Food)values(8)" );
		          }
		          catch(Exception ex){}
		          }
			
		});
		btnviva.setBounds(445, 458, 60, 50);
		frmDrinks.getContentPane().add(btnviva);
		btnviva.setIcon(new ImageIcon(this.getClass().getResource("/images/order.png")));
		
		JButton buttoncocacola = new JButton("Order");
		buttoncocacola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			          
		              theQuery("    insert into Orders (id_Food)values(7) " );
		          }
		          catch(Exception ex){}
		          }
			
			
		});
		buttoncocacola.setBounds(94, 458, 60, 50);
		frmDrinks.getContentPane().add(buttoncocacola);
		buttoncocacola.setIcon(new ImageIcon(this.getClass().getResource("/images/order.png")));

		JButton buttfanta = new JButton("Order");
		buttfanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			          
		              theQuery("   insert into Orders (id_Food)values(6) " );
		          }
		          catch(Exception ex){}
		          }
			
		});
		buttfanta.setBounds(268, 458, 60, 50);
		frmDrinks.getContentPane().add(buttfanta);
		buttfanta.setIcon(new ImageIcon(this.getClass().getResource("/images/order.png")));
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tost t=new Tost();
				frmDrinks.dispose();
			}
		});
		btnBack.setBounds(10, 485, 89, 23);
		frmDrinks.getContentPane().add(btnBack);
		
		JButton button_2 = new JButton("NEXT");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sandvich S=new Sandvich();
				frmDrinks.dispose();
			}
		});
		button_2.setBounds(515, 485, 89, 23);
		frmDrinks.getContentPane().add(button_2);
		JLabel fanta = new JLabel("New label");
		fanta.setBounds(198, 0, 195, 460);
		frmDrinks.getContentPane().add(fanta);
		fanta.setIcon(new ImageIcon(this.getClass().getResource("/images/fanta.png")));
		
		JLabel cocacola = new JLabel("New label");
		cocacola.setBounds(10, 0, 195, 460);
		frmDrinks.getContentPane().add(cocacola);
		cocacola.setIcon(new ImageIcon(this.getClass().getResource("/images/coca cola.png")));
		
		JLabel viva = new JLabel("New label");
		viva.setBounds(399, 0, 195, 460);
		frmDrinks.getContentPane().add(viva);
		viva.setIcon(new ImageIcon(this.getClass().getResource("/images/viva.png")));
		
		JLabel label = new JLabel("ORDER PRODUCT");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(154, 468, 115, 28);
		frmDrinks.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("ORDER PRODUCT");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(338, 468, 105, 28);
		frmDrinks.getContentPane().add(label_1);

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
