package br.com.zup.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.zup.dto.in.PessoaDTO;

@Table(name = "tb_pessoa", 
uniqueConstraints = 
{				
	@UniqueConstraint(columnNames = {"cpf"}, name="UK_TB_PESSOA_CPF"),
	@UniqueConstraint(columnNames = {"email"}, name="UK_TB_PESSOA_EMAIL")
})
@Entity
public class Pessoa {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@Column(nullable = false, length = 30)
	private String nome;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false, length = 11)
	private String cpf;
	
	@Column(name="dt_nascimento", nullable = false)
	private LocalDate dataNascimento;
	
	// gets and sets

	public Pessoa(PessoaDTO dto) {
		this.nome = dto.getNome();		
		this.email = dto.getEmail();
		this.cpf = dto.getCpf();
		this.dataNascimento = dto.getDataNascimento();
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
