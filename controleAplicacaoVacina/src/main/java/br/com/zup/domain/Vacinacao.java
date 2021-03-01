package br.com.zup.domain;

import java.time.LocalDate;
//Para garantir que uma pessoa não receba a mesma dose de uma vacina vou adicionar uma uniqueConstraints para os campos vacina_id, dose e pessoa_id
//adicionando index para as fks

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(name = "tb_vacinacao",
uniqueConstraints = 
@UniqueConstraint(columnNames = { "vacina_id", "dose","pessoa_id" }, 
name = "UK_TB_VACINACAO_VACINA_ID_DOSE_PESSOA_ID"),
indexes = {
@Index(columnList = "vacina_id", name = "IDX_TB_VACINACAO_VACINA_ID_TB_VACINA_ID"),
@Index(columnList = "pessoa_id", name = "IDX_TB_VACINACAO_PESSOA_ID_TB_PESSOA_ID") })

@Entity
public class Vacinacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "vacina_id", nullable = false, foreignKey = @ForeignKey(name = "FK_TB_VACINACAO_VACINA_ID_TB_VACINA_ID"))
	private Vacina vacina;

	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(name = "FK_TB_VACINACAO_PESSOA_ID_TB_PESSOA_ID"))
	private Pessoa pessoa;

	@Column(name = "dt_vacinacao", nullable = false)
	private LocalDate dataVacinacao;

	@Column(name = "dose", columnDefinition = "INT default 1")
	private int dose;
	
	//gets and sets
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public LocalDate getDataVacinacao() {
		return dataVacinacao;
	}

	public void setDataVacinacao(LocalDate dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}

	public int getDose() {
		return dose;
	}

	public void setDose(int dose) {
		this.dose = dose;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacinacao other = (Vacinacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
