package miPrimerPaqueteSpring.miProyecto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import miPrimerPaqueteSpring.miProyecto.domain.Car2;
import miPrimerPaqueteSpring.miProyecto.domain.Car2Repository;

@RestController
public class CarController {
	
	@Autowired
	private Car2Repository repository;
	
	@RequestMapping("/cars")
	public Iterable<Car2> getCars() {
		return repository.findAll();
		
	}
}
