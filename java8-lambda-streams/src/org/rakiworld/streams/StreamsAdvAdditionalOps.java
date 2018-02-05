package org.rakiworld.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.rakiworld.domain.Advertisement;
import org.rakiworld.domain.AdvertisementBuilder;
import org.rakiworld.domain.AdvertisementIndustry;

public class StreamsAdvAdditionalOps {

	public static void main(String[] args) {
		List<Advertisement> ads = AdvertisementBuilder.buildSampleAdvertisements();

		//Top two advertisement by cost
		List<Advertisement> topAds = ads.stream().sorted(Comparator.comparing(Advertisement::getCost).reversed()).limit(2).collect(Collectors.toList());
		System.out.println(topAds);
	
		//Get all different Advertisement industries
		List<AdvertisementIndustry> adIndstries = ads.stream().map(Advertisement::getAdvertisementIndustry).distinct().collect(Collectors.toList());
		System.out.println(adIndstries);
		
		
		//Number of Jewellery ads
		long noOfJewelleryAds = ads.parallelStream().filter(ad -> ad.getAdvertisementIndustry() == AdvertisementIndustry.JEWELLERY).count();
		System.out.println(noOfJewelleryAds);
		
		//Is there any ad related to aviation
		boolean adExists = ads.stream().anyMatch(ad -> ad.getAdvertisementIndustry() == AdvertisementIndustry.AVIATION);
		System.out.println(adExists);
	}
}
