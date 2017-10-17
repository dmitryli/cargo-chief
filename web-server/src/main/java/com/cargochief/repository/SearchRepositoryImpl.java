package com.cargochief.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cargochief.controller.domain.SearchLoadResult;

@Repository
public class SearchRepositoryImpl implements SearchRepository {

	private final static Logger log = LoggerFactory.getLogger(SearchRepositoryImpl.class);

	private final String QUERY = "select CRI.BUSINESS_NAME, CRI.FIRM_MC, CRI.HQ_CITY, CRI.FLEET_SIZE, CRI.FLEET_AGE, CPI.MINUTE_AGE "
			+ "from CC_CARRIER_INFO CRI INNER JOIN CC_CAPACITY_INFO CPI ON CPI.BUSINESS_NAME = CRI.BUSINESS_NAME "
			+ "WHERE CPI.ORIGIN_CITY = ? AND CPI.ORIGIN_STATE =? AND CPI.ORIGIN_ZIP=? AND CPI.DEST_CITY=? AND CPI.DEST_STATE=? AND CPI.DEST_ZIP = ?";
	@Autowired
	JdbcTemplate template = null;

	@Override
	public List<SearchLoadResult> findPotentialMatchesBasedOnOriginAndDestiation(String originCity, String originState,
			String originZip, String destCity, String destState, String destZip) {
		Object[] params = new Object[] { originCity, originState, originZip, destCity, destState, destZip };

		List<SearchLoadResult> list = template.query(QUERY, params, new RowMapper<SearchLoadResult>() {

			@Override
			public SearchLoadResult mapRow(ResultSet rs, int rownumber) throws SQLException {

				log.info("Hitting Results");

				SearchLoadResult re = new SearchLoadResult();

				re.setCarrierName(rs.getString("BUSINESS_NAME"));
				re.setCarrierMc(rs.getString("FIRM_MC"));
				re.setTruckOrigin(rs.getString("HQ_CITY"));
				re.setFleetSize(rs.getLong("FLEET_SIZE"));
				re.setFleetAge(rs.getLong("FLEET_AGE"));
				re.setMatchScore(rownumber + 1);
				re.setListingAge(rs.getLong("MINUTE_AGE") / 60);

				return re;

			}
		});

		return list;
	}

}
