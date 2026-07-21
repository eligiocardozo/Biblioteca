package tablas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.PersonaModelo;

public class ModeloTablaPersona extends AbstractTableModel{
	
	private String[] columnas = {"Código", "Nombre y Apellido", "Documento", "Contacto"};
	List<PersonaModelo> lista = new ArrayList<PersonaModelo>();
	
	
	public void setLista(List<PersonaModelo> lista) {
		this.lista = lista;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnas.length;
	}
	
	@Override
	public String getColumnName(int posicion) {
		// TODO Auto-generated method stub
		return columnas[posicion];
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		switch (columna) {
		case 0:
			return lista.get(fila).getIdPersona();
		case 1:
			return lista.get(fila).getNombre_persona() + " "+ lista.get(fila).getApellido_persona();
		case 2:
			return lista.get(fila).getCi_persona();
		case 3:
			return lista.get(fila).getTelefono_persona() != null ? 
					lista.get(fila).getTelefono_persona() : lista.get(fila).getCorreo_persona();
		default:
			return null;
		}
	}

}
