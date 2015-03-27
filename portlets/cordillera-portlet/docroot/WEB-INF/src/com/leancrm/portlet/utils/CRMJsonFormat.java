package com.leancrm.portlet.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.leancrm.portlet.entity.ContactEntity;
import com.leancrm.portlet.library.model.Enterprise;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Address;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

public class CRMJsonFormat {

	private static Logger logger = Logger.getLogger(CRMJsonFormat.class);
	
	public static void jsonResponse(ActionResponse actionResponse, String json) {
		try {
			HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
			PrintWriter out = response.getWriter();
			out.print( json.toString() );
			out.flush();
			out.close();
		} catch (IOException e) {
			logger.error("Unexpected error in json response.", e);	
		}
	}
	
	public static String generateJsonError(String error) {
		return generateJsonError(new String[] {error});
	}
	
	public static String generateJsonError(String[] errorList) {
		StringBuilder json = new StringBuilder();
		
		json.append("{\"errors\":[");
		boolean firstError = true;
		for (String error : errorList) {
			if (!firstError) {
				json.append(",");
			}
			json.append(error);
			
		}
		json.append("]}");
		
		return json.toString();
	}
	
	public static String getEnterpriseListAsJson(List<Enterprise> enterpriseList) {
		StringBuilder json = new StringBuilder();
		
		boolean firstEnterprise = true;
		json.append("{\"enterprises\":");
		json.append("[");
		for (Enterprise enterprise : enterpriseList) {
			if (!firstEnterprise) {
				json.append(",");
			}
			json.append("{");
			json.append("\"id\":\"" + enterprise.getEnterpriseId() + "\"");
			json.append(",");
			json.append("\"name\":\"" + enterprise.getName() + "\"");
			json.append(",");
			json.append("\"taxid\":\"" + enterprise.getTaxid() + "\"");
			json.append("}");
			
			firstEnterprise = false;
		}
		json.append("]");
		json.append("}");
		
		return json.toString();
	}
	
	public static String getContactDetailAsJson(ContactEntity contactEntity) throws SystemException {
		StringBuilder json = new StringBuilder();
		
		json.append("{");
		json.append("\"contact\":");
		json.append("{");
		
		json.append("\"contactId\":\"" + contactEntity.getContactId() + "\"");
		json.append(",");
		json.append("\"fullName\":\"" + contactEntity.getName() + "\"");
		json.append(",");
		json.append("\"position\":\"" + contactEntity.getPosition() + "\"");
		json.append(",");
		json.append("\"email\":\"" + contactEntity.getEmail() + "\"");
		json.append(",");
		json.append("\"personalEmail\":\"" + contactEntity.getPersonalEmail() + "\"");
		json.append(",");
		json.append("\"phone\":\"" + contactEntity.getPhone() + "\"");
		json.append(",");
		json.append("\"cellPhone\":\"" + contactEntity.getCellPhone() + "\"");
		json.append(",");
		json.append("\"skype\":\"" + contactEntity.getSkype() + "\"");
		
		json.append("}");
		json.append(",");
		
		json.append(getEnterpriseDetailAsJson(contactEntity.getEnterprise()));
		
		json.append("}");
		
		return json.toString();
	}
	
	public static String getEnterpriseDetailAsJson(Enterprise enterprise) throws SystemException {
		StringBuilder json = new StringBuilder();
		
		json.append("\"enterprise\":");
		json.append("{");
		
		// Enterprise Detail
		List<Address> addressList = AddressLocalServiceUtil.getAddresses(enterprise.getCompanyId(), Enterprise.class.getName(), enterprise.getEnterpriseId());
		
		json.append("\"enterpriseId\":\"" + enterprise.getEnterpriseId() + "\"");
		json.append(",");
		json.append("\"isPrivate\":\"" + CRMParamUtils.getCheckboxValue(enterprise.getIsPrivate()) + "\"");
		json.append(",");
		json.append("\"enterpriseName\":\"" + enterprise.getName() + "\"");
		json.append(",");
		json.append("\"taxid\":\"" + enterprise.getTaxid() + "\"");
		json.append(",");
		json.append("\"description\":\"" + enterprise.getDescription() + "\"");
		json.append(",");
		json.append("\"enterpriseEmail\":\"" + enterprise.getEmail() + "\"");
		json.append(",");
		json.append("\"insustryId\":\"" + enterprise.getIndustry() + "\"");
		if (addressList != null && !addressList.isEmpty()) {
			json.append(",");
			json.append("\"countryId\":\"" + addressList.get(0).getCountry().getCountryId() + "\"");
			json.append(",");
			json.append("\"street1\":\"" + addressList.get(0).getStreet1() + "\"");
			json.append(",");
			json.append("\"street2\":\"" + addressList.get(0).getStreet2() + "\"");
			json.append(",");
			json.append("\"street3\":\"" + addressList.get(0).getStreet3() + "\"");
			json.append(",");
			json.append("\"zip\":\"" + addressList.get(0).getZip() + "\"");
			json.append(",");
			json.append("\"city\":\"" + addressList.get(0).getCity() + "\"");
		}
		
		json.append("}");
		
		return json.toString();
	}
}
