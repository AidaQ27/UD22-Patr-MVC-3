package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaC_cientf extends JFrame {

	private JPanel contentPane;
	public JTextField TxtField_Nombre;
	public JTextField TxtField_DNI;
	public JButton btnEnviarDatos;

	/**
	 * Creacion de la vista Creacion Tabla.
	 */
	public VistaC_cientf() {
		setTitle("Insertar valores ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Introduce los valores de la tabla Cientifico");
		lblTitulo.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(78, 11, 272, 19);
		contentPane.add(lblTitulo);
		
		JLabel lbl_DNI = new JLabel("DNI:");
		lbl_DNI.setBounds(20, 45, 86, 14);
		contentPane.add(lbl_DNI);
		
		TxtField_DNI= new JTextField();
		TxtField_DNI.setBounds(20, 69, 185, 20);
		contentPane.add(TxtField_DNI);
		TxtField_DNI.setColumns(10);
		
		JLabel lblApellido = new JLabel("Nombre: ");
		lblApellido.setBounds(20, 98, 86, 14);
		contentPane.add(lblApellido);
		
		TxtField_Nombre = new JTextField();
		TxtField_Nombre.setColumns(10);
		TxtField_Nombre.setBounds(20, 123, 185, 20);
		contentPane.add(TxtField_Nombre);
		
		
		btnEnviarDatos = new JButton("Aceptar");
		btnEnviarDatos.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnEnviarDatos.setBounds(20, 166, 89, 23);
		contentPane.add(btnEnviarDatos);
	}
}
