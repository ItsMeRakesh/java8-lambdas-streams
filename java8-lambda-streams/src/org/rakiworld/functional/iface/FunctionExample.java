package org.rakiworld.functional.iface;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.rakiworld.domain.Advertisement;
import org.rakiworld.domain.AdvertisementBuilder;

public class FunctionExample {

	public void processAllAdvertisements(List<Advertisement> ads, Function<Advertisement, String> adMapper,
			Consumer<String> consumer) {
		for (Advertisement advertisement : ads) {
			String s = adMapper.apply(advertisement);
			consumer.accept(s);
		}
	}

	public static void main(String[] args) {
		List<Advertisement> ads = AdvertisementBuilder.buildSampleAdvertisements();
		new FunctionExample().processAllAdvertisements(ads, ad -> ad.getCompanyName(),
				companyName -> System.out.println(companyName));

	}

}
