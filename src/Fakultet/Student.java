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

public class Student {

	private JFrame Student;
	private JTextField indeks;
	private JTextField ime;
	private JTextField prezime;
	private JTextField id_otsek;
	private JTextField age;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student window = new Student();
					window.Student.setVisible(true);
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
		Student = new JFrame();
		Student.getContentPane().setBackground(SystemColor.activeCaption);
		Student.setTitle("Student");
		Student.setBounds(100, 100, 651, 300);
		Student.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Student.getContentPane().setLayout(null);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuForm mf=new MenuForm();
				Student.dispose();

			}
		});
		button.setBounds(335, 227, 89, 23);
		Student.getContentPane().add(button);
		
		JButton button_1 = new JButton("INSERT");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
		              theQuery("insert into Student (indeks,ime,prezime,id_otsek,age) values('"+indeks.getText()+"','"+ime.getText()+"','"+prezime.getText()+"','"+id_otsek.getText()+"','"+age.getText()+"')");
	             }
	             catch(Exception ex){}
	             
			}
				
			
		});
		button_1.setBounds(514, 95, 89, 23);
		Student.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("CREATE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
	                 theQuery("CREATE TABLE STUDENT ("
	                         + "	indeks int PRIMARY KEY,"
	                         + "	ime varchar(255) ,\n"
	                         + "	prezime varchar(255), "
	                         + "	id_otsek int, "
	                         +"     age varchar(255),"
	                        + " FOREIGN KEY (id_otsek) REFERENCES OTSEK(id_otsek)"
	                    + ");");
	             }
	             catch(Exception ex){}
			}
		});
		button_2.setBounds(10, 227, 89, 23);
		Student.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("DROP");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
	                 theQuery("Drop TABLE Student ");
	             }
	             catch(Exception ex){}
	             
			}
		});
		button_3.setBounds(109, 227, 89, 23);
		Student.getContentPane().add(button_3);
		
		id_otsek = new JTextField();
		id_otsek.setColumns(10);
		id_otsek.setBounds(407, 96, 86, 20);
		Student.getContentPane().add(id_otsek);
		
		ime = new JTextField();
		ime.setColumns(10);
		ime.setBounds(109, 96, 86, 20);
		Student.getContentPane().add(ime);
		
		prezime = new JTextField();
		prezime.setColumns(10);
		prezime.setBounds(211, 96, 86, 20);
		Student.getContentPane().add(prezime);
		
		indeks = new JTextField();
		indeks.setColumns(10);
		indeks.setBounds(10, 96, 86, 20);
		Student.getContentPane().add(indeks);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(311, 96, 86, 20);
		Student.getContentPane().add(age);
		
		JLabel lblIndeks = new JLabel("indeks");
		lblIndeks.setBounds(27, 70, 69, 14);
		Student.getContentPane().add(lblIndeks);
		
		JLabel lblIme = new JLabel("ime");
		lblIme.setBounds(122, 71, 46, 14);
		Student.getContentPane().add(lblIme);
		
		JLabel lblPrezime = new JLabel("prezime");
		lblPrezime.setBounds(229, 70, 46, 14);
		Student.getContentPane().add(lblPrezime);
		
		JLabel lblVozrst = new JLabel("vozrast");
		lblVozrst.setBounds(323, 70, 46, 14);
		Student.getContentPane().add(lblVozrst);
		
		JLabel lblIdotsek = new JLabel("id_otsek");
		lblIdotsek.setBounds(421, 70, 46, 14);
		Student.getContentPane().add(lblIdotsek);
		
		JButton button_4 = new JButton("DELETE");
		button_4.setBounds(514, 129, 89, 23);
		Student.getContentPane().add(button_4);
		Student.setVisible(true);
		Student.setLocationRelativeTo(null);

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
