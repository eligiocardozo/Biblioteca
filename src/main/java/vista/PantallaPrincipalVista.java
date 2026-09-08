package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import componentes.JPanelPersonalizado;
import componentes.JButonCom;
import controlador.PersonaController;
import controlador.CategoriaController;
import controlador.LibroController;

public class PantallaPrincipalVista extends JFrame {

	private JPanel contentPane;
	private JPanel panelContenido;
	private JPanel panelCentro;
	private JPanel panelLateral;
	private JPanel panelBarraSuperior;
	private JButton btnRegistros;
	private JButton btnCatalogo;
	private JButton btnReportes;
	private JButton btnConfiguracion;
	private List<JButton> subItemsRegistros = new ArrayList<>();
	private boolean registrosExpandido = false;

	private PersonaVista personaVista;
	private CategoriaVista categoriaVista;
	private LibroVista libroVista;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				PantallaPrincipalVista frame = new PantallaPrincipalVista();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public PantallaPrincipalVista() {
		setTitle("Biblioteca Virtual - Panel Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		Color colorMenuLateral = new Color(11, 63, 49);
		Color colorFondoCentro = new Color(241, 245, 249);
		Color colorTextoMenu = Color.WHITE;
		Font fuente = new Font("Segoe UI", Font.BOLD, 14);

		panelCentro = new JPanel();
		panelCentro.setBackground(colorFondoCentro);
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		panelCentro.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				ajustarLayout();
			}
		});

		panelLateral = new JPanel();
		panelLateral.setBackground(colorMenuLateral);
		panelLateral.setBounds(0, 0, 280, 681);
		panelLateral.setBorder(new EmptyBorder(120, 0, 0, 0));
		panelCentro.add(panelLateral);

		btnCatalogo = crearBotonMenu("Catálogo", "catalogo.png", fuente, colorTextoMenu, 25);

		btnRegistros = crearBotonMenu("Registros", "prestamos.png", fuente, colorTextoMenu, 25);
		btnRegistros.addActionListener(e -> {
			registrosExpandido = !registrosExpandido;
			btnRegistros.setText(registrosExpandido ? "Registros \u25B2" : "Registros \u25BC");
			reconstruirMenuLateral();
		});

		JButton btnSubUsuario = crearBotonMenu("Usuario", "usuarios.png", fuente, colorTextoMenu, 45);
		// Sin conectar todavía: falta el módulo de Usuario.

		JButton btnSubCategoria = crearBotonMenu("Categoría", "catalogo.png", fuente, colorTextoMenu, 45);
		btnSubCategoria.addActionListener(e -> {
			if (categoriaVista == null) {
				categoriaVista = new CategoriaVista();
				new CategoriaController(categoriaVista);
			}
			mostrarEnPanelContenido(categoriaVista);
		});

		JButton btnSubPersona = crearBotonMenu("Persona", "usuarios.png", fuente, colorTextoMenu, 45);
		btnSubPersona.addActionListener(e -> {
			if (personaVista == null) {
				personaVista = new PersonaVista();
				new PersonaController(personaVista);
			}
			mostrarEnPanelContenido(personaVista);
		});

		JButton btnSubLibro = crearBotonMenu("Libro", "catalogo.png", fuente, colorTextoMenu, 45);
		btnSubLibro.addActionListener(e -> {
			if (libroVista == null) {
				libroVista = new LibroVista();
				new LibroController(libroVista);
			}
			mostrarEnPanelContenido(libroVista);
		});

		JButton btnSubPrestamo = crearBotonMenu("Préstamo", "prestamos.png", fuente, colorTextoMenu, 45);
		// Sin conectar todavía: falta el módulo de Préstamo.

		JButton btnSubDetallePrestamo = crearBotonMenu("Detalle Préstamo", "prestamos.png", fuente, colorTextoMenu, 45);
		// Sin conectar todavía: falta el módulo de Detalle Préstamo.

		subItemsRegistros.add(btnSubUsuario);
		subItemsRegistros.add(btnSubCategoria);
		subItemsRegistros.add(btnSubPersona);
		subItemsRegistros.add(btnSubLibro);
		subItemsRegistros.add(btnSubPrestamo);
		subItemsRegistros.add(btnSubDetallePrestamo);

		btnReportes = crearBotonMenu("Reportes", "reportes.png", fuente, colorTextoMenu, 25);

		btnConfiguracion = crearBotonMenu("Configuración", "ajustes.png", fuente, colorTextoMenu, 25);

		reconstruirMenuLateral();

		panelBarraSuperior = new JPanel();
		panelBarraSuperior.setBackground(Color.WHITE);
		panelBarraSuperior.setBounds(280, 0, 984, 65);
		panelCentro.add(panelBarraSuperior);
		panelBarraSuperior.setLayout(null);

		panelContenido = new JPanel();
		panelContenido.setBackground(colorFondoCentro);
		panelContenido.setBounds(280, 65, 984, 616);
		panelCentro.add(panelContenido);
		panelContenido.setLayout(null);

		JPanel panelBuscadorContenedor = new JPanel();
		panelBuscadorContenedor.setBackground(new Color(241, 245, 249));
		panelBuscadorContenedor.setBounds(30, 12, 400, 40);
		panelBarraSuperior.add(panelBuscadorContenedor);
		panelBuscadorContenedor.setLayout(null);

		JLabel lblBuscarHint = new JLabel("Buscar libros, autores, códigos...");
		lblBuscarHint.setForeground(new Color(148, 163, 184));
		lblBuscarHint.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblBuscarHint.setBounds(15, 0, 330, 40);
		panelBuscadorContenedor.add(lblBuscarHint);

		JButton btnLupa = new JButton("");
		btnLupa.setIcon(new ImageIcon(
				"C:\\Users\\ELIGIO ANDRES\\Desktop\\LenguajeII\\Bibliotec\\src\\main\\resources\\imagenes\\lupa.png"));
		btnLupa.setContentAreaFilled(false);
		btnLupa.setBorderPainted(false);
		btnLupa.setFocusPainted(false);
		btnLupa.setBounds(350, 0, 50, 40);
		panelBuscadorContenedor.add(btnLupa);

		ajustarLayout();
	}

	private JButton crearBotonMenu(String texto, String nombreIcono, Font fuente, Color colorTexto, int indentacion) {
		JButton boton = new JButton(texto);
		boton.setIcon(new ImageIcon(
				"C:\\Users\\ELIGIO ANDRES\\Desktop\\LenguajeII\\Bibliotec\\Biblioteca\\src\\main\\resources\\imagenes\\"
						+ nombreIcono));
		boton.setFont(fuente);
		boton.setForeground(colorTexto);
		boton.setHorizontalAlignment(SwingConstants.LEFT);
		boton.setIconTextGap(15);
		boton.setContentAreaFilled(false);
		boton.setBorderPainted(false);
		boton.setBorder(BorderFactory.createEmptyBorder(0, indentacion, 0, 0));
		return boton;
	}

	private void reconstruirMenuLateral() {
		panelLateral.removeAll();

		List<Component> items = new ArrayList<>();
		items.add(btnCatalogo);
		items.add(btnRegistros);
		if (registrosExpandido)
			items.addAll(subItemsRegistros);
		items.add(btnReportes);
		items.add(btnConfiguracion);

		panelLateral.setLayout(new GridLayout(items.size(), 1, 0, 10));
		for (Component c : items)
			panelLateral.add(c);

		panelLateral.revalidate();
		panelLateral.repaint();
	}

	private void ajustarLayout() {
		int ancho = panelCentro.getWidth();
		int alto = panelCentro.getHeight();
		if (ancho <= 0 || alto <= 0)
			return;

		panelLateral.setBounds(0, 0, 280, alto);
		panelBarraSuperior.setBounds(280, 0, ancho - 280, 65);
		panelContenido.setBounds(280, 65, ancho - 280, alto - 65);

		if (panelContenido.getComponentCount() > 0) {
			Component vistaActual = panelContenido.getComponent(0);
			vistaActual.setBounds(0, 0, panelContenido.getWidth(), panelContenido.getHeight());
		}

		panelCentro.revalidate();
		panelCentro.repaint();
	}

	private void mostrarEnPanelContenido(JPanel panelVista) {
		panelContenido.removeAll();
		panelVista.setBounds(0, 0, panelContenido.getWidth(), panelContenido.getHeight());
		panelContenido.add(panelVista);
		panelContenido.revalidate();
		panelContenido.repaint();
	}
}