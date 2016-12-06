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

package com.liferay.projects.dashboard.business.unit.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.projects.dashboard.business.unit.model.ProjectBU;
import com.liferay.projects.dashboard.business.unit.model.ProjectBUModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ProjectBU service. Represents a row in the &quot;PD_ProjectBU&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ProjectBUModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProjectBUImpl}.
 * </p>
 *
 * @author Yury Butrymovich
 * @see ProjectBUImpl
 * @see ProjectBU
 * @see ProjectBUModel
 * @generated
 */
@ProviderType
public class ProjectBUModelImpl extends BaseModelImpl<ProjectBU>
	implements ProjectBUModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a project b u model instance should use the {@link ProjectBU} interface instead.
	 */
	public static final String TABLE_NAME = "PD_ProjectBU";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "projectBUId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "businessUnitId", Types.BIGINT },
			{ "projectId", Types.BIGINT },
			{ "type_", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("projectBUId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("businessUnitId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("projectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table PD_ProjectBU (uuid_ VARCHAR(75) null,projectBUId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,businessUnitId LONG,projectId LONG,type_ VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table PD_ProjectBU";
	public static final String ORDER_BY_JPQL = " ORDER BY projectBU.type ASC";
	public static final String ORDER_BY_SQL = " ORDER BY PD_ProjectBU.type_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.projects.dashboard.business.unit.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.projects.dashboard.business.unit.model.ProjectBU"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.projects.dashboard.business.unit.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.projects.dashboard.business.unit.model.ProjectBU"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.projects.dashboard.business.unit.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.projects.dashboard.business.unit.model.ProjectBU"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long TYPE_COLUMN_BITMASK = 2L;
	public static final long UUID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.projects.dashboard.business.unit.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.projects.dashboard.business.unit.model.ProjectBU"));

	public ProjectBUModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _projectBUId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProjectBUId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectBUId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectBU.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectBU.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("projectBUId", getProjectBUId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("businessUnitId", getBusinessUnitId());
		attributes.put("projectId", getProjectId());
		attributes.put("type", getType());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long projectBUId = (Long)attributes.get("projectBUId");

		if (projectBUId != null) {
			setProjectBUId(projectBUId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long businessUnitId = (Long)attributes.get("businessUnitId");

		if (businessUnitId != null) {
			setBusinessUnitId(businessUnitId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getProjectBUId() {
		return _projectBUId;
	}

	@Override
	public void setProjectBUId(long projectBUId) {
		_projectBUId = projectBUId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getBusinessUnitId() {
		return _businessUnitId;
	}

	@Override
	public void setBusinessUnitId(long businessUnitId) {
		_businessUnitId = businessUnitId;
	}

	@Override
	public long getProjectId() {
		return _projectId;
	}

	@Override
	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	@Override
	public String getType() {
		if (_type == null) {
			return StringPool.BLANK;
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		_columnBitmask = -1L;

		if (_originalType == null) {
			_originalType = _type;
		}

		_type = type;
	}

	public String getOriginalType() {
		return GetterUtil.getString(_originalType);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ProjectBU.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ProjectBU.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProjectBU toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ProjectBU)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProjectBUImpl projectBUImpl = new ProjectBUImpl();

		projectBUImpl.setUuid(getUuid());
		projectBUImpl.setProjectBUId(getProjectBUId());
		projectBUImpl.setCompanyId(getCompanyId());
		projectBUImpl.setUserId(getUserId());
		projectBUImpl.setUserName(getUserName());
		projectBUImpl.setCreateDate(getCreateDate());
		projectBUImpl.setModifiedDate(getModifiedDate());
		projectBUImpl.setBusinessUnitId(getBusinessUnitId());
		projectBUImpl.setProjectId(getProjectId());
		projectBUImpl.setType(getType());

		projectBUImpl.resetOriginalValues();

		return projectBUImpl;
	}

	@Override
	public int compareTo(ProjectBU projectBU) {
		int value = 0;

		value = getType().compareToIgnoreCase(projectBU.getType());

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

		if (!(obj instanceof ProjectBU)) {
			return false;
		}

		ProjectBU projectBU = (ProjectBU)obj;

		long primaryKey = projectBU.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		ProjectBUModelImpl projectBUModelImpl = this;

		projectBUModelImpl._originalUuid = projectBUModelImpl._uuid;

		projectBUModelImpl._originalCompanyId = projectBUModelImpl._companyId;

		projectBUModelImpl._setOriginalCompanyId = false;

		projectBUModelImpl._setModifiedDate = false;

		projectBUModelImpl._originalType = projectBUModelImpl._type;

		projectBUModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ProjectBU> toCacheModel() {
		ProjectBUCacheModel projectBUCacheModel = new ProjectBUCacheModel();

		projectBUCacheModel.uuid = getUuid();

		String uuid = projectBUCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			projectBUCacheModel.uuid = null;
		}

		projectBUCacheModel.projectBUId = getProjectBUId();

		projectBUCacheModel.companyId = getCompanyId();

		projectBUCacheModel.userId = getUserId();

		projectBUCacheModel.userName = getUserName();

		String userName = projectBUCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			projectBUCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			projectBUCacheModel.createDate = createDate.getTime();
		}
		else {
			projectBUCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			projectBUCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			projectBUCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		projectBUCacheModel.businessUnitId = getBusinessUnitId();

		projectBUCacheModel.projectId = getProjectId();

		projectBUCacheModel.type = getType();

		String type = projectBUCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			projectBUCacheModel.type = null;
		}

		return projectBUCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", projectBUId=");
		sb.append(getProjectBUId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", businessUnitId=");
		sb.append(getBusinessUnitId());
		sb.append(", projectId=");
		sb.append(getProjectId());
		sb.append(", type=");
		sb.append(getType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.projects.dashboard.business.unit.model.ProjectBU");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectBUId</column-name><column-value><![CDATA[");
		sb.append(getProjectBUId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>businessUnitId</column-name><column-value><![CDATA[");
		sb.append(getBusinessUnitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectId</column-name><column-value><![CDATA[");
		sb.append(getProjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = ProjectBU.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			ProjectBU.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _projectBUId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _businessUnitId;
	private long _projectId;
	private String _type;
	private String _originalType;
	private long _columnBitmask;
	private ProjectBU _escapedModel;
}