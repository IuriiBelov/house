package com.example.house;

import com.example.house.entities.Block;
import com.example.house.entities.Flat;
import com.example.house.entities.Owner;
import com.example.house.repositories.BillRepository;
import com.example.house.repositories.BlockRepository;
import com.example.house.repositories.FlatRepository;
import com.example.house.repositories.OwnerRepository;
import com.example.house.utils.MyRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class HouseApplication {
	private static final int NUMBER_OF_BLOCKS = 7;
	private static final int NUMBER_OF_FLOORS = 9;
	private static final int NUMBER_OF_FLATS_PER_FLOOR = 6;
	private static final int NUMBER_OF_OWNERS = 500;
	private static final int NUMBER_OF_BILLS = 1000;

	private MyRandom myRandom;

	@Autowired
	public void setMyRandom(MyRandom myRandom) {
		this.myRandom = myRandom;
	}

	public static void main(String[] args) {
		SpringApplication.run(HouseApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BlockRepository blockRepository,
								  OwnerRepository ownerRepository,
								  FlatRepository flatRepository,
								  BillRepository billRepository) {
		return (args) -> {
			for (int i = 0; i < NUMBER_OF_BLOCKS; ++i) {
				blockRepository.save(new Block(i + 1));
			}

			for (int i = 0; i < NUMBER_OF_OWNERS; ++i) {
				ownerRepository.save(new Owner(myRandom.getRandomFirstName(),
						myRandom.getRandomLastName(), myRandom.getRandomPhoneNumber()));
			}

			int flatNumber = 1;
			for (int i = 0; i < NUMBER_OF_BLOCKS; ++i) {
				for (int j = 0; j < NUMBER_OF_FLOORS; ++j) {
					for (int k = 0; k < NUMBER_OF_FLATS_PER_FLOOR; ++k) {
						flatRepository.save(new Flat(flatNumber++,
								blockRepository.getOneByNumber(i + 1),j + 1,
								myRandom.getRandomArea()));
					}
				}
			}
		};
	}
}
