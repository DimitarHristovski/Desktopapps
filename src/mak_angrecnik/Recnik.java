package mak_angrecnik;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Recnik {

	private JFrame frame;
	private JTextField MK;
	private JTextField ANG;
	private JTextField MEANING;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recnik window = new Recnik();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Recnik() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMakedonski = new JLabel("makedonski");
		lblMakedonski.setBounds(31, 11, 96, 26);
		frame.getContentPane().add(lblMakedonski);
		
		JLabel lblAngliski = new JLabel("angliski");
		lblAngliski.setBounds(156, 11, 91, 26);
		frame.getContentPane().add(lblAngliski);
		
		JLabel lblZnacenje = new JLabel("znacenje");
		lblZnacenje.setBounds(285, 11, 86, 26);
		frame.getContentPane().add(lblZnacenje);
		
		MK = new JTextField();
		MK.setBounds(31, 48, 86, 20);
		frame.getContentPane().add(MK);
		MK.setColumns(10);
		
		ANG = new JTextField();
		ANG.setBounds(156, 48, 86, 20);
		frame.getContentPane().add(ANG);
		ANG.setColumns(10);
		
		MEANING = new JTextField();
		MEANING.setBounds(285, 48, 86, 20);
		frame.getContentPane().add(MEANING);
		MEANING.setColumns(10);
		
		JButton btnUnsert = new JButton("INSERT\r\n");
		btnUnsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(MK.getText().equals("") || ANG.getText().equals("") || MEANING.getText().equals("")) {

				try{
					JOptionPane.showMessageDialog(frame,"ADD user data  ");

		          }
		          catch(Exception ex){}
		          }
			else {
	              theQuery("insert into Recnik (Makedonski,Angliski,Znacenje) values('"+MK.getText()+"','"+ANG.getText()+"','"+MEANING.getText()+"')");

			}}
		});
		btnUnsert.setBounds(156, 92, 91, 23);
		frame.getContentPane().add(btnUnsert);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
	                 theQuery("CREATE TABLE Recnik ("
	                         + "	indeks  serial PRIMARY KEY,"
	                         + "	Makedonski varchar(255) ,"
	                         + "	Angliski varchar(255), "
	                         +"     Znacenje varchar(255) "
	                         + ");");
	             }
	             catch(Exception ex){}
	             
			}
			
		});
		btnCreate.setBounds(31, 160, 89, 23);
		frame.getContentPane().add(btnCreate);
		
		JButton btnDrop = new JButton("DROP");
		btnDrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theQuery("drop table Recnik");

			}
		});
		btnDrop.setBounds(31, 194, 89, 23);
		frame.getContentPane().add(btnDrop);
		
		JButton btnDeleteWord = new JButton("DELETE WORD");
		btnDeleteWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
			           
		              theQuery("delete from Recnik where Angliski = '"+ANG.getText()+"'");
		              theQuery("delete from Recnik where Makedonski = '"+MK.getText()+"'");
		          }
		          catch(Exception ex){}
		          }
				
			
		});
		btnDeleteWord.setBounds(282, 92, 142, 23);
		frame.getContentPane().add(btnDeleteWord);
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
	  
	  
	      public static void main1(String[] args){
	      
	          new  Recnik();
	      }
}
