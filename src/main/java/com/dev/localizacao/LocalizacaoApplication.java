package com.dev.localizacao;

import com.dev.localizacao.domain.repository.CidadeRepository;
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
		listarCidadesPorNome();
		listarCidadesPorHabitantes();
	}

	void listarCidadesPorNome() {
		cidadeRepository.findByNome("Asa Sul").forEach(System.out::println);
		cidadeRepository.findByNomeStartingWith("Cei").forEach(System.out::println);
		cidadeRepository.findByNomeEndingWith("dia").forEach(System.out::println);
		cidadeRepository.findByNomeContaining("ua").forEach(System.out::println);
	}

	void listarCidadesPorHabitantes() {
		cidadeRepository.findByHabitantes(532L).forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}
}
