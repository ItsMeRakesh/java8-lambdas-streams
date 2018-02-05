package org.rakiworld.method.reference;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.rakiworld.domain.Advertisement;
import org.rakiworld.domain.AdvertisementBuilder;
import org.rakiworld.domain.AdvertisementIndustry;

public class MethodReferenceExample {
	
	public void processAllAdvertisements(List<Advertisement> ads, Consumer<Advertisement> adConsumer) {
		for (Advertisement advertisement : ads) {
				adConsumer.accept(advertisement);
		}
	}

	public static void main(String[] args) {
		List<Advertisement> ads = AdvertisementBuilder.buildSampleAdvertisements();
		new MethodReferenceExample().processAllAdvertisements(ads, ad -> System.out.print(ad));
		
		/*Instead of using
		AN ANONYMOUS CLASS
		you can use
		A LAMBDA EXPRESSION
		And if this just calls one method, you can use
		A METHOD REFERENCE*/
		new MethodReferenceExample().processAllAdvertisements(ads, System.out::print);
		
		
		Consumer<String> consumer = s -> System.out.println(s);
		consumer.accept("Hello Universe");
		
		Consumer<String> anotherConsumer = System.out::println;
		anotherConsumer.accept("Hello Universe");
		
		
		Function<Advertisement, AdvertisementIndustry>  advertisementFunc = ad -> ad.getAdvertisementIndustry(); 
		Collections.sort(ads, Comparator.comparing(advertisementFunc));
		Collections.sort(ads, Comparator.comparing(Advertisement::getAdvertisementIndustry));
	}
}
