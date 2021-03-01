package br.com.zup.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.dto.in.PessoaDTO;
import br.com.zup.service.interfaces.PessoaService;

@RestController
@RequestMapping(path = "/pessoas")
public class PessoaController {

	private PessoaService pessoaService;

	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	@PostMapping
	public void cadastrarPessoa(@RequestBody PessoaDTO dto) {
		pessoaService.cadastrarPessoa(dto);
	}
}
