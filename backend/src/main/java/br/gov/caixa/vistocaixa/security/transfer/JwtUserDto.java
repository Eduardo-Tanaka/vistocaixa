package br.gov.caixa.vistocaixa.security.transfer;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.gov.caixa.vistocaixa.model.Tarefa;

@Entity
@Table(name="TB_USER")
public class JwtUserDto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")
	private Long id;
	
	@Column(name="nm_user", nullable=false, unique=true)
	private String username;
	
	@Column(name="ds_email", nullable=false)
	private String email;
	
	@Column(name="ds_password", nullable=false)
	private String password;
	
	@Column(name="ds_role", nullable=false)
	private String role;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	private List<Tarefa> tarefas;
	
	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}