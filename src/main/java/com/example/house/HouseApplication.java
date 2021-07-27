package com.example.house;

import com.example.house.entity.*;
import com.example.house.repository.*;
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

	/*
	@Bean
	public CommandLineRunner fillDatabase(BlockRepository blockRepository,
								          OwnerRepository ownerRepository,
										  FlatRepository flatRepository,
										  BillRepository billRepository,
										  FlatOwnerRepository flatOwnerRepository) {
		return (args) -> {
			fillBlocks(blockRepository);
			fillOwners(ownerRepository);
			fillFlats(flatRepository, blockRepository);
			fillBills(billRepository, flatRepository);
			fillFlatOwners(flatOwnerRepository, flatRepository, ownerRepository);
		};
	}

	private void fillBlocks(BlockRepository blockRepository) {
		if (blockRepository.findAll().size() == 0) {
			for (int i = 0; i < MyConstants.NUMBER_OF_BLOCKS; ++i) {
				blockRepository.save(new BlockEntity(i + 1));
			}
		}
	}

	private void fillOwners(OwnerRepository ownerRepository) {
		if (ownerRepository.findAll().size() == 0) {
			for (int i = 0; i < MyConstants.NUMBER_OF_OWNERS; ++i) {
				ownerRepository.save(new OwnerEntity(myRandom.getRandomFirstName(),
						myRandom.getRandomLastName(), myRandom.getRandomPhoneNumber()));
			}
		}
	}

	private void fillFlats(FlatRepository flatRepository,
						   BlockRepository blockRepository) {
		if (flatRepository.findAll().size() == 0) {
			int flatNumber = 1;
			for (int i = 0; i < MyConstants.NUMBER_OF_BLOCKS; ++i) {
				for (int j = 0; j < MyConstants.NUMBER_OF_FLOORS; ++j) {
					for (int k = 0; k < MyConstants.NUMBER_OF_FLATS_PER_FLOOR; ++k) {
						flatRepository.save(new FlatEntity(flatNumber++,
								blockRepository.findById(Integer.toUnsignedLong(i)).orElse(new BlockEntity()), j + 1,
								myRandom.getRandomArea()));
					}
				}
			}
		}
	}

	private void fillBills(BillRepository billRepository,
						  FlatRepository flatRepository) {
		if (billRepository.findAll().size() == 0) {
			for (int i = 0; i < MyConstants.NUMBER_OF_BILLS; ++i) {
				billRepository.save(new BillEntity(
						flatRepository.findByNumber(myRandom.getRandomFlatNumber()),
						myRandom.getRandomDate(), myRandom.getRandomBillStatus()));
			}
		}
	}

	private void fillFlatOwners(FlatOwnerRepository flatOwnerRepository,
							   FlatRepository flatRepository,
							   OwnerRepository ownerRepository) {
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
	}
	 */
}
