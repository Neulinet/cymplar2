SELECT abc.contactid, u.emailAddress, cd.contactdataid, cd.contactdatamethodid as methodId, cdt.value as contactName, e.name as enterpriseName
FROM User_ u 
JOIN CRM_AddressBookUser abu ON u.userId = abu.userId
JOIN CRM_AddressBookContactData abcd ON abu.addressBookId = abcd.addressBookId
JOIN CRM_AddressBookContact abc ON abu.addressBookId = abc.addressBookId
JOIN CRM_ContactData cd ON abc.contactId = cd.contactId AND abcd.contactDataId = cd.contactDataId
LEFT JOIN CRM_ContactDataText cdt ON cd.contactDataId = cdt.contactDataId
LEFT JOIN CRM_ContactDataRef cdr ON cd.contactDataId = cdr.contactDataId
LEFT JOIN CRM_Enterprise e ON cdr.refValue = e.enterpriseId
WHERE abc.addressBookid IN (SELECT addressBookid FROM CRM_AddressBookUser abu JOIN users_orgs uo ON abu.userId=uo.userId WHERE uo.organizationId = ? AND uo.userId != ?)
AND cd.contactdatamethodid IN (204,205)