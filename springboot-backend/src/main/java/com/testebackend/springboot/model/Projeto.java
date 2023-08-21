package com.testebackend.springboot.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "projeto")
public class Projeto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "orcamento")
	private double orcamento;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "idgerente")
	private String responsavel;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "data_inicio")
	private String dataInicio;
	
	@Column(name = "data_previsao_fim")
	private String dataPrevisao;
	
	@Column(name = "data_fim")
	private String dataReal;
	
	public Projeto() {
	
	}
	
	public Projeto(double orcamento, String nome, String responsavel, String descricao, String status, String dataInicio,
			String dataPrevisao, String dataReal) {
		super();
		this.orcamento = orcamento;
		this.nome = nome;
		this.responsavel = responsavel;
		this.descricao = descricao;
		this.status = status;
		this.dataInicio = dataInicio;
		this.dataPrevisao = dataPrevisao;
		this.dataReal = dataReal;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(double orcamento) {
		this.orcamento = orcamento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataPrevisao() {
		return dataPrevisao;
	}
	public void setDataPrevisao(String dataPrevisao) {
		this.dataPrevisao = dataPrevisao;
	}
	public String getDataReal() {
		return dataReal;
	}
	public void setDataReal(String dataReal) {
		this.dataReal = dataReal;
	}
	
	
}
