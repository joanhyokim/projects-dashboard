create table PD_BusinessUnit (
	uuid_ VARCHAR(75) null,
	businessUnitId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null
);

create table PD_ProjectBU (
	uuid_ VARCHAR(75) null,
	businessUnitId LONG not null,
	projectId LONG not null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	type_ VARCHAR(75) null,
	primary key (businessUnitId, projectId)
);