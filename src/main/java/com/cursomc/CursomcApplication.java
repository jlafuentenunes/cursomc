package com.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursomc.domain.Categoria;
import com.cursomc.domain.Cidade;
import com.cursomc.domain.Estado;
import com.cursomc.domain.Produto;
import com.cursomc.repositories.CategoriaRepository;
import com.cursomc.repositories.CidadeRepository;
import com.cursomc.repositories.EstadoRepository;
import com.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1  = new Categoria(null, "Informática");
		Categoria cat2  = new Categoria(null, "Escritório");
		
		Produto prd1 = new Produto(null, "Computador", 2000.00 );
		Produto prd2 = new Produto(null, "Impressora", 800.00 );
		Produto prd3 = new Produto(null, "Mouse", 80.00 );
		
		cat1.getProdutos().addAll(Arrays.asList(prd1, prd2, prd3));
		cat2.getProdutos().addAll(Arrays.asList(prd2));
		
		prd1.getCategorias().addAll(Arrays.asList(cat1));
		prd2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		prd3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(prd1, prd2, prd3));
		
		Estado est1 = new Estado(null, "Braga");
		Estado est2 = new Estado(null, "Porto");
		
		Cidade c1 = new Cidade(null, "Esposende", est1);
		Cidade c2 = new Cidade(null, "Póvoa de Varzim", est2);
		Cidade c3 = new Cidade(null, "Maia", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
	}
}
