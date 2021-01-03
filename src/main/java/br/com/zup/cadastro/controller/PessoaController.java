package br.com.zup.cadastro.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.cadastro.controller.dto.PessoaDto;
import br.com.zup.cadastro.controller.form.PessoaForm;
import br.com.zup.cadastro.modelo.Pessoa;
import br.com.zup.cadastro.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping
	public List<PessoaDto> lista(){
		List<Pessoa> pessoas = pessoaRepository.findAll();		
		return PessoaDto.converter(pessoas);
		
	}
	
	@PostMapping
	public ResponseEntity<PessoaDto> cadastrar (@Valid @RequestBody PessoaForm form, UriComponentsBuilder uriBuilder) {
		Pessoa pessoa = form.converter();
		pessoaRepository.save(pessoa);
		
		URI uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();
		return ResponseEntity.created(uri).body(new PessoaDto(pessoa));
		
	}
	
}
