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
	public CommandLineRunner fillDatabase(BlockRepository blockRepository,
								          OwnerRepository ownerRepository,
										  FlatRepository flatRepository,
										  BillRepository billRepository,
										  FlatOwnerRepository flatOwnerRepository) {
		return (args) -> {
			if (blockRepository.findAll().size() == 0) {
				for (int i = 0; i < MyConstants.NUMBER_OF_BLOCKS; ++i) {
					blockRepository.save(new BlockEntity(i + 1));
				}
			}

			if (ownerRepository.findAll().size() == 0) {
				for (int i = 0; i < MyConstants.NUMBER_OF_OWNERS; ++i) {
					ownerRepository.save(new OwnerEntity(myRandom.getRandomFirstName(),
							myRandom.getRandomLastName(), myRandom.getRandomPhoneNumber()));
				}
			}

			if (flatRepository.findAll().size() == 0) {
				int flatNumber = 1;
				for (int i = 0; i < MyConstants.NUMBER_OF_BLOCKS; ++i) {
					for (int j = 0; j < MyConstants.NUMBER_OF_FLOORS; ++j) {
						for (int k = 0; k < MyConstants.NUMBER_OF_FLATS_PER_FLOOR; ++k) {
							flatRepository.save(new FlatEntity(flatNumber++,
									blockRepository.getOneByNumber(i + 1), j + 1,
									myRandom.getRandomArea()));
						}
					}
				}
			}

			if (billRepository.findAll().size() == 0) {
				for (int i = 0; i < MyConstants.NUMBER_OF_BILLS; ++i) {
					billRepository.save(new BillEntity(
							flatRepository.getOneByNumber(myRandom.getRandomFlatNumber()),
							myRandom.getRandomDate(), myRandom.getRandomBillStatus()));
				}
			}

			if (flatOwnerRepository.findAll().size() == 0) {
				for (int i = 0; i < MyConstants.NUMBER_OF_FLATS; ++i) {
					for (int j = 0; j < MyConstants.NUMBER_OF_OWNERS; ++j) {
						if (myRandom.flatBelongsToOwner()) {
							flatOwnerRepository.save(new FlatOwnerEntity(flatRepository.getOne((long) (i + 1)),
									ownerRepository.getOne((long) (j + 1))));
						}
					}
				}
			}
		};
	}
}
