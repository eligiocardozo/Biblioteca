package componentes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import interfaces.InterfaceABM;

public class JDialogGenerico extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panelFormulario;
	private JTable tabla;
	private JScrollPane scrollPane;
	private JLabelGenerico lblBuscador;
	private JButtonABM btnNuevo;
	private JButtonABM btnEditar;
	private JButtonABM btnGuardar;
	private JButtonABM btnEliminar;
	private JButtonABM btnCancelar;
	private JtextFieldGenerico tfBuscador;
	private InterfaceABM interfaceABM;
	
	public void setInterfaceABM(InterfaceABM interfaceABM) {
		this.interfaceABM = interfaceABM;
	}

	public JDialogGenerico() {
		setLayout(null);
		setBounds(0, 0, 1080, 720);
		
		btnNuevo = new JButtonABM();
		btnNuevo.setText("Nuevo");
		btnNuevo.setToolTipText("");
		btnNuevo.setBounds(512, 572, 95, 80);
		add(btnNuevo);
		
		btnEditar = new JButtonABM();
		btnEditar.setToolTipText("");
		btnEditar.setText("Editar");
		btnEditar.setBounds(617, 572, 95, 80);
		add(btnEditar);
		
		btnGuardar = new JButtonABM();
		btnGuardar.setToolTipText("");
		btnGuardar.setText("Guardar");
		btnGuardar.setBounds(722, 572, 95, 80);
		add(btnGuardar);
		
		btnEliminar = new JButtonABM();
		btnEliminar.setToolTipText("");
		btnEliminar.setText("Eliminar");
		btnEliminar.setBounds(827, 572, 95, 80);
		add(btnEliminar);
		
		btnCancelar = new JButtonABM();
		btnCancelar.setToolTipText("");
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(932, 572, 95, 80);
		add(btnCancelar);
		
		panelFormulario = new JPanel();
		panelFormulario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelFormulario.setBounds(10, 40, 515, 515);
		add(panelFormulario);
		panelFormulario.setLayout(null);
		
		JScrollPane scrollPaneTemp = new JScrollPane();
		scrollPaneTemp.setBounds(532, 74, 524, 481);
		add(scrollPaneTemp);
		scrollPane = scrollPaneTemp;
		
		tabla = new JTable();
		scrollPane.setViewportView(tabla);
		
		lblBuscador = new JLabelGenerico((String) null);
		lblBuscador.setText("Buscador:");
		lblBuscador.setBounds(535, 40, 73, 25);
		add(lblBuscador);
		
		tfBuscador = new JtextFieldGenerico();
		tfBuscador.setBounds(618, 40, 438, 24);
		add(tfBuscador);

		setAcciones();

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				ajustarComponentes();
			}
		});

		ajustarComponentes();
	}

	private void ajustarComponentes() {
		int ancho = getWidth();
		int alto = getHeight();
		if (ancho <= 0 || alto <= 0)
			return;

		int margen = 10;
		int altoFilaBotones = 80;
		int margenInferior = 20;
		int gapAntesBotones = 10;

		int yBotones = alto - altoFilaBotones - (margenInferior / 2);
		int yFinContenido = yBotones - gapAntesBotones;

		int anchoFormulario = Math.max(300, (ancho * 45) / 100);
		panelFormulario.setBounds(margen, 40, anchoFormulario, Math.max(200, yFinContenido - 40));

		int xDerecha = anchoFormulario + margen * 2;
		int anchoDerecha = ancho - xDerecha - margen;

		lblBuscador.setBounds(xDerecha, 40, 73, 25);
		tfBuscador.setBounds(xDerecha + 83, 40, Math.max(100, anchoDerecha - 83), 24);
		scrollPane.setBounds(xDerecha, 74, Math.max(200, anchoDerecha), Math.max(200, yFinContenido - 74));

		int anchoGrupoBotones = 5 * 95 + 4 * 10;
		int xBotones = Math.max(margen, ancho - margen - anchoGrupoBotones);

		btnNuevo.setBounds(xBotones, yBotones, 95, 80);
		btnEditar.setBounds(xBotones + 105, yBotones, 95, 80);
		btnGuardar.setBounds(xBotones + 210, yBotones, 95, 80);
		btnEliminar.setBounds(xBotones + 315, yBotones, 95, 80);
		btnCancelar.setBounds(xBotones + 420, yBotones, 95, 80);

		revalidate();
		repaint();
	}
	
	private void setAcciones() {
		btnNuevo.addActionListener(this);
		btnEditar.addActionListener(this);
		btnGuardar.addActionListener(this);
		btnEliminar.addActionListener(this);
		btnCancelar.addActionListener(this);
		tfBuscador.setActionCommand("Buscar");
		tfBuscador.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Nuevo":
			interfaceABM.nuevo();
			break;
		case "Editar":
			interfaceABM.editar();
			break;
		case "Guardar":
			interfaceABM.guardar();
			break;
		case "Eliminar":
			interfaceABM.eliminar();
			break;
		case "Cancelar":
			interfaceABM.cancelar();
			break;
		case "Buscar":
			interfaceABM.buscar();
			break;
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JPanel getPanelFormulario() {
		return panelFormulario;
	}

	public JTable getTabla() {
		return tabla;
	}

	public JButtonABM getBtnNuevo() {
		return btnNuevo;
	}

	public JButtonABM getBtnEditar() {
		return btnEditar;
	}

	public JButtonABM getBtnGuardar() {
		return btnGuardar;
	}

	public JButtonABM getBtnEliminar() {
		return btnEliminar;
	}

	public JButtonABM getBtnCancelar() {
		return btnCancelar;
	}

	public JtextFieldGenerico getTfBuscador() {
		return tfBuscador;
	}

	public InterfaceABM getInterfaceABM() {
		return interfaceABM;
	}
}