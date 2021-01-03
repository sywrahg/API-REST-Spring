package br.com.zup.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.cadastro.modelo.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
