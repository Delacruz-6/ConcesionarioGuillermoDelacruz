package com.salesianostriana.primerodam.modelo;

import java.util.List;
/**
 * Clase donde asignar los valores de los campos de tipo fijo del vehículo
 * @author gdlcr
 *
 */
public class DataMaster {
	/**
	 * Método que crea y devuelve los campos fijos del tipo de cambio del vehículo
	 * @return Lista con los campos fijos
	 */
	public static List<String> cambios(){
		return List.of("Manual", "Automatico");
	}

}
