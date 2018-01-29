package br.gov.caixa.vistocaixa.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.caixa.vistocaixa.security.transfer.JwtUserDto;

@Entity
@Table(name="TB_TAREFA")
public class Tarefa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tarefa")
	private Long id;
	
	@Column(name="ds_title", nullable=false)
	private String title;
	
	@Column(name="ds_tarefa", nullable=false)
	private String description;
	
	@Column(name="dt_tarefa", nullable=false)
	private Calendar data;
	
	@Column(name="id_user", nullable=false)
	private Long user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}


}
