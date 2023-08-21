package Fakultet;

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
import java.awt.SystemColor;

public class Ocena {

	private JFrame Ocena;
	private JTextField indeks;
	private JTextField id_predmet;
	private JTextField ocena;
	private JLabel id_ocena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ocena window = new Ocena();
					window.Ocena.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ocena() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Ocena = new JFrame();
		Ocena.getContentPane().setBackground(SystemColor.activeCaption);
		Ocena.setTitle("Ocena");
		Ocena.setResizable(false);
		Ocena.setBounds(100, 100, 450, 300);
		Ocena.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Ocena.getContentPane().setLayout(null);
		Ocena.setVisible(true);
		Ocena.setLocationRelativeTo(null);
		
		
		
		JLabel lblOcena = new JLabel("Ocena");
		lblOcena.setBounds(310, 46, 71, 14);
		Ocena.getContentPane().add(lblOcena);
		
		id_predmet = new JTextField();
		id_predmet.setBounds(174, 71, 86, 20);
		Ocena.getContentPane().add(id_predmet);
		id_predmet.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuForm mf=new MenuForm();
				Ocena.dispose();
							}
		});
		btnBack.setBounds(345, 237, 89, 23);
		Ocena.getContentPane().add(btnBack);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try{
		              
					theQuery("insert into Ocena (indeks,id_predmet,ocena) values('"+indeks.getText()+"','"+id_predmet.getText()+"','"+ocena.getText()+"')");
	             }
	             catch(Exception ex){}
	             
			}
				
			
		});
		btnInsert.setBounds(292, 102, 89, 23);
		Ocena.getContentPane().add(btnInsert);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
	                 theQuery("CREATE TABLE OCENA ("
	                		 + "	id_ocena serial  PRIMARY KEY,"
	                         + "	indeks int, "
	                         + "	id_predmet varchar(255) ,\n"
	                         + "	ocena int, "
	                         + " 	FOREIGN KEY (id_predmet) REFERENCES PREDMET(id_predmet),FOREIGN KEY (indeks) REFERENCES STUDENT(indeks)"

	                    + ");");
	             }
	             catch(Exception ex){}
			}
		});
		btnCreate.setBounds(21, 237, 89, 23);
		Ocena.getContentPane().add(btnCreate);
		
		JButton btnDrop = new JButton("DROP");
		btnDrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
	                 theQuery("Drop TABLE Ocena ");
	             }
	             catch(Exception ex){}
	             
			}
		});
		btnDrop.setBounds(120, 237, 89, 23);
		Ocena.getContentPane().add(btnDrop);
		
		indeks = new JTextField();
		indeks.setBounds(67, 71, 86, 20);
		Ocena.getContentPane().add(indeks);
		indeks.setColumns(10);
		
		ocena = new JTextField();
		ocena.setBounds(295, 71, 86, 20);
		Ocena.getContentPane().add(ocena);
		ocena.setColumns(10);
		
		JLabel lblIndeks = new JLabel("indeks student");
		lblIndeks.setBounds(67, 46, 86, 14);
		Ocena.getContentPane().add(lblIndeks);
		
		JLabel lblPredmet = new JLabel("predmet_id");
		lblPredmet.setBounds(185, 46, 75, 14);
		Ocena.getContentPane().add(lblPredmet);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(292, 135, 89, 23);
		Ocena.getContentPane().add(btnDelete);
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
