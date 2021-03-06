package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador;

import javax.swing.border.LineBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;

public class VistaPrincipal extends JFrame {

	private JPanel contentPane;
	public JButton actualizarBtn;
	public JMenuItem nuevoClienteMenu;
	public JMenuItem nuevoVideoMenu;
	public JMenuItem buscarClienteMenu;
	public JMenuItem buscarVideoMenu;
	
	private Controlador controlador;
	private JTextArea textArea;
	public JComboBox<String> desplegable;


	/**
	 * Create the frame.
	 */
	public VistaPrincipal() {
		
		setTitle("Muestra Datos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu pestanaNuevo = new JMenu("Nuevo Registro");
		pestanaNuevo.setIcon(null);
		pestanaNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(pestanaNuevo);
		
		nuevoClienteMenu = new JMenuItem("Cientificos");
		nuevoClienteMenu.setHorizontalAlignment(SwingConstants.LEFT);
		pestanaNuevo.add(nuevoClienteMenu);
		
		nuevoVideoMenu = new JMenuItem("Proyecto");
		pestanaNuevo.add(nuevoVideoMenu);
		
		JMenu pestanaBuscar = new JMenu("Buscar");
		menuBar.add(pestanaBuscar);
		
		buscarClienteMenu = new JMenuItem("Cientificos");
		buscarClienteMenu.setHorizontalAlignment(SwingConstants.LEFT);
		pestanaBuscar.add(buscarClienteMenu);
		
		buscarVideoMenu = new JMenuItem("Proyecto");
		pestanaBuscar.add(buscarVideoMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel tituloLable = new JLabel("Selecciona la tabla que quiere mostrar");
		tituloLable.setFont(new Font("SansSerif", Font.PLAIN, 15));
		tituloLable.setHorizontalAlignment(SwingConstants.CENTER);
		tituloLable.setBounds(172, 24, 261, 22);
		contentPane.add(tituloLable);
		
		desplegable = new JComboBox<String>();
		desplegable.setModel(new DefaultComboBoxModel<String>(new String[] {"Tabla Cientifico", "Tabla Proyecto"}));
		desplegable.setBounds(223, 73, 183, 31);
		contentPane.add(desplegable);
		
		actualizarBtn = new JButton("Actualizar");
		actualizarBtn.setBounds(435, 73, 88, 31);
		contentPane.add(actualizarBtn);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(113, 151, 404, 350);
		contentPane.add(textArea);
	}


	/**
	 * @return the actualizarBtn
	 */
	public JButton getActualizarBtn() {
		return actualizarBtn;
	}

	/**
	 * @param actualizarBtn the actualizarBtn to set
	 */
	public void setActualizarBtn(JButton actualizarBtn) {
		this.actualizarBtn = actualizarBtn;
	}
	
	/**
	 * @return the textArea
	 */
	public JTextArea getTextArea() {
		return textArea;
	}

	/**
	 * @param textArea the textArea to set
	 */
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	
	
	
}
