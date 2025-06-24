package org.suhodo.cardatabase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.suhodo.cardatabase.domain.Car;
import org.suhodo.cardatabase.repository.CarRepository;

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
}
