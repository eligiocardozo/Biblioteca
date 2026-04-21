package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name ="Usuario")
public class UsuarioModelo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Us_idUsuario")
	private Integer idUsuario;
	
	@Column(name = "Us_nombre_usuario", nullable = false, length = 45)
	private String nombre_usuario;
	
	@Column(name = "Us_contraseña", nullable = false, length = 45)
	private String contraseña;
	
	// falta idPersona

	public UsuarioModelo() {
		super();
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	

}
