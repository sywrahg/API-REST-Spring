package br.com.zup.cadastro.controller.form;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.zup.cadastro.modelo.Pessoa;

public class PessoaForm {
	
	@NotNull @NotEmpty 
	private String nome;
	@NotNull @NotEmpty @Email(message = "E-mail deve ser válido!")
	private String email;
	@NotNull @NotEmpty 
	private String cpf;
	private Date dtNascimento;
	
	public Pessoa converter() {
		return new Pessoa(nome, email, cpf, dtNascimento);
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

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
}
