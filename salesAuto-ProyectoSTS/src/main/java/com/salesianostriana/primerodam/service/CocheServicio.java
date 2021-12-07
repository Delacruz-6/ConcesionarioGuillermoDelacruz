package com.salesianostriana.primerodam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.primerodam.modelo.Coche;
import com.salesianostriana.primerodam.repository.CocheRepository;
import com.salesianostriana.primerodam.service.database.BaseService;

/**
 * Esta clase implementa la clase CocheRepository
 * @author gdlcr
 *@version 1.2
 */
@Service
public class CocheServicio extends BaseService<Coche, Long, CocheRepository>{
	/**
	 * Método de busqueda  por el campo marca de un coche
	 * @param c Parametro de busqueda 
	 * @return Devuelve los vehículos que contengan la marca que se le pasa como parametro
	 */
	public List<Coche> buscarPorMarca(String c) {
		return this.repository.findByMarcaContainsIgnoreCaseOrderByMarcaAsc(c);
	}
	/**
	 * Método de busqueda  por el campo combustible de una categoria asignada a un coche
	 * @param c Parametro de busqueda 
	 * @return Devuelve los vehículos que contengan el tipo de combustible que se le pasa como parametro
	 */
	public List<Coche> buscarCochePorCombustible(String c) {
		return repository.findByCategoriaCombustibleIgnoreCase(c);
	}
	/**
	 * Método de busqueda  por el campo carroceria de una categoria asignada a un coche
	 * @param c Parametro de busqueda 
	 * @return Devuelve los vehículos que contengan el tipo de carroceria que se le pasa como parametro
	 */
	public List<Coche> buscarCochePorCarroceria(String c) {
		return repository.findByCategoriaCarroceriaIgnoreCase(c);
	}
	/**
	 * Método de busqueda  por el identificador de una categoria 
	 * @param categoriaId Parametro de busqueda 
	 * @return Devuelve los vehículos que contengan el tipo de carroceria que se le pasa como parametro
	 */
	public List<Coche> findAllByCategoria(Long categoriaId) {
		return repository.findByCategoriaId(categoriaId);
	}



}