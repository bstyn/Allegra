package com.example.Allegra;

import com.example.Allegra.Models.Address;
import com.example.Allegra.Models.Auction;
import com.example.Allegra.Models.Profile;
import com.example.Allegra.Models.Review;
import com.example.Allegra.Repositories.AddressRepository;
import com.example.Allegra.Repositories.AuctionRepository;
import com.example.Allegra.Repositories.ProfileRepository;
import com.example.Allegra.Repositories.ReviewRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootApplication
public class AllegraApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AllegraApplication.class, args);
		ProfileRepository repo = context.getBean(ProfileRepository.class);
		AuctionRepository repoA = context.getBean(AuctionRepository.class);
		AddressRepository repoAd = context.getBean(AddressRepository.class);
		ReviewRepository repoR = context.getBean(ReviewRepository.class);
		Address address = new Address("Poland","84-200","Gdańsk","Świętojańska",22);
		Profile profile = new Profile("Bartek","Nazwisko", "example@example.com", "bstyn", "admin");
		Auction auction = new Auction("Ps5",new Date(),new Date(),"https://rytmy.pl/wp-content/uploads/bfi_thumb/playstation-5-pzfp9b0ku582y2etccfdns4p0nlb51vplzynmxywzs.jpg",1905.0);
		Auction auction2 = new Auction("Ps2",new Date(),new Date(),"https://rytmy.pl/wp-content/uploads/bfi_thumb/playstation-5-pzfp9b0ku582y2etccfdns4p0nlb51vplzynmxywzs.jpg",1905.0);
		Auction auction3 = new Auction("Ps2",new Date(),new Date(),"https://rytmy.pl/wp-content/uploads/bfi_thumb/playstation-5-pzfp9b0ku582y2etccfdns4p0nlb51vplzynmxywzs.jpg",1905.0);
		Auction auction4 = new Auction("Ps2",new Date(),new Date(),"https://rytmy.pl/wp-content/uploads/bfi_thumb/playstation-5-pzfp9b0ku582y2etccfdns4p0nlb51vplzynmxywzs.jpg",1905.0);
		Auction auction5 = new Auction("Ps2",new Date(),new Date(),"https://rytmy.pl/wp-content/uploads/bfi_thumb/playstation-5-pzfp9b0ku582y2etccfdns4p0nlb51vplzynmxywzs.jpg",1905.0);
		Auction auction6 = new Auction("Ps2",new Date(),new Date(),"https://rytmy.pl/wp-content/uploads/bfi_thumb/playstation-5-pzfp9b0ku582y2etccfdns4p0nlb51vplzynmxywzs.jpg",1905.0);
		Auction auction7 = new Auction("Ps2",new Date(),new Date(),"https://rytmy.pl/wp-content/uploads/bfi_thumb/playstation-5-pzfp9b0ku582y2etccfdns4p0nlb51vplzynmxywzs.jpg",1905.0);
		Review review = new Review("Opinia została wyrażona",4);
		Review review2 = new Review("Opinia została zatrzymana dla siebie",5);
		profile.setAddress(address);
		auction.addReview(review);
		auction.addReview(review2);
		auction.setName("Ps4");
		profile.addAuction(auction);
		repoA.save(auction);
		repoA.save(auction2);
		repoA.save(auction3);
		repoA.save(auction4);
		repoA.save(auction5);
		repoA.save(auction6);
		repoA.save(auction7);
		repo.save(profile);




		System.out.println(profile);
		System.out.println(profile.getUsersAuction());

	}


}
