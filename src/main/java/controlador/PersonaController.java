package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import dao.PersonaDao;
import interfaces.InterfaceABM;
import modelo.PersonaModelo;
import tablas.ModeloTablaPersona;
import vista.PersonaVista;

public class PersonaController implements InterfaceABM {

	private PersonaVista vista;
	private PersonaModelo persona;
	private PersonaDao dao;
	private List<PersonaModelo> personas;
	private ModeloTablaPersona tabla;

	public PersonaController(PersonaVista personaVista) {
		super();
		this.vista = personaVista;
		this.vista.setInterfaceABM(this);
		dao = new PersonaDao();
		tabla = new ModeloTablaPersona();
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
				personas = dao.recuperarTodo();
			else
				personas = dao.buscarPorFiltro(filtro);
			tabla.setLista(personas);
			tabla.fireTableDataChanged();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"No se pudo cargar la lista de personas:\n" + e.getMessage(),
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
		this.vista.getTfApellido().setEnabled(false);
		this.vista.getTfCi().setEnabled(false);
		this.vista.getTfCorreo().setEnabled(false);
		this.vista.getTfDireccion().setEnabled(false);
		this.vista.getTfTelefono().setEnabled(false);

		// Limpiar los campos
		this.vista.getTfNombre().setText("");
		this.vista.getTfApellido().setText("");
		this.vista.getTfCi().setText("");
		this.vista.getTfCorreo().setText("");
		this.vista.getTfDireccion().setText("");
		this.vista.getTfTelefono().setText("");
		persona = null;

	}

	private void seleccionarRegistro() {
		int fila = this.vista.getTabla().getSelectedRow();
		if (fila < 0 || personas == null || fila >= personas.size())
			return;
		persona = personas.get(fila);

		this.vista.getTfNombre().setText(persona.getNombre_persona());
		this.vista.getTfApellido().setText(persona.getApellido_persona());
		this.vista.getTfCi().setText(persona.getCi_persona());
		this.vista.getTfTelefono().setText(persona.getTelefono_persona());
		this.vista.getTfCorreo().setText(persona.getCorreo_persona());
		this.vista.getTfDireccion().setText(persona.getDireccion_persona());

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

		// desactiva los textfield
		this.vista.getTfNombre().setEnabled(true);
		this.vista.getTfApellido().setEnabled(true);
		this.vista.getTfCi().setEnabled(true);
		this.vista.getTfCorreo().setEnabled(true);
		this.vista.getTfDireccion().setEnabled(true);
		this.vista.getTfTelefono().setEnabled(true);

		persona = new PersonaModelo();

	}

	@Override
	public void editar() {
		if (persona == null)
			return;

		this.vista.getBtnNuevo().setEnabled(false);
		this.vista.getBtnEditar().setEnabled(false);
		this.vista.getBtnEliminar().setEnabled(false);
		this.vista.getBtnCancelar().setEnabled(true);
		this.vista.getBtnGuardar().setEnabled(true);

		// habilita los textfield para editar
		this.vista.getTfNombre().setEnabled(true);
		this.vista.getTfApellido().setEnabled(true);
		this.vista.getTfCi().setEnabled(true);
		this.vista.getTfCorreo().setEnabled(true);
		this.vista.getTfDireccion().setEnabled(true);
		this.vista.getTfTelefono().setEnabled(true);
	}

	@Override
	public void guardar() {
		if (this.vista.getTfNombre().getText().isEmpty()
				|| this.vista.getTfApellido().getText().isEmpty()
				|| this.vista.getTfCi().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"Nombre, apellido y CI son obligatorios.",
					"Atención", JOptionPane.WARNING_MESSAGE);
			return;
		}

		persona.setNombre_persona(this.vista.getTfNombre().getText());
		persona.setApellido_persona(this.vista.getTfApellido().getText());
		persona.setCi_persona(this.vista.getTfCi().getText());
		persona.setTelefono_persona(this.vista.getTfTelefono().getText());
		persona.setCorreo_persona(this.vista.getTfCorreo().getText());
		persona.setDireccion_persona(this.vista.getTfDireccion().getText());

		try {
			dao.guardar(persona);
			cargarTabla("");
			estadoInicial();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void eliminar() {
		if(persona==null) return;
		int confirmacion = JOptionPane.showConfirmDialog(null,"Estas seguro que deseas eliminar al cliente "
				+ persona.getNombre_persona()+" "+persona.getApellido_persona()+"?", "Atención", JOptionPane.YES_NO_OPTION);
		if(confirmacion == JOptionPane.YES_OPTION) {
			try {
				dao.eliminar(persona);
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