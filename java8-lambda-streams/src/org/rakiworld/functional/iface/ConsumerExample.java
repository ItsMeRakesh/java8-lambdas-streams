package org.rakiworld.functional.iface;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.rakiworld.domain.Advertisement;
import org.rakiworld.domain.AdvertisementBuilder;
import org.rakiworld.domain.AdvertisementIndustry;

public class ConsumerExample {
	
	public void processAdvertisements(List<Advertisement> ads, Predicate<Advertisement> adFilter, Consumer<Advertisement> adConsumer) {
		for (Advertisement advertisement : ads) {
			if (adFilter.test(advertisement)) {
				adConsumer.accept(advertisement);
			}
		}
	}
	
	public void processAllAdvertisements(List<Advertisement> ads, Consumer<Advertisement> adConsumer) {
		for (Advertisement advertisement : ads) {
				adConsumer.accept(advertisement);
		}
	}
	
	public static void main(String[] args) {
		List<Advertisement> ads = AdvertisementBuilder.buildSampleAdvertisements();
		new ConsumerExample().processAdvertisements(ads, ad -> ad.getCompanyName().equals("Emirates"), ad -> System.out.print(ad));
		new ConsumerExample().processAdvertisements(ads, ad -> ad.getCompanyName().equals("Emirates"), new Consumer<Advertisement>(){public void accept(Advertisement ad) {System.out.println(ad);}});
		
		new ConsumerExample().processAdvertisements(ads, ad -> ad.getAdvertisementIndustry() == AdvertisementIndustry.CONSUMER_GOODS, ad -> System.out.print(ad));
		
		new ConsumerExample().processAllAdvertisements(ads, ad -> System.out.println(ad.getCompanyName()));

	}
	
}
