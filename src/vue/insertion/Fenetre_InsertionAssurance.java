package vue.insertion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class Fenetre_InsertionAssurance extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Fenetre_InsertionAssurance frame = new Fenetre_InsertionAssurance();
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
	public Fenetre_InsertionAssurance() {
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);

	}

}
