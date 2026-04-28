package modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "Prestamo")
public class PrestamoModelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Pr_idPrestamo")
	private Integer idPrestamo;
	
	@ManyToOne(optional = false)
	private UsuarioModelo usuario;
	
	@ManyToOne(optional = false)
	private PersonaModelo persona;
	
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

	public UsuarioModelo getUsuario() {
		return usuario;
	}

	public PersonaModelo getPersona() {
		return persona;
	}

	public void setUsuario(UsuarioModelo usuario) {
		this.usuario = usuario;
	}

	public void setPersona(PersonaModelo persona) {
		this.persona = persona;
	}
	
	
	

}
