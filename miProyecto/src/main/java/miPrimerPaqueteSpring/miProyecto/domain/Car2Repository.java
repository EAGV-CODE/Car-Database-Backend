package miPrimerPaqueteSpring.miProyecto.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Car2Repository extends CrudRepository <Car2, Long> {
	
	//Fetch cars by brand
	List<Car2> findByBrand(@Param("brand") String brand);
	
	//Fetch cars by color
	List<Car2> findByColor(@Param("color") String color);
		
	//Fetch cars by year
	List<Car2> findByYear(int year);	
		
	//Fetch cars by brand and model
	List<Car2> findByBrandAndModel(String brand, String model);
		
	//Fetch cars by brand or color
	List<Car2> findByBrandOrColor(String brand, String color);
	
	//Fetch cars by brand and sort by year
	List<Car2> findByBrandOrderByYearAsc(String brand);
	

	
	//Fetch cars by brand using SQL
	//@Query("select c from Car c where c.brand = ?1")
	//List<Car2> findByBrandSQL(String brand);	
		
	//Fetch cars by brand using SQL
	//@Query("select c from Car c where c.brand like %?1")
	//List<Car2> findByBrandEndsWith(String brand);	
		
	
	
}
