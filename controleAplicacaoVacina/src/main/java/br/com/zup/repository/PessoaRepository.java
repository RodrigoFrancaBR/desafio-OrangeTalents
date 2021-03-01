package br.com.zup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
