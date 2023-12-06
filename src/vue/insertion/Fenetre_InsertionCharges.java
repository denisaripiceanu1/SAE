package vue.insertion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Fenetre_InsertionCharges extends JInternalFrame {
	private JTextField textField_nomCharge;
	private JTextField textField_montantReel;
	private JTextField textField_montantPrevisionnel;
	private JTextField textField_deductible;

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
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JSeparator separator_titreAjouterCharge = new JSeparator();
		separator_titreAjouterCharge.setForeground(new Color(0, 102, 204));
		separator_titreAjouterCharge.setBounds(271, 72, 190, 2);
		panel.add(separator_titreAjouterCharge);
		
		JLabel lbl_InsererUneCharge = new JLabel("Ajouter une Charge");
		lbl_InsererUneCharge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUneCharge.setBounds(288, 26, 160, 48);
		panel.add(lbl_InsererUneCharge);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAjouter.setBounds(246, 447, 94, 31);
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setBackground(new Color(0, 102, 204));
		panel.add(btnAjouter);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAnnuler.setBounds(398, 447, 94, 31);
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(new Color(0, 102, 204));
		panel.add(btnAnnuler);
		
		textField_nomCharge = new JTextField();
		textField_nomCharge.setColumns(10);
		textField_nomCharge.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Nom", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_nomCharge.setBounds(271, 109, 190, 40);
		panel.add(textField_nomCharge);
		
		textField_montantReel = new JTextField();
		textField_montantReel.setColumns(10);
		textField_montantReel.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Montant r\u00E9el", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_montantReel.setBounds(271, 173, 190, 40);
		panel.add(textField_montantReel);
		
		textField_montantPrevisionnel = new JTextField();
		textField_montantPrevisionnel.setColumns(10);
		textField_montantPrevisionnel.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Montant pr\u00E9visionnel", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_montantPrevisionnel.setBounds(271, 241, 190, 40);
		panel.add(textField_montantPrevisionnel);
		
		textField_deductible = new JTextField();
		textField_deductible.setColumns(10);
		textField_deductible.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "D\u00E9ductible", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_deductible.setBounds(271, 311, 190, 40);
		panel.add(textField_deductible);

		}
	}


