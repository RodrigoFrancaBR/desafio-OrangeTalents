package br.com.zup.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tb_vacina", 
uniqueConstraints = 
{ @UniqueConstraint(columnNames = { "nome" }, name = "UK_TB_VACINA_NOME") })
public class Vacina {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@Column(nullable = false, length = 30)
	private String nome;

	@Column(name = "forma_aplicar")
	private String formaDeAplicar;

	private String indicacao;

	@Column(name = "quando_tomar")
	private String quandoTomar;

	private String beneficios;
	
	//gets and sets

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFormaDeAplicar() {
		return formaDeAplicar;
	}

	public void setFormaDeAplicar(String formaDeAplicar) {
		this.formaDeAplicar = formaDeAplicar;
	}

	public String getIndicacao() {
		return indicacao;
	}

	public void setIndicacao(String indicacao) {
		this.indicacao = indicacao;
	}

	public String getQuandoTomar() {
		return quandoTomar;
	}

	public void setQuandoTomar(String quandoTomar) {
		this.quandoTomar = quandoTomar;
	}

	public String getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
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
		Vacina other = (Vacina) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
