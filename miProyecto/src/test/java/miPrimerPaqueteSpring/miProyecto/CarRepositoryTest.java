package miPrimerPaqueteSpring.miProyecto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import miPrimerPaqueteSpring.miProyecto.domain.Car2;
import miPrimerPaqueteSpring.miProyecto.domain.Car2Repository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private Car2Repository repository;
	
	@Test
	public void saveCar() {
		Car2 car = new Car2("Tesla", "Model X", "White", "ABC-1234", 2017, 86000, null);
		entityManager.persistAndFlush(car);
		
		assertThat(car.getId()).isNotNull();
	}
	
	@Test
	public void deleteCars() {
		entityManager.persistAndFlush(new Car2("Tesla", "Model X", "White", "ABC-1234", 2017, 86000, null));
		entityManager.persistAndFlush(new Car2("Mini", "Cooper", "Yellow", "BWS-3007", 2015, 24500, null));
		repository.deleteAll();
		assertThat(repository.findAll()).isEmpty();
	}	

}

