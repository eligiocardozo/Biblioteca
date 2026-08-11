package vista;

import componentes.JDialogGenerico;
import componentes.JLabelGenerico;
import componentes.JtextFieldGenerico;

public class UsuarioVista extends JDialogGenerico {
	
	public UsuarioVista(){
		
		JLabelGenerico lblgnrcNombreCompleto = new JLabelGenerico((String) null);
		lblgnrcNombreCompleto.setText("Nombre Completo:");
		lblgnrcNombreCompleto.setBounds(10, 28, 142, 25);
		getPanelFormulario().add(lblgnrcNombreCompleto);
		
		JtextFieldGenerico tfNombre = new JtextFieldGenerico();
		tfNombre.setBounds(142, 28, 343, 25);
		getPanelFormulario().add(tfNombre);
		
		JLabelGenerico lblgnrcContrasea = new JLabelGenerico((String) null);
		lblgnrcContrasea.setText("Contraseña:");
		lblgnrcContrasea.setBounds(10, 82, 142, 25);
		getPanelFormulario().add(lblgnrcContrasea);
		
		JtextFieldGenerico tfpassword = new JtextFieldGenerico();
		tfpassword.setBounds(142, 82, 343, 25);
		getPanelFormulario().add(tfpassword);
		
		
		
	}
}
