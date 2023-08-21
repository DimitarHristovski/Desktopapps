package FoodOrder;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class Adminmenu {

	private JFrame menu;
	private JTextField price;
	private JTextField food_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminmenu window = new Adminmenu();
					window.menu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Adminmenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		menu = new JFrame();
		menu.getContentPane().setBackground(SystemColor.activeCaption);
		menu.setTitle("menu");
		menu.setBounds(100, 100, 620, 443);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.getContentPane().setLayout(null);
		
		
		JButton btnCreate = new JButton("CREATE ");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
	                 theQuery("CREATE TABLE Food ("
	                         + "	id_Food  int PRIMARY KEY,"
	                         + "	food_name varchar(255) ,"
	                         + "	food_describe varchar(255), "
	                         + "	price int "
	                       
	                    + ");"); 
	                 
	                 
	                 theQuery("CREATE TABLE Orders(id_order serial primary key,id_Food int,datum date,foreign key(id_Food)references Food(id_Food))");
	             }
	             catch(Exception ex){}
	             
			}
			
		});
		btnCreate.setBounds(10, 30, 89, 23);
		menu.getContentPane().add(btnCreate);

		JButton btnDrop = new JButton("DROP");
		btnDrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				theQuery("drop table Orders");
				theQuery("drop table Food");
			}
		});
		btnDrop.setBounds(134, 30, 89, 23);
		menu.getContentPane().add(btnDrop);
		
		JButton btnUpdatePrices = new JButton("UPDATE PRICES");
		btnUpdatePrices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			          
		            theQuery("update Food set price = '"+price.getText()+"' where food_name = '"+food_name.getText()+"'");
		          }
		          catch(Exception ex){}
		          }
			
		});
		btnUpdatePrices.setBounds(10, 229, 128, 23);
		menu.getContentPane().add(btnUpdatePrices);
		
		price = new JTextField();
		price.setBounds(247, 230, 86, 20);
		menu.getContentPane().add(price);
		price.setColumns(10);
		
		food_name = new JTextField();
		food_name.setBounds(151, 230, 86, 20);
		menu.getContentPane().add(food_name);
		food_name.setColumns(10);
		
		JLabel lblFoodname = new JLabel("foodname");
		lblFoodname.setBounds(151, 205, 90, 14);
		menu.getContentPane().add(lblFoodname);
		
		JLabel lblPrice = new JLabel("price");
		lblPrice.setBounds(251, 205, 46, 14);
		menu.getContentPane().add(lblPrice);
		
		JButton btnInsertFoods = new JButton("INSERT FOODS");
		btnInsertFoods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			          
		            theQuery(" insert into Food (id_food,food_name,food_describe,price)values(1,'hamburger','burger',100);" 
		            		+"insert into Food (id_food,food_name,food_describe,price)values(2,'cheeseburger','burger',120);" 
		            		+"insert into Food (id_food,food_name,food_describe,price)values(3,'tost','salama,kaskaval',80);"
		            		+"insert into Food (id_food,food_name,food_describe,price)values(4,'fries','kompiri',50);"
		            		+"insert into Food (id_food,food_name,food_describe,price)values(5,'sandvich','salama,kaskaval,salata',40);"
		            		+"insert into Food (id_food,food_name,food_describe,price)values(6,'fanta','drink',40);"
		            		+"insert into Food (id_food,food_name,food_describe,price)values(7,'cocacola','drink',40);"
		            		+"insert into Food (id_food,food_name,food_describe,price)values(8,'viva','drink',20);"
		            		+"insert into Food (id_food,food_name,food_describe,price)values(9,'cake','desert',60)"
		            		
		            		
		            		
		            		
		            		
		            		
		            		);
		          }
		          catch(Exception ex){}
		          }
			
				
			
		});
		btnInsertFoods.setBounds(268, 30, 107, 23);
		menu.getContentPane().add(btnInsertFoods);
		
		JButton btnOpenMenu = new JButton("OPEN MENU");
		btnOpenMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FoodMenu fm=new FoodMenu();
				menu.dispose();		
				}
		});
		btnOpenMenu.setBounds(220, 370, 138, 23);
		menu.getContentPane().add(btnOpenMenu);
		
		JLabel lblAutomaticlyFillThe = new JLabel("Automaticly fill the database");
		lblAutomaticlyFillThe.setBounds(181, 11, 218, 14);
		menu.getContentPane().add(lblAutomaticlyFillThe);
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
