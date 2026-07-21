package componentes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import interfaces.InterfaceABM;

public class JDialogGenerico extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panelFormulario;
	private JTable tabla;
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(532, 74, 524, 481);
		add(scrollPane);
		
		tabla = new JTable();
		scrollPane.setViewportView(tabla);
		
		JLabelGenerico lblgnrcBuscador = new JLabelGenerico((String) null);
		lblgnrcBuscador.setText("Buscador:");
		lblgnrcBuscador.setBounds(535, 40, 73, 25);
		add(lblgnrcBuscador);
		
		tfBuscador = new JtextFieldGenerico();
		tfBuscador.setBounds(618, 40, 438, 24);
		add(tfBuscador);

		setAcciones();
		
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
