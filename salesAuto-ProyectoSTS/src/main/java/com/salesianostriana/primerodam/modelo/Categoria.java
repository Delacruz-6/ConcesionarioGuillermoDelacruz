package com.salesianostriana.primerodam.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * Esta clase contiene los atributos de la categoria de vehículos de la aplicación
 * @author gdlcr
 * @version 1.2
 *
 */
@Data @NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categoria {

	@Id @GeneratedValue
	private long id;
	
	private String carroceria;
	private String combustible;
	
	
	/**
	 * Este constructor contiene los campos de la clase menos el id dado que se tiene que asignar automaticamente cuando creas el objeto
	 * @param carroceria Tipo de tamaño y forma del vehículo
	 * @param combustible Tipo de combustible del vehículo
	 */
	public Categoria(String carroceria, String combustible) {
		super();
		this.carroceria = carroceria;
		this.combustible = combustible;
	}
	
	/**
	 * Se crea para que la aplicación no entre en bucle al crear los objetos
	 */
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="categoria", fetch = FetchType.EAGER)
	private List<Coche> coches = new ArrayList<>();
	
	/********************************************/
	/* MÉTODOS AUXILIARES					    */
	/********************************************/
	
	/**
	 * Método auxiliar para el tratamiento bidireccional de la asociación. Añade a un coche
	 * a la colección de coches de una categoria, y asigna a dicho coche esta categoria como el suyo.
	 * @param a
	 */
	public void addCoche(Coche c) {
		this.coches.add(c);
		c.setCategoria(this);
	}
	
	/**
	 * Método auxiliar para el tratamiento bidireccional de la asociación. Elimina un coche
	 * de la colección de coches de una categoria, y desasigna a dicho coche la categoria, dejándolo como nulo.
	 * @param a
	 */
	public void removeCoche(Coche c) {
		this.coches.remove(c);
		c.setCategoria(null);
	}
	/**
	 * Método toString modificado para visualizar de manera mas amena los campos cuando se pinte en el formulario
	 */
	@Override
	public String toString() {
		return  carroceria + " - " + combustible ;
	}
	


	



	
}