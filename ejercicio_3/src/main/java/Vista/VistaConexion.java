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
import javax.swing.JPasswordField;

public class VistaConexion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaConexion frame = new VistaConexion();
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
	public VistaConexion() {
		setTitle("CRUD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEfectueSuConexin = new JLabel("Efectue su conexión");
		lblEfectueSuConexin.setHorizontalAlignment(SwingConstants.CENTER);
		lblEfectueSuConexin.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblEfectueSuConexin.setBounds(87, 35, 261, 22);
		contentPane.add(lblEfectueSuConexin);
		
		JLabel lblIp = new JLabel("IP:");
		lblIp.setBounds(23, 82, 86, 14);
		contentPane.add(lblIp);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(23, 107, 185, 20);
		contentPane.add(textField);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setBounds(23, 149, 86, 14);
		contentPane.add(lblUser);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(23, 174, 185, 20);
		contentPane.add(textField_1);
		
		JLabel lblID_cli = new JLabel("Password:");
		lblID_cli.setBounds(23, 224, 86, 14);
		contentPane.add(lblID_cli);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnConectar.setBounds(23, 314, 89, 23);
		contentPane.add(btnConectar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(23, 249, 185, 20);
		contentPane.add(passwordField);
	}
}
