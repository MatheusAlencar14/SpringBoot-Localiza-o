package com.dev.localizacao;

import com.dev.localizacao.domain.entity.Cidade;
import com.dev.localizacao.domain.repository.CidadeRepository;
import com.dev.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeService cidadeService;

	@Override
	public void run(String... args) throws Exception {
		var cidade = new Cidade(null, "gama", null);
		cidadeService.filtroDinâmico(cidade).forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}
}
