package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Persona")
public class PersonaModelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Per_idPersona")
	private Integer idPersona;

	@Column(name = "Per_nombre_persona", nullable = false, length = 45)
	private String nombre_persona;

	@Column(name = "Per_apellido_persona", nullable = false, length = 45)
	private String apellido_persona;

	@Column(name = "Per_direccion_persona", nullable = false, length = 45)
	private String direccion_persona;

	@Column(name = "Per_telefono_persona", nullable = false, length = 45)
	private String telefono_persona;

	@Column(name = "Per_ci_persona", nullable = false, length = 45)
	private String ci_persona;

	@Column(name = "Per_correo_persona", nullable = false, length = 45)
	private String correo_persona;

	// metodo constructor

	public PersonaModelo() {
		super();
	}

	// getter y setters

	public Integer getIdPersona() {
		return idPersona;
	}

	public String getNombre_persona() {
		return nombre_persona;
	}

	public String getApellido_persona() {
		return apellido_persona;
	}

	public String getDireccion_persona() {
		return direccion_persona;
	}

	public String getTelefono_persona() {
		return telefono_persona;
	}

	public String getCi_persona() {
		return ci_persona;
	}

	public String getCorreo_persona() {
		return correo_persona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public void setNombre_persona(String nombre_persona) {
		this.nombre_persona = nombre_persona;
	}

	public void setApellido_persona(String apellido_persona) {
		this.apellido_persona = apellido_persona;
	}

	public void setDireccion_persona(String direccion_persona) {
		this.direccion_persona = direccion_persona;
	}

	public void setTelefono_persona(String telefono_persona) {
		this.telefono_persona = telefono_persona;
	}

	public void setCi_persona(String ci_persona) {
		this.ci_persona = ci_persona;
	}

	public void setCorreo_persona(String correo_persona) {
		this.correo_persona = correo_persona;
	}

}
