package cl.talentoDigital.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="SQ_ROLE", initialValue=1, allocationSize=1)
public class Role implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SQ_ROLE")
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "role")
	private List<Usuario> usuarios;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(Long id, String name, List<Usuario> usuarios) {
		super();
		this.id = id;
		this.name = name;
		this.usuarios = usuarios;
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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", usuarios=" + usuarios + "]";
	}
}
