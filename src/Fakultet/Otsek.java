package Fakultet;

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

public class Otsek {

	private JFrame Otsek;
	private JTextField id_otsek;
	private JTextField ime_otsek;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Otsek window = new Otsek();
					window.Otsek.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Otsek() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Otsek = new JFrame();
		Otsek.getContentPane().setBackground(SystemColor.activeCaption);
		Otsek.setTitle("Otsek");
		Otsek.setBounds(100, 100, 450, 300);
		Otsek.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Otsek.getContentPane().setLayout(null);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuForm mf=new MenuForm();
				Otsek.dispose();

			}
		});
		button.setBounds(335, 227, 89, 23);
		Otsek.getContentPane().add(button);
		
		JButton button_1 = new JButton("INSERT");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
		              theQuery("insert into Otsek (id_otsek,ime_otsek) values('"+id_otsek.getText()+"','"+ime_otsek.getText()+"')");
	             }
	             catch(Exception ex){}
	             
			}
				
			
		});
		button_1.setBounds(251, 87, 89, 23);
		Otsek.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("CREATE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
	                 theQuery("CREATE TABLE OTSEK ("
	                         + "	id_otsek int PRIMARY KEY,"
	                         + "	ime_otsek varchar(255) "
	        
	                    + ");");
	             }
	             catch(Exception ex){}
			}
		});
		button_2.setBounds(10, 227, 89, 23);
		Otsek.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("DROP");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
	                 theQuery("Drop TABLE Otsek ");
	             }
	             catch(Exception ex){}
	             
			}
		});
		button_3.setBounds(109, 227, 89, 23);
		Otsek.getContentPane().add(button_3);
		
		id_otsek = new JTextField();
		id_otsek.setColumns(10);
		id_otsek.setBounds(55, 88, 86, 20);
		Otsek.getContentPane().add(id_otsek);
		
		ime_otsek = new JTextField();
		ime_otsek.setColumns(10);
		ime_otsek.setBounds(151, 88, 86, 20);
		Otsek.getContentPane().add(ime_otsek);
		
		JLabel lblIdotsek = new JLabel("id_otsek");
		lblIdotsek.setBounds(55, 63, 86, 14);
		Otsek.getContentPane().add(lblIdotsek);
		
		JLabel lblImeotsek = new JLabel("ime_otsek");
		lblImeotsek.setBounds(152, 63, 85, 14);
		Otsek.getContentPane().add(lblImeotsek);
		
		JButton button_4 = new JButton("DELETE");
		button_4.setBounds(251, 117, 89, 23);
		Otsek.getContentPane().add(button_4);
		Otsek.setVisible(true);
		Otsek.setLocationRelativeTo(null);

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
