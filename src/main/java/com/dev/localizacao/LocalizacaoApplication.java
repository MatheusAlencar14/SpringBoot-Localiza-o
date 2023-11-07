package com.dev.localizacao;

import com.dev.localizacao.domain.entity.Cidade;
import com.dev.localizacao.domain.repository.CidadeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public void run(String... args) throws Exception {
		salvarCidade();
		listarCidades();
	}

	@Transactional
	public void salvarCidade() {
		var cidade = new Cidade(null, "Gama", 200000L);
		cidadeRepository.save(cidade);
	}

	public void listarCidades() {
		cidadeRepository.findAll().forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}
}
