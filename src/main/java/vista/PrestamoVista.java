package vista;

import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;

import componentes.JButtonABM;
import componentes.JLabelGenerico;
import componentes.JtextFieldGenerico;
import modelo.UsuarioModelo;

public class PrestamoVista extends JPanel {

	private static final long serialVersionUID = 1L;

	private JtextFieldGenerico tfCodigo;
	private JtextFieldGenerico tfFecha;

	private JtextFieldGenerico tfCiPersona;
	private JButton btnBuscarPersona;
	private JtextFieldGenerico tfNombrePersona;

	private JComboBox<UsuarioModelo> cbUsuario;

	private JtextFieldGenerico tfCodigoLibro;
	private JButton btnBuscarLibro;
	private JtextFieldGenerico tfTituloLibro;
	private JtextFieldGenerico tfAutorLibro;
	private JtextFieldGenerico tfPlazo;
	private JButton btnAgregarLibro;

	private JTable tabla;
	private JScrollPane scrollPane;

	private JButtonABM btnCancelar;
	private JButtonABM btnGuardar;
	private JLabel lblCantidadLibros;

	public PrestamoVista() {
		setLayout(null);
		setPreferredSize(new java.awt.Dimension(1080, 720));

		JLabelGenerico lblCodigo = new JLabelGenerico((String) null);
		lblCodigo.setText("Código:");
		lblCodigo.setBounds(24, 21, 70, 22);
		add(lblCodigo);

		tfCodigo = new JtextFieldGenerico();
		tfCodigo.setEditable(false);
		tfCodigo.setBounds(80, 20, 112, 23);
		add(tfCodigo);

		JLabelGenerico lblFecha = new JLabelGenerico((String) null);
		lblFecha.setText("Fecha:");
		lblFecha.setBounds(779, 21, 97, 22);
		add(lblFecha);

		tfFecha = new JtextFieldGenerico();
		tfFecha.setEditable(false);
		tfFecha.setBounds(886, 21, 150, 23);
		add(tfFecha);

		JLabelGenerico lblCi = new JLabelGenerico((String) null);
		lblCi.setText("C.I. de la persona:");
		lblCi.setBounds(24, 75, 150, 22);
		add(lblCi);

		tfCiPersona = new JtextFieldGenerico();
		tfCiPersona.setBounds(24, 107, 150, 23);
		add(tfCiPersona);

		btnBuscarPersona = new JButton("Buscar");
		btnBuscarPersona.setBounds(180, 107, 80, 23);
		add(btnBuscarPersona);

		JLabelGenerico lblNombrePersona = new JLabelGenerico((String) null);
		lblNombrePersona.setText("Persona:");
		lblNombrePersona.setBounds(281, 75, 200, 22);
		add(lblNombrePersona);

		tfNombrePersona = new JtextFieldGenerico();
		tfNombrePersona.setEditable(false);
		tfNombrePersona.setBounds(281, 107, 300, 23);
		add(tfNombrePersona);

		JLabelGenerico lblUsuario = new JLabelGenerico((String) null);
		lblUsuario.setText("Usuario responsable:");
		lblUsuario.setBounds(600, 75, 200, 22);
		add(lblUsuario);

		cbUsuario = new JComboBox<UsuarioModelo>();
		cbUsuario.setBounds(600, 107, 250, 23);
		add(cbUsuario);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 151, 1046, 2);
		add(separator);

		JLabelGenerico lblLibroCodigo = new JLabelGenerico((String) null);
		lblLibroCodigo.setText("Código de libro:");
		lblLibroCodigo.setBounds(10, 172, 150, 22);
		add(lblLibroCodigo);

		tfCodigoLibro = new JtextFieldGenerico();
		tfCodigoLibro.setBounds(10, 195, 150, 23);
		add(tfCodigoLibro);

		btnBuscarLibro = new JButton("Buscar");
		btnBuscarLibro.setBounds(165, 195, 80, 23);
		add(btnBuscarLibro);

		JLabelGenerico lblLibroTitulo = new JLabelGenerico((String) null);
		lblLibroTitulo.setText("Título:");
		lblLibroTitulo.setBounds(260, 172, 300, 22);
		add(lblLibroTitulo);

		tfTituloLibro = new JtextFieldGenerico();
		tfTituloLibro.setEditable(false);
		tfTituloLibro.setBounds(260, 195, 300, 23);
		add(tfTituloLibro);

		JLabelGenerico lblLibroAutor = new JLabelGenerico((String) null);
		lblLibroAutor.setText("Autor:");
		lblLibroAutor.setBounds(575, 172, 200, 22);
		add(lblLibroAutor);

		tfAutorLibro = new JtextFieldGenerico();
		tfAutorLibro.setEditable(false);
		tfAutorLibro.setBounds(575, 195, 200, 23);
		add(tfAutorLibro);

		JLabelGenerico lblPlazo = new JLabelGenerico((String) null);
		lblPlazo.setText("Plazo (días):");
		lblPlazo.setBounds(790, 172, 90, 22);
		add(lblPlazo);

		tfPlazo = new JtextFieldGenerico();
		tfPlazo.setBounds(790, 195, 80, 23);
		add(tfPlazo);

		btnAgregarLibro = new JButton("Agregar");
		btnAgregarLibro.setBounds(885, 195, 150, 23);
		add(btnAgregarLibro);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 234, 1046, 332);
		add(scrollPane);

		tabla = new JTable();
		scrollPane.setViewportView(tabla);

		btnCancelar = new JButtonABM();
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(10, 576, 97, 76);
		add(btnCancelar);

		btnGuardar = new JButtonABM();
		btnGuardar.setText("Guardar");
		btnGuardar.setBounds(151, 576, 97, 76);
		add(btnGuardar);

		lblCantidadLibros = new JLabel("Libros: 0");
		lblCantidadLibros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		lblCantidadLibros.setFont(new Font("Arial", Font.BOLD, 26));
		lblCantidadLibros.setBounds(648, 576, 408, 76);
		add(lblCantidadLibros);

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				ajustarLayout();
			}
		});

		ajustarLayout();
	}

	private void ajustarLayout() {
		int ancho = getWidth();
		int alto = getHeight();
		if (ancho <= 0 || alto <= 0)
			return;

		int margen = 10;

		scrollPane.setBounds(margen, 234, ancho - margen * 2, Math.max(150, alto - 234 - 96));

		int yBotones = alto - 96;
		btnCancelar.setBounds(margen, yBotones, 97, 76);
		btnGuardar.setBounds(margen + 141, yBotones, 97, 76);
		lblCantidadLibros.setBounds(ancho - margen - 408, yBotones, 408, 76);

		revalidate();
		repaint();
	}

	public JtextFieldGenerico getTfCodigo() {
		return tfCodigo;
	}

	public JtextFieldGenerico getTfFecha() {
		return tfFecha;
	}

	public JtextFieldGenerico getTfCiPersona() {
		return tfCiPersona;
	}

	public JButton getBtnBuscarPersona() {
		return btnBuscarPersona;
	}

	public JtextFieldGenerico getTfNombrePersona() {
		return tfNombrePersona;
	}

	public JComboBox<UsuarioModelo> getCbUsuario() {
		return cbUsuario;
	}

	public JtextFieldGenerico getTfCodigoLibro() {
		return tfCodigoLibro;
	}

	public JButton getBtnBuscarLibro() {
		return btnBuscarLibro;
	}

	public JtextFieldGenerico getTfTituloLibro() {
		return tfTituloLibro;
	}

	public JtextFieldGenerico getTfAutorLibro() {
		return tfAutorLibro;
	}

	public JtextFieldGenerico getTfPlazo() {
		return tfPlazo;
	}

	public JButton getBtnAgregarLibro() {
		return btnAgregarLibro;
	}

	public JTable getTabla() {
		return tabla;
	}

	public JButtonABM getBtnCancelar() {
		return btnCancelar;
	}

	public JButtonABM getBtnGuardar() {
		return btnGuardar;
	}

	public JLabel getLblCantidadLibros() {
		return lblCantidadLibros;
	}

}