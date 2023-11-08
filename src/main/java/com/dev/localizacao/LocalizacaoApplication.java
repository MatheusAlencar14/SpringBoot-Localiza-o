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
		//listarCidadesPorNome();
		listarCidadesPorHabitantes();
	}

	void listarCidadesPorNome() {
		cidadeRepository.findByNome("Asa Sul").forEach(System.out::println);
		cidadeRepository.findByNomeLike("Cei%").forEach(System.out::println);
		cidadeRepository.findByNomeLike("%dia").forEach(System.out::println);
		cidadeRepository.findByNomeContaining("%ua%").forEach(System.out::println);
	}

	void listarCidadesPorHabitantes() {
		cidadeRepository.findByHabitantesLessThan(400000L).forEach(System.out::println);
		cidadeRepository.findByHabitantesGreaterThan(400001L).forEach(System.out::println);
		cidadeRepository.findByHabitantesLessThanEqual(6501L).forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}
}
