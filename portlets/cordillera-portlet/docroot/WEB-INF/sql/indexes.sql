create index IX_3F66ED1E on crm_AddressBookContact (addressBookId);
create index IX_9FFBB66D on crm_AddressBookContact (addressBookId, contactId);
create index IX_5C330C1 on crm_AddressBookContact (contactId);

create index IX_3686F894 on crm_AddressBookContactData (addressBookId);
create index IX_33F29F01 on crm_AddressBookContactData (addressBookId, contactDataId);
create index IX_EE880101 on crm_AddressBookContactData (contactDataId);

create index IX_E4CD8BDD on crm_AddressBookContactDatas (addressBookId);
create index IX_9CCE944A on crm_AddressBookContactDatas (contactDataId);

create index IX_C9A5A8B4 on crm_AddressBookContactdata (addressBookId);
create index IX_81A6B121 on crm_AddressBookContactdata (contactDataId);

create index IX_F33028F7 on crm_AddressBookOrganization (organizationId);

create index IX_BE251F27 on crm_AddressBookUser (userId);

create index IX_DC90A535 on crm_Contact (enterpriseId);
create index IX_4BDC1847 on crm_Contact (organizationId);
create index IX_3C0D3B57 on crm_Contact (organizationId, enterpriseId);

create index IX_FC4FF594 on crm_ContactContract (contactId);
create index IX_F7687FF5 on crm_ContactContract (contactId, active_);
create index IX_EF2666D8 on crm_ContactContract (contractId);
create index IX_8118C473 on crm_ContactContract (contractId, contactId);

create index IX_63D71387 on crm_ContactData (contactDataMethodId);
create index IX_B8CB067C on crm_ContactData (contactId);
create index IX_11F5579A on crm_ContactData (contactId, contactDataMethodId);

create index IX_70366A2F on crm_ContactDataMethod (name);

create index IX_89735B32 on crm_Contract (contactId);
create index IX_3B6AB509 on crm_Contract (enterpriseId);
create index IX_5C71831B on crm_Contract (organizationId);
create index IX_6795232B on crm_Contract (organizationId, enterpriseId);
create index IX_BF52640 on crm_Contract (organizationId, enterpriseId, contactId);

create index IX_8DFBDB1A on crm_Enterprise (industry);
create index IX_8C4AF187 on crm_Enterprise (name);
create index IX_3B16526E on crm_Enterprise (taxid);

create index IX_C0D9C744 on crm_Industry (name);

create index IX_B1820DA1 on crm_NextFollowUpEvent (contractId);
create index IX_9FDB8143 on crm_NextFollowUpEvent (reportId);
create index IX_66F1CD29 on crm_NextFollowUpEvent (reportId, status);

create index IX_878F93D4 on crm_OrganizationContact (organizationId);

create index IX_18E589DC on crm_Report (contractId);
create index IX_87BED96B on crm_Report (enterpriseId);
create index IX_A0270800 on crm_Report (enterpriseId, contactId);
create index IX_1FDA0BA2 on crm_Report (enterpriseId, contactId, organizationId);
create index IX_E33839A3 on crm_Report (enterpriseId, contactId, organizationId, contractId);
create index IX_D65C603A on crm_Report (enterpriseId, contactId, userId);
create index IX_E44E16FD on crm_Report (organizationId);
create index IX_4372F695 on crm_Report (userId);

create index IX_951FAE71 on crm_UserContact (contactId);
create index IX_1836EDD4 on crm_UserContact (userId);

create index IX_88CEDA25 on crm_UserContract (contractId);
create index IX_6EE91EAB on crm_UserContract (contractId, accessLevel);
create index IX_CF19D35E on crm_UserContract (userId);
create index IX_5F5A856B on crm_UserContract (userId, active_);
create index IX_AE3E475F on crm_UserContract (userId, contractId);
create index IX_70F27FB1 on crm_UserContract (userId, contractId, accessLevel);

create index IX_1E873567 on crm_enterprise (name);