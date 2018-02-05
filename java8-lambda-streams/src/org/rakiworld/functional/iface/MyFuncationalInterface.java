package org.rakiworld.functional.iface;

import java.util.List;

import org.rakiworld.domain.Advertisement;
import org.rakiworld.domain.AdvertisementBuilder;
import org.rakiworld.domain.AdvertisementIndustry;

public class MyFuncationalInterface {

	
	private interface AdvertisementFilter {
		boolean filter(Advertisement ad);
		
		//Lambda's will work with interface where only one abstract method is there
		//boolean greatFilter(Advertisement ad);
		
		/*
		//default methods
		default boolean anotherFilter(Advertisement ad) {
			return false;
		}*/
	}

	public void printFilteredAdvertisements(List<Advertisement> ads, AdvertisementFilter adFilter) {
		for (Advertisement advertisement : ads) {
			if (adFilter.filter(advertisement)) {
				System.out.print(advertisement);
			}
		}
	}
	
	public static void main(String[] args) {
		List<Advertisement> ads = AdvertisementBuilder.buildSampleAdvertisements();
		new MyFuncationalInterface().printFilteredAdvertisements(ads , advertisement ->  advertisement.getAdvertisementIndustry() == AdvertisementIndustry.JEWELLERY);
		
	}
}
