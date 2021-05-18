package com.example.house;

import com.example.house.entities.*;
import com.example.house.repositories.*;
import com.example.house.utils.MyConstants;
import com.example.house.utils.MyRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class HouseApplication {

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
								  BillRepository billRepository,
								  FlatOwnerRepository flatOwnerRepository) {
		return (args) -> {
			for (int i = 0; i < MyConstants.NUMBER_OF_BLOCKS; ++i) {
				blockRepository.save(new Block(i + 1));
			}

			for (int i = 0; i < MyConstants.NUMBER_OF_OWNERS; ++i) {
				ownerRepository.save(new Owner(myRandom.getRandomFirstName(),
						myRandom.getRandomLastName(), myRandom.getRandomPhoneNumber()));
			}

			int flatNumber = 1;
			for (int i = 0; i < MyConstants.NUMBER_OF_BLOCKS; ++i) {
				for (int j = 0; j < MyConstants.NUMBER_OF_FLOORS; ++j) {
					for (int k = 0; k < MyConstants.NUMBER_OF_FLATS_PER_FLOOR; ++k) {
						flatRepository.save(new Flat(flatNumber++,
								blockRepository.getOneByNumber(i + 1),j + 1,
								myRandom.getRandomArea()));
					}
				}
			}

			for (int i = 0; i < MyConstants.NUMBER_OF_BILLS; ++i) {
				billRepository.save(new Bill(
						flatRepository.getOneByNumber(myRandom.getRandomFlatNumber()),
						myRandom.getRandomDate(), myRandom.getRandomBillStatus()));
			}

			for (int i = 0; i < MyConstants.NUMBER_OF_FLATS; ++i) {
				for (int j = 0; j < MyConstants.NUMBER_OF_OWNERS; ++j) {
					if (myRandom.flatBelongsToOwner()) {
						flatOwnerRepository.save(new FlatOwner(flatRepository.getOne((long)(i + 1)),
								ownerRepository.getOne((long)(j + 1))));
					}
				}
			}
		};
	}
}
