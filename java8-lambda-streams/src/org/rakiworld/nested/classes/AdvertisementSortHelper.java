package org.rakiworld.nested.classes;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.rakiworld.domain.Advertisement;
import org.rakiworld.domain.AdvertisementBuilder;

public class AdvertisementSortHelper {
	
	static class AdvertisementByIdComparator implements Comparator<Advertisement> {
		@Override
		public int compare(Advertisement o1, Advertisement o2) {
			return o1.getId().compareTo(o2.getId());
		}
	}
	
	public static Comparator<Advertisement> advertisementByActorNameComparator( ) {
		Comparator<Advertisement> comparator = new Comparator<Advertisement>() {
			@Override
			public int compare(Advertisement o1, Advertisement o2) {
				return o1.getLeadActorName().compareTo(o2.getLeadActorName());
			}
		};
		return comparator;
	}
	
	
	public static void main(String[] args) {
		//Using inner class. Sort by Id
		List<Advertisement> ads = AdvertisementBuilder.buildSampleAdvertisements();
		Collections.sort(ads, new AdvertisementSortHelper.AdvertisementByIdComparator()  );
		System.out.println("--------- By Id -------------------");
		System.out.println(ads);

		
/*		//Using anonymous class in method call. Sort by Actor name
		System.out.println("--------- By Actor Name -------------------");
		Collections.sort(ads, AdvertisementSortHelper.advertisementByActorNameComparator() );
		System.out.println(ads);*/
		
		
		//Using anonymous class in method call. Sort by Actor name
		System.out.println("--------- By Actor Name another way-------------------");
		Collections.sort(ads, new Comparator<Advertisement>() {
			@Override
			public int compare(Advertisement o1, Advertisement o2) {
				return o1.getLeadActorName().compareTo(o2.getLeadActorName());
			}});
		System.out.println(ads);
		
		//start using lambdas
		Comparator<Advertisement> firstLambdaComparator = (Advertisement o1, Advertisement o2) -> {return o1.getLeadActorName().compareTo(o2.getLeadActorName());} ;
		Collections.sort(ads, firstLambdaComparator);
		System.out.println(ads);
		
	}
 
}
