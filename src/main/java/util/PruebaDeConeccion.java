package util;

import dao.CategoriaDao;
import modelo.CategoriaModelo;

public class PruebaDeConeccion {
		
		public static void main(String[] args) {
			
			System.out.println("Iniciando prueba de coneccion");
			CategoriaModelo categoria = new CategoriaModelo();
			categoria.setNombre_categoria("prueba");
			categoria.setDescripcion_categoria("prueba de coneccion");
			
			CategoriaDao dao = new CategoriaDao();
			try {
				dao.guardar(categoria);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

}
