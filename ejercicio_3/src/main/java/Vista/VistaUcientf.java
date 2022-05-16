package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class VistaUcientf extends JFrame {

	private JPanel contentPane;
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void vistaU() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaUcientf frame = new VistaUcientf();
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
	public VistaUcientf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpgradeDeValores = new JLabel("Modificación de la tabla Cientificos");
		lblUpgradeDeValores.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpgradeDeValores.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblUpgradeDeValores.setBounds(78, 11, 272, 19);
		contentPane.add(lblUpgradeDeValores);
		
		JLabel lblNewLabel = new JLabel("DNI");
		lblNewLabel.setBounds(31, 52, 46, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(31, 77, 30, 22);
		contentPane.add(comboBox);
		
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(27, 120, 86, 14);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(27, 145, 185, 20);
		contentPane.add(textField);
		
	
		JButton btnEnviarDatos = new JButton("Actualizar");
		btnEnviarDatos.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnEnviarDatos.setBounds(55, 194, 89, 23);
		contentPane.add(btnEnviarDatos);
		
		
		
		JButton btnEnviarDatos_1 = new JButton("Eliminar");
		btnEnviarDatos_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnEnviarDatos_1.setBounds(248, 194, 89, 23);
		contentPane.add(btnEnviarDatos_1);
	}
}
