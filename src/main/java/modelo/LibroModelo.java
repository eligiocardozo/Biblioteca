package modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Libro")
public class LibroModelo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Li_idLibro")
	private Integer idLibro;
	
	@Column(name = "Li_titulo_li", nullable = false, length = 45)
	private String titulo_li;
	
	@Column(name = "Li_autor_li", nullable = false, length = 45)
	private String autor_li;
	
	@Column(name = "Li_anho_publicacion", nullable = false, length = 45)
	private Date anho_publicacion;
	
	@Column(name = "Li_isbn", nullable = false, length = 45)
	private String isbn;
	
	// falta el categoriaId
	
	@Column(name = "Li_editorial", nullable = false, length = 45)
	private String editorial;

	public LibroModelo() {
		super();
	}

	public Integer getIdLibro() {
		return idLibro;
	}

	public String getTitulo_li() {
		return titulo_li;
	}

	public String getAutor_li() {
		return autor_li;
	}

	public Date getAnho_publicacion() {
		return anho_publicacion;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	public void setTitulo_li(String titulo_li) {
		this.titulo_li = titulo_li;
	}

	public void setAutor_li(String autor_li) {
		this.autor_li = autor_li;
	}

	public void setAnho_publicacion(Date anho_publicacion) {
		this.anho_publicacion = anho_publicacion;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	
	

}
