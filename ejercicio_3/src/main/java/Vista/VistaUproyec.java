package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaUproyec extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	

	/**
	 * Launch the application.
	 */
	public static void vistaUVid() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaUproyec frame = new VistaUproyec();
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
	public VistaUproyec() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpgradeTablaVideos = new JLabel("Modificación de la tabla Proyecto");
		lblUpgradeTablaVideos.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpgradeTablaVideos.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblUpgradeTablaVideos.setBounds(72, 22, 272, 19);
		contentPane.add(lblUpgradeTablaVideos);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(31, 63, 46, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(31, 88, 30, 22);
		contentPane.add(comboBox);
		
		JLabel lblnombre = new JLabel("Nombre:");
		lblnombre.setBounds(31, 132, 86, 14);
		contentPane.add(lblnombre);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(31, 156, 185, 20);
		contentPane.add(textField);
		
		JLabel lblhoras = new JLabel("Horas: ");
		lblhoras.setBounds(31, 198, 86, 14);
		contentPane.add(lblhoras);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(31, 223, 185, 20);
		contentPane.add(textField_1);
		
		
		JButton btnEnviarDatos_1 = new JButton("Actualizar");
		btnEnviarDatos_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnEnviarDatos_1.setBounds(95, 280, 89, 23);
		contentPane.add(btnEnviarDatos_1);
		
		JButton btnEnviarDatos_1_1 = new JButton("Eliminar");
		btnEnviarDatos_1_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnEnviarDatos_1_1.setBounds(255, 280, 89, 23);
		contentPane.add(btnEnviarDatos_1_1);
	}

}
