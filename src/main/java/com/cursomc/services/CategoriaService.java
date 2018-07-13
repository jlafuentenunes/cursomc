package com.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursomc.domain.Categoria;
import com.cursomc.repositories.CategoriaRepository;
import com.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria procurar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado ID:" + id + ", Tipo: " + Categoria.class.getName());
		}
		
		
		return obj.orElse(null);
	}
	
}
