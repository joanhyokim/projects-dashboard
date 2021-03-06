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

package com.liferay.projects.dashboard.business.unit.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Yury Butrymovich
 * @generated
 */
@ProviderType
public class ProjectBUPK implements Comparable<ProjectBUPK>, Serializable {
	public long businessUnitId;
	public long projectId;

	public ProjectBUPK() {
	}

	public ProjectBUPK(long businessUnitId, long projectId) {
		this.businessUnitId = businessUnitId;
		this.projectId = projectId;
	}

	public long getBusinessUnitId() {
		return businessUnitId;
	}

	public void setBusinessUnitId(long businessUnitId) {
		this.businessUnitId = businessUnitId;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	@Override
	public int compareTo(ProjectBUPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (businessUnitId < pk.businessUnitId) {
			value = -1;
		}
		else if (businessUnitId > pk.businessUnitId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (projectId < pk.projectId) {
			value = -1;
		}
		else if (projectId > pk.projectId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectBUPK)) {
			return false;
		}

		ProjectBUPK pk = (ProjectBUPK)obj;

		if ((businessUnitId == pk.businessUnitId) &&
				(projectId == pk.projectId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, businessUnitId);
		hashCode = HashUtil.hash(hashCode, projectId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("businessUnitId");
		sb.append(StringPool.EQUAL);
		sb.append(businessUnitId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("projectId");
		sb.append(StringPool.EQUAL);
		sb.append(projectId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}