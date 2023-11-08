package com.dev.localizacao.domain.repository;

import com.dev.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    //Busca pelo nome correto
    List<Cidade> findByNome(String nome);

    //Busca pelo nome que começa por esse pedaço do nome
    List<Cidade> findByNomeStartingWith(String nome);

    //Busca pelo nome que termina com esse pedaço do nome
    List<Cidade> findByNomeEndingWith(String nome);

    //Busca por nome que contem esse pedaço
    List<Cidade> findByNomeContaining(String nome);

    List<Cidade> findByHabitantes(Long habitantes);
}
