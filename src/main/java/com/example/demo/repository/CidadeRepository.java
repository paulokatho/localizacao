package com.example.demo.repository;

import com.example.demo.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    List<Cidade> findByNome(String nome);

    List<Cidade> findByHabitantes(Long habitantes);
}