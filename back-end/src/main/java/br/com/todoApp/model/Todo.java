package br.com.todoApp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TB_TODO")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Todo implements Serializable{
	 
	private static final long serialVersionUID = -4394038967412993019L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CO_TODO")
	@EqualsAndHashCode.Include
	private Long id;
	
	@Column(name = "DS_TODO")
	private String descricao;
	
	@Column(name = "IC_STATUS")
	private Boolean feito;
}
