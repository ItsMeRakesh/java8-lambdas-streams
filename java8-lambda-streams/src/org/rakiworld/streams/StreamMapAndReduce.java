package org.rakiworld.streams;

import java.util.List;

import org.rakiworld.domain.Advertisement;
import org.rakiworld.domain.AdvertisementBuilder;

public class StreamMapAndReduce {

	public static void main(String[] args) {
		List<Advertisement> ads = AdvertisementBuilder.buildSampleAdvertisements();

		// Find out total cost of all advertisements
		Double totalCost = ads.stream()
								.mapToDouble(Advertisement::getCost)
								.sum();
		System.out.println("Total Cost:" + totalCost);
		
		totalCost = ads.stream()
				.mapToDouble(Advertisement::getCost)
				.reduce(0,(accumulator, nextVal) -> accumulator + nextVal);
		// totalCost = ads.stream()
//						.mapToDouble(Advertisement::getCost)
	//					.reduce(0,Double::sum);
		System.out.println("Total Cost with Reduce function:" + totalCost);
	}
}