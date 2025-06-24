package org.suhodo.cardatabase;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.suhodo.cardatabase.domain.Car;
import org.suhodo.cardatabase.repository.CarRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
class CardatabaseApplicationTests {

	@Autowired
	private CarRepository carRepository;

	@Test
	public void TestCarRepository(){
		Car fordCar = Car.builder()
						.brand("Ford")
						.model("Mustang")
						.color("Red")
						.registrationNumber("T-1111")
						.modelYear(2025)
						.price(5400)
						.build();
		
		carRepository.save(fordCar);

		Car kiaCar = Car.builder()
						.brand("Kia")
						.model("K-5")
						.color("Silver")
						.registrationNumber("K-111")
						.modelYear(2025)
						.price(6400)
						.build();
		
		carRepository.save(kiaCar);

		Car hyundaiCar = Car.builder()
						.brand("Hyundai")
						.model("Genesis")
						.color("Black")
						.registrationNumber("H-111")
						.modelYear(2025)
						.price(7400)
						.build();
		
		carRepository.save(hyundaiCar);
	}

	@Test
	public void TestFindAll(){
		List<Car> carList = carRepository.findAll();

		carList.stream().forEach(car -> log.info(car));
	}
}
