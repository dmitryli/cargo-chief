package com.cargochief.controller.domain;


public class SearchLoadResult {

	private String carrierName = null;
	private String carrierMc = null;
	private String truckOrigin = null;
	private Long fleetSize = null;
	private Long fleetAge = null;
	private Long listingAge = null;
	private Integer matchScore = null;
	private Long milesDHO = null;
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public String getCarrierMc() {
		return carrierMc;
	}
	public void setCarrierMc(String carrierMc) {
		this.carrierMc = carrierMc;
	}
	public String getTruckOrigin() {
		return truckOrigin;
	}
	public void setTruckOrigin(String truckOrigin) {
		this.truckOrigin = truckOrigin;
	}
	public Long getFleetSize() {
		return fleetSize;
	}
	public void setFleetSize(Long fleetSize) {
		this.fleetSize = fleetSize;
	}
	public Long getFleetAge() {
		return fleetAge;
	}
	public void setFleetAge(Long fleetAge) {
		this.fleetAge = fleetAge;
	}
	public Long getListingAge() {
		return listingAge;
	}
	public void setListingAge(Long listingAge) {
		this.listingAge = listingAge;
	}
	public Integer getMatchScore() {
		return matchScore;
	}
	public void setMatchScore(Integer matchScore) {
		this.matchScore = matchScore;
	}
	public Long getMilesDHO() {
		return milesDHO;
	}
	public void setMilesDHO(Long milesDHO) {
		this.milesDHO = milesDHO;
	}
	
	
}
