package br.com.zup.cadastro.controller.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.zup.cadastro.modelo.Pessoa;

public class PessoaDto {
	
	private long id;
	private String nome;
	private String email;
	private String cpf;
	private Date dtNascimento;
	
	public PessoaDto(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.email = pessoa.getEmail();
		this.cpf = pessoa.getCpf();
		this.dtNascimento = pessoa.getDtNascimento();
	}
	
	public static List<PessoaDto> converter(List<Pessoa> pessoas) {
		return pessoas.stream().map(PessoaDto::new).collect(Collectors.toList());
	}
	
	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getCpf() {
		return cpf;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	

}
