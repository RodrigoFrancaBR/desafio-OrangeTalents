package br.com.zup.service.implementation;

import org.springframework.stereotype.Service;

import br.com.zup.domain.Pessoa;
import br.com.zup.dto.in.PessoaDTO;
import br.com.zup.repository.PessoaRepository;
import br.com.zup.service.interfaces.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {
	
	private PessoaRepository pessoaRepository;

	public PessoaServiceImpl(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	@Override
	public void cadastrarPessoa(PessoaDTO dto) {
		Pessoa pessoa = new Pessoa(dto);
		pessoaRepository.save(pessoa);
	}
}
