package Table;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import RL.Registration;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Student {

	private JFrame frmStudent;
	private JTextField ID;
	private JTextField IME;
	private JTextField PREZIME;
	private JTextField GODINI;
	private JTextField PREDMET;
	private JTextField OCENKA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student window = new Student();
					window.frmStudent.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Student() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudent = new JFrame();
		frmStudent.setResizable(false);
		frmStudent.setForeground(SystemColor.controlText);
		frmStudent.setIconImage(Toolkit.getDefaultToolkit().getImage(Student.class.getResource("/Table/log.png")));
		frmStudent.setTitle("Student");
		frmStudent.setBackground(Color.LIGHT_GRAY);
		frmStudent.getContentPane().setBackground(SystemColor.activeCaptionBorder);
		frmStudent.setBounds(100, 100, 1023, 240);
		frmStudent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudent.getContentPane().setLayout(null);
		
		JLabel lblTable = new JLabel("TABELA STUDENT");
		lblTable.setBounds(24, 28, 107, 47);
		frmStudent.getContentPane().add(lblTable);
		
		ID = new JTextField();
		ID.setBounds(150, 41, 100, 25);
		frmStudent.getContentPane().add(ID);
		ID.setColumns(10);
		
		IME = new JTextField();
		IME.setColumns(10);
		IME.setBounds(270, 41, 100, 25);
		frmStudent.getContentPane().add(IME);
		
		PREZIME = new JTextField();
		PREZIME.setColumns(10);
		PREZIME.setBounds(390, 41, 100, 25);
		frmStudent.getContentPane().add(PREZIME);
		
		GODINI = new JTextField();
		GODINI.setColumns(10);
		GODINI.setBounds(510, 41, 100, 25);
		frmStudent.getContentPane().add(GODINI);
		
		PREDMET = new JTextField();
		PREDMET.setColumns(10);
		PREDMET.setBounds(630, 41, 100, 25);
		frmStudent.getContentPane().add(PREDMET);
		
		OCENKA = new JTextField();
		OCENKA.setColumns(10);
		OCENKA.setBounds(750, 41, 100, 25);
		frmStudent.getContentPane().add(OCENKA);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(150, 11, 100, 25);
		frmStudent.getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("IME\r\n");
		lblName.setBounds(270, 11, 100, 25);
		frmStudent.getContentPane().add(lblName);
		
		JLabel lblLastname = new JLabel("PREZIME\r\n");
		lblLastname.setBounds(390, 11, 100, 25);
		frmStudent.getContentPane().add(lblLastname);
		
		JLabel lblAge = new JLabel("GODINI\r\n");
		lblAge.setBounds(510, 11, 100, 25);
		frmStudent.getContentPane().add(lblAge);
		
		JLabel lblPredmet = new JLabel("PREDMET\r\n");
		lblPredmet.setBounds(630, 11, 100, 25);
		frmStudent.getContentPane().add(lblPredmet);
		
		JLabel lblOcenka = new JLabel("OCENKA\r\n");
		lblOcenka.setBounds(750, 11, 100, 25);
		frmStudent.getContentPane().add(lblOcenka);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
			          
		              theQuery("insert into Student (ime,prezime,godini,predmet,ocenka) values('"+IME.getText()+"','"+PREZIME.getText()+"','"+GODINI.getText()+"','"+PREDMET.getText()+"','"+OCENKA.getText()+"')");
		          }
		          catch(Exception ex){}
		          }
				
			
		});
		btnInsert.setBounds(882, 40, 89, 25);
		frmStudent.getContentPane().add(btnInsert);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
			          
		            theQuery("update Student set ime = '"+IME.getText()+"',prezime = '"+PREZIME.getText()+"', godini = "+GODINI.getText()+",predmet = '"+PREDMET.getText()+"' where id = "+ID.getText());
		          }
		          catch(Exception ex){}
		          }
				
				
			
		});
		btnUpdate.setBounds(270, 86, 460, 25);
		frmStudent.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
			           
		              theQuery("delete from Student where id = "+ID.getText());
		          }
		          catch(Exception ex){}
		          }
			
		});
		btnDelete.setBounds(160, 86, 89, 25);
		frmStudent.getContentPane().add(btnDelete);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
	                 theQuery("CREATE TABLE Student ("
	                         + "	id  serial PRIMARY KEY,"
	                         + "	ime varchar(255) ,"
	                         + "	prezime varchar(255), "
	                         + "	godini int, "
	                         +"     predmet varchar(255) DEFAULT 'Java I',"
	                         +"     ocenka int"
	                    + ");");
	             }
	             catch(Exception ex){}
	             
			}
			
		});
		btnCreate.setBounds(24, 86, 89, 25);
		frmStudent.getContentPane().add(btnCreate);
		
		JButton btnDrop = new JButton("DROP");
		btnDrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theQuery("drop table Student");
			}
		});
		btnDrop.setBounds(24, 120, 89, 25);
		frmStudent.getContentPane().add(btnDrop);
		
		JButton btnInsert_1 = new JButton("CHANGE OCENKA");
		btnInsert_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			          
		            theQuery("update Student set ocenka = "+OCENKA.getText()+" where ime = '"+IME.getText()+"'");
		          }
		          catch(Exception ex){}
		          }
			
			
		});
		btnInsert_1.setBounds(750, 86, 132, 25);
		frmStudent.getContentPane().add(btnInsert_1);
		
		JButton btnChangePredmet = new JButton("CHANGE PREDMET");
		btnChangePredmet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			          
		            theQuery("update Student set predmet = '"+PREDMET.getText()+"' where ime = '"+IME.getText()+"'");
		          }
		          catch(Exception ex){}
		          }
			
		});
		btnChangePredmet.setBounds(630, 132, 169, 25);
		frmStudent.getContentPane().add(btnChangePredmet);
	}
	
	//PROSEKOCENA.setText(theQuery("SELECT sum(ocenka) as zbir\r\n" + 
//"from student"));
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
	      
	          new  Student();
	      }
	 }

