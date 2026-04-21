package modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Prestamo")
public class PrestamoModelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Pr_idPrestamo")
	private Integer idPrestamo;
	
	//falta idUsuario
	
	//falta idPersona
	
	
	private Date fecha;
	
	private boolean estado;
	
	private Date fechaDevolucion;
	
	private int plazo;

	public PrestamoModelo() {
		super();
	}

	public Integer getIdPrestamo() {
		return idPrestamo;
	}

	public Date getFecha() {
		return fecha;
	}

	public boolean isEstado() {
		return estado;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public int getPlazo() {
		return plazo;
	}

	public void setIdPrestamo(Integer idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}
	
	
	

}
