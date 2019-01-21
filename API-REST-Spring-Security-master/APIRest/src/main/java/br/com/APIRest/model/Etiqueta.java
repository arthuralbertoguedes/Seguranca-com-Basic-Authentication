package br.com.APIRest.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_etiqueta")
public class Etiqueta implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;
	
	@Column(name = "etiqueta_codigo", nullable = false)
	private long codigo;
	
	@Column(name = "etiqueta_nome", nullable = false)
	private String nome;
	
	@Column(name = "etiqueta_preco", nullable = false)
	private BigDecimal preco;
		
	
	public Etiqueta() {}
		
	public Etiqueta(long codigo, String nome, BigDecimal preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public Long getId() {
		return this.ID;
	}
	
	
}
