package vista;

import componentes.JDialogGenerico;
import componentes.JLabelGenerico;
import componentes.JtextFieldGenerico;

public class PersonaVista extends JDialogGenerico{
	
	private JtextFieldGenerico tfCi;
	private JtextFieldGenerico tfNombre;
	private JtextFieldGenerico tfApellido;
	private JtextFieldGenerico tfDireccion;
	private JtextFieldGenerico tfTelefono;
	private JtextFieldGenerico tfCorreo;
	public PersonaVista() {
		
		JLabelGenerico lblgnrcNombre = new JLabelGenerico((String) null);
		lblgnrcNombre.setText("Nombre:");
		lblgnrcNombre.setBounds(10, 80, 142, 25);
		getPanelFormulario().add(lblgnrcNombre);
		
		JLabelGenerico lblgnrcApellido = new JLabelGenerico((String) null);
		lblgnrcApellido.setText("Apellido:");
		lblgnrcApellido.setBounds(10, 125, 142, 25);
		getPanelFormulario().add(lblgnrcApellido);
		
		JLabelGenerico lblgnrcDireccion = new JLabelGenerico((String) null);
		lblgnrcDireccion.setText("Direccion:");
		lblgnrcDireccion.setBounds(10, 170, 142, 25);
		getPanelFormulario().add(lblgnrcDireccion);
		
		JLabelGenerico lblgnrcTelefono = new JLabelGenerico((String) null);
		lblgnrcTelefono.setText("Telefono:");
		lblgnrcTelefono.setBounds(10, 218, 142, 25);
		getPanelFormulario().add(lblgnrcTelefono);
		
		JLabelGenerico lblgnrcNDeCi = new JLabelGenerico((String) null);
		lblgnrcNDeCi.setText("N° de CI:");
		lblgnrcNDeCi.setBounds(10, 31, 142, 25);
		getPanelFormulario().add(lblgnrcNDeCi);
		
		JLabelGenerico lblgnrcCorreo = new JLabelGenerico((String) null);
		lblgnrcCorreo.setText("Correo:");
		lblgnrcCorreo.setBounds(10, 264, 142, 25);
		getPanelFormulario().add(lblgnrcCorreo);
		
		tfNombre = new JtextFieldGenerico();
		tfNombre.setBounds(80, 80, 343, 25);
		getPanelFormulario().add(tfNombre);
		
		tfApellido = new JtextFieldGenerico();
		tfApellido.setBounds(80, 125, 343, 25);
		getPanelFormulario().add(tfApellido);
		
		tfDireccion = new JtextFieldGenerico();
		tfDireccion.setBounds(80, 170, 343, 25);
		getPanelFormulario().add(tfDireccion);
		
		tfTelefono = new JtextFieldGenerico();
		tfTelefono.setBounds(80, 218, 163, 25);
		getPanelFormulario().add(tfTelefono);
		
		tfCorreo = new JtextFieldGenerico();
		tfCorreo.setBounds(80, 264, 212, 25);
		getPanelFormulario().add(tfCorreo);
		
		tfCi = new JtextFieldGenerico();
		tfCi.setBounds(80, 31, 163, 25);
		getPanelFormulario().add(tfCi);
	}
	public JtextFieldGenerico getTfCi() {
		return tfCi;
	}
	public JtextFieldGenerico getTfNombre() {
		return tfNombre;
	}
	public JtextFieldGenerico getTfApellido() {
		return tfApellido;
	}
	public JtextFieldGenerico getTfDireccion() {
		return tfDireccion;
	}
	public JtextFieldGenerico getTfTelefono() {
		return tfTelefono;
	}
	public JtextFieldGenerico getTfCorreo() {
		return tfCorreo;
	}
	public void setTfCi(JtextFieldGenerico tfCi) {
		this.tfCi = tfCi;
	}
	public void setTfNombre(JtextFieldGenerico tfNombre) {
		this.tfNombre = tfNombre;
	}
	public void setTfApellido(JtextFieldGenerico tfApellido) {
		this.tfApellido = tfApellido;
	}
	public void setTfDireccion(JtextFieldGenerico tfDireccion) {
		this.tfDireccion = tfDireccion;
	}
	public void setTfTelefono(JtextFieldGenerico tfTelefono) {
		this.tfTelefono = tfTelefono;
	}
	public void setTfCorreo(JtextFieldGenerico tfCorreo) {
		this.tfCorreo = tfCorreo;
	}
	
	
	
}
