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

public class Predmet {

	private JFrame Predmet;
	private JTextField id_predmet;
	private JTextField ime_predmet;
	private JTextField krediti;
	private JTextField status;
	private JTextField semestar;
	private JLabel lblIdpredmet;
	private JLabel lblImepredmet;
	private JLabel lblSemestar;
	private JLabel lblKrediti;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Predmet window = new Predmet();
					window.Predmet.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Predmet() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Predmet = new JFrame();
		Predmet.getContentPane().setBackground(SystemColor.activeCaption);
		Predmet.setTitle("Predmet");
		Predmet.setBounds(100, 100, 801, 300);
		Predmet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Predmet.getContentPane().setLayout(null);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuForm mf=new MenuForm();
				Predmet.dispose();

			}
		});
		button.setBounds(656, 227, 89, 23);
		Predmet.getContentPane().add(button);
		
		JButton button_1 = new JButton("INSERT");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
		              theQuery("insert into Predmet (id_predmet,ime_predmet,krediti,status,semestar) values('"+id_predmet.getText()+"','"+ime_predmet.getText()+"','"+krediti.getText()+"','"+status.getText()+"','"+semestar.getText()+"')");
	             }
	             catch(Exception ex){}
	             
			}
				
			
		});
		button_1.setBounds(596, 112, 89, 23);
		Predmet.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("CREATE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
	                 theQuery("CREATE TABLE PREDMET ("
	                         + "	id_predmet varchar(255) PRIMARY KEY,"
	                         + "	ime_predmet varchar(255) ,\n"
	                         + "	krediti int, "
	                         + "	status varchar(25), "
	                         +"     semestar int"
	                       //  +"      FOREIGN KEY(id_predmet) REFERENCES Profesor(id_predmet)"
	                    + ");");
	             }
	             catch(Exception ex){}
			}
		});
		button_2.setBounds(10, 227, 89, 23);
		Predmet.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("DROP");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
	                 theQuery("Drop TABLE Predmet  ");
	             }
	             catch(Exception ex){}
	             
			}
		});
		button_3.setBounds(109, 227, 89, 23);
		Predmet.getContentPane().add(button_3);
		
		id_predmet = new JTextField();
		id_predmet.setColumns(10);
		id_predmet.setBounds(51, 113, 86, 20);
		Predmet.getContentPane().add(id_predmet);
		
		ime_predmet = new JTextField();
		ime_predmet.setColumns(10);
		ime_predmet.setBounds(153, 113, 86, 20);
		Predmet.getContentPane().add(ime_predmet);
		
		krediti = new JTextField();
		krediti.setColumns(10);
		krediti.setBounds(379, 113, 86, 20);
		Predmet.getContentPane().add(krediti);
		
		semestar = new JTextField();
		semestar.setColumns(10);
		semestar.setBounds(269, 113, 86, 20);
		Predmet.getContentPane().add(semestar);
		
		status = new JTextField();
		status.setColumns(10);
		status.setBounds(488, 113, 86, 20);
		Predmet.getContentPane().add(status);
		
		lblIdpredmet = new JLabel("id_predmet");
		lblIdpredmet.setBounds(51, 88, 86, 14);
		Predmet.getContentPane().add(lblIdpredmet);
		
		lblImepredmet = new JLabel("ime_predmet");
		lblImepredmet.setBounds(153, 88, 86, 14);
		Predmet.getContentPane().add(lblImepredmet);
		
		lblSemestar = new JLabel("semestar");
		lblSemestar.setBounds(269, 88, 86, 14);
		Predmet.getContentPane().add(lblSemestar);
		
		lblKrediti = new JLabel("krediti");
		lblKrediti.setBounds(379, 88, 86, 14);
		Predmet.getContentPane().add(lblKrediti);
		
		lblStatus = new JLabel("status");
		lblStatus.setBounds(488, 88, 46, 14);
		Predmet.getContentPane().add(lblStatus);
		Predmet.setVisible(true);
		Predmet.setLocationRelativeTo(null);

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
