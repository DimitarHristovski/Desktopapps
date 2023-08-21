package RL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class Passchange {

	private JFrame frame;
	private JTextField email;
	private JPasswordField pass;
	private JLabel lblEmail;
	private JLabel lblPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Passchange window = new Passchange();
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
	public Passchange() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		email = new JTextField();
		email.setBounds(206, 92, 155, 20);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(206, 123, 155, 20);
		frame.getContentPane().add(pass);
		
		JButton btnChangePass = new JButton("change pass");
		btnChangePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			          
		            theQuery("update Korisnik set password = '"+pass.getText()+"' where email = '"+email.getText()+"'");
		          }
		          catch(Exception ex){}
		          }
			
		});
		btnChangePass.setBounds(206, 154, 155, 23);
		frame.getContentPane().add(btnChangePass);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(86, 95, 78, 14);
		frame.getContentPane().add(lblEmail);
		
		lblPassword = new JLabel("password");
		lblPassword.setBounds(82, 117, 82, 14);
		frame.getContentPane().add(lblPassword);
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
	      
	          new  Passchange();
	      }
	 }

