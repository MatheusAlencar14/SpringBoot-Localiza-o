package com.dev.localizacao.domain.repository;

import com.dev.localizacao.domain.entity.Cidade;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    //Busca pelo nome correto, o Sort adiciona uma ordenação (habitantes)
    List<Cidade> findByNome(String nome, Sort sort);

    //Para tornar a Query case sensitive: linha abaixo
    @Query(" select c from Cidade c where upper(c.nome) like upper(?1) ")
    List<Cidade> findByNomeLike(String nome, Sort sort);

    //Busca pelo nome que começa por esse pedaço do nome
    // (select * from tb_cidade where nome like 'Sa%')
    List<Cidade> findByNomeStartingWith(String nome);

    //Busca pelo nome que termina com esse pedaço do nome
    // (select * from tb_cidade where nome like '%ia')

    List<Cidade> findByNomeEndingWith(String nome);

    //Busca por nome que contem esse pedaço
    // (select * from tb_cidade where nome like '%ia%')
    List<Cidade> findByNomeContaining(String nome);

    List<Cidade> findByHabitantes(Long habitantes);

    //Lista por habitantes menor que
    List<Cidade> findByHabitantesLessThan(Long habitantes);

    //Lista por habitantes maior que
    List<Cidade> findByHabitantesGreaterThan(Long habitantes);

    //Lista por habitantes menor e igual que
    List<Cidade> findByHabitantesLessThanEqual(Long habitantes);
}
