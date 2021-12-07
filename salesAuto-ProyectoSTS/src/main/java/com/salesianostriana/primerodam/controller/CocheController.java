package com.salesianostriana.primerodam.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.salesianostriana.primerodam.modelo.Coche;
import com.salesianostriana.primerodam.modelo.DataMaster;
import com.salesianostriana.primerodam.service.CategoriaServicio;
import com.salesianostriana.primerodam.service.CocheServicio;

import lombok.RequiredArgsConstructor;
/**
 * Clase que contiene los métodos necesarios para poder representar y crear los objetos de la aplicación
 * @author gdlcr
 * @version 1.2
 *
 */
@Controller
@RequiredArgsConstructor
public class CocheController {
	
	private final CocheServicio coServicio;
	private final CategoriaServicio catServicio;
	/**
	 * Método que crea una lista completa con todos vehículos y pasada una consulta pinta una lista de solo los vehículos consultados
	 * @param model Objeto génerico que en este caso contiene los vehículos
	 * @param consulta Consulta para la busqueda de ciertos vehículos según la marca que se pasa en el input buscar
	 * @return Devuelve la página principal con la lista de los vehículos que coincidan con la busqueda o de todos los vehículos
	 */
	@GetMapping({"/", "/coches"})
	public String findAllCoches (Model model, 
			@RequestParam("q") Optional<String> consulta)  {
		List <Coche> coches;
		if (consulta.isEmpty()) {
			coches = coServicio.findAll();
		} else {
			coches = coServicio.buscarPorMarca(consulta.get());
		}
		model.addAttribute("cochesList", coches);
		return "index";
	}
	/**
	 * Método ve los campos de un vehñiculo concreto a través de su id
	 * @param cocheId Contiene el id del vehiculo concreto
	 * @param model Objeto genérico que en este caso es un vehículo
	 * @return Devuelve la página donde se representan los campos del vehiculo
	 */
	@GetMapping("/coche/{id}")
	public String detalle(
			@PathVariable("id") Long cocheId, Model model) {
		Coche c = coServicio.findById(cocheId).orElse(null);
		model.addAttribute("coche", c);	
		return "detail";
	}
	/**
	 * Método crea un vehículo asignandole una categoria
	 * @param model Objeto genérico que en este caso es un vehículo
	 * @return Devuelve el formulario de registro del vehículo donde debe asignarse todos los atributos requeridos como la categoria
	 */
	@GetMapping("/nuevo")
	public String crear(Model model) {

		model.addAttribute("categorias", catServicio.findAll());

		model.addAttribute("cocheForm", new Coche());
		return "form";		
	}
	/**
	 * Método que guarda el vehñiculo creado en el formulario
	 * @param coche Argumento que deberecuperarse en este caso un vehículo
	 * @return Guarda el objeto y redirecciona la página al index
	 */
	@PostMapping("/nuevo/submit")
	public String guardar(@ModelAttribute("cocheForm") Coche coche) {

		coche.setFechaAlta(LocalDate.now());
		coServicio.save(coche);
		System.out.println("Coche guardado");
		return"redirect:/";
	}
	
	/**
	 * Método que edita los vehículos a través de su id
	 * @param cocheId Contiene el id que se asigna automáticamente 
	 * @param model Objeto genérico que en este caso es un vehículo
	 * @return Devuelve la página donde se representa el formulario del vehiculo con los campos que contenga ya pintados
	 */
	@GetMapping("/edit/{id}")
	public String editar(
			@PathVariable("id") Long cocheId, Model model) {
		Coche c = coServicio.findById(cocheId).orElse(null);
		model.addAttribute("categorias", catServicio.findAll());
		
		model.addAttribute("cocheForm", c);
		return "form";
	}
	/**
	 * Método que representa la lista fija del campo cambio del vehículo
	 * @return devuelve la lista de los campos fijos cambio
	 */
	@ModelAttribute("cambios")
	public List<String> cambios(){
		return DataMaster.cambios();		
	}
	
	/**
	 * Método que borra los vehículos 
	 * @param cocheId Identificador del vehículo concreto a borrar
	 * @return Borra el vehiculo asignado al id y redirecciona al index con la lista de vehículos 
	 */
	@GetMapping("/delete/{id}")
	public String borrar(
			@PathVariable("id") Long cocheId) {
		coServicio.deleteById(cocheId);
		return "redirect:/";
	}
	/**
	 * Método que filtra por el tipo de combustible del vehículo
	 * @param comCategoria String que se pasa como parametro que indica por que tipo de combustible filtrar
	 * @param model Objeto genérico en este caso vehículo para representarlo con thymeleaf
	 * @return Devuelve la página donde se muestran la lista de vehículos que coincide con la busqueda del filtro
	 */
	@GetMapping("/categoria")
	public String filtradoCombustible(@RequestParam(name="comCategoria", required=false) String comCategoria, Model model) {		

		List<Coche> coches;
		coches= coServicio.buscarCochePorCombustible(comCategoria);	
		model.addAttribute("cochesList", coches);
		
		return "filtrado";
	}
	
	/**
	 * Método que filtra por el tipo de carroceria del vehículo
	 * @param comCategoria String que se pasa como parametro que indica por que tipo de carroceria filtrar
	 * @param model Objeto genérico en este caso vehículo para representarlo con thymeleaf
	 * @return Devuelve la página donde se muestran la lista de vehículos que coincide con la busqueda del filtro
	 */
	@GetMapping("/carroceria")
	public String filtradoCarroceria(@RequestParam(name="carCategoria", required=false) String carCategoria, Model model) {		

		List<Coche> coches;
		coches= coServicio.buscarCochePorCarroceria(carCategoria);	
		model.addAttribute("cochesList", coches);
		
		return "filtrado";
	}


	

	
		
}
