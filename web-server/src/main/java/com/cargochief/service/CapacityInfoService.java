package com.cargochief.service;

import com.cargochief.controller.domain.CapacityInfo;

public interface CapacityInfoService {

	Iterable<CapacityInfo> findAllCapacities();
	CapacityInfo findOne(Long id);
}
