package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import dao.CategoriaDao;
import interfaces.InterfaceABM;
import modelo.CategoriaModelo;
import tablas.ModeloTablaCategoria;
import vista.CategoriaVista;

public class CategoriaController implements InterfaceABM {

	private CategoriaVista vista;
	private CategoriaModelo categoria;
	private CategoriaDao dao;
	private List<CategoriaModelo> categorias;
	private ModeloTablaCategoria tabla;

	public CategoriaController(CategoriaVista categoriaVista) {
		super();
		this.vista = categoriaVista;
		this.vista.setInterfaceABM(this);
		dao = new CategoriaDao();
		tabla = new ModeloTablaCategoria();
		this.vista.getTabla().setModel(tabla);
		setAcciones();
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

	private void cargarTabla(String filtro) {
		try {
			if (filtro == null || filtro.isEmpty())
				categorias = dao.recuperarTodo();
			else
				categorias = dao.buscarPorFiltro(filtro);
			tabla.setLista(categorias);
			tabla.fireTableDataChanged();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"No se pudo cargar la lista de categorías:\n" + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void estadoInicial() {
		// desactiva los botones
		this.vista.getBtnNuevo().setEnabled(true);
		this.vista.getBtnEditar().setEnabled(false);
		this.vista.getBtnEliminar().setEnabled(false);
		this.vista.getBtnCancelar().setEnabled(true);
		this.vista.getBtnGuardar().setEnabled(false);

		// desactiva los textfield
		this.vista.getTfNombre().setEnabled(false);
		this.vista.getTfDescripcion().setEnabled(false);

		// limpia los campos
		this.vista.getTfNombre().setText("");
		this.vista.getTfDescripcion().setText("");
		categoria = null;
	}

	private void seleccionarRegistro() {
		int fila = this.vista.getTabla().getSelectedRow();
		if (fila < 0 || categorias == null || fila >= categorias.size())
			return;
		categoria = categorias.get(fila);

		this.vista.getTfNombre().setText(categoria.getNombre_categoria());
		this.vista.getTfDescripcion().setText(categoria.getDescripcion_categoria());

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

		this.vista.getTfNombre().setEnabled(true);
		this.vista.getTfDescripcion().setEnabled(true);

		categoria = new CategoriaModelo();
	}

	@Override
	public void editar() {
		if (categoria == null)
			return;

		this.vista.getBtnNuevo().setEnabled(false);
		this.vista.getBtnEditar().setEnabled(false);
		this.vista.getBtnEliminar().setEnabled(false);
		this.vista.getBtnCancelar().setEnabled(true);
		this.vista.getBtnGuardar().setEnabled(true);

		this.vista.getTfNombre().setEnabled(true);
		this.vista.getTfDescripcion().setEnabled(true);
	}

	@Override
	public void guardar() {
		if (this.vista.getTfNombre().getText().isEmpty()
				|| this.vista.getTfDescripcion().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"Nombre y descripción son obligatorios.",
					"Atención", JOptionPane.WARNING_MESSAGE);
			return;
		}

		categoria.setNombre_categoria(this.vista.getTfNombre().getText());
		categoria.setDescripcion_categoria(this.vista.getTfDescripcion().getText());

		try {
			dao.guardar(categoria);
			cargarTabla("");
			estadoInicial();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void eliminar() {
		if (categoria == null)
			return;
		int confirmacion = JOptionPane.showConfirmDialog(null,
				"¿Estás seguro que deseas eliminar la categoría " + categoria.getNombre_categoria() + "?",
				"Atención", JOptionPane.YES_NO_OPTION);
		if (confirmacion == JOptionPane.YES_OPTION) {
			try {
				dao.eliminar(categoria);
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