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

public class VistaC_proyec extends JFrame {

	private JPanel contentPane;
	private JTextField TxtField_Nombre;
	private JTextField TxtField_Horas;


	/**
	 * Launch the application.
	 */
	public static void vista() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaC_proyec frame = new VistaC_proyec();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creacion de la vista Creación Tabla.
	 */
	public VistaC_proyec() {
		setTitle("Insertar valores ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Introduce los valores de la tabla Proyecto");
		lblTitulo.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(78, 11, 272, 19);
		contentPane.add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(20, 45, 86, 14);
		contentPane.add(lblNombre);
		
		TxtField_Nombre = new JTextField();
		TxtField_Nombre.setBounds(20, 69, 185, 20);
		contentPane.add(TxtField_Nombre);
		TxtField_Nombre.setColumns(10);
		
		JLabel lblHoras = new JLabel("Horas: ");
		lblHoras.setBounds(20, 111, 86, 14);
		contentPane.add(lblHoras);
		
		TxtField_Horas = new JTextField();
		TxtField_Horas.setColumns(10);
		TxtField_Horas.setBounds(20, 136, 185, 20);
		contentPane.add(TxtField_Horas);
		
		
		JButton btnEnviarDatos = new JButton("Aceptar");
		btnEnviarDatos.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnEnviarDatos.setBounds(20, 182, 89, 23);
		contentPane.add(btnEnviarDatos);
	}
}
