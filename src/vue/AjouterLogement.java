package vue;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AjouterLogement extends JInternalFrame implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					AjouterLogement frame = new AjouterLogement();
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
	public AjouterLogement() {
		this.setBounds(100, 100, 450, 300);
		this.getContentPane().setLayout(null);

		this.textField = new JTextField();
		this.textField.setBounds(93, 49, 96, 19);
		this.getContentPane().add(this.textField);
		this.textField.setColumns(10);

		this.textField_1 = new JTextField();
		this.textField_1.setBounds(93, 87, 96, 19);
		this.getContentPane().add(this.textField_1);
		this.textField_1.setColumns(10);

		this.textField_2 = new JTextField();
		this.textField_2.setBounds(93, 127, 96, 19);
		this.getContentPane().add(this.textField_2);
		this.textField_2.setColumns(10);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(26, 52, 45, 13);
		this.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(26, 90, 45, 13);
		this.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(26, 130, 45, 13);
		this.getContentPane().add(lblNewLabel_2);

		JButton btn_ajouter = new JButton("Ajouter");
		btn_ajouter.addActionListener(this);
		btn_ajouter.setBounds(218, 227, 85, 21);
		this.getContentPane().add(btn_ajouter);

		JButton btn_annuler = new JButton("Annuler");
		btn_annuler.addActionListener(this);
		btn_annuler.setBounds(329, 227, 85, 21);
		this.getContentPane().add(btn_annuler);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		switch (btn.getText()) {
		case "Ajouter":
			break;
		case "Annuler":
			this.dispose();
			break;
		}
	}

	/*
	 * public void openInternalFrame() { JInternalFrame internalFrame = new
	 * JInternalFrame("Ma JInternalFrame", true, true, true, true);
	 * internalFrame.setSize(300, 200);
	 * 
	 * // Position spécifique sur le bureau int x = 280; int y = 60;
	 * internalFrame.setLocation(x, y);
	 * 
	 * JTextArea textArea = new JTextArea("Contenu de la JInternalFrame");
	 * internalFrame.add(textArea);
	 * 
	 * internalFrame.setVisible(true); this.add(internalFrame); }
	 */

}
