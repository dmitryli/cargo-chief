package com.cargochief.repository;

import org.springframework.data.repository.CrudRepository;

import com.cargochief.controller.domain.CarrierInfo;

/*
 * Dima: This is an interface that will access the database using JPA to fetch info from CC_CARRIER_INFO
 */

public interface CarrierInfoRepository extends CrudRepository<CarrierInfo, Long> {

}
