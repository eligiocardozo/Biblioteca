package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import dao.LibroDao;
import dao.PersonaDao;
import dao.PrestamoDao;
import dao.UsuarioDao;
import modelo.DetallePrestamoModelo;
import modelo.LibroModelo;
import modelo.PersonaModelo;
import modelo.PrestamoModelo;
import modelo.UsuarioModelo;
import tablas.ModeloTablaPrestamoDetalle;
import vista.PrestamoVista;

public class PrestamoController {

	private PrestamoVista vista;
	private PrestamoDao dao;
	private PersonaDao personaDao;
	private LibroDao libroDao;
	private UsuarioDao usuarioDao;

	private ModeloTablaPrestamoDetalle tabla;
	private List<DetallePrestamoModelo> detalles;

	private PersonaModelo personaSeleccionada;
	private LibroModelo libroEncontrado;

	private SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	public PrestamoController(PrestamoVista prestamoVista) {
		super();
		this.vista = prestamoVista;
		dao = new PrestamoDao();
		personaDao = new PersonaDao();
		libroDao = new LibroDao();
		usuarioDao = new UsuarioDao();

		tabla = new ModeloTablaPrestamoDetalle();
		this.vista.getTabla().setModel(tabla);

		setAcciones();
		cargarUsuarios();
		estadoInicial();
	}

	private void setAcciones() {
		this.vista.getBtnBuscarPersona().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarPersona();
			}
		});

		this.vista.getBtnBuscarLibro().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarLibro();
			}
		});

		this.vista.getBtnAgregarLibro().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarLibro();
			}
		});

		this.vista.getBtnGuardar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});

		this.vista.getBtnCancelar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
	}

	private void cargarUsuarios() {
		try {
			this.vista.getCbUsuario().removeAllItems();
			List<UsuarioModelo> usuarios = usuarioDao.recuperarTodo();
			for (UsuarioModelo u : usuarios)
				this.vista.getCbUsuario().addItem(u);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"No se pudieron cargar los usuarios:\n" + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void estadoInicial() {
		this.vista.getTfCodigo().setText("");
		this.vista.getTfFecha().setText(formatoFechaHora.format(new Date()));

		this.vista.getTfCiPersona().setText("");
		this.vista.getTfNombrePersona().setText("");
		personaSeleccionada = null;

		limpiarCamposLibro();

		this.vista.getTfPlazo().setText("");

		detalles = new ArrayList<DetallePrestamoModelo>();
		tabla.setLista(detalles);
		this.vista.getLblCantidadLibros().setText("Libros: 0");
	}

	private void limpiarCamposLibro() {
		this.vista.getTfCodigoLibro().setText("");
		this.vista.getTfTituloLibro().setText("");
		this.vista.getTfAutorLibro().setText("");
		libroEncontrado = null;
	}

	private void buscarPersona() {
		String ci = this.vista.getTfCiPersona().getText().trim();
		if (ci.isEmpty())
			return;

		try {
			personaSeleccionada = personaDao.buscarPorCi(ci);
			if (personaSeleccionada == null) {
				JOptionPane.showMessageDialog(null, "No se encontró ninguna persona con esa CI.",
						"Atención", JOptionPane.WARNING_MESSAGE);
				this.vista.getTfNombrePersona().setText("");
			} else {
				this.vista.getTfNombrePersona()
						.setText(personaSeleccionada.getNombre_persona() + " " + personaSeleccionada.getApellido_persona());
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al buscar la persona:\n" + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void buscarLibro() {
		String texto = this.vista.getTfCodigoLibro().getText().trim();
		if (texto.isEmpty())
			return;

		Integer idLibro;
		try {
			idLibro = Integer.valueOf(texto);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "El código de libro debe ser un número.",
					"Atención", JOptionPane.WARNING_MESSAGE);
			return;
		}

		try {
			libroEncontrado = libroDao.recuperarPorId(idLibro);
			if (libroEncontrado == null) {
				JOptionPane.showMessageDialog(null, "No se encontró ningún libro con ese código.",
						"Atención", JOptionPane.WARNING_MESSAGE);
				this.vista.getTfTituloLibro().setText("");
				this.vista.getTfAutorLibro().setText("");
			} else {
				this.vista.getTfTituloLibro().setText(libroEncontrado.getTitulo_li());
				this.vista.getTfAutorLibro().setText(libroEncontrado.getAutor_li());
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al buscar el libro:\n" + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void agregarLibro() {
		if (libroEncontrado == null) {
			JOptionPane.showMessageDialog(null, "Primero buscá un libro válido.",
					"Atención", JOptionPane.WARNING_MESSAGE);
			return;
		}

		DetallePrestamoModelo detalle = new DetallePrestamoModelo();
		detalle.setLibro(libroEncontrado);
		detalles.add(detalle);

		tabla.setLista(detalles);
		this.vista.getLblCantidadLibros().setText("Libros: " + detalles.size());

		limpiarCamposLibro();
		this.vista.getTfCodigoLibro().requestFocus();
	}

	private void guardar() {
		if (personaSeleccionada == null) {
			JOptionPane.showMessageDialog(null, "Buscá y seleccioná una persona antes de guardar.",
					"Atención", JOptionPane.WARNING_MESSAGE);
			return;
		}

		UsuarioModelo usuarioSeleccionado = (UsuarioModelo) this.vista.getCbUsuario().getSelectedItem();
		if (usuarioSeleccionado == null) {
			JOptionPane.showMessageDialog(null, "No hay ningún usuario disponible para registrar el préstamo.",
					"Atención", JOptionPane.WARNING_MESSAGE);
			return;
		}

		if (detalles.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Agregá al menos un libro al préstamo.",
					"Atención", JOptionPane.WARNING_MESSAGE);
			return;
		}

		int plazo;
		try {
			plazo = Integer.parseInt(this.vista.getTfPlazo().getText().trim());
			if (plazo <= 0)
				throw new NumberFormatException();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "El plazo debe ser un número entero mayor a cero (en días).",
					"Atención", JOptionPane.WARNING_MESSAGE);
			return;
		}

		Date fecha = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_MONTH, plazo);
		Date fechaDevolucion = calendar.getTime();

		PrestamoModelo prestamo = new PrestamoModelo();
		prestamo.setPersona(personaSeleccionada);
		prestamo.setUsuario(usuarioSeleccionado);
		prestamo.setFecha(fecha);
		prestamo.setFechaDevolucion(fechaDevolucion);
		prestamo.setPlazo(plazo);
		prestamo.setEstado(true);

		for (DetallePrestamoModelo detalle : detalles)
			detalle.setPrestamo(prestamo);
		prestamo.setDetalles(detalles);

		try {
			dao.guardar(prestamo);
			JOptionPane.showMessageDialog(null, "Préstamo registrado correctamente.");
			estadoInicial();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se pudo guardar el préstamo:\n" + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cancelar() {
		estadoInicial();
	}

}