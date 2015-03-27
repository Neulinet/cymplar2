SELECT cd.contactId, cd.contactdatamethodid as methodId, cdt.value AS contactName, e.enterpriseId, e.name as enterpriseName,

(SELECT contractId 
 FROM crm_report 
 WHERE organizationId = ? 
 AND userId = ? 
 AND enterpriseId = e.enterpriseId 
 AND contactId = abc.contactId 
 AND reportDate = (SELECT MAX(reportDate) 
                   FROM crm_report 
                   WHERE organizationId = ? 
                   AND userId = ? 
                   AND enterpriseId = e.enterpriseId 
                   AND contactId = abc.contactId) 
                   LIMIT 1) 
AS contractId,

(SELECT reportId 
 FROM crm_report 
 WHERE organizationId = ? 
 AND userId = ? 
 AND enterpriseId = e.enterpriseId 
 AND contactId = abc.contactId 
 AND reportDate = (SELECT MAX(reportDate) 
                   FROM crm_report 
                   WHERE organizationId = ? 
                   AND userId = ? 
                   AND enterpriseId = e.enterpriseId 
                   AND contactId = abc.contactId) 
                   LIMIT 1) 
AS reportId,

(SELECT status 
 FROM crm_report 
 WHERE organizationId = ? 
 AND userId = ? 
 AND enterpriseId = e.enterpriseId 
 AND contactId = abc.contactId 
 AND reportDate = (SELECT MAX(reportDate) 
                   FROM crm_report 
                   WHERE organizationId = ? 
                   AND userId = ? 
                   AND enterpriseId = e.enterpriseId 
                   AND contactId = abc.contactId)
                   LIMIT 1) 
AS status,

(SELECT progress
 FROM crm_report
 WHERE organizationId = ?
 AND userId = ?
 AND enterpriseId = e.enterpriseId
 AND contactId = abc.contactId
 AND reportDate = (SELECT MAX(reportDate)
                   FROM crm_report
                   WHERE organizationId = ?
                   AND userId = ?
                   AND enterpriseId = e.enterpriseId 
                   AND contactId = abc.contactId) 
                   LIMIT 1) 
AS progress,

(SELECT c.description 
 FROM crm_report r 
 JOIN crm_contract c ON r.contractId = c.contractId 
 WHERE r.organizationId = ? 
 AND r.userId = ? 
 AND r.enterpriseId = e.enterpriseId 
 AND r.contactId = abc.contactId 
 AND reportDate = (SELECT MAX(reportDate) 
                   FROM crm_report 
                   WHERE organizationId = ? 
                   AND userId = ? 
                   AND enterpriseId = e.enterpriseId 
                   AND contactId = abc.contactId) 
                   LIMIT 1) 
AS description

FROM User_ u 
JOIN CRM_AddressBookUser abu ON u.userId = abu.userId
JOIN CRM_AddressBookContactData abcd ON abu.addressBookId = abcd.addressBookId
JOIN CRM_AddressBookContact abc ON abu.addressBookId = abc.addressBookId
JOIN CRM_ContactData cd ON abc.contactId = cd.contactId AND abcd.contactDataId = cd.contactDataId
LEFT JOIN CRM_ContactDataText cdt ON cd.contactDataId = cdt.contactDataId
LEFT JOIN CRM_ContactDataRef cdr ON cd.contactDataId = cdr.contactDataId
LEFT JOIN CRM_Enterprise e ON cdr.refValue = e.enterpriseId
WHERE abu.userid = ? 
AND cd.contactdatamethodid IN (204,205) 
LIMIT ? 
OFFSET ?