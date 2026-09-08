package tablas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.LibroModelo;

public class ModeloTablaLibro extends AbstractTableModel {

	private String[] columnas = { "Código", "Título", "Autor", "Categoría", "ISBN" };
	private List<LibroModelo> lista = new ArrayList<LibroModelo>();

	public void setLista(List<LibroModelo> lista) {
		this.lista = lista;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public String getColumnName(int posicion) {
		return columnas[posicion];
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		LibroModelo libro = lista.get(fila);
		switch (columna) {
		case 0:
			return libro.getIdLibro();
		case 1:
			return libro.getTitulo_li();
		case 2:
			return libro.getAutor_li();
		case 3:
			return libro.getCategoria() != null ? libro.getCategoria().getNombre_categoria() : "";
		case 4:
			return libro.getIsbn();
		default:
			return null;
		}
	}

}