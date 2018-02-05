package org.rakiworld.streams;

import java.util.List;
import java.util.Optional;

import org.rakiworld.domain.Advertisement;
import org.rakiworld.domain.AdvertisementBuilder;

public class OptionalWithStreams {

	public static void main(String[] args) {
		List<Advertisement> ads = AdvertisementBuilder.buildSampleAdvertisements();

		Optional<Advertisement> adExists = ads.stream().filter(ad -> ad.getId() < 0 ).findFirst();
		if(adExists.isPresent())
			System.out.println(adExists.get());
		else
			System.out.println("No advertisement exists with id less than 0");
		
		adExists = ads.stream().filter(ad -> ad.getId() == 1l ).findFirst();
		if(adExists.isPresent())
			System.out.println(adExists.get());
		else
			System.out.println("Sorry Can't find ad");
		
		System.out.println("If present");
		ads.stream()
			.filter(ad -> ad.getId() == 1l )
			.findFirst()
			.ifPresent(System.out::println);
			
		System.out.println("Or Else");
		Advertisement advertisement = ads.stream()
			.filter(ad -> ad.getId() == 100000l )
			.findFirst()
			.orElseGet(Advertisement::new);
		System.out.println(advertisement);
		
		
		//Optional-Int, Optional-Double
			
	}
}
