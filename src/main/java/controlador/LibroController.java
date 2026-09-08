package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;

import dao.CategoriaDao;
import dao.LibroDao;
import interfaces.InterfaceABM;
import modelo.CategoriaModelo;
import modelo.LibroModelo;
import tablas.ModeloTablaLibro;
import vista.LibroVista;

public class LibroController implements InterfaceABM {

	private LibroVista vista;
	private LibroModelo libro;
	private LibroDao dao;
	private CategoriaDao categoriaDao;
	private List<LibroModelo> libros;
	private ModeloTablaLibro tabla;
	private SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

	public LibroController(LibroVista libroVista) {
		super();
		this.vista = libroVista;
		this.vista.setInterfaceABM(this);
		dao = new LibroDao();
		categoriaDao = new CategoriaDao();
		tabla = new ModeloTablaLibro();
		this.vista.getTabla().setModel(tabla);
		setAcciones();
		cargarCategorias();
		cargarTabla("");
		estadoInicial();
	}

	private void setAcciones() {
		this.vista.getTabla().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2)
					seleccionarRegistro();
			}
		});
	}

	private void cargarCategorias() {
		try {
			this.vista.getCbCategoria().removeAllItems();
			List<CategoriaModelo> categorias = categoriaDao.recuperarTodo();
			for (CategoriaModelo c : categorias)
				this.vista.getCbCategoria().addItem(c);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"No se pudieron cargar las categorías:\n" + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cargarTabla(String filtro) {
		try {
			if (filtro == null || filtro.isEmpty())
				libros = dao.recuperarTodo();
			else
				libros = dao.buscarPorFiltro(filtro);
			tabla.setLista(libros);
			tabla.fireTableDataChanged();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"No se pudo cargar la lista de libros:\n" + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void estadoInicial() {
		this.vista.getBtnNuevo().setEnabled(true);
		this.vista.getBtnEditar().setEnabled(false);
		this.vista.getBtnEliminar().setEnabled(false);
		this.vista.getBtnCancelar().setEnabled(true);
		this.vista.getBtnGuardar().setEnabled(false);

		this.vista.getTfTitulo().setEnabled(false);
		this.vista.getTfAutor().setEnabled(false);
		this.vista.getTfAnhoPublicacion().setEnabled(false);
		this.vista.getTfEditorial().setEnabled(false);
		this.vista.getTfIsbn().setEnabled(false);
		this.vista.getCbCategoria().setEnabled(false);

		this.vista.getTfTitulo().setText("");
		this.vista.getTfAutor().setText("");
		this.vista.getTfAnhoPublicacion().setText("");
		this.vista.getTfEditorial().setText("");
		this.vista.getTfIsbn().setText("");
		if (this.vista.getCbCategoria().getItemCount() > 0)
			this.vista.getCbCategoria().setSelectedIndex(0);

		libro = null;
	}

	private void seleccionarRegistro() {
		int fila = this.vista.getTabla().getSelectedRow();
		if (fila < 0 || libros == null || fila >= libros.size())
			return;
		libro = libros.get(fila);

		this.vista.getTfTitulo().setText(libro.getTitulo_li());
		this.vista.getTfAutor().setText(libro.getAutor_li());
		this.vista.getTfEditorial().setText(libro.getEditorial());
		this.vista.getTfIsbn().setText(libro.getIsbn());
		this.vista.getTfAnhoPublicacion()
				.setText(libro.getAnho_publicacion() != null ? formatoFecha.format(libro.getAnho_publicacion()) : "");
		this.vista.getCbCategoria().setSelectedItem(libro.getCategoria());

		this.vista.getBtnNuevo().setEnabled(false);
		this.vista.getBtnEditar().setEnabled(true);
		this.vista.getBtnEliminar().setEnabled(true);
	}

	@Override
	public void nuevo() {
		this.vista.getBtnNuevo().setEnabled(false);
		this.vista.getBtnEditar().setEnabled(false);
		this.vista.getBtnEliminar().setEnabled(false);
		this.vista.getBtnCancelar().setEnabled(true);
		this.vista.getBtnGuardar().setEnabled(true);

		this.vista.getTfTitulo().setEnabled(true);
		this.vista.getTfAutor().setEnabled(true);
		this.vista.getTfAnhoPublicacion().setEnabled(true);
		this.vista.getTfEditorial().setEnabled(true);
		this.vista.getTfIsbn().setEnabled(true);
		this.vista.getCbCategoria().setEnabled(true);

		libro = new LibroModelo();
	}

	@Override
	public void editar() {
		if (libro == null)
			return;

		this.vista.getBtnNuevo().setEnabled(false);
		this.vista.getBtnEditar().setEnabled(false);
		this.vista.getBtnEliminar().setEnabled(false);
		this.vista.getBtnCancelar().setEnabled(true);
		this.vista.getBtnGuardar().setEnabled(true);

		this.vista.getTfTitulo().setEnabled(true);
		this.vista.getTfAutor().setEnabled(true);
		this.vista.getTfAnhoPublicacion().setEnabled(true);
		this.vista.getTfEditorial().setEnabled(true);
		this.vista.getTfIsbn().setEnabled(true);
		this.vista.getCbCategoria().setEnabled(true);
	}

	@Override
	public void guardar() {
		if (this.vista.getTfTitulo().getText().isEmpty()
				|| this.vista.getTfAutor().getText().isEmpty()
				|| this.vista.getTfIsbn().getText().isEmpty()
				|| this.vista.getCbCategoria().getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null,
					"Título, autor, ISBN y categoría son obligatorios.",
					"Atención", JOptionPane.WARNING_MESSAGE);
			return;
		}

		try {
			libro.setAnho_publicacion(formatoFecha.parse(this.vista.getTfAnhoPublicacion().getText()));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null,
					"La fecha de publicación debe tener el formato dd/MM/yyyy.",
					"Atención", JOptionPane.WARNING_MESSAGE);
			return;
		}

		libro.setTitulo_li(this.vista.getTfTitulo().getText());
		libro.setAutor_li(this.vista.getTfAutor().getText());
		libro.setEditorial(this.vista.getTfEditorial().getText());
		libro.setIsbn(this.vista.getTfIsbn().getText());
		libro.setCategoria((CategoriaModelo) this.vista.getCbCategoria().getSelectedItem());

		try {
			dao.guardar(libro);
			cargarTabla("");
			estadoInicial();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"No se pudo guardar el libro:\n" + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void eliminar() {
		if (libro == null)
			return;
		int confirmacion = JOptionPane.showConfirmDialog(null,
				"¿Estás seguro que deseas eliminar el libro " + libro.getTitulo_li() + "?",
				"Atención", JOptionPane.YES_NO_OPTION);
		if (confirmacion == JOptionPane.YES_OPTION) {
			try {
				dao.eliminar(libro);
				estadoInicial();
				cargarTabla("");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void cancelar() {
		estadoInicial();
	}

	@Override
	public void buscar() {
		String filtro = this.vista.getTfBuscador().getText().trim();
		cargarTabla(filtro);
	}

}