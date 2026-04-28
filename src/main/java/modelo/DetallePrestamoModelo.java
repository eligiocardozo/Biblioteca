package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "Detalle_prestamo")
public class DetallePrestamoModelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Dp_idDetalle_prestamo")
	private Integer idDetalle_prestamo;
	
	@ManyToOne(optional = false)
	private PrestamoModelo prestamo;
	
	@ManyToOne(optional = false)
	private LibroModelo libro;

	public DetallePrestamoModelo() {
		super();
	}

	public Integer getIdDetalle_prestamo() {
		return idDetalle_prestamo;
	}

	public PrestamoModelo getPrestamo() {
		return prestamo;
	}

	public LibroModelo getLibro() {
		return libro;
	}

	public void setIdDetalle_prestamo(Integer idDetalle_prestamo) {
		this.idDetalle_prestamo = idDetalle_prestamo;
	}

	public void setPrestamo(PrestamoModelo prestamo) {
		this.prestamo = prestamo;
	}

	public void setLibro(LibroModelo libro) {
		this.libro = libro;
	}
	
	

}
