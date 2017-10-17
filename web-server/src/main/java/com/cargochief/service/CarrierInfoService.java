package com.cargochief.service;

import com.cargochief.controller.domain.CarrierInfo;

public interface CarrierInfoService {

	Iterable<CarrierInfo> findAllCarriers();
	CarrierInfo findOne(Long id);
}
