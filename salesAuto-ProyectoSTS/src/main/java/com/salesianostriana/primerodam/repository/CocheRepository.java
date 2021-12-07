package com.salesianostriana.primerodam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.primerodam.modelo.Coche;

/**
 * Esta clase contiene los métodos necesarios para la aplicación, es solo un 'envoltorio', su contenido se añade en la clase servicio
 * @author gdlcr
 *@version 1.2
 */
public interface CocheRepository extends JpaRepository<Coche,Long>{
	/**
	 * Método de busqueda por marca del objeto coche
	 * @param marca Marca del vehículo
	 * @return No devuelve nada al tratarse de una interfaz
	 */
	List<Coche> findByMarcaContainsIgnoreCaseOrderByMarcaAsc(String marca);
	
	/**
	 * Método de busqueda por campo combustible de una categoria asignada a un coche
	 * @param marca Parametro de busqueda 
	 * @return No devuelve nada al tratarse de una interfaz
	 */
	List<Coche> findByCategoriaCombustibleIgnoreCase(String c);
	/**
	 * Método de busqueda  por el campo carroceria de una categoria asignada a un coche
	 * @param c Parametro de busqueda 
	 * @return No devuelve nada al tratarse de una interfaz
	 */
	List<Coche> findByCategoriaCarroceriaIgnoreCase(String c);
	/**
	 * Método de busqueda por id de la clase categoria
	 * @param categoriaId Identificador de la categoria
	 * @return No devuelve nada al tratarse de una interfaz
	 */
	List<Coche> findByCategoriaId(Long categoriaId);


}
