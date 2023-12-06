package vue.insertion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class Fenetre_InsertionCharges extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Fenetre_InsertionCharges frame = new Fenetre_InsertionCharges();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Fenetre_InsertionCharges() {
			this.setBounds(100, 100, 762, 541);
			this.getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 755, 511);
			this.getContentPane().add(panel);

		}

	}


