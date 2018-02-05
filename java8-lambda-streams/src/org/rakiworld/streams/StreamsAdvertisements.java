package org.rakiworld.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.rakiworld.domain.Advertisement;
import org.rakiworld.domain.AdvertisementBuilder;
import org.rakiworld.domain.AdvertisementIndustry;

public class StreamsAdvertisements {

	public static void main(String[] args) {
		List<Advertisement> ads = AdvertisementBuilder.buildSampleAdvertisements();

		//Get List of ads related to JEWELLERY industry and whose id is greater then 10 and sort them based on cost
		List<Advertisement> jewelleryAdds = ads.stream()
											   .filter(ad -> ad.getAdvertisementIndustry() == AdvertisementIndustry.JEWELLERY)
											   .filter(ad -> ad.getId() > 10d)
											   .sorted(Comparator.comparing(Advertisement::getCost))
											   .collect(Collectors.toList());

		System.out.println(jewelleryAdds);
		
		//What if i want to change order from Ascending to descending
		jewelleryAdds = ads.stream()
				   .filter(ad -> ad.getAdvertisementIndustry() == AdvertisementIndustry.JEWELLERY)
				   .filter(ad -> ad.getId() > 10d)
				   .sorted(Comparator.comparing(Advertisement::getCost).reversed()) //changed order here
				   .collect(Collectors.toList());
		
		//Get total industry wise total cost
		Map<AdvertisementIndustry, Double> industryWiseCost = ads.stream()
					.collect(Collectors.groupingBy(Advertisement::getAdvertisementIndustry, Collectors.summingDouble(Advertisement::getCost)));
		//.collect(Collectors.toMap(Advertisement::getAdvertisementIndustry, Advertisement::getCost)); //Wont' work
		System.out.println(industryWiseCost);
	}
}
