package com.cargochief.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cargochief.controller.domain.SearchLoadResult;
import com.cargochief.repository.SearchRepository;

@Service
public class SearchServiceImpl implements SearchService{

	@Autowired
	private SearchRepository searchRepository = null;

	public List<SearchLoadResult> findListings(String origin, String destination, long fleetSize, long fleetAge) {

		// if the format city,state is not honored, throw an error
		if (!origin.contains(",") || !destination.contains(",")) {
			throw new RuntimeException("The format for origin or destination of city,state is incorrect");
		}

		// parse the paramenters 
		String res[] = origin.split(",");
		String originCity = res[0];
		String originState = res[1];
		String originZip = res[2];

		res = destination.split(",");
		String destCity = res[0];
		String destState = res[1];
		String destZip = res[2];

		List<SearchLoadResult> list = findPotentialMatchesBasedOnOriginAndDestiation(originCity, originState, originZip, destCity,
				destState, destZip);
		
		list = processExtraInfo(list);
		return list;

	}

	// TODO implement the logic for rankings
	private List<SearchLoadResult> processExtraInfo(List<SearchLoadResult> list) {
		return list;
	}

	// Call the repository to fetch the data
	private List<SearchLoadResult> findPotentialMatchesBasedOnOriginAndDestiation(String originCity, String originState, String originZip,
			String destCity, String destState, String destZip) {

		return searchRepository.findPotentialMatchesBasedOnOriginAndDestiation(originCity, originState, originZip, destCity,
				destState ,destZip);
	}
}
