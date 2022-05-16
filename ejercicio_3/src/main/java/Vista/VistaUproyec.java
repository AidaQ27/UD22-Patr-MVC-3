package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaUproyec extends JFrame {

	private JPanel contentPane;
	public JTextField textFieldNombre;
	public JTextField textFieldHoras;
	public JButton btnEnviarDatos;
	public JButton btnEliminar;
	public JButton btnBuscar;
	

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
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(31, 156, 185, 20);
		contentPane.add(textFieldNombre);
		
		JLabel lblhoras = new JLabel("Horas: ");
		lblhoras.setBounds(31, 198, 86, 14);
		contentPane.add(lblhoras);
		
		textFieldHoras = new JTextField();
		textFieldHoras.setColumns(10);
		textFieldHoras.setBounds(31, 223, 185, 20);
		contentPane.add(textFieldHoras);
		
		btnEnviarDatos = new JButton("Actualizar");
		btnEnviarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEnviarDatos.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnEnviarDatos.setBounds(24, 478, 89, 23);
		contentPane.add(btnEnviarDatos);
	
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnEliminar.setBounds(289, 479, 89, 23);
		contentPane.add(btnEliminar);
		
		btnBuscar = new JButton("🔍︎");

		btnBuscar.setBounds(72, 88, 46, 23);
		contentPane.add(btnBuscar);
		
		
		
	}

}
