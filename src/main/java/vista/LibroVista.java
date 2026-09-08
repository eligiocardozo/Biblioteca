package vista;

import javax.swing.JComboBox;

import componentes.JDialogGenerico;
import componentes.JtextFieldGenerico;
import componentes.JLabelGenerico;
import modelo.CategoriaModelo;

public class LibroVista extends JDialogGenerico {

	private static final long serialVersionUID = 1L;
	private JtextFieldGenerico tfEditorial;
	private JtextFieldGenerico tfAnhoPublicacion;
	private JtextFieldGenerico tfAutor;
	private JtextFieldGenerico tfTitulo;
	private JtextFieldGenerico tfIsbn;
	private JComboBox<CategoriaModelo> cbCategoria;

	public LibroVista() {

		JLabelGenerico lblgnrcTitulo = new JLabelGenerico((String) null);
		lblgnrcTitulo.setText("Titulo:");
		lblgnrcTitulo.setBounds(10, 31, 113, 25);
		getPanelFormulario().add(lblgnrcTitulo);

		tfTitulo = new JtextFieldGenerico();
		tfTitulo.setBounds(98, 31, 359, 25);
		getPanelFormulario().add(tfTitulo);

		JLabelGenerico lblgnrcAutor = new JLabelGenerico((String) null);
		lblgnrcAutor.setText("Autor:");
		lblgnrcAutor.setBounds(10, 78, 113, 25);
		getPanelFormulario().add(lblgnrcAutor);

		tfAutor = new JtextFieldGenerico();
		tfAutor.setBounds(98, 78, 359, 25);
		getPanelFormulario().add(tfAutor);

		JLabelGenerico lblgnrcAoDePublicacin = new JLabelGenerico((String) null);
		lblgnrcAoDePublicacin.setText("Año de publicación:");
		lblgnrcAoDePublicacin.setBounds(10, 125, 133, 25);
		getPanelFormulario().add(lblgnrcAoDePublicacin);

		tfAnhoPublicacion = new JtextFieldGenerico();
		tfAnhoPublicacion.setBounds(153, 125, 304, 25);
		getPanelFormulario().add(tfAnhoPublicacion);

		JLabelGenerico lblgnrcEditorial = new JLabelGenerico((String) null);
		lblgnrcEditorial.setText("Editorial:");
		lblgnrcEditorial.setBounds(10, 179, 113, 25);
		getPanelFormulario().add(lblgnrcEditorial);

		tfEditorial = new JtextFieldGenerico();
		tfEditorial.setBounds(98, 179, 359, 25);
		getPanelFormulario().add(tfEditorial);

		JLabelGenerico lblgnrcIsbn = new JLabelGenerico((String) null);
		lblgnrcIsbn.setText("ISBN:");
		lblgnrcIsbn.setBounds(10, 226, 113, 25);
		getPanelFormulario().add(lblgnrcIsbn);

		tfIsbn = new JtextFieldGenerico();
		tfIsbn.setBounds(98, 226, 359, 25);
		getPanelFormulario().add(tfIsbn);

		JLabelGenerico lblgnrcCategoria = new JLabelGenerico((String) null);
		lblgnrcCategoria.setText("Categoría:");
		lblgnrcCategoria.setBounds(10, 273, 113, 25);
		getPanelFormulario().add(lblgnrcCategoria);

		cbCategoria = new JComboBox<CategoriaModelo>();
		cbCategoria.setBounds(98, 273, 359, 25);
		getPanelFormulario().add(cbCategoria);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JtextFieldGenerico getTfEditorial() {
		return tfEditorial;
	}

	public JtextFieldGenerico getTfAnhoPublicacion() {
		return tfAnhoPublicacion;
	}

	public JtextFieldGenerico getTfAutor() {
		return tfAutor;
	}

	public JtextFieldGenerico getTfTitulo() {
		return tfTitulo;
	}

	public JtextFieldGenerico getTfIsbn() {
		return tfIsbn;
	}

	public JComboBox<CategoriaModelo> getCbCategoria() {
		return cbCategoria;
	}

	public void setTfEditorial(JtextFieldGenerico tfEditorial) {
		this.tfEditorial = tfEditorial;
	}

	public void setTfAnhoPublicacion(JtextFieldGenerico tfAnhoPublicacion) {
		this.tfAnhoPublicacion = tfAnhoPublicacion;
	}

	public void setTfAutor(JtextFieldGenerico tfAutor) {
		this.tfAutor = tfAutor;
	}

	public void setTfTitulo(JtextFieldGenerico tfTitulo) {
		this.tfTitulo = tfTitulo;
	}

	public void setTfIsbn(JtextFieldGenerico tfIsbn) {
		this.tfIsbn = tfIsbn;
	}

}