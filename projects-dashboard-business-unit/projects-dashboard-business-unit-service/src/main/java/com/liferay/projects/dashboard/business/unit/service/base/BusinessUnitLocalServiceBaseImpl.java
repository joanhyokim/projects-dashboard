/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.projects.dashboard.business.unit.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.liferay.projects.dashboard.business.unit.model.BusinessUnit;
import com.liferay.projects.dashboard.business.unit.service.BusinessUnitLocalService;
import com.liferay.projects.dashboard.business.unit.service.persistence.BusinessUnitPersistence;
import com.liferay.projects.dashboard.business.unit.service.persistence.ProjectBUPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the business unit local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.projects.dashboard.business.unit.service.impl.BusinessUnitLocalServiceImpl}.
 * </p>
 *
 * @author Yury Butrymovich
 * @see com.liferay.projects.dashboard.business.unit.service.impl.BusinessUnitLocalServiceImpl
 * @see com.liferay.projects.dashboard.business.unit.service.BusinessUnitLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class BusinessUnitLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements BusinessUnitLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.projects.dashboard.business.unit.service.BusinessUnitLocalServiceUtil} to access the business unit local service.
	 */

	/**
	 * Adds the business unit to the database. Also notifies the appropriate model listeners.
	 *
	 * @param businessUnit the business unit
	 * @return the business unit that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public BusinessUnit addBusinessUnit(BusinessUnit businessUnit) {
		businessUnit.setNew(true);

		return businessUnitPersistence.update(businessUnit);
	}

	/**
	 * Creates a new business unit with the primary key. Does not add the business unit to the database.
	 *
	 * @param businessUnitId the primary key for the new business unit
	 * @return the new business unit
	 */
	@Override
	public BusinessUnit createBusinessUnit(long businessUnitId) {
		return businessUnitPersistence.create(businessUnitId);
	}

	/**
	 * Deletes the business unit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param businessUnitId the primary key of the business unit
	 * @return the business unit that was removed
	 * @throws PortalException if a business unit with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public BusinessUnit deleteBusinessUnit(long businessUnitId)
		throws PortalException {
		return businessUnitPersistence.remove(businessUnitId);
	}

	/**
	 * Deletes the business unit from the database. Also notifies the appropriate model listeners.
	 *
	 * @param businessUnit the business unit
	 * @return the business unit that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public BusinessUnit deleteBusinessUnit(BusinessUnit businessUnit) {
		return businessUnitPersistence.remove(businessUnit);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(BusinessUnit.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return businessUnitPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.projects.dashboard.business.unit.model.impl.BusinessUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return businessUnitPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.projects.dashboard.business.unit.model.impl.BusinessUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return businessUnitPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return businessUnitPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return businessUnitPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public BusinessUnit fetchBusinessUnit(long businessUnitId) {
		return businessUnitPersistence.fetchByPrimaryKey(businessUnitId);
	}

	/**
	 * Returns the business unit with the matching UUID and company.
	 *
	 * @param uuid the business unit's UUID
	 * @param companyId the primary key of the company
	 * @return the matching business unit, or <code>null</code> if a matching business unit could not be found
	 */
	@Override
	public BusinessUnit fetchBusinessUnitByUuidAndCompanyId(String uuid,
		long companyId) {
		return businessUnitPersistence.fetchByUuid_C_First(uuid, companyId, null);
	}

	/**
	 * Returns the business unit with the primary key.
	 *
	 * @param businessUnitId the primary key of the business unit
	 * @return the business unit
	 * @throws PortalException if a business unit with the primary key could not be found
	 */
	@Override
	public BusinessUnit getBusinessUnit(long businessUnitId)
		throws PortalException {
		return businessUnitPersistence.findByPrimaryKey(businessUnitId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(businessUnitLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(BusinessUnit.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("businessUnitId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(businessUnitLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(BusinessUnit.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"businessUnitId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(businessUnitLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(BusinessUnit.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("businessUnitId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {
		final ExportActionableDynamicQuery exportActionableDynamicQuery = new ExportActionableDynamicQuery() {
				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary = portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(stagedModelType,
						modelAdditionCount);

					long modelDeletionCount = ExportImportHelperUtil.getModelDeletionCount(portletDataContext,
							stagedModelType);

					manifestSummary.addModelDeletionCount(stagedModelType,
						modelDeletionCount);

					return modelAdditionCount;
				}
			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(new ActionableDynamicQuery.AddCriteriaMethod() {
				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(dynamicQuery,
						"modifiedDate");
				}
			});

		exportActionableDynamicQuery.setCompanyId(portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<BusinessUnit>() {
				@Override
				public void performAction(BusinessUnit businessUnit)
					throws PortalException {
					StagedModelDataHandlerUtil.exportStagedModel(portletDataContext,
						businessUnit);
				}
			});
		exportActionableDynamicQuery.setStagedModelType(new StagedModelType(
				PortalUtil.getClassNameId(BusinessUnit.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return businessUnitLocalService.deleteBusinessUnit((BusinessUnit)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return businessUnitPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the business unit with the matching UUID and company.
	 *
	 * @param uuid the business unit's UUID
	 * @param companyId the primary key of the company
	 * @return the matching business unit
	 * @throws PortalException if a matching business unit could not be found
	 */
	@Override
	public BusinessUnit getBusinessUnitByUuidAndCompanyId(String uuid,
		long companyId) throws PortalException {
		return businessUnitPersistence.findByUuid_C_First(uuid, companyId, null);
	}

	/**
	 * Returns a range of all the business units.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.projects.dashboard.business.unit.model.impl.BusinessUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of business units
	 * @param end the upper bound of the range of business units (not inclusive)
	 * @return the range of business units
	 */
	@Override
	public List<BusinessUnit> getBusinessUnits(int start, int end) {
		return businessUnitPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of business units.
	 *
	 * @return the number of business units
	 */
	@Override
	public int getBusinessUnitsCount() {
		return businessUnitPersistence.countAll();
	}

	/**
	 * Updates the business unit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param businessUnit the business unit
	 * @return the business unit that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public BusinessUnit updateBusinessUnit(BusinessUnit businessUnit) {
		return businessUnitPersistence.update(businessUnit);
	}

	/**
	 * Returns the business unit local service.
	 *
	 * @return the business unit local service
	 */
	public BusinessUnitLocalService getBusinessUnitLocalService() {
		return businessUnitLocalService;
	}

	/**
	 * Sets the business unit local service.
	 *
	 * @param businessUnitLocalService the business unit local service
	 */
	public void setBusinessUnitLocalService(
		BusinessUnitLocalService businessUnitLocalService) {
		this.businessUnitLocalService = businessUnitLocalService;
	}

	/**
	 * Returns the business unit persistence.
	 *
	 * @return the business unit persistence
	 */
	public BusinessUnitPersistence getBusinessUnitPersistence() {
		return businessUnitPersistence;
	}

	/**
	 * Sets the business unit persistence.
	 *
	 * @param businessUnitPersistence the business unit persistence
	 */
	public void setBusinessUnitPersistence(
		BusinessUnitPersistence businessUnitPersistence) {
		this.businessUnitPersistence = businessUnitPersistence;
	}

	/**
	 * Returns the project b u local service.
	 *
	 * @return the project b u local service
	 */
	public com.liferay.projects.dashboard.business.unit.service.ProjectBULocalService getProjectBULocalService() {
		return projectBULocalService;
	}

	/**
	 * Sets the project b u local service.
	 *
	 * @param projectBULocalService the project b u local service
	 */
	public void setProjectBULocalService(
		com.liferay.projects.dashboard.business.unit.service.ProjectBULocalService projectBULocalService) {
		this.projectBULocalService = projectBULocalService;
	}

	/**
	 * Returns the project b u persistence.
	 *
	 * @return the project b u persistence
	 */
	public ProjectBUPersistence getProjectBUPersistence() {
		return projectBUPersistence;
	}

	/**
	 * Sets the project b u persistence.
	 *
	 * @param projectBUPersistence the project b u persistence
	 */
	public void setProjectBUPersistence(
		ProjectBUPersistence projectBUPersistence) {
		this.projectBUPersistence = projectBUPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.liferay.projects.dashboard.business.unit.model.BusinessUnit",
			businessUnitLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.projects.dashboard.business.unit.model.BusinessUnit");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return BusinessUnitLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return BusinessUnit.class;
	}

	protected String getModelClassName() {
		return BusinessUnit.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = businessUnitPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = BusinessUnitLocalService.class)
	protected BusinessUnitLocalService businessUnitLocalService;
	@BeanReference(type = BusinessUnitPersistence.class)
	protected BusinessUnitPersistence businessUnitPersistence;
	@BeanReference(type = com.liferay.projects.dashboard.business.unit.service.ProjectBULocalService.class)
	protected com.liferay.projects.dashboard.business.unit.service.ProjectBULocalService projectBULocalService;
	@BeanReference(type = ProjectBUPersistence.class)
	protected ProjectBUPersistence projectBUPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}