package vista;

import componentes.JDialogGenerico;
import componentes.JtextFieldGenerico;
import componentes.JLabelGenerico;

public class CategoriaVista extends JDialogGenerico {
	
	private JtextFieldGenerico tfNombre;
	private JtextFieldGenerico tfDescripcion;
	
	public CategoriaVista() {
		
		JLabelGenerico lblgnrcNombre = new JLabelGenerico((String) null);
		lblgnrcNombre.setText("Nombre:");
		lblgnrcNombre.setBounds(10, 56, 142, 25);
		getPanelFormulario().add(lblgnrcNombre);
		
		tfNombre = new JtextFieldGenerico();
		tfNombre.setBounds(98, 56, 343, 25);
		getPanelFormulario().add(tfNombre);
		
		JLabelGenerico lblgnrcDescripcion = new JLabelGenerico((String) null);
		lblgnrcDescripcion.setText("Descripcion:");
		lblgnrcDescripcion.setBounds(10, 116, 142, 25);
		getPanelFormulario().add(lblgnrcDescripcion);
		
		tfDescripcion = new JtextFieldGenerico();
		tfDescripcion.setBounds(98, 116, 343, 25);
		getPanelFormulario().add(tfDescripcion);
	}

	public JtextFieldGenerico getTfNombre() {
		return tfNombre;
	}

	public JtextFieldGenerico getTfDescripcion() {
		return tfDescripcion;
	}

	public void setTfNombre(JtextFieldGenerico tfNombre) {
		this.tfNombre = tfNombre;
	}

	public void setTfDescripcion(JtextFieldGenerico tfDescripcion) {
		this.tfDescripcion = tfDescripcion;
	}
	
	
}