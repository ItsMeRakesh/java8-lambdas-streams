package org.rakiworld.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.rakiworld.domain.Advertisement;
import org.rakiworld.domain.AdvertisementBuilder;
import org.rakiworld.domain.AdvertisementIndustry;

public class LambdaExample {

	public static void main(String[] args) {

		// General Lambda syntax
		// (ArgumentType arg1, ArgumentType arg2 .....) -> {Statements needs to be
		// executed in body}

		List<Advertisement> ads = AdvertisementBuilder.buildSampleAdvertisements();
		// Sort in descending order
		Comparator<Advertisement> firstLambdaComparator = (Advertisement o1, Advertisement o2) -> {
			return o2.getLeadActorName().compareTo(o1.getLeadActorName());
		};
		Collections.sort(ads, firstLambdaComparator);
		System.out.println(ads);

		// Instead of variable. Let's use it directly
		Collections.sort(ads, (Advertisement o1, Advertisement o2) -> {
			return o1.getLeadActorName().compareTo(o2.getLeadActorName());
		});

		// Parameters that are being passed to function can be identified from context
		Collections.sort(ads, (o1, o2) -> {
			return o1.getLeadActorName().compareTo(o2.getLeadActorName());
		});

		// Curly braces are optional if there is only one statement
		Collections.sort(ads, (o1, o2) -> o1.getLeadActorName().compareTo(o2.getLeadActorName()));

		// Let's print all advertisements belongs to JEWELLERY industry
		//Java-7 style
		LambdaExample example = new LambdaExample();
		example.printFilteredAdvertisements(ads, new AdvertisementFilter() {
			@Override
			public boolean filter(Advertisement ad) {
				return ad.getAdvertisementIndustry() == AdvertisementIndustry.JEWELLERY;
			}
		});
		
		//Java-8 using lambdas
		System.out.println("~~~~~~~~~~~~~~~ With Lambdas ~~~~~~~~~~~~~~~");
		example.printFilteredAdvertisements(ads, (advertisement) ->  advertisement.getAdvertisementIndustry() == AdvertisementIndustry.JEWELLERY);
		
		//Parenthesis are optional if there is only one parameter
		example.printFilteredAdvertisements(ads, advertisement ->  advertisement.getAdvertisementIndustry() == AdvertisementIndustry.JEWELLERY);
	}

	private interface AdvertisementFilter {
		boolean filter(Advertisement ad);
	}

	public void printFilteredAdvertisements(List<Advertisement> ads, AdvertisementFilter adFilter) {
		for (Advertisement advertisement : ads) {
			if (adFilter.filter(advertisement)) {
				System.out.print(advertisement);
			}
		}
	}

}
