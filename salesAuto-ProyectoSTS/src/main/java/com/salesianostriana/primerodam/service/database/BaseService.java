package com.salesianostriana.primerodam.service.database;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 * Esta clase contiene los metodos genéricos para todos los objetos de la aplicación utilizando al repositorio de JPA
 * @author gdlcr
 *@version 1.2
 * @param <T> Objeto genérico
 * @param <ID> Identificador
 * @param <R> Objeto que extiende a JpaRepository
 */
public abstract class BaseService<T, ID, R extends JpaRepository<T,ID>> {
	
	@Autowired
	protected R repository;
	
	public T save(T t) {
		return repository.save(t);
	}
	
	public T edit(T t) {
		return save(t);
	}
	
	public void delete(T t) {
		repository.delete(t);
	}
	
	public void deleteById(ID id) {
		repository.deleteById(id);
	}
	
	public List<T> findAll() {
		return repository.findAll();
	}
	
	public Optional<T> findById(ID id) {
		return repository.findById(id);
	}
	

}
