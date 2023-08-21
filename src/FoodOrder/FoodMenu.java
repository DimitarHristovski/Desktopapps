package FoodOrder;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FoodMenu {

	private JFrame frmFoodmenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodMenu window = new FoodMenu();
					window.frmFoodmenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FoodMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFoodmenu = new JFrame();
		frmFoodmenu.setResizable(false);
		frmFoodmenu.setTitle("FoodMenu");
		frmFoodmenu.setBounds(100, 100, 601, 527);
		frmFoodmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFoodmenu.setVisible(true);
		frmFoodmenu.getContentPane().setLayout(null);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hamburger h=new Hamburger();
				frmFoodmenu.dispose();
			}
		});
		btnNext.setBounds(496, 472, 89, 23);
		frmFoodmenu.getContentPane().add(btnNext);

		JLabel menu = new JLabel("image");
		menu.setBounds(10, 11, 584, 484);
		frmFoodmenu.getContentPane().add(menu);
		menu.setIcon(new ImageIcon(this.getClass().getResource("/images/menu.png")));

	}
}
