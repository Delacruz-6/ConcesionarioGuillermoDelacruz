package com.salesianostriana.primerodam.modelo;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Esta clase contiene los campos del objeto tipo coche de la aplicación
 * @author gdlcr
 * @version 1.2
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coche {
	@Id
	@GeneratedValue
	private long id;
//	@NotEmpty
	private String marca,modelo,cambio,foto;

	private int cV;
	private Double cO2, consumo,precio;
	@ManyToOne
	private Categoria categoria;
	private LocalDate fechaAlta;
	/**
	 * Este constructor contiene todos los campos menos el id que se asigna automáticamente cuando se crea dicho objeto coche
	 * @param marca Marca del vehículo
	 * @param modelo Modelo del vehículo
	 * @param cambio Tipo de cambio del vehículo
	 * @param foto Imagen del vehículo
	 * @param cV Potencia del vehículo
	 * @param cO2 Emisiones del vehículo
	 * @param consumo Consumo del vehículo por l/100km
	 * @param precio Precio del vehículo
	 * @param categoria Tipo de categoria asignada al vehículo
	 * @param fechaAlta Fecha de alta en el concesionario del vehículo
	 */
	public Coche(String marca, String modelo, String cambio, String foto, int cV, Double cO2, Double consumo,
			Double precio, Categoria categoria, LocalDate fechaAlta) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.cambio = cambio;
		this.foto = foto;
		this.cV = cV;
		this.cO2 = cO2;
		this.consumo = consumo;
		this.precio = precio;
		this.categoria = categoria;
		this.fechaAlta = fechaAlta;
	}
	
	/**
	 * Este constructor contiene todos los campos menos la categoria y el id que se asigna automáticamente cuando se crea dicho objeto coche
	 * @param marca Marca del vehículo
	 * @param modelo Modelo del vehículo
	 * @param cambio Tipo de cambio del vehículo
	 * @param foto Imagen del vehículo
	 * @param cV Potencia del vehículo
	 * @param cO2 Emisiones del vehículo
	 * @param consumo Consumo del vehículo por l/100km
	 * @param precio Precio del vehículo
	 * @param fechaAlta Fecha de alta en el concesionario del vehículo
	 */
	public Coche(String marca, String modelo, String cambio, String foto, int cV, Double cO2, Double consumo,
			Double precio, LocalDate fechaAlta) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.cambio = cambio;
		this.foto = foto;
		this.cV = cV;
		this.cO2 = cO2;
		this.consumo = consumo;
		this.precio = precio;
		this.fechaAlta = fechaAlta;
	}
	
	
	
	
	
	
	
	
	
	

}
