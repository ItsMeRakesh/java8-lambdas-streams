package org.rakiworld.functional.iface;

import java.util.List;
import java.util.function.Predicate;

import org.rakiworld.domain.Advertisement;
import org.rakiworld.domain.AdvertisementBuilder;

public class PredicateExmple {

	public void printFilteredAdvertisements(List<Advertisement> ads, Predicate<Advertisement> adFilter) {
		for (Advertisement advertisement : ads) {
			if (adFilter.test(advertisement)) {
				System.out.print(advertisement);
			}
		}
	}
	
	
	public static void main(String[] args) {
		List<Advertisement> ads = AdvertisementBuilder.buildSampleAdvertisements();
		new PredicateExmple().printFilteredAdvertisements(ads, (ad) -> ad.getCompanyName().equals("Emirates"));
	}
}
