package com.example.demo.repository;

import com.example.demo.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    //busca pelo nome correto e completo
    //e caixa alta para o que está no banco de dados e para o parametro que está vindo na request
    @Query(" select c from Cidade c where upper(c.nome) like upper(?1)")
    List<Cidade> findByNomeLike(String nome);

    //busca pelo nome comecando por alguma letra
    List<Cidade> findByNomeStartingWith(String nome);

    //busca pelo nome terminando por alguma letra
    List<Cidade> findByNomeEndingWith(String nome);

    //busca pelo nome contendo alguma letra no filtro
    List<Cidade> findByNomeContaining(String nome);
    List<Cidade> findByHabitantes(Long habitantes);
}
