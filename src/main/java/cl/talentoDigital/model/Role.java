package cl.talentoDigital.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="SQ_ROLE", initialValue=1, allocationSize=1)
public class Role implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SQ_ROLE")
	private Long id;
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(Long id, String name, Usuario usuario) {
		super();
		this.id = id;
		this.name = name;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", usuario=" + usuario + "]";
	}
}
