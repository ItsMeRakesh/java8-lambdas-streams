package org.rakiworld.functional.iface;

import org.rakiworld.domain.Advertisement;
import org.rakiworld.domain.AdvertisementIndustry;

public interface Java8Interface {

	boolean filter(Advertisement ad);

	// Final method implementation. No one can override this
	static boolean advertisementIndustryFilter(Advertisement ad) {
		return ad.getAdvertisementIndustry() == AdvertisementIndustry.AUTOMOBILES;
	}

	// Default method implementation
	default boolean anotherFilter(Advertisement ad) {
		return false;
	}
}
