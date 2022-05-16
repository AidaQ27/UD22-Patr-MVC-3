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
	private JTable tablaRegistros;
	private JButton actualizarBtn;
	private Controlador controlador;

	/**
	 * Launch the application.
	 */
	public void crearVista(Controlador controlador) {
		this.controlador = controlador;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal frame = new VistaPrincipal();
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
		
		JMenuItem nuevoClienteMenu = new JMenuItem("Cientificos");
		nuevoClienteMenu.setHorizontalAlignment(SwingConstants.LEFT);
		pestanaNuevo.add(nuevoClienteMenu);
		
		JMenuItem nuevoVideoMenu = new JMenuItem("Proyecto");
		pestanaNuevo.add(nuevoVideoMenu);
		
		JMenu pestanaBuscar = new JMenu("Buscar");
		menuBar.add(pestanaBuscar);
		
		JMenuItem buscarClienteMenu = new JMenuItem("Cientificos");
		buscarClienteMenu.setHorizontalAlignment(SwingConstants.LEFT);
		pestanaBuscar.add(buscarClienteMenu);
		
		JMenuItem buscarVideoMenu = new JMenuItem("Proyecto");
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
		
		JComboBox<String> desplegable = new JComboBox<String>();
		desplegable.setModel(new DefaultComboBoxModel<String>(new String[] {"Tabla Cientifico", "Tabla Proyecto", "Ambas Tablas"}));
		desplegable.setBounds(229, 92, 183, 31);
		contentPane.add(desplegable);
		
		tablaRegistros = new JTable();
		tablaRegistros.setRowSelectionAllowed(false);
		tablaRegistros.setVisible(false);
		contentPane.add(tablaRegistros);
		tablaRegistros.setBorder(new LineBorder(new Color(0, 0, 0)));
		tablaRegistros.setBounds(38, 177, 557, 224);
		tablaRegistros.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"1", "2", "3", "4", "5", "6"
			}
		));
		
		actualizarBtn = new JButton("Actualizar");
		actualizarBtn.setBounds(431, 92, 88, 31);
		contentPane.add(actualizarBtn);
	}

	/**
	 * @return the tablaRegistros
	 */
	public JTable getTablaRegistros() {
		return tablaRegistros;
	}

	/**
	 * @param tablaRegistros the tablaRegistros to set
	 */
	public void setTablaRegistros(JTable tablaRegistros) {
		this.tablaRegistros = tablaRegistros;
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
	
	
}
