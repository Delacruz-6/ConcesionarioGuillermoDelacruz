package com.salesianostriana.primerodam;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.salesianostriana.primerodam.modelo.Categoria;
import com.salesianostriana.primerodam.modelo.Coche;
import com.salesianostriana.primerodam.service.CategoriaServicio;
import com.salesianostriana.primerodam.service.CocheServicio;

import lombok.RequiredArgsConstructor;

/**
 * Esta aplicación es una versión básica de la gestión de un concesionario de coches en la cual podemos hacer las gestiones principales 
 * como agregar, borrar, editar, ver detalles, filtrar o buscar los vehívulos.
 * @author gdlcr
 * @version 1.2
 *
 */
@Component
@RequiredArgsConstructor
public class PseudoMain {
	
	private final CocheServicio coServicio;
	
	private final CategoriaServicio catServicio;
	@PostConstruct
	public void run() {

		List<Categoria> categorias = List.of(
				new Categoria("4x4","Gasolina"),
				new Categoria("4x4","Diesel"),
				new Categoria("4x4","Eléctrico"),
				new Categoria("4x4","Híbrido"),
				new Categoria("Monovolumen","Gasolina"),
				new Categoria("Monovolumen","Diesel"),
				new Categoria("Monovolumen","Eléctrico"),
				new Categoria("Monovolumen","Híbrido"),
				new Categoria("deportivo","Gasolina"),
				new Categoria("deportivo","Diesel"),
				new Categoria("deportivo","Eléctrico"),
				new Categoria("deportivo","Híbrido"),
				new Categoria("Coupe","Gasolina"),
				new Categoria("Coupe","Diesel"),
				new Categoria("Coupe","Eléctrico"),
				new Categoria("Coupe","Híbrido")
				);
		
		categorias.forEach(catServicio::save);
		
		List<Coche> lista =List.of(
		new Coche ("Audi", "Q7", "Manual","https://cdn.autobild.es/sites/navi.axelspringer.es/public/media/image/2019/06/audi-q7-2019_2.jpg",200,120.0,7.9,60700.0,catServicio.findById(2L).get(),LocalDate.of(2019, 9, 28) ),
		new Coche ("Audi", "Q5", "Manual","https://mediaservice.audi.com/media/cdb/data/fc039f65-6d13-455e-b8d5-41878d67cf0f.jpg",180,110.0,6.8,55680.0,catServicio.findById(4L).get(),LocalDate.of(2020, 5, 18) ),
		new Coche ("Audi", "R8", "Manual","https://images1.autocasion.com/unsafe/900x600/actualidad/wp-content/uploads/2016/05/_main_image_227447_5731aa2b146c7.jpg",280,150.0,6.8,170000.0,catServicio.findById(2L).get(),LocalDate.of(2018, 7, 8) ),
		new Coche ("BMW", "Z4",  "Manual","https://periodismodelmotor.com/wp-content/uploads/2020/02/prueba-bmw-z4-m40i.jpg'",197,139.0,6.1,65400.0,catServicio.findById(10L).get(),LocalDate.of(2021, 1, 20) ),
		new Coche ("Porsche", "Panamera", "Automático","https://cdn.topgear.es/sites/navi.axelspringer.es/public/media/image/2020/10/porsche-panamera-turbo-s-hybrid-2021-2107543.jpg",440,244.0,10.8,130000.0,catServicio.findById(9L).get(),LocalDate.of(2021, 2, 22) ),
		new Coche ("BMW", "i8", "Automatico","https://www.motor16.com/images/modelos/100/121/1.jpg",362,0.0,2.4,146800.0,catServicio.findById(11L).get(),LocalDate.of(2021, 4, 4) ),
		new Coche ("Mercedes", "Clase B", "Manual","https://d1cjrn2338s5db.cloudfront.net/vo/imagenes/h_img_58_43114_738465_1610624458.jpg",136,158.0,1.1,34025.0,catServicio.findById(5L).get(),LocalDate.of(2021, 4, 28) ),
		new Coche ("Mercedes", "Clase C", "Automatico","https://www.diariomotor.com/imagenes/picscache/750x/mercedes-clase-c-2021-p2_750x.jpg",218,188.0,1.1,46800.0,catServicio.findById(16L).get(),LocalDate.of(2021, 2, 15) )
		);
		
		lista.forEach(coServicio::save);
		
	}

}
