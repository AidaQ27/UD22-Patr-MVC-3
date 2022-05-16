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
	private JTextField TxtField_Nombre;
	


	/**
	 * Launch the application.
	 */
	public static void vista() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaC_cientf frame = new VistaC_cientf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		
		JLabel lblApellido = new JLabel("Nombre: ");
		lblApellido.setBounds(26, 52, 86, 14);
		contentPane.add(lblApellido);
		
		TxtField_Nombre = new JTextField();
		TxtField_Nombre.setColumns(10);
		TxtField_Nombre.setBounds(23, 77, 185, 20);
		contentPane.add(TxtField_Nombre);
		
		
		JButton btnEnviarDatos = new JButton("Aceptar");
		btnEnviarDatos.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnEnviarDatos.setBounds(23, 143, 89, 23);
		contentPane.add(btnEnviarDatos);
	}
}
