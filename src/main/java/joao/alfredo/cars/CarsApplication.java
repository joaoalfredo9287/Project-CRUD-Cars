package joao.alfredo.cars;

import joao.alfredo.cars.model.Car;
import joao.alfredo.cars.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public abstract class CarsApplication{

	public static void main(String[] args) {
		SpringApplication.run(CarsApplication.class, args);
	}

}
