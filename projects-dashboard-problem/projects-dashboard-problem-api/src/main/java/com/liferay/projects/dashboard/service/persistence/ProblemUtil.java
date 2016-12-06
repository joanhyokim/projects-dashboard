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

package com.liferay.projects.dashboard.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.liferay.projects.dashboard.model.Problem;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the problem service. This utility wraps {@link com.liferay.projects.dashboard.service.persistence.impl.ProblemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Howie Chou
 * @see ProblemPersistence
 * @see com.liferay.projects.dashboard.service.persistence.impl.ProblemPersistenceImpl
 * @generated
 */
@ProviderType
public class ProblemUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Problem problem) {
		getPersistence().clearCache(problem);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Problem> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Problem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Problem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Problem> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Problem update(Problem problem) {
		return getPersistence().update(problem);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Problem update(Problem problem, ServiceContext serviceContext) {
		return getPersistence().update(problem, serviceContext);
	}

	/**
	* Caches the problem in the entity cache if it is enabled.
	*
	* @param problem the problem
	*/
	public static void cacheResult(Problem problem) {
		getPersistence().cacheResult(problem);
	}

	/**
	* Caches the problems in the entity cache if it is enabled.
	*
	* @param problems the problems
	*/
	public static void cacheResult(List<Problem> problems) {
		getPersistence().cacheResult(problems);
	}

	/**
	* Creates a new problem with the primary key. Does not add the problem to the database.
	*
	* @param problemId the primary key for the new problem
	* @return the new problem
	*/
	public static Problem create(long problemId) {
		return getPersistence().create(problemId);
	}

	/**
	* Removes the problem with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param problemId the primary key of the problem
	* @return the problem that was removed
	* @throws NoSuchProblemException if a problem with the primary key could not be found
	*/
	public static Problem remove(long problemId)
		throws com.liferay.projects.dashboard.exception.NoSuchProblemException {
		return getPersistence().remove(problemId);
	}

	public static Problem updateImpl(Problem problem) {
		return getPersistence().updateImpl(problem);
	}

	/**
	* Returns the problem with the primary key or throws a {@link NoSuchProblemException} if it could not be found.
	*
	* @param problemId the primary key of the problem
	* @return the problem
	* @throws NoSuchProblemException if a problem with the primary key could not be found
	*/
	public static Problem findByPrimaryKey(long problemId)
		throws com.liferay.projects.dashboard.exception.NoSuchProblemException {
		return getPersistence().findByPrimaryKey(problemId);
	}

	/**
	* Returns the problem with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param problemId the primary key of the problem
	* @return the problem, or <code>null</code> if a problem with the primary key could not be found
	*/
	public static Problem fetchByPrimaryKey(long problemId) {
		return getPersistence().fetchByPrimaryKey(problemId);
	}

	public static java.util.Map<java.io.Serializable, Problem> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the problems.
	*
	* @return the problems
	*/
	public static List<Problem> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the problems.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProblemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of problems
	* @param end the upper bound of the range of problems (not inclusive)
	* @return the range of problems
	*/
	public static List<Problem> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the problems.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProblemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of problems
	* @param end the upper bound of the range of problems (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of problems
	*/
	public static List<Problem> findAll(int start, int end,
		OrderByComparator<Problem> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the problems.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProblemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of problems
	* @param end the upper bound of the range of problems (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of problems
	*/
	public static List<Problem> findAll(int start, int end,
		OrderByComparator<Problem> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the problems from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of problems.
	*
	* @return the number of problems
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ProblemPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProblemPersistence, ProblemPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ProblemPersistence.class);
}