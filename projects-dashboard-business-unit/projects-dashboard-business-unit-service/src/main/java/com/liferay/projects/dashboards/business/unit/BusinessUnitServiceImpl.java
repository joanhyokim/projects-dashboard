package com.liferay.projects.dashboards.business.unit;

import com.liferay.projects.dashboards.business.unit.BusinessUnitService;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
	},
	service = BusinessUnitService.class
)
public class BusinessUnitServiceImpl implements BusinessUnitService {
}