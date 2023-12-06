package vue.insertion;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;

public class Fenetre_InsertionDiagnostic extends JFrame {
	private JTextField textField_Date_Validite;
	private JTextField textField_Id_Bien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Fenetre_InsertionDiagnostic frame = new Fenetre_InsertionDiagnostic();
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
	public Fenetre_InsertionDiagnostic() {
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JSeparator separator_titreInsererBien = new JSeparator();
		separator_titreInsererBien.setForeground(new Color(0, 102, 204));
		separator_titreInsererBien.setBounds(263, 71, 190, 2);
		panel.add(separator_titreInsererBien);
		
		JLabel lbl_InsererUnDiagnostic = new JLabel("Ajouter un Diagnostic");
		lbl_InsererUnDiagnostic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUnDiagnostic.setBounds(275, 25, 163, 48);
		panel.add(lbl_InsererUnDiagnostic);
		
		textField_Date_Validite = new JTextField();
		textField_Date_Validite.setColumns(10);
		textField_Date_Validite.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Date Validite", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_Date_Validite.setBounds(263, 197, 190, 40);
		panel.add(textField_Date_Validite);
		
		textField_Id_Bien = new JTextField();
		textField_Id_Bien.setColumns(10);
		textField_Id_Bien.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Id Bien", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_Id_Bien.setBounds(263, 247, 190, 40);
		panel.add(textField_Id_Bien);
		
		JComboBox comboBox_typeDeDiagnostic = new JComboBox();
		comboBox_typeDeDiagnostic.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Type", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		comboBox_typeDeDiagnostic.setBounds(264, 148, 189, 39);
		panel.add(comboBox_typeDeDiagnostic);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setBackground(new Color(0, 102, 204));
		btnAjouter.setBounds(244, 395, 94, 31);
		panel.add(btnAjouter);
		
		JButton btnAnnuler = new JButton("Annuler");		
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(new Color(0, 102, 204));
		btnAnnuler.setBounds(396, 395, 94, 31);
		panel.add(btnAnnuler);
		

	}
}
