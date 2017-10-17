package com.cargochief.service;

import java.util.List;

import com.cargochief.controller.domain.SearchLoadResult;

public interface SearchService {

	public List<SearchLoadResult> findListings(String origin, String destination, long fleetSize, long fleetAge);

}
