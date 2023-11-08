package com.dev.localizacao.service;

import com.dev.localizacao.domain.entity.Cidade;
import com.dev.localizacao.domain.repository.CidadeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
}
