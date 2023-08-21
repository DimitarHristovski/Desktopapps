package RL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class LoginForm extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmLogin;
	private JTextField Username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(SystemColor.activeCaption);
		frmLogin.setTitle("Login");
		frmLogin.setAlwaysOnTop(false);
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		frmLogin.setVisible(true);
		frmLogin.setLocationRelativeTo(null);
		
		Username = new JTextField();
		Username.setBounds(229, 83, 160, 25);
		frmLogin.getContentPane().add(Username);
		Username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(101, 141, 80, 25);
		frmLogin.getContentPane().add(lblPassword);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setBounds(101, 83, 100, 25);
		frmLogin.getContentPane().add(lblUsername);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps;
		        ResultSet rs;
		        String uname = Username.getText();
		        String pass = String.valueOf(password.getPassword());
		        
		        String query = "SELECT * FROM Korisnik WHERE username =? AND password =?";
		        
		        try {
			           Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Test","dimi","postgres");

		            ps = con.prepareStatement(query);
		            
		            ps.setString(1, uname);
		            ps.setString(2, pass);
		            
		            rs = ps.executeQuery();
		            
		            if(rs.next())
		            {
	                    JOptionPane.showMessageDialog(null, "You're logged in", "Login ", 2);
		                   
		                   
		                    
		            }
		            else{
		                    JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "Login Failed", 2);
		                }
		            
		        } catch (SQLException ex) {
		            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
		        }
				
				
			}
		});
		btnLogin.setBounds(171, 207, 100, 25);
		frmLogin.getContentPane().add(btnLogin);
		
		password = new JPasswordField();
		password.setBounds(229, 143, 160, 25);
		frmLogin.getContentPane().add(password);
	}

	

	
	

	

}
/*String n=Name.getText();
String p=password.getText();


if(n.equals(Name.getText()) && p.equals(password.getText())) 
{
	
	try {
		Desktop.getDesktop().open(new File("C:/Users/private/Documents/Dimi"));
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}
else
{
	JOptionPane.showMessageDialog(frame,"invalid username or password or email");
	
}*/