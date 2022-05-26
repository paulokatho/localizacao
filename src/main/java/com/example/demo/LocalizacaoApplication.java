package com.example.demo;

import com.example.demo.domain.entity.Cidade;
import com.example.demo.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeRepository cidaderepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inicializando projeto!!!");
		//listarCidades();
		listarCidadesPorNome();
		//listarCidadesPorHabitantes();
		System.out.println("");
	}

	void listarCidadesPorNome() {
		System.out.println("");
		cidaderepository.findByNomeLike("porto%").forEach(System.out::println);
		System.out.println("");
		cidaderepository.findByNomeStartingWith("Porto").forEach(System.out::println);
		System.out.println("BUSCA PELO INICIO DO NOME");
		cidaderepository.findByNomeStartingWith("Porto").forEach(System.out::println);
		System.out.println("BUSCA PELO CARACTERE FINAL");
		cidaderepository.findByNomeEndingWith("e").forEach(System.out::println);
		System.out.println("BUSCA PELO CARACTER QUE CONTEM NO NOME");
		cidaderepository.findByNomeContaining("l").forEach(System.out::println);
		System.out.println("");

	}

	void listarCidadesPorHabitantes() {
		cidaderepository.findByHabitantes(4948989L).forEach(System.out::println);
	}

	@Transactional
	void salvarCidade() {
		var cidade = new Cidade(1L, "São Paulo", 12396372L);
		cidaderepository.save(cidade);
	}

	void listarCidades() {
		cidaderepository.findAll().forEach(System.out::println);
	}
	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}
}
