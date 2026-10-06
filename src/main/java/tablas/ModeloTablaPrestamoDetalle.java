package tablas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.DetallePrestamoModelo;

public class ModeloTablaPrestamoDetalle extends AbstractTableModel {

	private String[] columnas = { "Código", "Título", "Autor" };
	private List<DetallePrestamoModelo> lista = new ArrayList<DetallePrestamoModelo>();

	public void setLista(List<DetallePrestamoModelo> lista) {
		this.lista = lista;
		fireTableDataChanged();
	}

	public List<DetallePrestamoModelo> getLista() {
		return lista;
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
		switch (columna) {
		case 0:
			return lista.get(fila).getLibro().getIdLibro();
		case 1:
			return lista.get(fila).getLibro().getTitulo_li();
		case 2:
			return lista.get(fila).getLibro().getAutor_li();
		default:
			return null;
		}
	}

}