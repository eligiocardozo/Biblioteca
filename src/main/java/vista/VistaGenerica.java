package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import componentes.JButonCom;

public class VistaGenerica extends JPanel {

	private JLabel lblTitulo;
    protected JPanel panelContenedorFormulario;

	public VistaGenerica(String TituloSeccion) {
		setBackground(new Color(241, 245, 249));
		setLayout(null);
		this.setSize(980, 655);
		
		lblTitulo = new JLabel(TituloSeccion);
        lblTitulo.setForeground(new Color(15, 23, 42)); 
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setBounds(30, 0, 600, 40);
        add(lblTitulo);

		JPanel panelContenedorFormulario = new JPanel();
		panelContenedorFormulario.setLayout(null);
		panelContenedorFormulario.setBackground(Color.WHITE);
		panelContenedorFormulario.setBounds(40, 50, 920, 509);
		add(panelContenedorFormulario);
		
		JButonCom btncmGuardar = new JButonCom();
		btncmGuardar.setForeground(new Color(30, 30, 30));
		btncmGuardar.setText("Guardar");
		btncmGuardar.setBounds(581, 569, 68, 62);
		add(btncmGuardar);
		
		JButonCom btncmCancelar = new JButonCom();
		btncmCancelar.setForeground(new Color(30, 30, 30));
		btncmCancelar.setText("Cancelar");
		btncmCancelar.setBounds(659, 569, 68, 62);
		add(btncmCancelar);
		
		JButonCom btncmEditar = new JButonCom();
		btncmEditar.setForeground(new Color(30, 30, 30));
		btncmEditar.setText("Editar");
		btncmEditar.setBounds(737, 569, 68, 62);
		add(btncmEditar);
		
		JButonCom btncmBorrar = new JButonCom();
		btncmBorrar.setForeground(new Color(30, 30, 30));
		btncmBorrar.setText("Borrar");
		btncmBorrar.setBounds(816, 569, 68, 62);
		add(btncmBorrar);
		
		JButonCom btncmNuevo = new JButonCom();
		btncmNuevo.setText("Nuevo");
		btncmNuevo.setForeground(new Color(30, 30, 30));
		btncmNuevo.setBounds(503, 569, 68, 62);
		add(btncmNuevo);
		
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}
}
