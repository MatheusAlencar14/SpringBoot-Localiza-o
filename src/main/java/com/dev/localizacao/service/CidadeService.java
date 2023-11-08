package com.dev.localizacao.service;

import com.dev.localizacao.domain.entity.Cidade;
import com.dev.localizacao.domain.repository.CidadeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class CidadeService {

    private CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    @Transactional
    public void salvarCidade() {
        var cidade = new Cidade(12L, "Brasília", 2000000L);
        cidadeRepository.save(cidade);
    }

    public void listarCidadesPorNome() {
        cidadeRepository.findByNome("Asa Sul", Sort.by("habitantes")).forEach(System.out::println);
        cidadeRepository.findByNomeLike("Cei%", Sort.by("nome")).forEach(System.out::println);
        cidadeRepository.findByNomeLike("%dia", Sort.by("id")).forEach(System.out::println);
        cidadeRepository.findByNomeLike("%a%", Sort.by("nome")).forEach(System.out::println);
    }

    public void listarCidadesPorHabitantes() {
        cidadeRepository.findByHabitantesLessThan(400000L).forEach(System.out::println);
        cidadeRepository.findByHabitantesGreaterThan(400001L).forEach(System.out::println);
        cidadeRepository.findByHabitantesLessThanEqual(6501L).forEach(System.out::println);
    }

    public void listarCidades() {
        cidadeRepository.findAll(Sort.by("habitantes"));
    }

    //Usando o Example para queries dinâmicas, onde a pesquisa pode ser tanto com nome,
    // quanto com habitantes ou mesmo com os dois campos.
    public List<Cidade> filtroDinâmico(Cidade cidade) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase(); //para ignorar letras maiusculas e minusculas

        Example<Cidade> example = Example.of(cidade, matcher);
        return cidadeRepository.findAll(example);
    }
}
