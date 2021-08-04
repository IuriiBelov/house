package com.example.house;

import com.example.house.entity.BillEntity;
import com.example.house.repository.BillRepository;
import com.example.house.repository.FlatRepository;
import com.example.house.utils.BillStatus;
import com.example.house.utils.MyRandom;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseApplication.class, args);
	}

	@Bean
	public CommandLineRunner fillDatabase(BillRepository billRepository,
										  FlatRepository flatRepository) {
		return (args) -> {
			MyRandom myRandom = new MyRandom();

			for (int i = 0; i < 10; ++i) {
				billRepository.save(new BillEntity(flatRepository.findByNumber(1).get(0), (i + 1),
						myRandom.getRandomDate(), BillStatus.PAID));
			}
		};
	}
}
