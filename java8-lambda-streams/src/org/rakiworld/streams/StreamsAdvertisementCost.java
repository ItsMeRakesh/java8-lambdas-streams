package org.rakiworld.streams;

import java.util.List;

import org.rakiworld.domain.Advertisement;
import org.rakiworld.domain.AdvertisementBuilder;
import org.rakiworld.domain.AdvertisementIndustry;

public class StreamsAdvertisementCost {

	public static void main(String[] args) {
		List<Advertisement> ads = AdvertisementBuilder.buildSampleAdvertisements();

		// Filter out ads related to JEWELLERY industry and whose id is greater then 10
		// and calculate total cost
		double totalCost = 0d;
		for (Advertisement advertisement : ads) {
			if (advertisement.getAdvertisementIndustry() == AdvertisementIndustry.JEWELLERY) {
				if (advertisement.getId() > 10d)
					totalCost += advertisement.getCost();
			}
		}
		System.out.println("Total Cost:" + totalCost);

		totalCost = ads.stream()
						.filter(ad -> ad.getAdvertisementIndustry() == AdvertisementIndustry.JEWELLERY)
						.filter(ad -> ad.getId() > 10d)
						.mapToDouble(Advertisement::getCost)
						.sum();
		System.out.println("Total Cost with Lambdas:" + totalCost);

		//What will be output of it
		//Streams are lazy
		ads.stream()
		.filter(ad -> {System.out.println(ad);return ad.getAdvertisementIndustry() == AdvertisementIndustry.JEWELLERY;})
		.filter(ad -> ad.getId() > 10d)
		.mapToDouble(Advertisement::getCost);
		
		//Parallel streams
		ads.stream()
		.parallel()
		.filter(ad -> {System.out.println(Thread.currentThread().getName());return ad.getAdvertisementIndustry() == AdvertisementIndustry.JEWELLERY;})
		.filter(ad -> ad.getId() > 10d)
		.mapToDouble(Advertisement::getCost).sum();
	}

}
