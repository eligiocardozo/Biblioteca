package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Categoria")
public class CategoriaModelo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Cat_idCategoria")
	private Integer idCategoria;
	
	@Column(name = "Cat_nombre_categoria", nullable = false, length = 45)
	private String nombre_categoria;
	
	@Column(name = "Cat_descripcion_categoria", nullable = false, length = 100)
	private String descripcion_categoria;

	public CategoriaModelo() {
		super();
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public String getNombre_categoria() {
		return nombre_categoria;
	}

	public String getDescripcion_categoria() {
		return descripcion_categoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}

	public void setDescripcion_categoria(String descripcion_categoria) {
		this.descripcion_categoria = descripcion_categoria;
	}
	
	
	

}
