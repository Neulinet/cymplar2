create table crm_AddressBook (
	addressBookId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	addressBookType LONG
);

create table crm_AddressBookContact (
	addressBookId LONG not null,
	contactId LONG not null,
	groupId LONG,
	companyId LONG,
	assignedTo LONG,
	currentProgress DOUBLE,
	primary key (addressBookId, contactId)
);

create table crm_AddressBookContactData (
	addressBookId LONG not null,
	contactDataId LONG not null,
	active_ BOOLEAN,
	primary key (addressBookId, contactDataId)
);

create table crm_AddressBookContactDatas (
	addressBookId LONG not null,
	contactDataId LONG not null,
	active_ BOOLEAN,
	primary key (addressBookId, contactDataId)
);

create table crm_AddressBookContactdata (
	addressBookId LONG not null,
	contactDataId LONG not null,
	active_ BOOLEAN,
	primary key (addressBookId, contactDataId)
);

create table crm_AddressBookOrganization (
	addressBookId LONG not null primary key,
	organizationId LONG
);

create table crm_AddressBookUser (
	addressBookId LONG not null primary key,
	userId LONG
);

create table crm_ColleagueAddressBookContact (
	contactid LONG not null,
	emailAddress VARCHAR(75) null,
	contactdataid LONG,
	methodId LONG not null,
	contactName VARCHAR(75) null,
	enterpriseName VARCHAR(75) null,
	primary key (contactid, methodId)
);

create table crm_Contact (
	contactId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table crm_ContactContract (
	contactId LONG not null,
	contractId LONG not null,
	active_ BOOLEAN,
	primary key (contactId, contractId)
);

create table crm_ContactData (
	contactDataId LONG not null primary key,
	groupId LONG,
	contactDataType INTEGER,
	readOnly BOOLEAN,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	contactDataMethodId LONG,
	contactId LONG
);

create table crm_ContactDataMethod (
	contactDataMethodId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	name VARCHAR(75) null,
	title VARCHAR(75) null,
	contactDataType INTEGER
);

create table crm_ContactDataPhone (
	contactDataId LONG not null primary key,
	extension VARCHAR(75) null,
	number_ VARCHAR(75) null
);

create table crm_ContactDataRef (
	contactDataId LONG not null primary key,
	refValue LONG
);

create table crm_ContactDataText (
	contactDataId LONG not null primary key,
	value VARCHAR(75) null
);

create table crm_Contract (
	contractId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	organizationId LONG,
	enterpriseId LONG,
	contactId LONG,
	description VARCHAR(75) null,
	amount DOUBLE
);

create table crm_Enterprise (
	enterpriseId LONG not null primary key,
	groupId LONG,
	isPrivate INTEGER,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(250) null,
	taxid VARCHAR(75) null,
	description VARCHAR(250) null,
	industry LONG,
	email VARCHAR(75) null
);

create table crm_Industry (
	industryId LONG not null primary key,
	groupId LONG,
	name VARCHAR(75) null
);

create table crm_MyAddressBookContact (
	contactId LONG not null,
	methodId LONG not null,
	contactName VARCHAR(75) null,
	enterpriseId LONG,
	enterpriseName VARCHAR(75) null,
	contractId LONG,
	reportId LONG,
	status INTEGER,
	progress DOUBLE,
	description VARCHAR(75) null,
	primary key (contactId, methodId)
);

create table crm_NextFollowUpEvent (
	eventId LONG not null primary key,
	eventDate DATE null,
	status INTEGER,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	createDate DATE null,
	ownerId LONG,
	contractId LONG,
	reportId LONG
);

create table crm_OrganizationContact (
	organizationId LONG not null,
	contactId LONG not null,
	groupId LONG,
	companyId LONG,
	primary key (organizationId, contactId)
);

create table crm_OrganizationIndustry (
	organizationId LONG not null,
	industryId LONG not null,
	primary key (organizationId, industryId)
);

create table crm_Report (
	reportId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	userId LONG,
	organizationId LONG,
	enterpriseId LONG,
	contactId LONG,
	contactDataId LONG,
	contactMethodId LONG,
	reportDate DATE null,
	comments VARCHAR(500) null,
	progress DOUBLE,
	status INTEGER,
	contractId LONG,
	cdNameId LONG
);

create table crm_UserContact (
	userId LONG not null,
	contactId LONG not null,
	groupId LONG,
	companyId LONG,
	primary key (userId, contactId)
);

create table crm_UserContract (
	userId LONG not null,
	contractId LONG not null,
	active_ BOOLEAN,
	accessLevel INTEGER,
	primary key (userId, contractId)
);

create table crm_contact (
	contactId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table crm_enterprise (
	enterpriseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null
);