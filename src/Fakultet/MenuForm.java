package Fakultet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class MenuForm {

	private JFrame MenuForm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuForm window = new MenuForm();
					window.MenuForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MenuForm = new JFrame();
		MenuForm.setTitle("Menu");
		MenuForm.getContentPane().setBackground(SystemColor.activeCaption);
		MenuForm.getContentPane().setForeground(Color.BLUE);
		MenuForm.setBounds(100, 100, 350, 350);
		MenuForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		MenuForm.getContentPane().setLayout(null);
		MenuForm.setVisible(true);
		MenuForm.setLocationRelativeTo(null);

		JButton button = new JButton("Profesor");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Profesor p=new Profesor();
				MenuForm.dispose();

			}
		});
		button.setBounds(169, 141, 89, 30);
		MenuForm.getContentPane().add(button);
		
		JButton button_1 = new JButton("Student");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student s=new Student();
				MenuForm.dispose();

			}
		});
		button_1.setBounds(70, 141, 89, 30);
		MenuForm.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Ocena");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ocena o=new Ocena();
				MenuForm.dispose();
			}
		});
		button_2.setBounds(70, 194, 188, 30);
		MenuForm.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Otsek");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Otsek ot=new Otsek();
				MenuForm.dispose();

			}
		});
		button_3.setBounds(169, 90, 89, 30);
		MenuForm.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("Predmet");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Predmet pr=new Predmet();
				MenuForm.dispose();

			}
		});
		button_4.setBounds(70, 90, 89, 30);
		MenuForm.getContentPane().add(button_4);
		
		JButton btnDropAll = new JButton("DROP ALL");
		btnDropAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try{
	                 theQuery("Drop TABLE predmet,otsek,student,profesor,ocena  ");
	             }
	             catch(Exception ex){}
	             
			}
		});
		btnDropAll.setBounds(208, 277, 116, 23);
		MenuForm.getContentPane().add(btnDropAll);
		
		JLabel lblCreateTheTables = new JLabel("CREATE THE TABLES BY ORDER");
		lblCreateTheTables.setBounds(70, 56, 188, 23);
		MenuForm.getContentPane().add(lblCreateTheTables);
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
