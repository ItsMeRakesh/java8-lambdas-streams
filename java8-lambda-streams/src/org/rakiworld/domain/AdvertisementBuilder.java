package org.rakiworld.domain;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementBuilder {

	public static Advertisement build(Long id, String companyName, String leadActorName, 
			Double cost, AdvertisementIndustry adIndustry) {
		
		Advertisement ad = new Advertisement();
		ad.setAdvertisementIndustry(adIndustry);
		ad.setCompanyName(companyName);
		ad.setCost(cost);
		ad.setLeadActorName(leadActorName);
		ad.setId(id);
		return ad;
	}

	public static List<Advertisement> buildSampleAdvertisements() {
		List<Advertisement> ads = new ArrayList<>();
		ads.add(build(1l, "Malbar Gold and Diamonds", "Tamannaah Bhatia", 500000d, AdvertisementIndustry.JEWELLERY));
		ads.add(build(21l, "Manyavar", "Virat Kohli", 50000000d, AdvertisementIndustry.APPAREL));
		ads.add(build(43l, "Emirates", "Jennifer Aniston", 100000000d, AdvertisementIndustry.AVIATION));
		ads.add(build(52l, "Khazana Jewellers", "Kajal Aggarwal", 750000d, AdvertisementIndustry.JEWELLERY));
		ads.add(build(9l, "Maaza", "Samantha Akkineni", 5300000d, AdvertisementIndustry.CONSUMER_GOODS));
		ads.add(build(36l, "Kalyan Jewellers", "Nagarjuna Akkineni", 1000000d, AdvertisementIndustry.JEWELLERY));
		

		return ads;
	}
	
	public static void main(String[] args) {
		List<Advertisement> ads = AdvertisementBuilder.buildSampleAdvertisements();
		System.out.println(ads);
	}
}
