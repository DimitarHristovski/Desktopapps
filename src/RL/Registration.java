package RL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.SystemColor;

public class Registration {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame REGISTER;
	private JTextField id;
	private JTextField Name;
	private JTextField LastName;
	private JTextField Username;
	private JPasswordField passwordField;
	private JTextField Email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.REGISTER.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		REGISTER = new JFrame();
		REGISTER.setBackground(SystemColor.info);
		REGISTER.getContentPane().setBackground(SystemColor.inactiveCaption);
		REGISTER.getContentPane().setForeground(SystemColor.controlDkShadow);
		REGISTER.setTitle("REGISTER");
		REGISTER.setResizable(false);
		REGISTER.setBounds(100, 100, 537, 381);
		REGISTER.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		REGISTER.getContentPane().setLayout(null);
		
		REGISTER.setVisible(true);
		REGISTER. setLocationRelativeTo(null);
	      
		JLabel lblId = new JLabel("id");
		lblId.setBounds(56, 40, 140, 25);
		REGISTER.getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(56, 70, 140, 25);
		REGISTER.getContentPane().add(lblName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(56, 100, 140, 25);
		REGISTER.getContentPane().add(lblLastName);
		
		id = new JTextField();
		id.setBounds(244, 40, 140, 25);
		REGISTER.getContentPane().add(id);
		id.setColumns(10);
		
		Name = new JTextField();
		Name.setBounds(244, 70, 140, 25);
		REGISTER.getContentPane().add(Name);
		Name.setColumns(10);
		
		LastName = new JTextField();
		LastName.setBounds(244, 100, 140, 25);
		REGISTER.getContentPane().add(LastName);
		LastName.setColumns(10);
		
		JButton btnInsert = new JButton("Register");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Name.getText().equals("") || LastName.getText().equals("") || Username.getText().equals("") || passwordField.getText().equals("") || Email.getText().equals("")) {

				try{
					JOptionPane.showMessageDialog(REGISTER,"ADD user data  ");

		          }
		          catch(Exception ex){}
		          }
				
			
			else {
	              theQuery("insert into Korisnik (Name,lastname,username,email,password) values('"+Name.getText()+"','"+LastName.getText()+"','"+Username.getText()+"','"+Email.getText()+"','"+passwordField.getText()+"')");

			}
			
		}
		});
		btnInsert.setBounds(244, 251, 140, 23);
		REGISTER.getContentPane().add(btnInsert);
		
		JButton btnChangepassword = new JButton("CHANGE PASSWORD");
		btnChangepassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passchange pass=new Passchange();
			}
				
			
		});
		btnChangepassword.setBounds(394, 190, 137, 33);
		REGISTER.getContentPane().add(btnChangepassword);
		
		JButton btnCreateTable = new JButton("Create Table");
		btnCreateTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try{
	                 theQuery("CREATE TABLE Korisnik ("
	                         + "	id serial PRIMARY KEY,"
	                         + "	name varchar(255) ,\n"
	                         + "	Lastname varchar(255), "
	                         + "	Username varchar(255), "
	                         +"     email varchar(255),"
	                         +"     password varchar(255)"
	                    + ");");
	             }
	             catch(Exception ex){}
	             
			}
		});
		btnCreateTable.setBounds(416, 11, 104, 23);
		REGISTER.getContentPane().add(btnCreateTable);
		
		JButton btnDropTable = new JButton("Drop Table");
		btnDropTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
	                 theQuery("Drop TABLE Korisnik ");
	             }
	             catch(Exception ex){}
	             
			}
		});
		btnDropTable.setBounds(416, 56, 104, 23);
		REGISTER.getContentPane().add(btnDropTable);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setBounds(56, 130, 140, 25);
		REGISTER.getContentPane().add(lblUsername);
		
		Username = new JTextField();
		Username.setBounds(244, 130, 140, 25);
		REGISTER.getContentPane().add(Username);
		Username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(244, 190, 140, 25);
		REGISTER.getContentPane().add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(53, 190, 140, 25);
		REGISTER.getContentPane().add(lblPassword);
		
		JButton Login = new JButton("Login\r\n");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
               LoginForm lg=new LoginForm();
               lg.setVisible(true);
			}
		});
		Login.setBounds(323, 316, 89, 23);
		REGISTER.getContentPane().add(Login);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(56, 160, 46, 25);
		REGISTER.getContentPane().add(lblEmail);
		
		Email = new JTextField();
		Email.setBounds(244, 160, 140, 25);
		REGISTER.getContentPane().add(Email);
		Email.setColumns(10);
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
	      
	          new  Registration();
	      }
	 }

