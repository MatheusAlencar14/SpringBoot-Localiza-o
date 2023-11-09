package com.dev.localizacao.domain.repository.specs;

import com.dev.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.domain.Specification;

public abstract class CidadeSpecification {

    public static Specification<Cidade> nomeEqual(String nome) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("nome"), nome));
    }

    public static Specification<Cidade> idEqual(Long id) {
        return ((root, query, cB) -> cB.greaterThan(root.get("id"), id));
    }

    public static Specification<Cidade> habitantesGreaterThan(Long value) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("habitantes"), value));
    }

    public static Specification<Cidade> habitantesBetwenn(Long max, Long min) {
        return ((root, query, cB) -> cB.between(root.get("habitantes"), min, max));
    }

    public static Specification<Cidade> nomeLike(String nome) {
        return ((root, query, cB) -> cB.like(
                cB.upper(root.get("habitantes")), "%" + nome + "%"
        ));
    }
}
