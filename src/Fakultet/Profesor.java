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

public class Profesor {

	private JFrame Profesor;
	private JTextField id;
	private JTextField ime;
	private JTextField prezime;
	private JTextField email;
	private JTextField id_predmet;
	private JTextField status_profesor;
	private JLabel lblId;
	private JLabel lblIme;
	private JLabel lblPrezime;
	private JLabel lblEmail;
	private JLabel lblIdpredmet;
	private JLabel lblStatus;
	private JButton button_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profesor window = new Profesor();
					window.Profesor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Profesor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Profesor = new JFrame();
		Profesor.getContentPane().setBackground(SystemColor.activeCaption);
		Profesor.setTitle("Profesor");
		Profesor.setBounds(100, 100, 721, 300);
		Profesor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Profesor.getContentPane().setLayout(null);
		
		JButton button = new JButton("Back");
		button.setToolTipText("Profesor");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuForm mf=new MenuForm();
				Profesor.dispose();

			}
		});
		button.setBounds(594, 227, 89, 23);
		Profesor.getContentPane().add(button);
		
		JButton button_1 = new JButton("INSERT");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
		              theQuery("insert into Profesor (id,ime,prezime,id_predmet,email,status_profesor) values('"+id.getText()+"','"+ime.getText()+"','"+prezime.getText()+"','"+id_predmet.getText()+"','"+email.getText()+"','"+status_profesor.getText()+"')");
	             }
	             catch(Exception ex){}
	             
			}
				
			
		});
		button_1.setBounds(594, 106, 89, 23);
		Profesor.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("CREATE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
	                 theQuery("CREATE TABLE PROFESOR ("
	                         + "	id serial PRIMARY KEY,"
	                         + "	ime varchar(255) ,\n"
	                         + "	prezime varchar(255), "
	                         + "	id_predmet varchar(255), "
	                         +"     email varchar(255),"
	                         +"     status_profesor varchar(255),"
	                         + " FOREIGN KEY (id_predmet) REFERENCES PREDMET(id_predmet)"
	                    + ");");
	             }
	             catch(Exception ex){}
			}
		});
		button_2.setBounds(10, 227, 89, 23);
		Profesor.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("DROP");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
	                 theQuery("Drop TABLE Profesor ");
	             }
	             catch(Exception ex){}
	             
			}
		});
		button_3.setBounds(109, 227, 89, 23);
		Profesor.getContentPane().add(button_3);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(10, 107, 86, 20);
		Profesor.getContentPane().add(id);
		
		ime = new JTextField();
		ime.setColumns(10);
		ime.setBounds(106, 107, 86, 20);
		Profesor.getContentPane().add(ime);
		
		prezime = new JTextField();
		prezime.setColumns(10);
		prezime.setBounds(202, 107, 86, 20);
		Profesor.getContentPane().add(prezime);
		
		id_predmet = new JTextField();
		id_predmet.setColumns(10);
		id_predmet.setBounds(302, 107, 86, 20);
		Profesor.getContentPane().add(id_predmet);
		
		status_profesor = new JTextField();
		status_profesor.setColumns(10);
		status_profesor.setBounds(401, 107, 86, 20);
		Profesor.getContentPane().add(status_profesor);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(498, 107, 86, 20);
		Profesor.getContentPane().add(email);
		
		lblId = new JLabel("id");
		lblId.setBounds(30, 71, 46, 14);
		Profesor.getContentPane().add(lblId);
		
		lblIme = new JLabel("ime");
		lblIme.setBounds(109, 71, 46, 14);
		Profesor.getContentPane().add(lblIme);
		
		lblPrezime = new JLabel("prezime");
		lblPrezime.setBounds(213, 71, 46, 14);
		Profesor.getContentPane().add(lblPrezime);
		
		lblEmail = new JLabel("email");
		lblEmail.setBounds(498, 71, 46, 14);
		Profesor.getContentPane().add(lblEmail);
		
		lblIdpredmet = new JLabel("id_predmet");
		lblIdpredmet.setBounds(318, 71, 70, 14);
		Profesor.getContentPane().add(lblIdpredmet);
		
		lblStatus = new JLabel("status");
		lblStatus.setBounds(401, 71, 75, 14);
		Profesor.getContentPane().add(lblStatus);
		
		button_4 = new JButton("DELETE");
		button_4.setBounds(594, 140, 89, 23);
		Profesor.getContentPane().add(button_4);
		Profesor.setVisible(true);
		Profesor.setLocationRelativeTo(null);

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
