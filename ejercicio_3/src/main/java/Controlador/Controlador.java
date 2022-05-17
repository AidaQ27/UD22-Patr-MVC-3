package Controlador;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputFilter.Config;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modelo.Cientifico;

import Modelo.Conexion;
import Modelo.ConexionMySQL;
import Modelo.ConfigConexion;
import Modelo.Proyecto;

import Modelo.ModeloCientifico;
import Modelo.ModeloProyecto;

import Vista.VistaC_cientf;
import Vista.VistaC_proyec;
import Vista.VistaConexion;
import Vista.VistaPrincipal;

import Vista.VistaUcientf;
import Vista.VistaUproyec;

public class Controlador {

	// Attributes
	private VistaConexion vistaConexion;
	private VistaPrincipal vistaPrincipal;
	private VistaC_cientf vistaC_cientf;
	private VistaC_proyec vistaC_proyect;
	private VistaUcientf vistaUcient;
	private VistaUproyec vistaUProyect;
	private ConexionMySQL conexionMySQL;
	private ModeloProyecto modeloProyecto;
	private ModeloCientifico modeloCientif;
	private ConfigConexion configConexion;

	// Constructors
	public Controlador() {
	}

	/**
	 * @return the vistaPrincipal
	 */
	public VistaPrincipal getVistaPrincipal() {
		return vistaPrincipal;
	}

	/**
	 * @param vistaPrincipal the vistaPrincipal to set
	 */
	public void setVistaPrincipal(VistaPrincipal vistaPrincipal) {
		this.vistaPrincipal = vistaPrincipal;
	}

	/**
	 * @return the conexionMySQL
	 */
	public ConexionMySQL getConexionMySQL() {
		return conexionMySQL;
	}

	/**
	 * @param conexionMySQL the conexionMySQL to set
	 */
	public void setConexionMySQL(ConexionMySQL conexionMySQL) {
		this.conexionMySQL = conexionMySQL;
	}

	/**
	 * @return the modeloClientes
	 */
	public ModeloCientifico getModeloCientifico() {
		return modeloCientif;
	}

	/**
	 * @param modeloClientes the modeloClientes to set
	 */
	public void setModeloCientifico(ModeloCientifico modeloCientifico) {
		this.modeloCientif = modeloCientifico;
	}

	/**
	 * Inicializar la vista principal
	 */
	public void init() {

		// Inicializar vista Conexion mysql
		vistaConexion = new VistaConexion();
		vistaConexion.setVisible(true);

		listenerConectarBtn();

	}

	/**
	 * Accion boton "Actualizar"
	 */
	public void listenerActualziarBtn() {
		vistaPrincipal.actualizarBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int selItem = vistaPrincipal.desplegable.getSelectedIndex();

				switch (selItem) {
				case 0:
					modeloCientif = new ModeloCientifico(conexionMySQL);
					ArrayList<Cientifico> cientificos = modeloCientif.mostrarTodos();

					vistaPrincipal.getTextArea().setText("");
					for (int i = 0; i < cientificos.size(); i++) {
						Cientifico cientifico = cientificos.get(i);
						String stringCientifico = cientifico.getDNI() + ". " + cientifico.getNombre() + "\n";
								
						vistaPrincipal.getTextArea().append(stringCientifico);

					}
					break;
				case 1:
					modeloProyecto = new ModeloProyecto(conexionMySQL);
					ArrayList<Proyecto> proyectos = modeloProyecto.mostrarTodos();

					vistaPrincipal.getTextArea().setText("");
					for (int i = 0; i < proyectos.size(); i++) {
						Proyecto proyecto = proyectos.get(i);
						vistaPrincipal.getTextArea().append(proyecto.getID() + ". " + proyecto.getNombre() + ", "
								+ proyecto.getHoras() + "\n");

					}
					break;

				default:

					break;
				}

			}
		});
	}

	/**
	 * Listener boton "Conectar"
	 */
	public void listenerConectarBtn() {
		vistaConexion.btnConectar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Conectar");
				configConexion = new ConfigConexion();
				configConexion.setDireccion(vistaConexion.textFieldIP.getText());
				configConexion.setUser(vistaConexion.textFieldUser.getText());
				configConexion.setPass(vistaConexion.passwordField.getText());

				System.out.println(vistaConexion.textFieldIP.getText());
				System.out.println(vistaConexion.textFieldUser.getText());
				System.out.println(vistaConexion.passwordField.getText());

				conexionMySQL = new ConexionMySQL();
				conexionMySQL.conectar(configConexion);

				if (conexionMySQL.conexionEstablecida) {
					JOptionPane dialog = new JOptionPane();
					dialog.showMessageDialog(null, "Conectado a la base de datos con exito");
					vistaConexion.dispose();
					// Abrir vistaPrincipal
					abrirVistaPrincipal();

					// Crear base de datos si no existe
					conexionMySQL.dropDB("Laboratorio");
					conexionMySQL.createDB("Laboratorio");
					
					Conexion conexion = new Conexion(conexionMySQL);
					
					conexion.crearTablaCientifico();
					conexion.crearTablaProyecto();
					conexion.crearTablaAsignado();
					conexion.insertarRegistrosCientificos();
					conexion.insertarRegistrosProyecto();
					
					// Instanciar Modelos
					modeloCientif = new ModeloCientifico(conexionMySQL);
					modeloProyecto = new ModeloProyecto(conexionMySQL);

				} else {
					JOptionPane dialog = new JOptionPane();
					dialog.showMessageDialog(null, "Conexión fallida");

				}

			}
		});
	}

	public void abrirVistaPrincipal() {
		// Inicializar la vista principal
		vistaPrincipal = new VistaPrincipal();
		vistaPrincipal.setVisible(true);
		listenerActualziarBtn();
		listenerNuevoClienteMenu();
		listenerNuevoVideoMenu();
		listenerBuscarClienteMenu();
		listenerBuscarVideoMenu();
	}

	private void listenerNuevoClienteMenu() {
		vistaPrincipal.nuevoClienteMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vistaC_cientf = new VistaC_cientf();
				vistaC_cientf.setVisible(true);
				vistaC_cientf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				vistaC_cientf.btnEnviarDatos.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							
							Cientifico cientifico = new Cientifico();
							cientifico.setDNI(vistaC_cientf.TxtField_DNI.getText());
							cientifico.setNombre(vistaC_cientf.TxtField_Nombre.getText());
							
							modeloCientif.insertar(cientifico);
							JOptionPane dialog = new JOptionPane();
							dialog.showMessageDialog(null, "Registro cliente insertado correctamente!");
							
						} catch(Exception e2) {
							JOptionPane dialog = new JOptionPane();
							dialog.showMessageDialog(null, "Error al insertar registro cliente");
						}
						
						
					}
				});
			}
		});
		
	}
	
	private void listenerNuevoVideoMenu() {
		vistaPrincipal.nuevoVideoMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				vistaC_proyect = new VistaC_proyec();
				vistaC_proyect.setVisible(true);
				vistaC_proyect.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				vistaC_proyect.btnEnviarDatos.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						try {
						Proyecto proyecto = new Proyecto();
						proyecto.setNombre(vistaC_proyect.TxtField_Nombre.getText());
						proyecto.setHoras(vistaC_proyect.TxtField_Horas.getText());
						
						modeloProyecto.insertar(proyecto);
						JOptionPane dialog = new JOptionPane();
						dialog.showMessageDialog(null, "Registro video insertado correctamente!");
						} catch(Exception e2) {
							JOptionPane dialog = new JOptionPane();
							dialog.showMessageDialog(null, "Error al insertar registro video");
						}
						
					}
				});
			}
		});
		
	}

	// Buscar 
	private void listenerBuscarClienteMenu() {
		vistaPrincipal.buscarClienteMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					vistaUcient = new VistaUcientf();
					vistaUcient.setVisible(true);
					vistaUcient.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
					vistaUcient.btnBuscar.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								Cientifico cientifico = modeloCientif.mostrarPorDNI(vistaUcient.textField_dni.getText());
								
								//vistaUcient.textField_dni.setText(cientifico.getDNI());
								vistaUcient.textField_nombre.setText(cientifico.getNombre());

							} catch (Exception e2) {
								JOptionPane dialog = new JOptionPane();
								dialog.showMessageDialog(null, "No se ha encontrado el registro.");
							}

						}
					});
					
					// Actualizar Cliente
					vistaUcient.btnEnviarDatos.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {

							try {
								Cientifico cientifico = new Cientifico();
								
								cientifico.setNombre(vistaUcient.textField_nombre.getText());
								cientifico.setDNI(vistaUcient.textField_dni.getText());
								

								modeloCientif.update(cientifico);
								JOptionPane dialog = new JOptionPane();
								dialog.showMessageDialog(null, "Registro actualizado con éxito!");
							} catch (Exception e2) {
								JOptionPane dialog = new JOptionPane();
								dialog.showMessageDialog(null, "No se ha podido actualizar el registro.");
							}

						}
					});
					vistaUcient.btnEliminar.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								modeloCientif.delete(vistaUcient.textField_dni.getText());
								JOptionPane dialog = new JOptionPane();
								dialog.showMessageDialog(null, "Se ha eliminado el registro!");
							} catch (Exception e2) {
								JOptionPane dialog = new JOptionPane();
								dialog.showMessageDialog(null, "No se ha podido eliminar el registro.");
							}

						}
					});
				}
			});

		}

		/**
		 * Menu boton buscar video
		 */
		private void listenerBuscarVideoMenu() {

			vistaPrincipal.buscarVideoMenu.addActionListener(new ActionListener() {

				// Accion click boton menu -> buscar -> video
				@Override
				public void actionPerformed(ActionEvent e) {
					vistaUProyect = new VistaUproyec();
					vistaUProyect.setVisible(true);
					vistaUProyect.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					// Buscar Video
					vistaUProyect.btnBuscar.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {

							try {
								Proyecto proyecto = modeloProyecto.mostrarPorId(Long.parseLong(vistaUProyect.textFieldID.getText()));

								vistaUProyect.textFieldNombre.setText(proyecto.getNombre());
								vistaUProyect.textFieldHoras.setText(proyecto.getHoras());
								
							} catch (Exception e2) {
								JOptionPane dialog = new JOptionPane();
								dialog.showMessageDialog(null, "No se ha encontrado el registro del video.");
							}

						}
					});

					// Actualizar Video
					vistaUProyect.btnEnviarDatos.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								Proyecto proyecto = new Proyecto();
								proyecto.setID(Long.parseLong(vistaUProyect.textFieldID.getText()));
								proyecto.setNombre(vistaUProyect.textFieldNombre.getText());
								proyecto.setHoras(vistaUProyect.textFieldHoras.getText());
							

								modeloProyecto.update(proyecto);

								JOptionPane dialog = new JOptionPane();
								dialog.showMessageDialog(null, "Se ha actualizado el registro!");
							} catch (Exception e2) {
								JOptionPane dialog = new JOptionPane();
								dialog.showMessageDialog(null, "No se ha podido actualizar el registro.");
							}

						}
					});
					// Delete Video
					vistaUProyect.btnEliminar.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							
							try {
								modeloProyecto.delete(Long.parseLong(vistaUProyect.textFieldID.getText()));
								JOptionPane dialog = new JOptionPane();
								dialog.showMessageDialog(null, "Se ha eliminado el registro.");
							} catch (Exception e2) {
								JOptionPane dialog = new JOptionPane();
								dialog.showMessageDialog(null, "No se ha podido eliminar el registro.");
							}

						}
					});
				}
			});

		}

	}

				
		
		
	
	