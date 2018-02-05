package org.rakiworld.domain;

public class Advertisement {
	private String companyName;
	private String leadActorName;
	private Double cost;
	private AdvertisementIndustry advertisementIndustry;
	private Long id;

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((advertisementIndustry == null) ? 0 : advertisementIndustry.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((leadActorName == null) ? 0 : leadActorName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Advertisement other = (Advertisement) obj;
		if (advertisementIndustry != other.advertisementIndustry)
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (leadActorName == null) {
			if (other.leadActorName != null)
				return false;
		} else if (!leadActorName.equals(other.leadActorName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Advertisement [companyName=" + companyName + ", leadActorName=" + leadActorName + ", cost=" + cost
				+ ", advertisementIndustry=" + advertisementIndustry + ", id=" + id + "]\n";
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getLeadActorName() {
		return leadActorName;
	}


	public void setLeadActorName(String leadActorName) {
		this.leadActorName = leadActorName;
	}


	public Double getCost() {
		return cost;
	}


	public void setCost(Double cost) {
		this.cost = cost;
	}


	public AdvertisementIndustry getAdvertisementIndustry() {
		return advertisementIndustry;
	}


	public void setAdvertisementIndustry(AdvertisementIndustry advertisementIndustry) {
		this.advertisementIndustry = advertisementIndustry;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public static void main(String[] args) {
		Advertisement ad = new Advertisement();
		ad.setAdvertisementIndustry(AdvertisementIndustry.CONSUMER_GOODS);
		ad.setCompanyName("McDonald");
		ad.setCost(1000000d);
		ad.setLeadActorName("PK");
		ad.setId(1L);
		System.out.println(ad);		
	}
}
